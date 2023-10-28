import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestCaller {

    public static void main(String[] args) throws IOException {
        // Create a URL object for the REST service
        URL url = new URL("http://google.com");

        // Create an HTTP connection object
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Set the request headers
        connection.setRequestProperty("Accept", "application/json");

        // Make the request
        connection.connect();

        // Get the response status code
        int statusCode = connection.getResponseCode();

        // Check the response status code
        if (statusCode == 200) {
            // The request was successful, so read the response body
            InputStream inputStream = connection.getInputStream();
            String responseBody = new String(inputStream.readAllBytes());

            // Print the response body
            System.out.println(responseBody);
        } else {
            // The request failed, so print the error message
            String errorMessage = connection.getResponseMessage();
            System.out.println(errorMessage);
        }
    }
}