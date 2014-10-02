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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Student[] s1 = generateStudents(200);
         int count = 0;
         for (Student s2 : s1) {
             if(s2.getGroup().equals("IG201")){
             System.out.println(s2.toString());
             count++;
             }
         }
        System.out.println(count);
    }

    public static Student[] generateStudents(int n) {
        int[] studieAmount = new int[4];
        int[] classAmount = new int[4];
        String[] className = {"G","S","T","N"};
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
        
        int sum = classAmount[0] + classAmount[1] + classAmount[2] + classAmount[3]; 
        int counter = 0;
        String[] classArray = new String[sum];
            for (int j = 0; j < 4; j++) {
                for (int i = 1; i < classAmount[j]+1; i++) {
                    String c = "I" +  className[j] + "20" + i;
                    
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
            float grade = (float)Math.random()*10;
            grade = Math.round(grade);
            studentNr++;
            if(teller >= classArray.length)
             teller=0;
           students[i] = new Student(studentNr,classArray[teller],grade);   
           teller++;
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
