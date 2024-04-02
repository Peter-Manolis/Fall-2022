import java.util.Scanner; // import scanner class
import java.util.Random; // import random class


/*Hello, My name is Peter Manolis, and this is my code for the Guessing Game. The purpose of this code
is to have 2 players try and guess a secret number, that I have generated, between 1 and 100.
Step by Step:
1st the code asks for the name of the two users playing the game.
2nd I generate a random number between 1 and 100.
3rd I ask for the two player's guesses at the random number.
4th I print and show what the secret number was.
5th I calculate and print out the difference between the users guess, and teh random integer. I also check to make sure the
bigger number is being subtracted by the smaller number.
6th I print out who is the winner based on the difference between their guess and the random integer.
*/
public class GuessingGame {
    public static void main(String[] args) {
        //User enters 1st name
        Scanner in = new Scanner(System.in); //instance of scanner class
        System.out.println("Enter Player 1 Name: "); //ask for user's name
        String firstName = in.next(); // user puts in name and is assigned to firstName

        //User enters 2nd name
        Scanner in1 = new Scanner(System.in); // instance of scanner class
        System.out.println("Enter Player 2 Name: "); // ask for user's name
        String secondName = in1.next(); // user puts in name and is assigned to secondName

        //random number between 1-100
        System.out.println("Hmmmmm, let me think of a number between 1 and 100");//user interaction
        System.out.println("Alright, I have thought of a number.");//user interaction
        Random rand = new Random(); //instance of random class
        int randomNumber = rand.nextInt(100) +1; // generate random number

        //Asks for the first users guess
        Scanner in2 = new Scanner(System.in);//instance of scanner class
        System.out.println(firstName + " enter your guess: "); // asks for the first users guess
        int firstGuess = in2.nextInt(); // firstName enters their guess and is assigned to firstGuess

        //Asks for the second users guess
        Scanner in3 = new Scanner(System.in);// instance of scanner class
        System.out.println(secondName + " enter your guess: "); //asks for the second users guess
        int secondGuess = in3.nextInt();// secondName enters their guess and is assigned to guess 2

        //Displays secret number
        System.out.println("The secret number was " + randomNumber);//prints secret number

        //Calculates the difference between firstGuess and the random int
        int firstGuessDifference=0; //initializes firstGuessDifference integer
        if (firstGuess>randomNumber){ // when firstGuess is less than randomNumber
            firstGuessDifference=firstGuess-randomNumber; // sets firstGuessDifference equal to firstGuess minus randomNumber
            System.out.println(firstName + " had " + firstGuess + " with a difference of " + firstGuess + " - " + randomNumber + " = " + firstGuessDifference); //prints firstName,  their guess, and the difference between  their guess and randomNumber
        }
        if(firstGuess<=randomNumber){ //when guess 1 is less than or equal to randomNumber
            firstGuessDifference=randomNumber-firstGuess;// sets firstGuessDifference equal to randomNumber minus guess 1
            System.out.println(firstName + " had " + firstGuess + " with a difference of " + randomNumber + " - " + firstGuess + " = " + firstGuessDifference);//prints firstName, their guess, and the difference between randomNumber and their guess

        }
        //Calculates the difference between firstGuess and the random int
        int secondGuessDifference=0;//initializes secondGuessDifference integer
        if (secondGuess>=randomNumber){ //when secondGuess is less than or equal to Random Number
            secondGuessDifference=secondGuess-randomNumber; //sets secondGuessDifference equal to secondGuess minus randomNumber
            System.out.println(secondName + " had " + secondGuess + " with a difference of " + secondGuess + " - " + randomNumber + " = " + secondGuessDifference);//prints secondName, their guess, and the difference between their guess and randomNumber

        }
        if(secondGuess<randomNumber){ //when secondGuess is less than randomNumber
            secondGuessDifference = randomNumber - secondGuess; // sets secondGuessDifference equal to randomNumber minus secondGuess
            System.out.println(secondName + " had " + secondGuess + " with a difference of " + randomNumber + " - " + secondGuess + " = " + secondGuessDifference);//prints secondName, their guess, and the difference between randomNumber and their guess

        }

        //Shows the winner
        if (firstGuess==secondGuess){ //when both players guess the same number
            System.out.println("Since both players guessed the same number, the winner is the first player who guessed a number, and that happens to be " + firstName +"."); // prints the description of why the winner is chosen
            System.out.println(firstName+ " Wins!!!");//firstName is the winner because they guessed the same number
        }
        if(firstGuessDifference<secondGuessDifference){ //when firstGuessDifference is less than secondGuessDifference
            System.out.println(firstName+ " Wins!!!"); //name 1 is the winner because their difference is smaller than secondName
        }
            else if (firstGuessDifference>secondGuessDifference){ //when firstGuessDifference is greater than diff 2
                System.out.println(secondName+ " Wins!!!");//secondName is the winner because their difference is smaller then firstName
            }
            else{ //edge case when the differences are the same
                if(firstGuess<secondGuess){ //when firstGuess is less than secondGuess
                    System.out.println("Since both scores are equal, the winner is the one who guessed the lower number wins, and that happens to be " + firstName + ".");//prints the description of why the winner is chosen
                    System.out.println(firstName + " Wins!!!"); //firstName is the winner because they guessed the lower number

                }

                if(firstGuess>secondGuess){ //when firstGuess is greater than secondGuess
                System.out.println("Since both scores are equal, the winner is the one who guessed the lower number wins, and that happens to be " + secondName + ".");//prints the description of why the winner is chosen
                System.out.println(secondName + " Wins!!!");//secondName is the winner because they guessed the lower number
            }
        }

    }
}