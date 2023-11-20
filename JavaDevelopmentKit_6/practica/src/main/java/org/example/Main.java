package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        descriptiveStatistics.addValue(12);
        descriptiveStatistics.addValue(1);
        descriptiveStatistics.addValue(123);
        descriptiveStatistics.addValue(1212);

        System.out.println("Максимальное число - " + descriptiveStatistics.getMax());
        System.out.println("Минимальное число - " + descriptiveStatistics.getMin());
        System.out.println("Среднее значение - " + descriptiveStatistics.getMean());
        System.out.println("Сумма чисел " + descriptiveStatistics.getSum());

    }
}