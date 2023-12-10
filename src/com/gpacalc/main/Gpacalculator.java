package com.gpacalc.main;

import com.gpacalc.utils.Console;
import com.gpacalc.models.Course;
import com.gpacalc.models.Grades;


public class Gpacalculator {
  

    public static void main(String[] args) {
        System.out.println("Grade Point Average(GPA) Calculator");

        int numberOfCourses = Console.checkPositiveNumber("Enter the number of courses you wish to calculate: ");
        Course[] courses = new Course[numberOfCourses];
        //Course [] courses = new Course[5]

        for (int i = 0; i < numberOfCourses; i++) {
            Course course = inputCourse(i);
            // Add the course to the array
            courses[i] = course;
        }

        fullCourseInfo(courses);

        double gpa = Grades.calculateGPA(courses);
        System.out.printf("\nYour GPA is: %.2f\n", gpa);
    }

    private static void fullCourseInfo(Course[] courses) {
        System.out.println("\n Here are your Course details and grades:\n");

        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");

        for (Course course : courses) {
            String grade = Grades.scoreToLetter(course.getScore());
            int gradePoint = Grades.letterToNumericalValue(course.getScore());

            System.out.format("| %-27s| %-21s | %-10s | %-19s |\n",
                    course.getCourseNameAndCode(), course.getUnits(), grade, gradePoint);
        }
        System.out.println("|---------------------------------------------------------------------------------------|");
    }

    private static Course inputCourse(int i) {

        int count = i + 1;
        System.out.println("\nEnter details for Course *" + count);

        String  courseNameAndCode = Console.retrieveCourseNameAndCode("Course Name And Code(e.g. MTH 101): ");
        int units = Console.retrieveCourseUnit("Units: ");
        double score = Console.retrieveCourseScore("Score: ");

        return new Course(courseNameAndCode, units, score);
    }

  
}