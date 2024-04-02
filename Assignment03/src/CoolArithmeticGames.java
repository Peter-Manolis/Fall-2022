/* Hello, my name is Peter Manolis. In these comments, I outline my approach adn goal of this code. The goal of this
code is to make an interactive math game that helps to improve your multiplication and addition skills. The game
tracks the users current win streak and keeps their longest win streak. As the user gets questions right or wrong
they will get a number of points. The amount of points they receive is based on weather they answered
addition/multiplication questions, and how many questions they answered correctly. The user can end the game
whenever they want.
Step by Step:
1. Welcomed the user to the arithmetic game and established 4 variables that are used throughout the game
2. Started a do while loop that lasts until the user inputs "3" which ends the game as well
3. inside the first do while loop I start with some introductory code that asks teh user what part of the game they
want to access. I do this by getting the users input and then 3 if statements take them to the desired game. If they
don't input any of the 3 games, they are told it's an invalid input and to try again.
4. if the user selects "1", the arithmetic game, another do while loop begins. Then they are prompted to select either addition (1) or multiplication
(2). I use another 2 if statements to guide the user to the addition or multiplication game based on their input
5. When the user selects the addition game, another do while loop begins. This loop goes until all the questions are
answered.
6. I prompt the user to input a number higher than their score. This value is used to create the random addition questions
7. I call the arithGame method, this method returns the points that should be added to the users score.
8. If the user gets the question right or wrong, then their score will add the value returned from the arithGame method
9. As the user goes through a round, then the current streak will go up 1. If the current streak is higher than their long
streak, then current streak becomes the long streak.
10. once all teh questions are answered, teh do while loop ends, and it returns the user to the homepage with an update
on their new score
11. Steps 5-9 are repeated for the multiplication section of the arithmetic game
12. if the user selects "2" on the home screen, it will take them to the Hall of Fame. This displays the users current
score, current streak, and their high streak.
13. if the user selects "3" on the home screen, the code ends.



 */
import java.util.Random; // import Random class
import java.util.Scanner; // import Scanner class

public class CoolArithmeticGames {
    public static void main(String[] args) {
        System.out.println("Welcome to Cool Arithmetic Games!"); // introductory print statement
        boolean valid = true; // establishes a boolean variable called valid as true
        double userScore = 0; // establishes a double variable called userScore as 0
        int highStreak = 0; // establishes an int variable called highStreak as 0
        int currentStreak = 0; // establishes an int variable called currentStreak as 0

        do { // starts a do while loop
            System.out.println("Please make a selection from the following:"); // Asks the user to select the section of the game they want to access
            System.out.println("1. Play Arithmetic Game."); // ^
            System.out.println("2. View Hall of Fame."); // ^^
            System.out.println("3. Quit."); // ^^^

            Scanner in = new Scanner(System.in); // instance of Scanner class
            String gameSelection = in.next(); // stores the users input as gameSelectiom

            boolean validArithmetic = true; // establishes a boolean variable called validArithmetic as true.

            if (gameSelection.equals("1")) { // if statement that is true if gameSelection is equal to "1"
                do { // starts a do while loop

                    Scanner in1 = new Scanner(System.in); // instance of Scanner class
                    System.out.println("Would you like (1) addition or (2) multiplication?"); // asks the user what game they want to play
                    String addOrMultiply = in1.next(); // stores the users input as addOrMultiply

                    if (addOrMultiply.equals("1")) { // if statement that is true if the user inputs "1"
                        boolean maxNumberIsGreaterAddition = true; // establishes a boolean variable called maxNumberIsGreaterAddition as true

                        do { // starts a do while loop

                            Scanner in2 = new Scanner(System.in); // instance of Scanner class
                            System.out.println("Enter the maximum number, which must be greater than your score (" + (int)userScore + ") :"); // asks the user to input a number higher than their score
                            int maxNumber = in2.nextInt(); // stores the users input as maxNumber

                            if (maxNumber > userScore){ // if statement that is true when maxNumber is less than userScore
                                maxNumberIsGreaterAddition= false; // sets maxNumberIsGreaterAddition to false
                                int scoreFromAdd = arithGame(maxNumber, (int)(Math.ceil(userScore/5)+1), true); // sets scoreFromAdd equal to instance of the arithGame method. Which returns a number/their score
                                userScore += scoreFromAdd; // adds  the integer scoreFromAdd to userScore. Their points gained in the previous round.
                                currentStreak++;  // current streak goes up one
                                if (scoreFromAdd == 0){ // if statement true when scoreFromAdd == 0/ when they get a question wrong
                                    currentStreak=0; // makes the users streak equal to 0
                                }
                            }

                            if (currentStreak > highStreak) { // if statement that is true when their current streak is higher than their highest streak
                                highStreak = currentStreak; // sets their high streak to their current streak
                            }

                            else{
                                System.out.println("That max number is too low, please try again."); // tells the user to reenter a number higher than their score
                            }
                        }while (maxNumberIsGreaterAddition); // ends the do while loop when maxNumberIsGreaterAddition is false


                        validArithmetic=false; // sets validArithmetic to false



                    } else if (addOrMultiply.equals("2")) { // else if statement that is true if the users input is equal to "2"
                        boolean maxNumberIsGreaterMultiplication = true; // sets boolean variable called maxNumberIsGreaterMultiplication to true.

                        do { // starts a do while loop

                            Scanner in2 = new Scanner(System.in); // instance of Scanner class
                            System.out.println("Enter the maximum number, which must be greater than your score (" + (int)userScore + ") :"); // asks the user to enter a number higher than their score
                            int maxNumber = in2.nextInt(); // sets maxNumber equal to the users input

                            if (maxNumber > userScore){ // if statement is true when maxNumber is greater than the users score.
                                maxNumberIsGreaterMultiplication= false; // sets maxNumberIsGreaterMultiplication to false
                                int scoreFromMultiply = arithGame(maxNumber, (int)(Math.ceil(userScore/5)+1),false); // sets scoreFromMultiply equal to instance of the arithGame method. Which returns a number/their score
                                userScore+=scoreFromMultiply; // adds scoreFromMultiply to userScore
                                currentStreak++; // their current streak goes up 1
                                if (scoreFromMultiply==0){ // if statement true when scoreFromAdd == 0/ when they get a question wrong
                                    currentStreak=0; // makes their current streak 0
                                }
                            }
                            if (currentStreak>highStreak){ // if statement that is true when their current streak is higher than their highest streak
                                highStreak=currentStreak; // sets their high streak to their current streak
                            }
                            else{
                                System.out.println("That max number is too low, please try again."); // tells the user to reenter a number higher than their score
                            }

                        }while (maxNumberIsGreaterMultiplication); // ends the do while loop when maxNumberIsGreaterMultiplication is false

                        validArithmetic=false; // sets validArithmetic to false


                    } else {
                        System.out.println("Invalid Selection, please try again."); // if the user doesn't input "1" or "2" they are prompted to reenter the number


                    }
                } while (validArithmetic); // the do while loop continues until validArithmetic is false
            }



            else if (gameSelection.equals("2")) { // if the user inputs "2" on the home page
                System.out.println("===== Hall of Fame ====="); // shows the user they are in the hall of fame
                System.out.println("Your score: " + (int)userScore); // prints the users score
                System.out.println("Current round win streak: " + currentStreak + ", and still going!"); // prints the users current streak
                System.out.println("Longest round win streak: " + highStreak); // prints the users highest streak
                System.out.println("======================="); // looks good


            } else if (gameSelection.equals("3")) { // if the user inputs "3" on the home page
                System.out.println("Goodbye!"); // prints out goodbye
                valid=false; // makes valid equal to false / ends the game
            } else {
                System.out.println("Invalid selection, please try again."); // if the user doesn't select "1" , "2" , or "3" on the homepage, they must reenter a value
            }
        } while (valid); // ends the do while loop when valid is false


    }

