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

    private static long totalTimeBucket;
    private static long totalTimeGen;
    private static long totalTimeInsertion;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Student[] s1 = generateStudents(4800);
        for (Student s2 : s1) {
            System.out.println(s2);
        }
        System.out.println("\n\n");

        Student[][] s3 = sortByGroup(s1);

        for (int i = 0; i < s3.length; i++) {
            for (Student s4 : s3[i]) {
                System.out.println(s4);
            }
        }
        System.out.println("\n\n");
        Student[] s5 = insertionSortGrade(s1);
        for (Student s6 : s5) {
            System.out.println(s6);
        }

        System.out.println(totalTimeBucket + " nano sec , bucket");
        System.out.println(totalTimeGen + " nano sec , gen");
        System.out.println(totalTimeInsertion + " nano sec , insertion");
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

        for (int i = 0; i < classArray.length; i++) {
            System.out.println(classArray[i]);
        }

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
        long startTimeBucket = System.nanoTime();
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
        long endTimeBucket = System.nanoTime();
        totalTimeBucket = endTimeBucket - startTimeBucket;
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
        long startTimeInsertion = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            int j = i;
            Student B = array[i];
            while ((j > 0) && (array[j - 1].getGrade() > B.getGrade())) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = B;
        }
        long endTimeInsertion = System.currentTimeMillis();
        totalTimeInsertion = endTimeInsertion - startTimeInsertion;
        return array;
    }
}
