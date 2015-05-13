package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import  common.IDelimitable;

/**
 * A helper class for the serialization and de-serialization of all IDelimitable objects.
 * IDelimitable contains two handles to the marshaling and unmarshaling
 * of a String tuple.
 * 
 * @see IDelimitable
 * @author jliu
 * 
 */
public final class CSVFileHandler {

	private static final String DELIMITER = ";";
	private static final String DOS_LINE_SEPARATOR = "\r\n";

	private static final Logger log = Logger.getLogger(CSVFileHandler.class);

	private CSVFileHandler() {

	}

	/**
	 * Write a delimitable object to a file
	 * 
	 * @param filename
	 *            file complete name ([drive] + path + name + extension)
	 * @param object
	 * @param overwrite
	 *            create a new file if overwrite is true,
	 *            append to the end of an existing file if false.
	 */
	public static <T> void flush(String filename, IDelimitable<T> object, boolean overwrite) {
		try {
			FileWriter fw = new FileWriter(filename, !overwrite);
			fw.write(object.serialize(DELIMITER) + DOS_LINE_SEPARATOR);
			fw.close();
		} catch (IOException e) {
			log.error("IOException: " + e.getMessage(), e);
		}
	}

	/**
	 * Read from a CSV file and render a list of delimitable objects parsed from
	 * each line of the file content.
	 * 
	 * @param filename
	 *            file complete name ([drive] + path + name + extension)
	 * @param holder
	 *            a new instance of the object that implements IDelimitable
	 * @return
	 *         a list of delimitable objects
	 */
	public static <T extends IDelimitable<T>> List<T> read(String filename, T holder) {
		List<T> result = new ArrayList<T>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null && line.contains(DELIMITER)) {
				result.add(holder.clone().parse(line, DELIMITER));
			}
			reader.close();
		} catch (IOException e) {
			log.error("IOException: " + e.getMessage(), e);
		}
		return result;
	}

}