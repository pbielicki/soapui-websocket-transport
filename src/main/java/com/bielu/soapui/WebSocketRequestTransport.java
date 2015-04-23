package com.bielu.soapui;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

import com.eviware.soapui.impl.wsdl.submit.RequestFilter;
import com.eviware.soapui.impl.wsdl.submit.RequestTransport;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.model.iface.SubmitContext;

/**
 * @author Przemyslaw Bielicki
 */
public class WebSocketRequestTransport implements RequestTransport {

  public void abortRequest(SubmitContext ctx) {
  }

  public void addRequestFilter(RequestFilter filter) {
  }

  public void removeRequestFilter(RequestFilter filter) {
  }

  public Response sendRequest(SubmitContext ctx, Request req) throws Exception {
    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    WebSocketResponse response = new WebSocketResponse(req);
    container.connectToServer(new WebSocketSoapClient(response), new URI(req.getEndpoint()));
    return response;
  }

@Override
public void insertRequestFilter(RequestFilter arg0, RequestFilter arg1) {
	// TODO Auto-generated method stub
	
}
}
