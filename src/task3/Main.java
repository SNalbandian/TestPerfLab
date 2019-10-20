package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Float> arrayList1 = new ArrayList<>();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        ArrayList<Float> arrayList3 = new ArrayList<>();
        ArrayList<Float> arrayList4 = new ArrayList<>();
        ArrayList<Float> arrayList5 = new ArrayList<>();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(args[0]));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(args[1]));
        BufferedReader fileReader3 = new BufferedReader(new FileReader(args[2]));
        BufferedReader fileReader4 = new BufferedReader(new FileReader(args[3]));
        BufferedReader fileReader5 = new BufferedReader(new FileReader(args[4]));
        while (fileReader1.ready() && fileReader2.ready() && fileReader3.ready() && fileReader4.ready() && fileReader5.ready()) {
            arrayList1.add(Float.parseFloat(fileReader1.readLine()));
            arrayList2.add(Float.parseFloat(fileReader2.readLine()));
            arrayList3.add(Float.parseFloat(fileReader3.readLine()));
            arrayList4.add(Float.parseFloat(fileReader4.readLine()));
            arrayList5.add(Float.parseFloat(fileReader5.readLine()));
        }
        if (fileReader1 != null) {
            fileReader1.close();
        }
        if (fileReader2 != null) {
            fileReader2.close();
        }
        if (fileReader3 != null) {
            fileReader3.close();
        }
        if (fileReader4 != null) {
            fileReader4.close();
        }
        if (fileReader5 != null) {
            fileReader5.close();
        }
        float[] array1 = new float[16];
        float[] array2 = new float[16];
        float[] array3 = new float[16];
        float[] array4 = new float[16];
        float[] array5 = new float[16];
        for (int i = 0; i < arrayList1.size(); i++) {
            array1[i] = arrayList1.get(i);
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            array2[i] = arrayList2.get(i);
        }
        for (int i = 0; i < arrayList3.size(); i++) {
            array3[i] = arrayList3.get(i);
        }
        for (int i = 0; i < arrayList4.size(); i++) {
            array4[i] = arrayList4.get(i);
        }
        for (int i = 0; i < arrayList5.size(); i++) {
            array5[i] = arrayList5.get(i);
        }
        float sum = array1[0] + array2[0] + array3[0] + array3[0] + array4[0] + array5[0];
        float max = sum;
        int n = 1;
        for (int i = 1; i < 16; i++) {
            sum = array1[i] + array2[i] + array3[i] + array3[i] + array4[i] + array5[i];
            if (sum > max) {
                max = sum;
                n = i + 1;
            }
        }
        System.out.println("Номер интервала в котором было больше всего человек - " + n);
    }
}
