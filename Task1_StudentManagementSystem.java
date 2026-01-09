import java.util.ArrayList;
import java.util.Scanner;

class AcademicRecord{
    int year;
    double cgpa;

    AcademicRecord(int year, double cgpa) {
        this.year = year;
        this.cgpa = cgpa;
    }
    
}

class Student{
    int id;
    String name;
    int age;
    String branch;
    ArrayList<AcademicRecord> records;

    Student(int id, String name, int age, String branch){
        this.id = id;
        this.name = name;
        this.age = age;
        this.branch = branch;
        this.records = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public ArrayList<AcademicRecord> getRecords(){
        return records;
    }
}

class StudentService{
    Scanner sc = new Scanner(System.in);
    ArrayList<Student> studs = new ArrayList<>();
    
    public void AddStudentDetails(){
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Branch: ");
        String branch = sc.next();

        Student s = new Student(id, name, age, branch);
       
        System.out.print("How many years data to enter (1-4): ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            addAcademicDetails(s);
        }
        studs.add(s);
        System.out.println("Student added successfully");

    }

    public void addAcademicDetails(Student s){
        System.out.println("Enter Year (1-4): ");
        int year = sc.nextInt();

        System.out.println("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        s.records.add(new AcademicRecord(year, cgpa));      
    }

    public void searchStudent() {
    System.out.print("Enter Student ID to search: ");
    int id = sc.nextInt();

    for (Student s : studs) {
        if (s.getId() == id) {

            System.out.println("\n----- Student Details -----");
            System.out.println("ID      : " + s.id);
            System.out.println("Name    : " + s.name);
            System.out.println("Age     : " + s.age);
            System.out.println("Branch  : " + s.branch);

            if (s.records.isEmpty()) {
                System.err.println("No academic records available");
            } else {
                System.out.println("---- Academic Records ----");
                for (AcademicRecord r : s.records) {
                    System.out.println(
                        "Year " + r.year +
                        " | CGPA: " + r.cgpa
                    );
                }
            }
            return;
        }
    }
    System.err.println("Student not found");
}


     public void displayStudents() {
         if (studs.isEmpty()) {
        System.out.println("No records found");
        return;
    }

    for (Student s : studs) {
        System.out.println("\nID: " + s.id);
        System.out.println("Name: " + s.name);
        System.out.println("Age: " + s.age);
        System.out.println("Branch: " + s.branch);

        for (AcademicRecord r : s.records) {
            System.out.println(
                "Year " + r.year +
                " | CGPA: " + r.cgpa
            );
        }
    }

    }

    public void menu(){
        String choice;

        System.out.println("******************************************************************");
        System.out.println("Enter the number for selection from following menu");
        System.out.println("1.Add Student details\n2.Search Student\n3.Display Students\n4.Exit");
        System.out.println("******************************************************************");

        while(true){
            choice = sc.next();
            switch(choice) {
                case "1" -> AddStudentDetails();

                case "2" -> searchStudent();

                case "3" -> displayStudents();

                case "4" -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> {
                    System.err.println("Enter vaid input!!");
                    
                    System.out.println("******************************************************************");
                    System.out.println("1.Add Student details\n2.Search Student\n3.Result\n4.Attendence\n5.Exit");
                     System.out.println("******************************************************************");
                }
            }
        }
    }


}
public class Task1_StudentManagementSystem {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        service.menu();

    }
}