    static int arithGame(int max, int numberOfQuestions, boolean isAdditionGame){ // creates a static method called arithGame that returns an integer
        int addScore=0; // creates an integer addScore and sets it equal to 0
        if (isAdditionGame) { // if isAdditionGame is true
            while (numberOfQuestions > 0) { // a while loop until numberOfQuestions is equal to 0
                Random firstRand = new Random(); // instance of random class
                int randNumberOne = firstRand.nextInt(0, max+1); // sets randNumberOne equal to a random integer between 0 and max

                Random secondRand = new Random(); // instance of random class
                int randNumberTwo = secondRand.nextInt(0, max+1); // sets randNumberTwo equal to a random integer between 0 and max

                System.out.println(randNumberOne + " + " + randNumberTwo + " = "); // prints out the mathematical equation with the random integers
                Scanner in = new Scanner(System.in); // instance of scanner class
                int userGuess = in.nextInt(); // sets userGuess equal to the users input
                if (userGuess == (randNumberOne + randNumberTwo)) { // if they user answers the questions correctly
                    addScore++; // addScore goes up 1
                }
                else { // if the question is answered incorrectly
                    addScore=0; // if the question is answered incorrectly
                    break; // the method is over

                }
                numberOfQuestions--; // number of questions goes down 1
            }
            System.out.println("You got " + addScore + " points for winning!"); // prints the users points for winning
            return addScore; // returns addScore
        }
        else{ // if IsAddition is false
            while (numberOfQuestions > 0) { // a while loop until numberOfQuestions is equal to 0
                Random firstRand = new Random(); // instance of random class
                int randNumberOne = firstRand.nextInt(0, max+1); // sets randNumberOne equal to a random integer between 0 and max

                Random secondRand = new Random(); // instance of random class
                int randNumberTwo = secondRand.nextInt(0, max+1); // sets randNumberOne equal to a random integer between 0 and max

                System.out.println(randNumberOne + " * " + randNumberTwo + " = "); // prints out the mathematical equation with the random integers
                Scanner in = new Scanner(System.in); // instance of scanner class
                int userGuess = in.nextInt(); // sets userGuess equal to the users input
                if (userGuess == (randNumberOne * randNumberTwo)) { // if they user answers the questions correctly
                    addScore=addScore+2; // addScore gos up 2
                }
                else { // if the question is answered incorrectly
                    addScore=0; // if the question is answered incorrectly
                    break; // method is over
                }
                numberOfQuestions--; // number of questions goes down 1
            }
            System.out.println("You got " + addScore + " points for winning!"); // prints the users points for winning
            return addScore; // returns addScore
        }
        }

}