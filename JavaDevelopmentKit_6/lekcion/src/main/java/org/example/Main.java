package org.example;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public void printMine() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("hello.txt");
        System.out.println(new String(inputStream.readAllBytes()));
    }
    public static void main(String[] args) throws IOException {
        new Main().printMine();
    }

}