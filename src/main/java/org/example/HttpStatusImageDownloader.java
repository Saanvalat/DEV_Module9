package org.example;

import lombok.Data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    public HttpStatusImageDownloader(){
        this.checker = new HttpStatusChecker();
    }
    private HttpStatusChecker checker;
        public void downloadStatusImage (int code) throws Exception {
        String imageUrl = checker.getStatusImage(code);

        URL url = new URL(imageUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try (InputStream inputStream = connection.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(code + ".jpg")){
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, bytesRead);
            }
        }


        }
}
