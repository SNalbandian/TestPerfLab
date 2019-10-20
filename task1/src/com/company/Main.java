package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
/**
    //Нахождение 90 Персентиля: Находим Положение нашего персентиля = (количество элем.+1) * 90/100;
    //Определяем число персентиля: если число целое, то берем данный элемент массива, после считаем по формуле:
    // (элемент положения массива-1) + (элемент положения массива-(элемент положения массива-1)) * (элемент положения массива-Положение);
 */
    public static double percentiles(short[] array) {
        Arrays.sort(array, 0, array.length);
        double Poloj = (array.length + 1) * 0.9;
        if (Poloj % 1 == 0) {
            return (double) array[(int) Poloj-1];
        } else {
            double percent = (array[(int) Poloj-1]) + (array[(int) Poloj] - array[(int)Poloj-1]) * (array[(int) Poloj] - Poloj);
            return percent;
        }
    }

    public static double median(short[] array) {
        Arrays.sort(array, 0, array.length);
        int middle = array.length / 2;
        if (array.length % 2 == 1) {
            return array[middle];
        } else {
            return (array[middle - 1] + array[middle]) / 2.0;
        }
    }

    public static short max(short[] array) {
        short maximum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (maximum < array[i]) {
                maximum = array[i];
            }
        }
        return maximum;
    }

    public static short min(short[] array) {
        short minimum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (minimum > array[i]) {
                minimum = array[i];
            }
        }
        return minimum;
    }

    public static double average(short[] array) {
        int sum = 0;
        for (double x : array) {
            sum += x;
        }
        double average = sum * 1.0 / array.length;
        return average;
    }


    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        ArrayList<Short> arrayList = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            arrayList.add(Short.parseShort(fileReader.readLine()));
        }
        if (fileReader != null) {
            fileReader.close();
        }
        short[] array = new short[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);

        }

        //int[] array = initializeArray();
        double percent = percentiles(array);
        double median = median(array);
        double max = max(array);
        double min = min(array);
        double average = average(array);

        System.out.printf("Перцинтель - %.2f\n", percent);
        System.out.printf("Медиана - %.2f\n", median);
        System.out.printf("Максимум - %.2f\n", max);
        System.out.printf("Минимум - %.2f\n", min);
        System.out.printf("Среднее - %.2f\n", average);

        // write your code here
    }
}
