package error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Программа работает");
                int num = scanner.nextInt();
                list1.add(num);
            }
        } catch (Exception e) {
            System.out.println("Массив:");
            for (Integer x : list1) {
                System.out.println(x);
                //System.out.printf("%d\t", x);
            }
        }
    }

    public String input() throws MyException {
        String s = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (s.equals("")) {
            throw new MyException("String can not be empty!");
        }
        return s;
    }
}
    class MyException extends Exception{
        public MyException(String s) {

        }
    }
