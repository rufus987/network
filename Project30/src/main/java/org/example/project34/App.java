package org.example.project35;

import org.example.project34.DynamicArray;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DynamicArray transport = new DynamicArray();
        transport.add(new Plane());
        transport.add(new Car());
        transport.add(new Plane());
        transport.add(new Car());
        transport.add(new Car());
        for (int i=0; i <= transport.size; i++) {
            ((Car)transport.get(i)).drive();
        }
    }
}
class Car{
    void drive(){
        System.out.println("WRRYYYMMM");
    }
}

class Plane{
    void fly(){
        System.out.println("FLLLLYYY");
    }
}
