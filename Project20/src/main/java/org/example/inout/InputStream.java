package org.example.inout;

import java.io.*;
import java.nio.charset.StandardCharsets;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class InputStream {
    public static void main(String[] args) throws RuntimeException {
        int b;
        try (FileInputStream inputStream = new FileInputStream("/home/evgen/dir_dir/x22"); InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            while ((b = inputStreamReader.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}