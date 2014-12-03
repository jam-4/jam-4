package org.jam4.web.rest;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonReader {

    public String readJsonFromUrl(String url) throws IOException {
        try (InputStream inputStream = new URL(url).openStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            return readAll(bufferedReader);
        }
    }

    private String readAll(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int character;

        while ((character = reader.read()) != -1) {
            stringBuilder.append((char) character);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        JsonReader jsonReader = new JsonReader();
        String json = jsonReader.readJsonFromUrl("https://graph.facebook.com/19292868552");

        System.out.println("json = " + json);
    }
}