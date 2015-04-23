soapui-websocket-transport
==========================

WebSocket Transport Plugin for soapUI

How to make it work?
-------------

1. Build the project using Maven e.g.: <code>mvn clean package</code>
1. Copy <code>target/soapui-websocket-transport.jar</code> to <code>SOAPUI_HOME/bin/ext</code>
1. Copy <code>factories/</code> directory to <code>SOAPUI_HOME/bin</code>
1. Start soapUI
1. Check the soapUI logs. You should see <code>"...INFO:Adding factories from [SOAPUI_HOME/bin/factories/soapui-factories.xml]"</code>
1. You can now send your SOAP message to WebSocket destinations e.g. <code>ws://localhost:8080/example-webapp/echo</code>

Secured WebSocket endpoint i.e. **wss** is not supported at the moment.

Tested with soapUI 5.1.2
Note that the SmartBear repo is missing artifacts for 5.1.3!