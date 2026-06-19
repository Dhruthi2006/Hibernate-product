package com.example.student;

/**
 * Hello world!
 *
 */
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        StudentDao dao = new StudentDao();
        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Find student");
            System.out.println("3. Find All student");
            System.out.println("4. Update student");
            System.out.println("5. Delete studentS");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch(choice) {
            case 1:
                Student s = new Student();
                System.out.println("Enter student id:");
                s.setStudentId(sc.nextInt());
                System.out.print("Enter StudentName: ");
                s.setStudentName(sc.next());
                System.out.print("Enter email: ");
                s.setEmail(sc.next());
                System.out.print("Enter Course: ");
                s.setCourse(sc.next());
                System.out.print("Enter age: ");
                s.setAge(sc.nextInt());
                dao.saveStudent(s);
                break;
            case 2:
                System.out.print("Enter Student id: ");
                int id = sc.nextInt();
                Student s1 = dao.find(id);
                if(s1 != null) {
                    System.out.println(
                      s1.getStudentId()+" "+
                      s1.getStudentName()+" "+
                      s1.getEmail()+" "+
                      s1.getCourse()+" "+
                      s1.getAge()+" "
                     
                    );
                }
                else {
                    System.out.println("Student not found");
                }
                break;
            case 3:
                List<Student> list = dao.findAll();
                for(Student b1 : list) {
                    System.out.println(
                            b1.getStudentId()+" "+
                            b1.getStudentName()+" "+
                            b1.getEmail()+" "+
                            b1.getCourse()+" "+
                            b1.getAge()+" "
                           
                          );
                }
                break;
            case 4:
                Student update = new Student();
                System.out.println("Enter student id:");
                update.setStudentId(sc.nextInt());
                System.out.print("Enter StudentName: ");
                update.setStudentName(sc.next());
                System.out.print("Enter email: ");
                update.setEmail(sc.next());
                System.out.print("Enter Course: ");
                update.setCourse(sc.next());
                System.out.print("Enter age: ");
                update.setAge(sc.nextInt());
                dao.Update(update);
                break;
            case 5:
                System.out.print("Enter id to delete: ");
                int deleteId = sc.nextInt();
                dao.delete(deleteId);
                break;
            case 6:
                System.out.println("Exiting...");
                sc.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice");

            }
        }
    }
}