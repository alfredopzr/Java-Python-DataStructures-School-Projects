//Alfredo Perez
//Bo Mei
//Data Structures
//March 30, 2020
//Assignment 3

public class Main {
    public static void main(String[] args) {
        BDDStack<Integer> stack = new ListStack<>(10);

        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(2);
        stack.push(9);


        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        System.out.println();
        BDDStack<Double> stack2 = new ArrayStack<>(10);

        stack2.push(2.0);
        stack2.push(7.5);
        stack2.push(3.2);

        BDDStack<Double> stack3 = stack2.copy();
        stack3.flip();

        while (!stack2.isEmpty()){
            System.out.println(stack2.pop());
        }

        System.out.println();

        while (!stack3.isEmpty()){
            System.out.println(stack3.pop());
        }
    }
}
