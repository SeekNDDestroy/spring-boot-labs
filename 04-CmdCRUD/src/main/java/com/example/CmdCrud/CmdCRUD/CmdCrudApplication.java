package com.example.CmdCrud.CmdCRUD;

import com.example.CmdCrud.CmdCRUD.DAO.StudentDAO;
import com.example.CmdCrud.CmdCRUD.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CmdCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmdCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return args -> {
            try(Scanner scanner = new Scanner(System.in)){


                while (true) {
                    System.out.println("===== Student Management Menu =====");

                    // Create
                    System.out.println("1. Insert new student");

                    // Display
                    System.out.println("2. Display all students");
                    System.out.println("3. Display student by ID");
                    System.out.println("4. Display student(s) by first name");

                    // Update
                    System.out.println("5. Update student information");

                    // Delete
                    System.out.println("6. Delete all students");
                    System.out.println("7. Delete student by ID");

                    System.out.print("Enter your choice: ");
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1: // Create
                            saveStudent(studentDAO, scanner);
                            break;

                        case 2: // Display all
                            getAllStudents(studentDAO);
                            break;

                        case 3: // Display by ID
                            System.out.println("Enter student ID");
                            int id = Integer.parseInt(scanner.nextLine());
                            System.out.println(findStudentByID(id, studentDAO));
                            break;

                        case 4: // Display by first name
                            getStudentByFirstName(studentDAO, scanner);
                            break;

                        case 5: // Update
                            updateStudentInfo(studentDAO, scanner);
                            break;

                        case 6: // Delete all
                            deleteAllStudents(studentDAO);
                            break;

                        case 7: // Delete by ID
                            deleteStudentById(studentDAO, scanner);
                            break;

                        default:
                            System.out.println("Invalid input. Please try again.");
                    }
                }


            }
        };
    }

    //insert
    public void saveStudent(StudentDAO studentDAO, Scanner scanner){
        System.out.println("enter student's name");
        String firstName = scanner.nextLine();
        System.out.println("enter student's last name");
        String lastName = scanner.nextLine();
        System.out.println("enter student's age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("enter student's grade");
        String grade = scanner.nextLine();

        studentDAO.save(new Student(firstName, lastName, age, grade));
        System.out.println("student's data has been saved!");
    }

    //display
    public void getAllStudents(StudentDAO studentDAO){
        List<Student> students = studentDAO.getAll();
        if(students.isEmpty()){
            System.out.println("no students found");
        }
        System.out.println("-----all students-----");
        students.stream()
                .forEach(x -> System.out.println(x));
    }

    public void getStudentByFirstName(StudentDAO studentDAO, Scanner scanner){
        System.out.println("enter student's first name");
        String firstName = scanner.nextLine();
        System.out.println(studentDAO.findByFirstName(firstName));

    }

    public Student findStudentByID(Integer id, StudentDAO studentDAO){
        return studentDAO.getById(id);
    }



    public void updateStudentInfo(StudentDAO studentDAO, Scanner scanner){
        System.out.println("enter the student's id of the student to change the info of");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = findStudentByID(id, studentDAO);

        System.out.println("enter student's new age");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("enter student's new grade");
        String grade = scanner.nextLine();

        student.setAge(age);
        student.setGrade(grade);

        studentDAO.update(student);
    }

    //delete
    public void deleteAllStudents(StudentDAO studentDAO){
        int numberOfDeletedRows = studentDAO.deleteAll();
        System.out.println(numberOfDeletedRows);
    }

    public void deleteStudentById(StudentDAO studentDAO, Scanner scanner){

        System.out.println("Enter the ID of student");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println(studentDAO.deleteById(id));
    }

}
