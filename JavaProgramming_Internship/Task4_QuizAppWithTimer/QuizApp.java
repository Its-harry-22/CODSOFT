package Task4_QuizAppWithTimer;

import java.util.*;

//class representing a quiz question
class QuizQuestion{
    private String question;
    private String[] options;
    private int correctOptionIndex;

    public QuizQuestion(String question, String[] options, int correctOptionIndex){
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion(){
        return question;
    }

    public String[] getOptions(){
        return options;
    }

    public int getCorrectOptionIndex(){
        return correctOptionIndex;
    }
}

//Class representing the Quiz Application
public class QuizApp {
    private static Scanner sc = new Scanner(System.in);
    private static Timer timer;

    public static void main(String[] args){
        System.out.println("--------JAVA PROGRAMMING INTERNSHIP--------");
        System.out.println("\n---------------TASK - 4---------------");
        System.out.println("\n******* WELCOME TO THE QUIZ APP *******\n");

        //create quiz questions
        QuizQuestion[] quizQuestions = {
            new QuizQuestion("What is the capital of India?", new String[]{"A. Mumbai", "B. New Delhi", "C. Kolkata", "D. Pune"}, 1),
            new QuizQuestion("What is national sports of India?", new String[]{"A. Cricket", "B. Kho-Kho", "C. Hockey", "D. Kabaddi"}, 2),
        };

        //Set quiz timer duaration in seconds
        int quizTimerDuration = 10;

        int userScore = 0;

        //Start
        for(QuizQuestion question : quizQuestions){
            displayQuestion(question);

            //start the timer for the current question
            startTimer(quizTimerDuration);

            //Allow user to submit an answer within the timer duration
            int userAnswer = getUserAnswer(question.getOptions().length);

            //Stop the timer
            timer.cancel();

            //Check if the user's answer is correct
            if(userAnswer == question.getCorrectOptionIndex()){
                System.out.println("Correct Answer.");
                userScore++;
            }

            else{
                System.out.println("Incorrect. The correct answer is: "+question.getOptions()[question.getCorrectOptionIndex()]);
            }
        }

        //Display the final score and summary
        System.out.println("\nQuiz Completed.");
        System.out.println("Your final score: "+userScore+" out of "+quizQuestions.length);

        //closing scanner
        sc.close();
    }

    //Method to display a quiz question
    private static void displayQuestion(QuizQuestion question){
        System.out.println("\n"+question.getQuestion());
        for(String option : question.getOptions()){
            System.out.println(option);
        }

        System.out.print("Enter your answer (1 - "+question.getOptions().length+ "): ");
    }

    //Method to start the timer for each question
    private static void startTimer(int duration){
        timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                System.out.println("\nTime's up! Moving to the next question.");
                timer.cancel();
            }
        }, duration * 1000);
    }

    //Method to get user's answer
    private static int getUserAnswer(int numOptions){
        int userAnswer = -1;
        boolean isValidInput = false;

        do{
            try{
                userAnswer = sc.nextInt();
                if(userAnswer >=1 && userAnswer <= numOptions){
                    isValidInput = true;
                }

                else{
                    System.out.print("Invalid input. Please enter a number between 1 and "+numOptions+": ");
                }
            } catch(Exception e){
                System.out.print("Invalid input. Please enter a number: ");
                sc.next(); //consume the invalid input
            }
        } while(!isValidInput);

        return userAnswer - 1; //Adjust to 0-based index
    }
}
