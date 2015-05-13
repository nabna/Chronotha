package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import common.Tested;

@Tested
public class JXMLHandler<T> {

	private static final Logger log = Logger.getLogger(CSVFileHandler.class);

	private Class<T> clazz;

	public JXMLHandler(Class<T> clazz) {
		this.clazz = clazz;
	}

	public String toXML(T bean, String... outputFiles) {
		try {
			OutputStream stream = new ByteArrayOutputStream();
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			if (outputFiles.length > 0) {
				for (String outputFile : outputFiles) {
					File file = new File(outputFile);
					jaxbMarshaller.marshal(bean, file);
				}
			}

			jaxbMarshaller.marshal(bean, stream);

			return stream.toString();

		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public T fromXMLFile(String filename) {
		try {
			File file = new File(filename);
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (T) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T fromXML(String content) {
		try {
			InputStream is = new ByteArrayInputStream(content.getBytes());
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (T) jaxbUnmarshaller.unmarshal(is);
		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
}
