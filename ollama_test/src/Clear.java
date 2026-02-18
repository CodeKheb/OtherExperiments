import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.URI;
import java.net.http.*;
import com.fasterxml.jackson.databind.*;
public class Clear {
     void main(String[] a) throws IOException, InterruptedException {
               String json = """
              {
              "model": "llama3",
              "prompt": "say one word.",
              "stream": false
              }
              """;

               HttpClient client = HttpClient.newHttpClient();

      HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create("http://localhost:11434/api/generate"))
              .header("Content-Type", "application/json")
              .POST(HttpRequest.BodyPublishers.ofString(json))
              .build();

            HttpResponse<String> response =
              client.send(request, HttpResponse.BodyHandlers.ofString());


            while (true) {
                System.out.println(response.body());
                 }
    }
}
