package dev.pranavtech.week3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    int id;
    String name;
    float GPA;

    Student(int id, String name, float gpa) {
        this.id = id;
        this.name = name;
        this.GPA = gpa;
    }

    @Override
    public String toString() {
        return "[" + id + ", " + name + ", GPA: " + GPA + "]";
    }

    @Override
    public int compareTo(Student other) {
        // We want to sort in descending order of GPA, so we reverse the usual comparison
        //return Float.compare(other.GPA, this.GPA);
        if (this.GPA > other.GPA){
            return -1;
        } else if (this.GPA < other.GPA){
            return 1;
        }else{
            return 0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // PriorityQueue will use the natural ordering of Student, based on GPA descending
        PriorityQueue<Student> studentPQ = new PriorityQueue<>();

        // Read the CSV file and populate the PriorityQueue
        String csvFile = "src/main/resources/students.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] studentData = line.split(csvSplitBy);
                int id = Integer.parseInt(studentData[0]);
                String name = studentData[1];
                float gpa = Float.parseFloat(studentData[2]);

                Student s = new Student(id, name, gpa);
                studentPQ.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Distribute the prize money to the top 5 students with GPA >= 4.0
        int maxRecipients = 5;
        int recipients = 0;


        System.out.println("Top " + maxRecipients + " students with GPA >= 4.0 eligible for the prize:");

        while (!studentPQ.isEmpty() && recipients < maxRecipients) {
            Student topStudent = studentPQ.remove();

            if (topStudent.GPA >= 4.0) {
                System.out.println(topStudent + " wins!");
                recipients++;
            }
        }

        // If there are fewer than 5 eligible students
        if (recipients < maxRecipients) {
            System.out.println("Only " + recipients + " students were eligible for the prize.");
        }
    }

}

