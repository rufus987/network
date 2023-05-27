package org.example;

import java.util.EmptyStackException;
import java.util.Queue;
import java.util.Stack;

public class Worker {
    boolean isWorked = true;
    private Stack toDoQueue; // у рабочего есть ссылка на очередь из заданий

    public Worker(Stack toDoQueue) {
        this.toDoQueue = toDoQueue; // даем ссылку на очередь в конструкторе
    }

    public void takeTask() {
        try {
            Object task = toDoQueue.pop();
            System.out.println("Выполняю задачу: " + task);
            isWorked = true;
        } catch (EmptyStackException e){
            System.out.println("Нет работы! Можно идти домой");
            isWorked = false;
        }
    }
}
