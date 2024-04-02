
/* Hello, my name is peter manolis. This is the approach I took to solve the CodeCracker guessing game. The
purpose of this code is for two players to guess a random integer between 100 and 999. The users will recived feedback
if they get any of the 3 digits correct.
Step by Step:
1. I print out introductory statements.
2. I ask for the users to input their names.
3. I print out more statements guiding the users how the game works.
4. I generate a random number between 100-999.
5. I flip a coin using a random boolean variable to decide who gets to guess first.
6. Next I start a while loop that continues until the user has guessed all 3 digits.
7. Within the while loop there is an if statement and an else statement,
the if statement is what happens when player 1 guess's, and the else statement is for when player 2 has to guess.
8. Within the if and else statement I created a variable for the ones, tens, and hundreds digit for the users guess
and the random integer.
9. I check if the ones, tens, and hundreds digit are equal in the variables.
10. I create a 3 variables equal to "X" for each digit.
11. f they guess a correct digit, I add 1 to the users score, and replace the digit (in the variables stated above)
that is correct.
12. After each guess, I switch the coin boolean variable to the opposite value, to allow the other user to guess.
13. Finally, I print a congratulatory statement when the score reaches 3 and a user guesses all 3 integers
 */
import java.util.Scanner; // import Scanner class
import java.util.Random; // import Random class
public class CodeCracker {
    public static void main(String[] args) {

        System.out.println("Welcome to code cracker by Peter Manolis"); // introductory print statement

        Scanner in = new Scanner(System.in); //instance of scanner class
        System.out.println("Enter player 1 name: "); // ask for player1's name
        String firstName = in.next(); // store the users input in firstName variable

        Scanner in1 = new Scanner(System.in); // instance of scanner class
        System.out.println("Enter player 2 name: "); // ask for player2's name
        String secondName = in1.next(); // store the users input in secondName variable

        System.out.println("Can you crack the code?"); // user interaction

        Random firstRand = new Random(); // instance of random class
        int randNumber = firstRand.nextInt(100,1000); // store a random number b

        System.out.println("The computer has thought of a 3 digit number."); // user interaction
        System.out.println("Flipping a coin to decide who goes first."); // user interaction

        Random secondRand = new Random(); // instance of random class.
        boolean coin = secondRand.nextBoolean(); // random boolean value assigned to coin
        if (coin){ // if statement that is true when coin is true
            System.out.println(firstName + " gets the first turn..."); // print out the first user gets to go first
        }
        else{ // when coin is false
            System.out.println(secondName + " gets the first turn..."); // prints out the second user gets to go first
        }
        int score = 0; // initializes an integer variable called score with the value of 0
        String ones = "X"; // initializes a string variable called ones equal to "X"
        String tens = "X"; // initializes a string variable called ones equal to "X"
        String hundreds = "X"; // initializes a string variable called ones equal to "X"

        while (score < 3) { // a while loop that goes until the integer score is 3
            score = 0; // sets score equal to 0
            ones="X"; // sets ones equal to "X"
            tens = "X"; // sets tens equal to "X"
            hundreds = "X"; // sets hundreds equal to "X"
            if (coin) {  // if statement that is tue when coin is true, first user is guessing
                Scanner firstInput = new Scanner(System.in); // instance of scanner class
                System.out.println(firstName + " make a guess: "); // asks the first user to make a guess
                int firstGuess = firstInput.nextInt(); // makes integer firstGuess equal to the user input

                int firstGuessOne = (firstGuess % 1000) / 100; // makes firstGuessOne equal to the ones digit of the guess
                int firstGuessTen = (firstGuess % 100) / 10; // makes firstGuessTen equal to the tens digit of the guess
                int firstGuessHundred = firstGuess % 10; // makes firstGuessHundreds equal to the hundreds digit of the guess

                int randNumberOne = (randNumber % 1000) / 100; // makes randNumberOne equal to the ones digit of the random number
                int randNumberTen = (randNumber % 100) / 10; // makes randNumberTen equal to the tens digit of the random number
                int randNumberHundred = randNumber % 10; // makes randNumberHundred equal to the hundreds digit of the random number
                if (firstGuessOne == randNumberOne) { // if statement that is true when the first digit of the guess is equal to the first digit of the random number
                    score++; // integer score goes up 1
                    ones= Integer.toString(randNumberOne); // assigns the ones variable equal to the correct integer guess

                }

                if (firstGuessTen == randNumberTen) { // if statement that is true when the first digit of the guess is equal to the first digit of the random number
                    score++; // integer score goes up 1
                    tens= Integer.toString(randNumberTen); // assigns the tens variable equal to the correct integer guess

                }
                if (firstGuessHundred == randNumberHundred) { // if statement that is true when the hundreds digit of the guess is equal to the hundreds digit of the random number
                    score++; // integer score goes up 1
                    hundreds= Integer.toString(randNumberHundred); // assigns the hundreds varaible equal to the correct integer guess

                }
                System.out.println("You got " + score + " correct: " + ones + tens + hundreds); // prints out the users score and the ones, tens, and hundreds variable
                coin=false; // makes the coin boolean false which switches the user who is guessing

            } else { // when coin is false, when the second user is guessing
                Scanner secondInput = new Scanner(System.in); // instance of scanner class
                System.out.println(secondName + " make a guess: "); // asks the 2nd user to make a guess
                int secondGuess = secondInput.nextInt(); // makes the integer secondGuess equal to the input by the user

                int firstGuessOne = (secondGuess % 1000) / 100; // makes firstGuessOne equal to the ones digit of the guess
                int firstGuessTen = (secondGuess % 100) / 10; // makes firstGuessTen equal to the ones digit of the guess
                int firstGuessHundred = secondGuess % 10; // makes firstGuessHundred equal to the ones digit of the guess

                int randNumberOne = (randNumber % 1000) / 100; // makes randNumberOne equal to the ones digit of the random number
                int randNumberTen = (randNumber % 100) / 10; // makes randNumberOne equal to the ones digit of the random number
                int randNumberHundred = randNumber % 10; // makes randNumberOne equal to the ones digit of the random number

                if (firstGuessOne == randNumberOne) { // if statement that is true when the first digit of the guess is equal to the first digit of the random number
                    score++; // integer score goes up 1
                    ones= Integer.toString(randNumberOne); // assigns the ones variable equal to the correct integer guess
                }

                if (firstGuessTen == randNumberTen) { // if statement that is true when the first digit of the guess is equal to the first digit of the random number
                    score++; // integer score goes up 1
                    tens= Integer.toString(randNumberTen); // assigns the tens variable equal to the correct integer guess

                }
                if (firstGuessHundred == randNumberHundred) { // if statement that is true when the hundreds digit of the guess is equal to the hundreds digit of the random number
                    score++; // integer score goes up 1
                    hundreds= Integer.toString(randNumberHundred); // assigns the hundreds variable equal to the correct integer guess

                }
                System.out.println("You got " + score + " correct: " + ones + tens + hundreds); // prints out the users score and the ones, tens, and hundreds variable
                coin=true; // makes the coin boolean false which switches the user who is guessing
            }
        }
        // once score is equal to 3, the last user to give a guess is printed as the winner
        if (!coin){ // if statement that is true if coin is equal to false
            System.out.println(firstName + " Wins!"); // prints the name of the winner
        }
        else{ // when coin is false
            System.out.println(secondName + " Wins!"); // prints the name of the winner

        }
        System.out.println("Bye bye!"); // ends the game
    }
}
