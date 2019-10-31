package de.usu.test.web.suite.testcase.interfaces.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import com.google.gson.*;

/**
 * Json file handling interface 
 * @author uzimmiksov
 *
 */
public abstract class FileHandler {
	
	/**
	 * Method loads string input from specified JSON file and converts
	 * it to JSON formated string via Gson 3rd party library. If file is unreadable,
	 * method returns null.
	 * 
	 * @param String path to the JSON file
	 * @return String with JSON file content
	 * @throws FileNotFoundException
	 */
	public static String loadJsonFileAsString(String path) {
		try {
			return loadJsonFile(path).exists() ? new Gson().toJson(loadJsonFileAsJsonElement(path)) : "Unreadable file";
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method loads string input from specified JSON file and serializes
	 * it as JSON Element via Gson 3rd party library. If file is unreadable,
	 * method returns null.
	 * 
	 * @param String path to the JSON file
	 * @return JsonElement - serialized JSON
	 * @throws FileNotFoundException
	 */
	public static JsonElement loadJsonFileAsJsonElement(String path) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		return loadJsonFile(path).canRead() ? new Gson().fromJson(new FileReader(path), JsonElement.class) : null;
	}
	
	/**
	 * Method <b> gets File reference </b> to specified (json) file
	 * @param path path to file
	 * @return File instance
	 */
	public static File loadJsonFile(String path) {
		return new File(path);
	}
	
	
	//TODO create directory if doesn't exists!!
	
	/**
	 * Method saves input string into file via FileWriter instance
	 * @param path to file
	 * @param jsonInput
	 * @return true if byte length of file is greater than 0
	 * @throws IOException
	 */
	public static boolean saveJsonFile(String path, String jsonInput) throws IOException {
		File jsonFile = new File(path);
		if(!jsonFile.exists()) {
			
			jsonFile.getParentFile().mkdirs();
			jsonFile.createNewFile();
		}
		return saveFile(jsonFile, jsonInput);
	}

	/**
	 * Method <b> saves input string into file via FileWriter instance </b>
	 * @param path to file
	 * @param jsonInput
	 * @return true if byte length of file is greater than 0
	 * @throws IOException
	 */
	public static boolean saveJsonFileAs(File jsonFile, String jsonInput) throws IOException  {
		if(!jsonFile.exists()) {
			jsonFile.createNewFile();
			jsonFile.getParentFile().mkdirs();
		}			
		return saveJsonFile(jsonFile.getPath(), jsonInput);
	}
	
	public static boolean saveFile(File file, String input) {
		
		try {
			FileWriter writer = new FileWriter(file, false);
			writer.write(getTimeStamp()+"\n");	
			writer.append(input);
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return file.length() > 0 ? true : false;
	}
	
	public static String getTimeStamp() {
		return new Date().toString();
	}
	
}
