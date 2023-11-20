package org.example;

import java.util.Arrays;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(new User("Павел", 18), new User("Аркадий", 32), new User("Федор", 13));
        list.stream().map(user -> new User(user.name, user.age -5)).filter(user -> user.age >= 13).forEach(System.out::println);
    }


}
