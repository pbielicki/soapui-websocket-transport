package com.bielu.soapui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.submit.transports.http.SSLInfo;
import com.eviware.soapui.impl.wsdl.submit.transports.http.WsdlResponse;
import com.eviware.soapui.model.iface.Attachment;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.support.types.StringToStringsMap;

/**
 * @author Przemyslaw Bielicki
 */
public class WebSocketResponse implements WsdlResponse {

  private String responseContent;
  private Request request;
  private final CountDownLatch contentLatch;

  public WebSocketResponse(Request request) {
    this.request = request;
    contentLatch = new CountDownLatch(1);
  }

  public Attachment[] getAttachments() {
    return new Attachment[0];
  }

  public Attachment[] getAttachmentsForPart(String arg0) {
    return new Attachment[0];
  }

  public String getContentAsString() {
    return getResponseContent();
  }

  public String getContentAsXml() {
    return getResponseContent();
  }

  public long getContentLength() {
    return getRequestContent().length();
  }

  public String getContentType() {
    return "text/xml";
  }

  public String getProperty(String arg0) {
    return null;
  }

  public String[] getPropertyNames() {
    return new String[0];
  }

  public byte[] getRawRequestData() {
    return request.getRequestContent().getBytes();
  }

  public byte[] getRawResponseData() {
    return getResponseContent().getBytes();
  }

  public String getRequestContent() {
    return request.getRequestContent();
  }

  public StringToStringsMap getRequestHeaders() {
    return null;
  }

  public StringToStringsMap getResponseHeaders() {
    return null;
  }

  public long getTimeTaken() {
    return 0;
  }

  public long getTimestamp() {
    return 0;
  }

  public void setProperty(String arg0, String arg1) {
  }

  public void setResponseContent(String msg) {
    this.responseContent = msg;
    contentLatch.countDown();
  }
  
  public String getResponseContent() {
    try {
      contentLatch.await(1, TimeUnit.SECONDS);
      return responseContent;
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }

  public SSLInfo getSSLInfo() {
    return null;
  }

  public URL getURL() {
    try {
      return new URL(request.getEndpoint());
    } catch (MalformedURLException e) {
      throw new IllegalStateException(e);
    }
  }

  public String getMethod() {
    return null;
  }

  public String getHttpVersion() {
    return null;
  }

  public int getStatusCode() {
    return 0;
  }

  @Override
  public Vector<?> getWssResult() {
    return null;
  }

  @Override
  public WsdlRequest getRequest() {
    return (WsdlRequest) request;
  }
}
