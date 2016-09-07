package localhost.employee.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 
 * @author Justin Moore
 * @created on 9/7/16 Class that gets all employee id
 *
 *          x
 */

public class EmployeeGet {

	/**
	 * The URL of the API we want to connect to
	 */
	protected static String endpoint = "http://localhost:1337/employee/";

	/**
	 * the character set to use when encoding URL parameters
	 */
	protected static String charset = "UTF-8";

	public static void main(String[] args) {

		try {

			// creates a new URL out of the endpoint, returnType and queryString
			URL employee = new URL(endpoint);
			HttpURLConnection connection = (HttpURLConnection) employee.openConnection();
			connection.setRequestMethod("GET");

			// if we did not get a 200 or 201 (success) thrown an exception
			if (connection.getResponseCode() != 200 && connection.getResponseCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			// read response into buffer
			BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

			// loop of buffer line by line until it returns null meaning there
			// are no more lines
			while (br.readLine() != null) {
				// print out each line to the screen
				System.out.println(br.readLine());
			}

			// close connection to API
			connection.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}