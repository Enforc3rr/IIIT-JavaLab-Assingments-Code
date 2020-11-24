package Lab2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Number of Students ->");
        int line = Integer.parseInt(br.readLine());
        int count = 0;
        Student st = null;
        Student [] student = new Student[line];
        while (count < line) {
            System.out.println("Enter First Name");
            String firstName = br.readLine();
            if (firstName.length() > 20) {
                System.out.println("Enter Name Again WithIn 20 Letters");
                firstName = br.readLine();
            }
            System.out.println("Enter Last Name");
            String lastName = br.readLine();
            if (lastName.length() > 20) {
                System.out.println("Enter Name Again WithIn 20 Letters");
                lastName = br.readLine();
            }
            System.out.println("Enter Section");
            String section = br.readLine();
            System.out.println("Enter Marks ->");
            int admMarks = Integer.parseInt(br.readLine());
            st = new Student(firstName, lastName, admMarks, section);
            student[count]=st;
            count++;
        }
        sort(student);
        display(student);
        sectionAllotment(student);

    }
    public static Student [] sort(Student [] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].admMarks > a[min].admMarks) {
                    min = j;
                }
            }
            int temp = a[i].admMarks;
            a[i] = a[min];
            a[min].admMarks = temp;
        }
        return a;
    }
    public static void sectionAllotment(Student [] students){
        Student [] A = new Student[5];
        int cA = 0 ;
        int i = 0 ;
        Student [] B = new Student[5];
        int cB = 0 , cC = 0 ;
        Student [] C = new Student[5];
        while (i < students.length-2){
         A[cA] = students[i];
         cA++;
         i = i + 3 ;
        }
        i= 0;
        while (i < students.length-1){
            B[cA] = students[i];
            cB++;
            i = i + 3 ;
        }
        i= 0;
        while (i < students.length){
            C[cC] = students[i];
            cC++;
            i = i + 3 ;
        }

        System.out.println("Section A");
        display(A);
        System.out.println("Section B");
        display(B);
        System.out.println("Section C");
        display(C);
    }
    public  static  void display(Student [] student){
        for(int i = 0 ; i < student.length ; i++){
            System.out.println(student[i].firstName + " " + student[i].lastName + " " + student[i].section + " " + student[i].admMarks);
        }
    }
}
class Student{
    String firstName ;
    String lastName ;
    int admMarks ;
    String section ;
    public Student(String firstName, String lastName, int admMarks, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.admMarks = admMarks;
        this.section = section;
    }
}
