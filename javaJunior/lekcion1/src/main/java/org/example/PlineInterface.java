package org.example;
//Если интерфейс не содержит методов, он называется - маркерным
//Если в интерфейсе 1 метод, он называется - функциональный
// Если много методов - обычный

@FunctionalInterface
public interface PlineInterface {
    int akcion(int x, int y);
}
