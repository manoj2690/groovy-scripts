/*package mavensoapintegration;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.WsdlSubmit;
import com.eviware.soapui.impl.wsdl.WsdlSubmitContext;
import com.eviware.soapui.model.iface.Request.SubmitException;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;

public class TestConnectivity {

	public static void main(String[] args) throws XmlException, IOException, SoapUIException, SubmitException {
		// TODO Auto-generated method stub
		// create new project
		WsdlProject project = new WsdlProject();

		// import amazon wsdl
		WsdlInterface iface = WsdlInterfaceFactory.importWsdl(project,
				"http://www.webservicex.com/CurrencyConvertor.asmx", true)[0];

		// get desired operation
		WsdlOperation operation = (WsdlOperation) iface.getOperationByName("ConversionRate");

		// create a new empty request for that operation
		WsdlRequest request = operation.addNewRequest("Myrequest");

		// generate the request content from the schema
		request.setRequestContent(operation.createRequest(true));

		// submit the request
		WsdlSubmit submit = (WsdlSubmit) request.submit(new WsdlSubmitContext(request), false);

		// wait for the response
		Response response = submit.getResponse();

		// print the response
		String content = response.getContentAsString();
		System.out.println(content);
		// assertNotNull( content );
		// assertTrue( content.indexOf( "404 Not Found" ) > 0 );
	}

}
*/