/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastrucutre2a;

import datastrucutre2a.models.*;
import datastrucutre2a.models.comparables.StudentCompare;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Joost & Mohamed
 */
public class Main {

    private static int studentN = 50060000;
    private static String group;
    private static float grade;
    private static String[] g = {"G", "N", "S", "T"};
    private static Student[] s;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    public static Student[] generateStudents(int n) {
        Random rn = new Random();
        int[] studieAmount = new int[4];
        int[] classAmount = new int[4];
        Student[] students = new Student[n];
        int prevGroup = 0;
        
        studieAmount[0] = n / studieAmount.length;
        studieAmount[1] = n / studieAmount.length;
        studieAmount[2] = n / studieAmount.length;
        studieAmount[3] = n / studieAmount.length;
        
        if (n % 4 != 0) {
            for (int i = 0; i < n % studieAmount.length; i++) {
                studieAmount[prevGroup]++;
                if(prevGroup>=3) {
                    prevGroup = 0;
                } else {
                    prevGroup++;
                }
            }
        }
        for(int i=0;i<studieAmount.length;i++) {
            classAmount[i] = studieAmount[i]/32;
            if(studieAmount[i]%32 != 0) {
                classAmount[i]++;
            }
        }
        
        prevGroup = 0;
        for (int i = 0; i < n; i++) {
            int studentNr = 500000000 + i;
            Student student = new Student(studentNr,);
        }
        return students;
    }

    public static void insertionSortStudentNr(Student array[]) {
        for (int i = 1; i < array.length; i++) {
            StudentCompare comparables = new StudentCompare();
            Comparator compare = comparables.studentNrCompare();
            int j = i;
            Student B = array[i];
            while ((j > 0) && (compare.compare(array[j - 1], B) > 0)) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = B;
        }
    }

    public static void insertionSortGrade(Student array[]) {
        for (int i = 1; i < array.length; i++) {
            StudentCompare comparables = new StudentCompare();
            Comparator compare = comparables.groupCompare();
            int j = i;
            Student B = array[i];
            while ((j > 0) && (compare.compare(array[j - 1], B) > 0)) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = B;
        }
    }

    public static void insertionSortGroup(Student array[]) {
        for (int i = 1; i < array.length; i++) {
            StudentCompare comparables = new StudentCompare();
            Comparator compare = comparables.groupCompare();
            int j = i;
            Student B = array[i];
            while ((j > 0) && (compare.compare(array[j - 1], B) > 0)) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = B;
        }
    }
}
