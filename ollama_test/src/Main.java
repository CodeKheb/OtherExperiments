//import java.io.*;
//import java.lang.*;
//import java.util.*;
//import java.net.URI;
//import java.net.http.*;
//
//public class Main {
//
//   void main(String[] args) throws IOException, InterruptedException {
//
//      Scanner sc = new Scanner(System.in);
//      String cmd = sc.nextLine();
//      String proc = "curl http://localhost:11434/api/generate -d '{ \"model\": \"llama3\", \"prompt\": \"hello\" ";
//      String line;
//
//      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//      String json = String.format("""
//              {
//              "model": "llama3",
//              "prompt": "%s.",
//              "stream": false
//              """, cmd);
//
//      HttpClient client = HttpClient.newHttpClient();
////
//      HttpRequest request = HttpRequest.newBuilder()
//              .uri(URI.create("http://localhost:11434/api/chat"))
//              .header("Content-Type", "application/json")
//              .POST(HttpRequest.BodyPublishers.ofString(json))
//              .build();
////
//
//      HttpResponse<String> response =
//              client.send(request, HttpResponse.BodyHandlers.ofString());
//
//      System.out.println(response.body());
//
////      for (int i = 0; i > -1; i++) {
//
//      while ((line = reader.readLine()) != null) {
//         System.out.println(line);
//      }
//   }
//}
