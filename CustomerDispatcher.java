import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CustomerDispatcher {
    
	public static void main(String[] args) {
		
		// doGet();
		doPost();
        
    }
	
	public static void doGet() {
		
		try {
			
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.ecdp.app/customers/id/53492"))
                    .headers(
                            "Content-Type", "application/json",
                            "x-api-key", "hahaha"
                    )
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
			
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	public static void doPost() {
		
		try {
            // Create the HttpClient
            HttpClient client = HttpClient.newHttpClient();

            String json = "{\r\n"
			+ "  \"mode\": \"AddOrUpdate\",\r\n"
			+ "  \"matchBy\": \"Email\",\r\n"
			+ "  \"data\": [\r\n"
			+ "    {\r\n"
			+ "      \"email\": \"saga_gemini2000@yahoo.com.br\",\r\n"
			+ "      \"firstName\": \"Marcos\",\r\n"
			+ "      \"lastName\": \"Silvestri\",\r\n"
			+ "      \"customAttributes\": [\r\n"
			+ "        {\r\n"
			+ "          \"Name\": \"Genero\",\r\n"
			+ "      	  \"Value\": \"M\"\r\n"
			+ "        },\r\n"
			+ "    	{\r\n"
			+ "          \"Name\": \"Nascimento\",\r\n"
			+ "      	  \"Value\": \"18/07/1981\"\r\n"
			+ "        }\r\n"
			+ "      ],\r\n"
			+ "      \"consentsData\": {\r\n"
			+ "        \"consents\": [\r\n"
			+ "          {\r\n"
			+ "            \"id\": 1,\r\n"
			+ "            \"value\": \"True\"\r\n"
			+ "          }\r\n"
			+ "        ],\r\n"
			+ "        \"force\": false\r\n"
			//+ "        \"confirmationMessageId\": 0\r\n"
			+ "      }\r\n"
			+ "    }\r\n"
			+ "  ]\r\n"
			+ "}";

            // Create the HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.ecdp.app/customers"))
                    .headers(
							"Content-Type", "application/json",
							"x-api-key", "hehehe"
						   )
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the response status code and body
            System.out.println("Response code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
}
