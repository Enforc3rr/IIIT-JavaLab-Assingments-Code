package LabExam;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        List<String> coursesOfBtech = new ArrayList<>();
        coursesOfBtech.add("DSA");
        coursesOfBtech.add("Discrete");
        coursesOfBtech.add("OOPS Lab");
        List<Integer> courseNo = new ArrayList<>();
        courseNo.add(100);
        courseNo.add(90);
        courseNo.add(80);
        BTechStudent bTechStudent = new BTechStudent("Nishchay" ,30 ,coursesOfBtech,courseNo);
        System.out.println(bTechStudent.toString());

        List<String> coursesOfMtech = new ArrayList<>();
        coursesOfMtech.add("Micro-Processor");
        coursesOfMtech.add("Electronics");
        List<Integer> courseNoMtech = new ArrayList<>();
        courseNoMtech.add(100);
        courseNoMtech.add(90);
        MTechStudent mTechStudent = new MTechStudent("Swasari" ,40 ,coursesOfMtech,courseNoMtech);
        System.out.println(mTechStudent.toString());


    }
}
abstract class student {
    public String studentType;
    public String studentName;
    public int rollNo;
    public List<String> courses;
    public List<Integer> gpa;
    public float cgpa;
    public String studentCategory;


    public abstract void cgpaCal();
    public abstract void categoryOfStudent();

    @Override
    public String toString(){
        return "student{" +
                "studentType='" + studentType + '\'' +
                ", studentName='" + studentName + '\'' +
                ", rollNo=" + rollNo +
                ", courses=" + courses +
                ", gpa=" + gpa +
                ", cgpa=" + cgpa +
                ", studentCategory='" + studentCategory + '\'' +
                '}';
    }
}

class BTechStudent extends student{
    public BTechStudent(String studentName, int rollNo, List<String> courses, List<Integer> gpa) {
        this.studentType = "BTech";
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.courses = courses;
        this.gpa = gpa;
        cgpaCal();
        categoryOfStudent();
    }
    @Override
    public void cgpaCal() {
        System.out.println(this.gpa);
        float sum = 0;
        for (int i = 0; i < this.gpa.size(); i++) {
            sum = sum + this.gpa.get(i);
        }
        sum = sum / this.gpa.size();
        this.cgpa = sum;
    }
    @Override
    public void categoryOfStudent() {
        if (this.cgpa > 9.0) {
            this.studentCategory = "Distinction";
        } else if (this.cgpa < 9.0 && this.cgpa > 8.0) {
            this.studentCategory = "Second-Class";
        } else if (this.cgpa < 8.0 && this.cgpa > 7.0) {
            this.studentCategory = "Third-Class";
        } else {
            this.studentCategory = "Other-Class";
        }
    }
}
class MTechStudent extends student{
    public MTechStudent(String studentName, int rollNo, List<String> courses, List<Integer> gpa) {
        this.studentType = "MTech";
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.courses = courses;
        this.gpa = gpa;
        cgpaCal();
        categoryOfStudent();
    }
    @Override
    public void cgpaCal() {
        float sum = 0;
        for (int i = 0; i < this.gpa.size(); i++) {
            sum = sum + this.gpa.get(i);
        }
        sum = sum / this.gpa.size();
        this.cgpa = sum;
    }
    @Override
    public void categoryOfStudent() {
        if (this.cgpa > 7.5) {
            this.studentCategory = "Distinction";
        }else{
            this.studentCategory = "Non-Distinction";
        }
    }
}


