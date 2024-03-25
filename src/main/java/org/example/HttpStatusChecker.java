package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
   public static String getStatusImage(int code) throws IOException{
        String URL = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();

        connection.setRequestMethod("HEAD");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_NOT_FOUND){
            throw new IOException("No image found for HTTP status " + code);
        }
        return URL;
   }
}