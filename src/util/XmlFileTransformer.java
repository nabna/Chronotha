package util;

import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

public class XmlFileTransformer {

	private static final Logger log = Logger.getLogger(XmlFileTransformer.class);

	private final String xslt;

	public XmlFileTransformer(String xslt) {
		this.xslt = xslt;
	}

	public void transform(String inputFile, String outputFile) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Source xslt = new StreamSource(new File(this.xslt));
			Transformer transformer = factory.newTransformer(xslt);

			Source text = new StreamSource(new File(inputFile));
			transformer.transform(text, new StreamResult(new File(outputFile)));
		} catch (TransformerException te) {
			log.error(te.getMessage(), te);
		}
	}
}
