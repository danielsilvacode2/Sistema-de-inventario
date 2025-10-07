package application;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {


        List<Integer>numbers = new ArrayList<>();

        numbers.add(21);
        numbers.add(5);
        numbers.add(4);
        System.out.println("lista 1: ");
        numbers.forEach(System.out::println);

        numbers = numeros();

        System.out.print("lista 3: ");
        numbers.forEach(System.out::println);

    }
    public static List<Integer> numeros(){
        List<Integer>n = new ArrayList<>();
        n.add(2);
        n.add(3);
        n.add(3);
        System.out.print("lista 2: ");
        n.forEach(System.out::println);
        return n;
    }
}
