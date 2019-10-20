package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        int[] intervals = new int[721];
        //на всякий случай явно проинициализируем
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = 0;
        }
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        while (fileReader.ready()) {
            String[] times = fileReader.readLine().split(" ");
            String[] startInterval = times[0].split(":");
            String[] endInterval = times[1].split(":");
            int k = (Integer.parseInt(startInterval[0]) - 8) * 60 + Integer.parseInt(startInterval[1]);//написали когда пришел
            int z = (Integer.parseInt(endInterval[0]) - 8) * 60 + Integer.parseInt(endInterval[1]);//написали когда ушел
            for (int i = k; i < z; i++) {
                intervals[i]++;
            }
        }
        int max = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i] > max) {
                max = intervals[i];
            }
        }

        int start = -1;
        //int end = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (start == -1) {
                if (intervals[i] == max) {
                    start = i;
                    System.out.print((i / 60 + 8) + ":" + i % 60 + " ");
                }
            } else {
                if (intervals[i] != max) {
                    start = -1;
                    int t = i + 1;
                    String minutes = "";
                    if ((i) % 60 < 10) {
                        minutes = "0" + (i % 60);
                    } else
                        minutes = String.valueOf(i % 60);
                    System.out.println(((t) / 60 + 8) + ":" + minutes);
                }
            }
        }
    }
}

