/* STUDENT GRADE CALCULATOR */

package Task2_StudentGradeCalculator;

import java.util.Scanner;

public class GradeCalculator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("--------JAVA PROGRAMMING INTERNSHIP--------");
        System.out.println("\n---------------TASK - 2---------------");
        System.out.println("\n*** WELCOME TO THE STUDENT GRADE CALCULATOR ***");

        //To take number of subjects
        System.out.print("\nEnter the number of subjects: ");
        int numOfSubjects = sc.nextInt();
        System.out.println();

        int totalMarks = 0;

        //To take marks of each subject
        for(int i=1; i<=numOfSubjects; i++){
            System.out.print("Enter marks for subject "+i+" (out off 100): ");
            int marks = sc.nextInt();

            //To check if marks entered are vaild
            if(marks<0 || marks>100){
                System.out.println("Please enter valid marks. Marks should be between 0 and 100. Please try again.");
                i--; //to re-enter marks for current subject
            }
            
            else{
                totalMarks += marks;
            }
        }

        //To calculate average percentage
        double avgPercentage = (double)totalMarks/numOfSubjects;

        //To calculate the grade based on the average percentage
        char grade = calculateGrade(avgPercentage);

        //To display results to user
        System.out.println("\nRESULTS:");
        System.out.println("Total Marks: "+totalMarks);
        System.out.println("Avergae Percentage: "+avgPercentage+"%");
        System.out.println("Grade: "+grade);

        sc.close();
    }

    public static char calculateGrade(double averagePercentage){
        if(averagePercentage >= 90){
            return 'A';
        }

        else if(averagePercentage >= 80){
            return 'B';
        }

        else if(averagePercentage >= 70){
            return 'C';
        }

        else if(averagePercentage >=60){
            return 'D';
        }

        else{
            return 'F';
        }
    }
}
