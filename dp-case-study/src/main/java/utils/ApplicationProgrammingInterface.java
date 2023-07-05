package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

public class ApplicationProgrammingInterface {
	// SRP: get() and post() have different responsibilities
	// OCP: difficult to extend when only 2 methods get() and post() are supported
	// solution: split into GetAPI, PostAPI classes and extend this API class and
	// override excute() method together
	// Coincidental cohesion
	// singleton: use private static final for Logger and Date_Formatter
	public static DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Logger LOGGER = Utils.getLogger(Utils.class.getName());

	public String get(String url, String token) throws Exception {
		LOGGER.info("Request URL: " + url + "\n");
		// Procedural cohesion
		HttpURLConnection conn = setupConnection(url);
	}
	public String execute(String url, String data) throws Exception {
		conn = setupConnection(url);
		setRequestMethod();
		prepareData(data);
		BufferedReader in = getBufferedReader();
		String response = readData(in);
		return response;
	}

	public abstract void setRequestMethod() throws Exception;

	public abstract void prepareData(String data) throws Exception;

	public abstract BufferedReader getBufferedReader() throws Exception;

	public String readData(BufferedReader in) throws Exception {
		String inputLine;
		StringBuilder response = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);
		in.close();
		LOGGER.info("Respone Info: " + response.toString());
		return response.toString();
	}

//	public static String get(String url, String token) throws Exception {
//		LOGGER.info("Request URL: " + url + "\n");
//		HttpURLConnection conn = setupConnection(url);
//
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Authorization", "Bearer " + token);
//		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		String inputLine;
//		StringBuilder respone = new StringBuilder(); // ising StringBuilder for the sake of memory and performance
//		while ((inputLine = in.readLine()) != null)
//			System.out.println(inputLine);
//		respone.append(inputLine + "\n");
//		in.close();
//		LOGGER.info("Respone Info: " + respone.substring(0, respone.length() - 1).toString());
//		return respone.substring(0, respone.length() - 1).toString();
//	}

//	public static String post(String url, String data) throws IOException {
//		allowMethods("PATCH");
//		HttpURLConnection conn = setupConnection(url);
//		conn.setRequestMethod("PATCH");
//		String payload = data;
//		LOGGER.info("Request Info:\nRequest URL: " + url + "\n" + "Payload Data: " + payload + "\n");
//
//		Writer writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
//		writer.write(payload);
//		writer.close();
//		BufferedReader in;
//		String inputLine;
//		if (conn.getResponseCode() / 100 == 2) {
//			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		} else {
//			in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//		}
//		StringBuilder response = new StringBuilder();
//		while ((inputLine = in.readLine()) != null)
//			response.append(inputLine);
//		in.close();
//		LOGGER.info("Respone Info: " + response.toString());
//		return response.toString();
//	}

	protected HttpURLConnection setupConnection(String url) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json");
		return conn;
	}

	protected void allowMethods(String... methods) {
		try {
			// Content coupling
			Field methodsField = HttpURLConnection.class.getDeclaredField("methods");
			methodsField.setAccessible(true);

			// Content coupling
			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

			String[] oldMethods = (String[]) methodsField.get(null);
			Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
			methodsSet.addAll(Arrays.asList(methods));
			String[] newMethods = methodsSet.toArray(new String[0]);

			methodsField.set(null/* static field */, newMethods);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new IllegalStateException(e);
		}
	}
}
