package com.bielu.soapui;

import com.eviware.soapui.impl.wsdl.submit.RequestTransport;
import com.eviware.soapui.impl.wsdl.submit.RequestTransportFactory;

/**
 * @author Przemyslaw Bielicki
 */
public class WebSocketRequestTransportFactory implements
    RequestTransportFactory {

  public String getProtocol() {
    return "ws";
  }

  public RequestTransport newRequestTransport() {
    return new WebSocketRequestTransport();
  }

}
