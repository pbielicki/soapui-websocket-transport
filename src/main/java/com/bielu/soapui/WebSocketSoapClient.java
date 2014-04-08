package com.bielu.soapui;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 * @author Przemyslaw Bielicki
 */
@ClientEndpoint
public class WebSocketSoapClient {

  private WebSocketResponse response;

  public WebSocketSoapClient(WebSocketResponse response) {
    this.response = response;
  }

  @OnClose
  public void onClose(Session session, CloseReason reason) {
    System.out.printf("Connection %s closed: %s%n", session.getId(), reason);
  }

  @OnOpen
  public void onOpen(Session session) {
    System.out.printf("Connection open: %s%n", session);
    try {
      session.getBasicRemote().sendText(response.getRequestContent());
    } catch (Exception e) {
      System.err.println("Error while sending the request. " + e);
    }
  }

  @OnMessage
  public void onMessage(String msg, Session session) {
    response.setResponseContent(msg);
    try {
      session.close(new CloseReason(CloseCodes.NORMAL_CLOSURE, "OK"));
    } catch (IOException e) {
      System.err.println("Error while closing the connection. " + e);
    }
  }
}
