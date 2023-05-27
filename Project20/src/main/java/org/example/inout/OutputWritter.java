package org.example.inout;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OutputWritter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        try (FileWriter fw = new FileWriter("/home/evgen/dir_dir/x2", true)) {
            fw.write(str);
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }
}
