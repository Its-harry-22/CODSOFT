/*--------NUMBER GAME--------*/
package Task1_NumberGame;

import java.util.*;

public class NumberGame{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //To set the range of random number
        int min = 1;
        int max = 100;

        //Number of attempts allow for each round
        int numAttempts = 5;

        //To keep track of user score
        int userScore = 0;

        System.out.println("--------JAVA PROGRAMMING INTERNSHIP--------");
        System.out.println("\n---------------TASK - 1---------------");
        System.out.println("\n****** WELCOME TO THE NUMBER GAME ******");
        System.out.println("\nAre You Ready? Let's Play.........");

        //using do while loop
        do{
            //To generate random number for each round
            int genratedNum = generateRandomNumber(min, max);
            System.out.println("The number is generated between "+min+" and "+max+". Guess it !");

            //Allow user to make multiple attempts
            for(int attempt = 1; attempt <= numAttempts; attempt++){
                System.out.print("\nAttempt "+attempt+": Enter your guess: ");
                int userGuess = sc.nextInt();

                //to check if user's guess is correct
                if(userGuess == genratedNum){
                    System.out.println("Congratulations ! you guessed the correct number.");
                    userScore = userScore + numAttempts - (attempt - 1);
                    break;
                }

                else if(userGuess < genratedNum){
                    System.out.println("Your guessed number is too low ! Please try again.");
                }

                else{
                    System.out.println("Your guessed number is too high ! Please try again.");
                }

                //to inform user if they have run out of attempts
                if(attempt == numAttempts){
                    System.out.println("\nSORRY..you have run out of attempts. The Correct number was: "+genratedNum);
                } 
            }

            //To ask user if they want to play again
            System.out.print("Do you want to play again ? (yes/no): ");
        }while(sc.next().equalsIgnoreCase("yes"));{
            //Display the user's total score when they decide to stop playing
            System.out.println("\nYour total score is :"+userScore);
            System.out.println("THANKS FOR PLAYING....");
        }

        sc.close();
    }

    public static int generateRandomNumber(int lower, int upper){
        return new Random().nextInt(upper - lower + 1)+lower;
    }
}