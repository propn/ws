/**
 * 
 */
package org.ws.client;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

/**
 * @author Administrator
 *
 */
public class WsClient {

	/**
	 * @param args
	 * @throws AxisFault
	 */
	public static void main(String[] args) throws AxisFault {
		String addres = "http://localhost:8080/axis2/services/SimpleService";
		String namespaceURI = "http://ws.apache.org/axis2";
		String localPart = "getGreeting";
		String xml = "";

		RPCServiceClient serviceClient = new RPCServiceClient();
		EndpointReference targetEPR = new EndpointReference(addres);
		QName opName = new QName(namespaceURI, localPart);
		Options options = serviceClient.getOptions();
		options.setTo(targetEPR);
		Object[] opAddEntryArgs = new Object[] { xml };

		System.out.println(serviceClient.invokeBlocking(opName, opAddEntryArgs,
				new Class[] { String.class })[0]);

	}

}
