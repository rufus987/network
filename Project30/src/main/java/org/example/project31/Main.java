package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int numberOfTasks = 5; // ограничим нашу очередь 5 задачами
        Stack toDoQueue = new Stack(); // создаем очередь
        Boss boss = new Boss(toDoQueue); // создаем начальника с ссылкой на
        // очередь
        Worker worker = new Worker(toDoQueue); // то же самое делаем с рабочим
        // в цикле начальник заполняет очередь заданиями
        for (int i = 1; i <= numberOfTasks; i++) {
            boss.giveTask("Задание " + i);
        }

        System.out.println("Начальник закончил давать задания");
        // в цикле говорим рабочему взять задание из очереди и выполнить его
        // скажем ему взять на одно задание больше, чем есть в очереди
        for (int i = 1; i <= numberOfTasks + 1; i++) {
            if(worker.isWorked){
                worker.takeTask();
            } else break;
        }

        Deque deque = new ArrayDeque();
        deque.add(12);
        deque.add(6);
        deque.add(4);
        deque.add(84);

        deque.poll();
        deque.peek();
        System.out.println(deque.element());
    }
}