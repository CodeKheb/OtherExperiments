package backend;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.Scanner;

public class gemini_API {

    static Scanner input = new Scanner(System.in);
    static boolean running = true;

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        while (running) {
            System.out.print("Prompt: ");
            String prompt = input.nextLine();
            String json = String.format("""
    {
  "contents": [
    {
      "parts": [
        {
          "text": "%s"
        }
      ]
    }
  ],
  "generationConfig": {
    "thinkingConfig": {
          "thinkingBudget": -1
    }
  }
}
    """, prompt.replace("\"", "\\\"").replace("\n", "\\n"));
            String API_KEY = null; //Replace with your gemini API key
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash-lite:generateContent"))
                    .header("x-goog-api-key", API_KEY)
                    .header("'Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response: " + extractText(response.body()));
        }
    }

    static String extractText(String jsonResponse) {
        String searchKey = "\"text\": \"";
        int start = jsonResponse.indexOf(searchKey) + searchKey.length();
        int end = jsonResponse.indexOf("\"", start);

        if (start > searchKey.length() - 1 && end > start) {
            return jsonResponse.substring(start, end);
        }
        return "Text not found";
    }
}
