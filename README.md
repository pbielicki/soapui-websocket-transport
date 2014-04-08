soapui-websocket-transport
==========================

WebSocket Transport Plugin for soapUI

How to make it work?
-------------

# Build the project using Maven e.g.: <code>mvn clean package</code>
# Copy target/soapui-websocket-transport.jar to SOAPUI_HOME/bin/ext
# Copy factories/ directory to SOAPUI_HOME/bin
# Start soapUI
# Check the soapUI logs. You should see "...INFO:Adding factories from [SOAPUI_HOME/bin/factories/soapui-factories.xml]"
# You can now send your SOAP message to WebSocket destinations e.g. ws://localhost:8080/example-webapp/echo

Tested with soapUI 4.5.x