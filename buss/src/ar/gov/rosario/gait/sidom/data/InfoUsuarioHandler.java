package ar.gov.rosario.gait.sidom.data;


import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author tecso.coop
 *
 */
public class InfoUsuarioHandler extends DefaultHandler {

	private InfoUsuario infoUsuario = null;

	
	public InfoUsuario getInfoUsuario(){
		return infoUsuario;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		//Push it in element stack
		this.elementStack.push(qName);
		//
		if (qName.equalsIgnoreCase("InfoUsuario")) {
			infoUsuario = new InfoUsuario();
		} 
	}

	@Override
	public void endElement(String uri, String localName, 
			String qName) throws SAXException {
		//
	}


	@Override
	public void characters(char ch[], int start, 
			int length) throws SAXException {
		String data = new String(ch, start, length);
		String element = currentElement();
		if(element.equalsIgnoreCase("Id")){
			infoUsuario.setId(data);
		} else  if (element.equalsIgnoreCase("Nombre")) {
			infoUsuario.setNombre(data);
		} else if (element.equalsIgnoreCase("Apellido")) {
			infoUsuario.setApellido(data);
		} else if (element.equalsIgnoreCase("Email")) {
			infoUsuario.setEmail(data);
		} else if (element.equalsIgnoreCase("Hash")) {
			infoUsuario.setHash(data);
		}
	}
	
	
	//As we read any XML element we will push that in this stack
    private Stack<String> elementStack = new Stack<>();
	
	   /**
     * Utility method for getting the current element in processing
     * */
    private String currentElement() {
        return this.elementStack.peek();
    }
}