package com.company;

public class Main {

    public static void main(String[] args) {

        Queue myQueue = new Queue();

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);

        System.out.println("My Queue - First in, first out");
        // it is like a line of people. The first person to get in
        // is the first person to leave

        System.out.println(myQueue.toString());
        myQueue.remove();
        System.out.println(myQueue.toString());


        Stack myStack = new Stack();
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println("Stack - last in, first out");
        // it is lack a stack of plates. The last plate you put on the top of the stack,
        // that's going to be the first plate to be removed
        System.out.println(myStack.toString());
        myStack.pop();
        System.out.println(myStack.toString());
    }
}
