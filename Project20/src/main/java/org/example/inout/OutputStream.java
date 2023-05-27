package org.example.inout;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream {
    public static void main(String[] args) {
        String str = "TI PSYINA\n";
        try (FileOutputStream fos = new FileOutputStream("/home/evgen/dir_dir/x2")) {
            fos.write(str.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
