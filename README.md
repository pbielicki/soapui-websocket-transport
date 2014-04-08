soapui-websocket-transport
==========================

WebSocket Transport Plugin for soapUI

How to make it work?
-------------

1. Build the project using Maven e.g.: <code>mvn clean package</code>
1. Copy target/soapui-websocket-transport.jar to SOAPUI_HOME/bin/ext
1. Copy factories/ directory to SOAPUI_HOME/bin
1. Start soapUI
1. Check the soapUI logs. You should see "...INFO:Adding factories from [SOAPUI_HOME/bin/factories/soapui-factories.xml]"
1. You can now send your SOAP message to WebSocket destinations e.g. ws://localhost:8080/example-webapp/echo

Tested with soapUI 4.5.x