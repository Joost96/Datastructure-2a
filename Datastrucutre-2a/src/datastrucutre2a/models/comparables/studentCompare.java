/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastrucutre2a.models.comparables;

import datastrucutre2a.models.Student;
import java.util.Comparator;

/**
 *
 * @author Joost
 */
public class studentCompare {

    public Comparator studentNrCompare() {
        return new studentNrCompare();
    }

    public Comparator groupCompare() {
        return new groupCompare();
    }

    public Comparator gradeCompare() {
        return new gradeCompare();
    }

    private class studentNrCompare implements Comparator {

        @Override
        public int compare(Object t, Object t1) {
            Student a = (Student) t;
            Student b = (Student) t1;
            return (a.getStudentNr() - b.getStudentNr());
        }

    }

    private class groupCompare implements Comparator {

        @Override
        public int compare(Object t, Object t1) {
            Student a = (Student) t;
            Student b = (Student) t1;
            return (a.getGroup().compareTo(b.getGroup()));
        }

    }

    private class gradeCompare implements Comparator {

        @Override
        public int compare(Object t, Object t1) {
            Student a = (Student) t;
            Student b = (Student) t1;
            float result = (a.getGrade() - b.getGrade());
            if (result == 0) {
                return 0;
            } else if (result > 1) {
                return 1;
            } else {
                return -1;
            }
        }

    }
}
