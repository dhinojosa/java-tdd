package com.xyzcorp.instructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLStreamConverter {

    public static BufferedReader convert(String u) throws IOException {
        URL url = new URL(u);
        InputStream inputStream = url.openConnection().getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return new BufferedReader(inputStreamReader);
    }
}
