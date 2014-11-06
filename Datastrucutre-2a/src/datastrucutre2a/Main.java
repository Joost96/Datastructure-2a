/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastrucutre2a;

import datastrucutre2a.models.*;
import datastrucutre2a.models.comparables.StudentCompare;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Joost & Mohamed
 */
public class Main {

    private static int studentN = 50060000;
    private static String[] classArray = null;
    private static int[] classAmount = new int[4];
    private static int[] studieAmount = new int[4];

    private static long totalTimeGen;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long totalTimeInsertion[] = new long[100];
        long totalTimeBucket[] = new long[100];
        for (int i = 0; i < 100; i++) {
            Student[] s1 = generateStudents(1600);

            long startTimeBucket = System.nanoTime();
            Student[][] s3 = sortByGroup(s1);
            long endTimeBucket = System.nanoTime();

            long startTimeInsertion = System.nanoTime();
            Student[] s5 = insertionSortGrade(s1);
            long endTimeInsertion = System.nanoTime();

            totalTimeInsertion[i] = endTimeInsertion - startTimeInsertion;
            totalTimeBucket[i] = endTimeBucket - startTimeBucket;
        }

        System.out.println(avg(totalTimeBucket) + " nano sec , bucket");
//        System.out.println(totalTimeGen + " nano sec , gen");
        System.out.println(avg(totalTimeInsertion) + " nano sec , insertion");
    }

    public static Student[] generateStudents(int n) {
        long startTimeGen = System.currentTimeMillis();
        String[] className = {"G", "S", "T", "N"};
        Student[] students = new Student[n];
        int prevGroup = 0;

        studieAmount[0] = n / studieAmount.length;
        studieAmount[1] = n / studieAmount.length;
        studieAmount[2] = n / studieAmount.length;
        studieAmount[3] = n / studieAmount.length;

        if (n % 4 != 0) {
            for (int i = 0; i < n % studieAmount.length; i++) {
                studieAmount[prevGroup]++;
                if (prevGroup >= 3) {
                    prevGroup = 0;
                } else {
                    prevGroup++;
                }
            }
        }
        for (int i = 0; i < studieAmount.length; i++) {
            classAmount[i] = studieAmount[i] / 32;
            if (studieAmount[i] % 32 != 0) {
                classAmount[i]++;
            }
        }

        int sum = classAmount[0] + classAmount[1] + classAmount[2] + classAmount[3];
        int counter = 0;
        classArray = new String[sum];
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < classAmount[j] + 1; i++) {
                String c = "I" + className[j] + "20" + i;

                classArray[counter] = c;
                counter++;
            }
        }

//        for (int i = 0; i < classArray.length; i++) {
//            System.out.println(classArray[i]);
//        }
        prevGroup = 0;
        int studentNr = 500000000;
        int teller = 0;
        for (int i = 0; i < n; i++) {
            float grade = (float) Math.random() * 10;
            grade = Math.round(grade);
            studentNr++;
            if (teller >= classArray.length) {
                teller = 0;
            }
            students[i] = new Student(studentNr, classArray[teller], grade);
            teller++;
        }
        long endTimeGen = System.currentTimeMillis();
        totalTimeGen = endTimeGen - startTimeGen;
        return students;
    }

    public static Student[][] sortByGroup(Student[] students) {
        int amount = studieAmount[1] / classAmount[1];
        if (studieAmount[1] % classAmount[1] != 0) {
            amount++;
        }
        Student[][] classes = new Student[classArray.length][amount];
        int[] filled = new int[classArray.length];
        for (Student student : students) {
            for (int i = 0; i < classArray.length; i++) {
                if (student.getGroup().equals(classArray[i])) {
                    classes[i][filled[i]] = student;
                    filled[i] += 1;
                }
            }
        }
        for (int i = 0; i < classes.length; i++) {

            classes[i] = insertionSortStudentNr(classes[i]);
        }
        return classes;
    }

    public static Student[] insertionSortStudentNr(Student array[]) {
        for (int i = 0; i < array.length; i++) {
            int j = i;
            Student B = array[i];
            while ((j > 0) && B != null && (array[j - 1].getStudentNr() > B.getStudentNr())) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = B;
        }
        return array;
    }

    public static Student[] insertionSortGrade(Student array[]) {
        for (int i = 0; i < array.length; i++) {
            int j = i;
            Student B = array[i];
            while ((j > 0) && (array[j - 1].getGrade() > B.getGrade())) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = B;
        }
        return array;
    }

    public static long avg(long[] numbers) {
        long avg =0;
        long sum =0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        avg = sum/numbers.length;
        return avg;
    }
}
