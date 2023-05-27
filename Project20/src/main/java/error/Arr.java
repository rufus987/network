package error;

import java.util.ArrayList;
import java.util.List;

public class Arr {
    public static void main(String[] args) {
        double result = 0;

        List < Double > list1 = new ArrayList < > ();
        for (int i = 0; i < 10; i++)
            list1.add(((Math.random() * 100)));

        List < Double > list2 = new ArrayList < > ();
        for (int j = 0; j < 10; j++)
            list2.add(((Math.random() * 100)));

        System.out.println("Первый массив случайных чисел:");
        for (Double x: list1)
            System.out.printf("%.2f\t", x);

        System.out.println("\nВторой массив случайных чисел:");
        for (Double y: list2)
            System.out.printf("%.2f\t", y);

        System.out.println("\n");

        for (int k = 0; k < list1.size(); k++) {
            try {
                if (list2.get(k) == 0)
                    throw new ArithmeticException();

                result = list1.get(k) / list2.get(k);

                if (result < 1)
                    throw new DivisionExc(list1.get(k), list2.get(k));

                System.out.printf("Результат деления %.2f на %.2f равен %.2f\n", list1.get(k), list2.get(k), result);

            } catch (DivisionExc divisionExc) {
                System.out.println(divisionExc);
            } catch (ArithmeticException e) {
                System.out.println("Попытка деления на ноль");
            }
        }
    }
}

class DivisionExc extends Exception {
    double firsNum;
    double secondNum;

    public DivisionExc(double firsNum, double secondNum) {
        this.firsNum = firsNum;
        this.secondNum = secondNum;
    }

    @Override
    public String toString() {
        return "Результат деления " + String.format("%.2f", firsNum) +
                " на " + String.format("%.2f", secondNum) +
                " меньше 1";
    }
}

