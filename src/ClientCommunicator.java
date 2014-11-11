
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import shared.communication.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * Allows the client to communicate with the server
 * @author kevinjreece
 */
public class ClientCommunicator {
	
	private String SERVER_HOST = "localhost";
	private int SERVER_PORT = 8080;
	private String URL_PREFIX = "http://" + SERVER_HOST + ":" + SERVER_PORT;
	private final String HTTP_POST = "POST";
	private final String HTTP_GET = "GET";
	
	private XStream xmlStream;
	
	public ClientCommunicator() {
		xmlStream = new XStream(new DomDriver());
	}
	
	public ClientCommunicator(String host, int port) {
		SERVER_HOST = host;
		SERVER_PORT = port;
		URL_PREFIX = "http://" + SERVER_HOST + ":" + SERVER_PORT;
		xmlStream = new XStream(new DomDriver());
	}
	
	/**
	 * Determines if a username/password combination is valid
	 * @author			kevinjreece
	 * @param	params	the parameters needed to validate the user (username and password)
	 * @return			true if the username/password combination is in the database, false otherwise
	 * */
	public ValidateUser_Result validateUser(ValidateUser_Params params) throws ClientException {
		return (ValidateUser_Result)doPost("/ValidateUser", params);
	}
	
	/**
	 * Gets all the projects in the database
	 * @author	kevinjreece
	 * @return	all projects in the database
	 * */
	public GetProjects_Result getProjects(GetProjects_Params params) throws ClientException {
		return (GetProjects_Result)doPost("/GetProjects", params);
	}
	
	/**
	 * Gets a sample image for a project
	 * @author			kevinjreece
	 * @param	params	the parameters needed to download a sample image
	 * @return			a sample image for the given project
	 * */
	public GetSampleImage_Result getSampleImage(GetSampleImage_Params params) throws ClientException {
		return (GetSampleImage_Result)doPost("/GetSampleImage", params);
	}
	
	/**
	 * Gets an incomplete batch for the given project
	 * @author			kevinjreece
	 * @param	params	the parameters needed to download a batch from a specific project
	 * @return			an incomplete batch from the given project
	 * */
	public DownloadBatch_Result downloadBatch(DownloadBatch_Params params) throws ClientException {
		return (DownloadBatch_Result)doPost("/DownloadBatch", params);
	}

	/**
	 * Submits a completed batch to the database
	 * @author			kevinjreece
	 * @param	params	the parameters needed to insert new values into the database
	 * */
	public SubmitBatch_Result submitBatch(SubmitBatch_Params params) throws ClientException {
		return (SubmitBatch_Result)doPost("/SubmitBatch", params);
	}
	
	/**
	 * Gets the fields for a given project
	 * @author			kevinjreece
	 * @param	params	the parameters needed to get fields for a project
	 * @return			the fields for the given project
	 * */
	public GetFields_Result getFields(GetFields_Params params) throws ClientException {
		return (GetFields_Result)doPost("/GetFields", params);
	}

	/**
	 * Searches the database for the given string
	 * @author			kevinjreece
	 * @param	params	the parameters needed to search the database
	 * @return			the images containing the search_string
	 * */
	public Search_Result search(Search_Params params) throws ClientException {
		return (Search_Result)doPost("/Search", params);
	}
	
	/**
	 * Downloads a file from the server
	 * @author			kevinjreece
	 * @param	params	the parameters needed to download the file
	 * @return			the file
	 * */
	public DownloadFile_Result downloadFile(DownloadFile_Params params) throws ClientException {
		return (DownloadFile_Result)doGet("/");
	}
	
	public AddUser_Result addUser(AddUser_Params params) throws ClientException {
		return (AddUser_Result)doPost("/AddUser", params);
	}
	
	public AddProject_Result addProject(AddProject_Params params) throws ClientException {
		return (AddProject_Result)doPost("/AddProject", params);
	}
	
	public AddField_Result addField(AddField_Params params) throws ClientException {
		return (AddField_Result)doPost("/AddField", params);
	}
	
	public AddImage_Result addImage(AddImage_Params params) throws ClientException {
		return (AddImage_Result)doPost("/AddImage", params);
	}
	
	public AddValue_Result addValue(AddValue_Params params) throws ClientException {
		return (AddValue_Result)doPost("/AddValue", params);
	}
	
	private Object doGet(String urlPath) throws ClientException {
		try {
			URL url = new URL(URL_PREFIX + urlPath);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod(HTTP_GET);
			connection.connect();
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				Object result = xmlStream.fromXML(connection.getInputStream());
				return result;
			}
			else {
				throw new ClientException(String.format("doGet failed: %s (http code %d)",
											urlPath, connection.getResponseCode()));
			}
		}
		catch (IOException e) {
			throw new ClientException(String.format("doGet failed: %s", e.getMessage()), e);
		}
	}
	
	private Object doPost(String urlPath, Object postData) throws ClientException {
		try {
//			System.out.println(URL_PREFIX);
			
			URL url = new URL(URL_PREFIX + urlPath);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod(HTTP_POST);
			connection.setDoOutput(true);
			connection.connect();
			xmlStream.toXML(postData, connection.getOutputStream());
			connection.getOutputStream().close();
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				Object result = xmlStream.fromXML(connection.getInputStream());
				return result;
			}
			else {
				throw new ClientException(String.format("doPost failed: %s (http code %d)",
						urlPath, connection.getResponseCode()));
			}
		}
		catch (IOException e) {
			throw new ClientException(String.format("doPost failed: %s", e.getMessage()), e);
		}
	}
}
