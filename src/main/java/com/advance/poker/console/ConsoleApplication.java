package com.advance.poker.console;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsoleApplication {

    private static final String BASE_URL = "http://localhost:8080/api/poker";

    public static void main(String[] args) {
        try {
            // Access the "/play" endpoint
            String playResult = getEndpoint("/play?handSize=5");
            System.out.println(playResult);

            // Access the "/dealDeck" endpoint
            //String dealDeckResult = getEndpoint("/dealDeck");
            // System.out.println("Result of dealing a deck: " + dealDeckResult);

            // Access the "/dealHand" endpoint with a custom hand size (e.g., 4 for badugi)
            // String dealHandResult = getEndpoint("/dealHand?handSize=4");
            // System.out.println("Result of dealing a hand: " + dealHandResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getEndpoint(String endpoint) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
