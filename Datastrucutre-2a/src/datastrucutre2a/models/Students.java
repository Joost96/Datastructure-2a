/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastrucutre2a.models;

/**
 *
 * @author Joost
 */
public class Students {
    
    private int studentNr;
    private String group;
    private float grade;
    
    public Students(int studentNr , String group , float grade) {
        this.studentNr = studentNr;
        this.group = group;
        this.grade = grade;
    }

    public int getStudentNr() {
        return studentNr;
    }

    public void setStudentNr(int studentNr) {
        this.studentNr = studentNr;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
    
    
}
