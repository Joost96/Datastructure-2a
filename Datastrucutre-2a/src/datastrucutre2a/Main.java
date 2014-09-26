/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastrucutre2a;
import datastrucutre2a.models.*;
import java.util.Random;
/**
 *
 * @author Joost & Mohamed
 */
public class Main {
    private static int studentN = 50060001;
    private static String group;
    private static float grade;
    private static String[] g = {"G","N","S","T"};
    private static Student s;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       s = generateStudent();
       
    }
    
    public static Student generateStudent(){
        int counter = 1;
        Random rn = new Random();
        int i = rn.nextInt(4)+0;
        group = "I" + g[i] + "20" + 1;
        grade = (int)(Math.random()*10);
        studentN++;
        Student s = new Student(studentN,group,grade);
        System.out.println(s);
        return s;
    }
    
}
