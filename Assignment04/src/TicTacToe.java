/*
Hello my name is Peter Manolis, I am going to outline the goal of this code. The goal of this game is to make
a tic tak toe game that can be played against a computer or against a friend. If you choose to play a friend
then you enter the row and column of the move you would like to do. If you play against a computer, then you
have 3 difficulties to choose from. Easy: which selects a random spot on the board every time, Medium: trys to
get 3 in a row diagonally, and Hard: which will win the game or draw every time. You can also display all teh moves
from teh previous game by selecting "D" on the main menu. There is also a "Quit" option ont eh main menu which ends the
game.

Step By Step:
1. I created a displayFromState method, which returns the current state of the game board.
2. Created a getInBoundsPlayerMove method, which repeatedly prompts player for move. Returns [row, column] of
their desired move such that row & column are on.
3. I created a checkValidMove method, when given a [row, col] move, return true if a space is unclaimed.
4. I created a makeMove method, when given a [row, col] move, the symbol to add, and a game state,
return a NEW array (do NOT modify the argument currentState) with the new game state.
5. I created a checkWin method, given a state, return true if some player has won in that state
6. I created a checkDraw method, given a state, simply checks whether all spaces are occupied. Does not care or
check if a player has won.
7. I created a easyCPUMove method, given a game state, return a new game state with the move from the easy AI
The easy AI should simply make a move at random from the available spaces.
8. I created a mediumCPUMove method, given a game state, return a new game state with the move from the medium AI,
which trys to connect either of the 2 diaganols
9. I created a hardCPUMove method, given a game state, return a new game state with move from the hard AI
 The hard AI follows the algorithm in the PDF to ensure a tie (or win if possible)
10. I created a runGameHistory method, given player names and the game history, display the past game as in the PDF
sample code output
11. I created a runTwoPlayerGame method, given the player names, run the two-player game.
return an ArrayList of game states of each turn -- in other words, the gameHistory
12. I created a runOnePlayerGame method, given the player names
(where player two is "Easy Computer", "Medium Computer", etc.), and the difficulty,
Run the one-player game.
Return an ArrayList of game states of each turn -- in other words, the gameHistory
13. I created a menu system with do while loops that will ask the user what they want to do until they select to quit
the game
14. In each selection I simply call the runOnePlayerGame or runTwoPlayerGame methods, based on which game they are
going to play

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class TicTacToe {
    // Static variables for the TicTacToe class, effectively configuration options
    // Use these instead of hard-coding ' ', 'X', and 'O' as symbols for the game
    // In other words, changing one of these variables should change the program
    // to use that new symbol instead without breaking anything
    // Do NOT add additional static variables to the class!
    static char emptySpaceSymbol = ' ';
    static char playerOneSymbol = 'X';
    static char playerTwoSymbol = 'O';

    public static void main(String[] args) {
        // TODO
        // This is where the main menu system of the program will be written.
        // Hint: Since many of the game runner methods take in an array of player names,
        // you'll probably need to collect names here.
        char[][] firstArray = new char[3][3];
        boolean validMenuChoice = true;
        ArrayList<char[][]> gameHistory = new ArrayList<>();
        String [] playerNames = new String[]{};

        do { // starts teh main menu
            System.out.println("1. Single player"); // main menu options
            System.out.println("2. Two player"); // ^^
            System.out.println("D. Display last match"); // ^^^
            System.out.println("Q. Quit"); // ^^^

            Scanner in = new Scanner(System.in);
            System.out.println("What do you want to do: ");
            String menuChoice = in.next();

            if (menuChoice.equals("1")) { //when the user selects a one player game
                boolean validOnePlayerChoice = true;
                do {
                    System.out.println("E: Easy"); // ^
                    System.out.println("M: Medium"); // ^^
                    System.out.println("H: Hard"); // ^^^

                    Scanner in1 = new Scanner(System.in);
                    System.out.println("Choose difficulty: ");
                    String difficultyChoice = in1.next();



                    if (difficultyChoice.equals("E") || difficultyChoice.equals("e")){ //if the user selects easy
                        Scanner in2 = new Scanner(System.in);
                        System.out.println("Enter player 1 name: ");
                        String playerOne = in2.next();
                        String playerTwo = "Easy Computer";
                        playerNames = new String[]{playerOne,playerTwo};

                        gameHistory = runOnePlayerGame(playerNames, 'e');
                        validOnePlayerChoice =false;



                    }
                    else if (difficultyChoice.equals("M") || difficultyChoice.equals("m")){ //if the user selects medium
                        Scanner in2 = new Scanner(System.in);
                        System.out.println("Enter player 1 name: ");
                        String playerOne = in2.next();
                        String playerTwo = "Medium Computer";
                        playerNames = new String[]{playerOne,playerTwo};

                        gameHistory=runOnePlayerGame(playerNames, 'm');
                        validOnePlayerChoice =false;



                    }
                    else if (difficultyChoice.equals("H") || difficultyChoice.equals("h")){// if the user selects hard
                        Scanner in2 = new Scanner(System.in);
                        System.out.println("Enter player 1 name: ");
                        String playerOne = in2.next();
                        String playerTwo = "Hard Computer";
                        playerNames = new String[]{playerOne,playerTwo};
                        gameHistory=runOnePlayerGame(playerNames, 'h');
                        validOnePlayerChoice =false;


                    }
                    else{
                        System.out.println("'" + difficultyChoice + "' is not a valid difficulty"); //when they choose an invalid option
                    }

                } while (validOnePlayerChoice);



            } else if (menuChoice.equals("2")) { //if the user selects a two player game

                    Scanner in1 = new Scanner(System.in);
                    System.out.println("Enter player 1 name: ");
                    String playerOne = in1.next();

                    Scanner in2 = new Scanner(System.in);
                    System.out.println("Enter player 2 name: ");
                    String playerTwo = in2.next();

                    playerNames = new String[]{playerOne, playerTwo};


                    gameHistory = runTwoPlayerGame(playerNames);


            } else if (menuChoice.equals("D") || menuChoice.equals("d")) { //if the user wnats to display the previous game
                //for (int i =0; i <gameHistory.size();i++){
                    //System.out.println(gameHistory.get(i));
               // }
               // System.out.println(gameHistory);
                runGameHistory(playerNames,gameHistory);

            } else if (menuChoice.equals("Q") || menuChoice.equals("q")) { //if the user wants to quit and end the code
                System.out.println("Thanks for playing. Hope you had fun!");
                break;



            } else
                System.out.println("'" + menuChoice +  "' is not a valid option."); //invaldi main menu choice
        } while (validMenuChoice);
    }


    // Given a state, return a String which is the textual representation of the tic-tac-toe board at that state.
    private static String displayGameFromState(char[][] state) {
        // TODO
        // Hint: Make use of the newline character \n to get everything into one String
        // It would be best practice to do this with a loop, but since we hardcode the game to only use 3x3 boards
        // it's fine to do this without one.
        String stringBoard = "";
        for (int row = 0; row < state.length; row++) {
            if (row>0) {
                stringBoard += "\n";
                stringBoard += "---------";
                stringBoard += "\n";


            }
            for (int col = 0; col < state[row].length; col++) {
                stringBoard = stringBoard + state[row][col];
                if (col < 2) {
                    stringBoard += " | ";
                }
            }

        }
        System.out.println(stringBoard);
        return null;
    }

    // Returns the state of a game that has just started.
    // This method is implemented for you. You can use it as an example of how to utilize the static class variables.
    // As you can see, you can use it just like any other variable, since it is instantiated and given a value already.
    private static char[][] getInitialGameState() {
        return new char[][]{{emptySpaceSymbol, emptySpaceSymbol, emptySpaceSymbol},
                {emptySpaceSymbol, emptySpaceSymbol, emptySpaceSymbol},
                {emptySpaceSymbol, emptySpaceSymbol, emptySpaceSymbol}};
    }

    // Given the player names, run the two-player game.
    // Return an ArrayList of game states of each turn -- in other words, the gameHistory
    private static ArrayList<char[][]> runTwoPlayerGame(String[] playerNames) {
        ArrayList<char[][]> gameHistory = new ArrayList<>();
        char[][] currentState = getInitialGameState();
        System.out.println("Tossing a coin to decide who goes first!!!");

        Random secondRand = new Random(); // instance of random class.
        boolean coin = secondRand.nextBoolean(); // random boolean value assigned to coin

        if (coin){ // if statement that is true when coin is true
            System.out.println(playerNames[0] + " gets to go first."); // print out the first user gets to go first

        }
        else{ // when coin is false
            System.out.println(playerNames[1] + " gets to go first"); // prints out the second user gets to go first


        }
        displayGameFromState(currentState);

        boolean gameNotOver = true;
        boolean usersTurn = true;

        while (!checkDraw(currentState) || !checkWin(currentState)){
            if (coin){
                int[] move = getInBoundsPlayerMove(playerNames[0]);
                if (checkValidMove(move, currentState)){
                    currentState = makeMove(move, playerOneSymbol, currentState);
                    gameHistory.add(currentState);
                    displayGameFromState(currentState);
                    if (checkWin(currentState)){
                        System.out.println(playerNames[0] + " wins!");
                        break;
                    }
                    if (checkDraw(currentState)) {
                        System.out.println("It's a draw!");
                        break;
                    }
                    coin = false;
                }
                else {
                    System.out.println("That space is already taken. Try again.");
                }
            }
            else{
                int[] move = getInBoundsPlayerMove(playerNames[1]);
                if (checkValidMove(move, currentState)){
                    currentState = makeMove(move, playerTwoSymbol, currentState);
                    gameHistory.add(currentState);
                    displayGameFromState(currentState);
                    if (checkWin(currentState)){
                        System.out.println(playerNames[1] + " wins!");

                        break;
                    }
                    if (checkDraw(currentState)) {
                        System.out.println("It's a draw!");
                        break;
                    }

                    coin = true;
                }
                else {
                    System.out.println("That space is already taken. Try again.");
                }
            }
        }


        return gameHistory;
    }

    // Given the player names (where player two is "Easy Computer", "Medium Computer", etc.), and the difficulty,
    // Run the one-player game.
    // Return an ArrayList of game states of each turn -- in other words, the gameHistory
    private static ArrayList<char[][]> runOnePlayerGame(String[] playerNames, char difficulty) {
        ArrayList<char[][]> gameHistory = new ArrayList<>();
        char[][] currentState = getInitialGameState();
        System.out.println("Tossing a coin to decide who goes first!!!");

        Random secondRand = new Random(); // instance of random class.
        boolean coin = secondRand.nextBoolean(); // random boolean value assigned to coin

        if (coin){ // if statement that is true when coin is true
            System.out.println(playerNames[0] + " gets to go first."); // print out the first user gets to go first

        }
        else{ // when coin is false
            System.out.println(playerNames[1] + " gets to go first"); // prints out the second user gets to go first

        }
        displayGameFromState(currentState);
        while (!checkDraw(currentState) || !checkWin(currentState)){
            if (coin) {
                int[] move = getInBoundsPlayerMove(playerNames[0]);
                if (checkValidMove(move, currentState)){
                    currentState = makeMove(move, playerOneSymbol, currentState);
                    gameHistory.add(currentState);
                    displayGameFromState(currentState);
                    if (checkWin(currentState)){
                        System.out.println(playerNames[0] + " wins!");
                        break;
                    }
                    if (checkDraw(currentState)) {
                        System.out.println("It's a draw!");
                        break;
                    }
                    coin = false;
                }
                else {
                    System.out.println("That space is already taken. Try again.");
                }
            }
            else{
                if ((difficulty=='e') || (difficulty == 'E')) {
                    System.out.println("Easy Computer's turn");
                    getEasyCPUMove(currentState);
                    gameHistory.add(currentState);
                    displayGameFromState(currentState);
                    if (checkWin(currentState)) {
                        System.out.println(playerNames[1] + " wins!");
                        break;
                    }
                    if (checkDraw(currentState)) {
                        System.out.println("It's a draw!");
                        break;
                    }
                    coin = true;
                }
                if ((difficulty=='m') || (difficulty == 'M')) {
                    System.out.println("Medium Computer's turn");
                    getMediumCPUMove(currentState);
                    gameHistory.add(currentState);
                    displayGameFromState(currentState);
                    if (checkWin(currentState)) {
                        System.out.println(playerNames[1] + " wins!");
                        break;
                    }
                    if (checkDraw(currentState)) {
                        System.out.println("It's a draw!");
                        break;
                    }
                    coin = true;
                }
                    if ((difficulty=='h') || (difficulty=='H')) {
                        System.out.println("Hard Computer's turn");
                        getHardCPUMove(currentState);
                        gameHistory.add(currentState);
                        displayGameFromState(currentState);
                        if (checkWin(currentState)) {
                            System.out.println(playerNames[1] + " wins!");
                            break;
                        }
                        if (checkDraw(currentState)) {
                            System.out.println("It's a draw!");
                            break;
                        }
                        coin = true;

                    }
                }
        }
        return gameHistory;
    }

    // Repeatedly prompts player for move in current state, returning new state after their valid move is made
    private static char[][] runPlayerMove(String playerName, char playerSymbol, char[][] currentState) {
        char[][] updatedState = currentState;
        int[] move = getInBoundsPlayerMove(playerName);
        updatedState[move[0]][move[1]] = playerSymbol;
        return updatedState;
    }

    // Repeatedly prompts player for move. Returns [row, column] of their desired move such that row & column are on
    // the 3x3 board, but does not check for availability of that space.
    private static int[] getInBoundsPlayerMove(String playerName) {
        boolean inBoundsMove = true;
        int[] playerMove = new int[]{};

        do {
            Scanner in1 = new Scanner(System.in); // instance of scanner class
            System.out.println(playerName + " enter row: ");
            int rowValue = in1.nextInt();

            Scanner in = new Scanner(System.in); // instance of scanner class
            System.out.println(playerName + " enter col: ");
            int colValue = in.nextInt();
            if ((rowValue >= 3 || rowValue < 0) || (colValue >= 3 || colValue < 0)) {
                System.out.println("That row or column is out of bounds. Try again.");
            } else {
                playerMove = new int[]{rowValue, colValue};
                inBoundsMove=false;
            }

        } while (inBoundsMove);
        return playerMove;
    }


    // Given a [row, col] move, return true iff a space is unclaimed.
    // Doesn't need to check whether move is within bounds of the board.
    private static boolean checkValidMove(int[] move, char[][] state) {
        if (state[move[0]][move[1]] == emptySpaceSymbol){
            return true;
        }
        return false;
    }

    // Given a [row, col] move, the symbol to add, and a game state,
    // Return a NEW array (do NOT modify the argument currentState) with the new game state
    private static char[][] makeMove(int[] move, char symbol, char[][] currentState) {
        // Hint: Make use of Arrays.copyOf() somehow to copy a 1D array easily
        // You may need to use it multiple times for a 1D array
        char [][] updatedState = currentState;
        updatedState[move[0]][move[1]] = symbol;
        return updatedState;
    }

    // Given a state, return true iff some player has won in that state
    private static boolean checkWin(char[][] state) {
        // Hint: no need to check if player one has won and if player two has won in separate steps,
        // you can just check if the same symbol occurs three times in any row, col, or diagonal (except empty space symbol)
        // But either implementation is valid: do whatever makes most sense to you.

        // Player One Symbols
            // Horizontals
            if (state[0][0] == playerOneSymbol && state[0][1] == playerOneSymbol && state[0][2] == playerOneSymbol){
                return true;
            }
            if (state[1][0] == playerOneSymbol && state[1][1] == playerOneSymbol && state[1][2] == playerOneSymbol){
                return true;
            }
            if (state[2][0] == playerOneSymbol && state[2][1] == playerOneSymbol && state[2][2] == playerOneSymbol){
                return true;
            }

            // Verticals
            if (state[0][0] == playerOneSymbol && state[1][0] == playerOneSymbol && state[2][0] == playerOneSymbol){
                return true;
            }
            if (state[0][1] == playerOneSymbol && state[1][1] == playerOneSymbol && state[2][1] == playerOneSymbol){
                return true;
            }
            if (state[0][2] == playerOneSymbol && state[1][2] == playerOneSymbol && state[2][2] == playerOneSymbol){
                return true;
            }
            // Diagonals
            if (state[0][0] == playerOneSymbol && state[1][1] == playerOneSymbol && state[2][2] == playerOneSymbol){
                return true;
            }
            if (state[2][0] == playerOneSymbol && state[1][1] == playerOneSymbol && state[0][2] == playerOneSymbol){
                return true;
            }

        // Player 2 Symbols
            // Horizontals
            if (state[0][0] == playerTwoSymbol && state[0][1] == playerTwoSymbol && state[0][2] == playerTwoSymbol){
                return true;
            }
            if (state[1][0] == playerTwoSymbol && state[1][1] == playerTwoSymbol && state[1][2] == playerTwoSymbol){
                return true;
            }
            if (state[2][0] == playerTwoSymbol && state[2][1] == playerTwoSymbol && state[2][2] == playerTwoSymbol){
                return true;
            }

            // Verticals
            if (state[0][0] == playerTwoSymbol && state[1][0] == playerTwoSymbol && state[2][0] == playerTwoSymbol){
                return true;
            }
            if (state[0][1] == playerTwoSymbol && state[1][1] == playerTwoSymbol && state[2][1] == playerTwoSymbol){
                return true;
            }
            if (state[0][2] == playerTwoSymbol && state[1][2] == playerTwoSymbol && state[2][2] == playerTwoSymbol){
                return true;
            }
            // Diagonals
            if (state[0][0] == playerTwoSymbol && state[1][1] == playerTwoSymbol && state[2][2] == playerTwoSymbol){
                return true;
            }
            if (state[2][0] == playerTwoSymbol && state[1][1] == playerTwoSymbol && state[0][2] == playerTwoSymbol){
                return true;
            }
        return false;
    }

    // Given a state, simply checks whether all spaces are occupied. Does not care or check if a player has won.
    private static boolean checkDraw(char[][] state) {
        char firstPosition = state[0][0];
        char secondPosition = state[0][1];
        char thirdPosition = state[0][2];
        char fourthPosition = state[1][0];
        char fifthPosition = state[1][1];
        char sixthPosition = state[1][2];
        char seventhPosition = state[2][0];
        char eighthPosition = state[2][1];
        char ninthPosition = state[2][2];
        if (firstPosition != emptySpaceSymbol){
            if (secondPosition != emptySpaceSymbol){
                if (thirdPosition != emptySpaceSymbol){
                    if (fourthPosition != emptySpaceSymbol){
                        if (fifthPosition != emptySpaceSymbol){
                            if (sixthPosition != emptySpaceSymbol){
                                if (seventhPosition != emptySpaceSymbol) {
                                    if(eighthPosition != emptySpaceSymbol){
                                        if(ninthPosition!= emptySpaceSymbol){
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // For all AI methods, assume the AI is player two.

    // Given a game state, return a new game state with the move from the easy AI
    // The easy AI should simply make a move at random from the available spaces
    private static char[][] getEasyCPUMove(char[][] gameState) {
        boolean validRandNumber = true;
        char[][] currentState = gameState;
        do{
            Random random = new Random();
            int rowValue = random.nextInt(3);
            Random random1 = new Random();
            int colValue = random1.nextInt(3);
            int[] computerMove = new int[]{rowValue, colValue};
            if (checkValidMove(computerMove,currentState)){
                currentState[rowValue][colValue] = playerTwoSymbol;
                validRandNumber=false;
            }
        } while(validRandNumber);

        return currentState;
    }

    // Given a game state, return a new game state with move from the hard AI
    // The behavior of the medium AI is up to you, as long as its skill/algorithm
    // is better than easy but worse than hard
    private static char[][] getMediumCPUMove(char[][] gameState) {
        int row = 0;
        int col = 0;
        char[][] currentState = gameState;

        //Targets T=top left to bottom right
        if (gameState[0][0] == emptySpaceSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][2] == playerTwoSymbol) {
            row = 0;
            col = 0;
        } else if (gameState[0][0] == emptySpaceSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][2] == playerTwoSymbol) {
            row = 0;
            col = 0;
        } else if (gameState[0][0] == emptySpaceSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][2] == emptySpaceSymbol) {
            row = 0;
            col = 0;
        } else if (gameState[0][0] == emptySpaceSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][2] == emptySpaceSymbol) {
            row = 0;
            col = 0;
        } else if (gameState[0][0] == playerTwoSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][2] == emptySpaceSymbol) {
            row = 2;
            col = 2;
        } else if (gameState[0][0] == playerTwoSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][2] == emptySpaceSymbol) {
            row = 2;
            col = 2;
        } else if (gameState[0][0] == playerTwoSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][2] == playerTwoSymbol) {
            row = 1;
            col = 1;

        }
        //Targets bottom left to top right
        else if (gameState[0][2] == emptySpaceSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][0] == emptySpaceSymbol) {
            row = 0;
            col = 2;
        } else if (gameState[0][2] == emptySpaceSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][0] == emptySpaceSymbol) {
            row = 0;
            col = 2;
        } else if (gameState[0][2] == emptySpaceSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][0] == playerTwoSymbol) {
            row = 0;
            col = 2;
        } else if (gameState[0][2] == emptySpaceSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][0] == playerTwoSymbol) {
            row = 0;
            col = 2;
        } else if (gameState[0][2] == playerTwoSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][0] == emptySpaceSymbol) {
            row = 2;
            col = 0;
        } else if (gameState[0][2] == playerTwoSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][0] == emptySpaceSymbol) {
            row = 2;
            col = 0;
        } else if (gameState[0][2] == playerTwoSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][0] == playerTwoSymbol) {
            row = 1;
            col = 1;
        } else {
            currentState=getEasyCPUMove(gameState);
        }


        int[] computerMove = new int[]{row, col};
        if (checkValidMove(computerMove, currentState)) {
            currentState[row][col] = playerTwoSymbol;

        }

        return currentState;
    }

    // Given a game state, return a new game state with move from the hard AI
    // The hard AI follows the algorithm in the PDF to ensure a tie (or win if possible)
    private static char[][] getHardCPUMove(char[][] gameState) {
        // TODO

        // Hint: you can call makeMove() and not end up returning the result, in order to "test" a move
        // and see what would happen. This is one reason why makeMove() does not modify the state argument

        // Determine all available spaces

        // If there is a winning move available, make that move

        // If not, check if opponent has a winning move, and if so, make a move there

        // If not, move on center space if possible

        // If not, move on corner spaces if possible

        // Otherwise, move in any available spot
        int row = 0;
        int col = 0;
        char[][] currentState = gameState;

        // Horozontal Wins
        if (gameState[0][0] == emptySpaceSymbol && gameState[0][1] == playerTwoSymbol && gameState[0][2] == playerTwoSymbol) {
            row = 0;
            col = 0;
        }
        else if (gameState[0][0] == playerTwoSymbol && gameState[0][1] == emptySpaceSymbol && gameState[0][2] == playerTwoSymbol) {
            row = 0;
            col = 1;
        }
        else if (gameState[0][0] == playerTwoSymbol && gameState[0][1] == playerTwoSymbol && gameState[0][2] == emptySpaceSymbol) {
            row = 0;
            col = 2;
        }
        else if (gameState[1][0] == emptySpaceSymbol && gameState[1][1] == playerTwoSymbol && gameState[1][2] == playerTwoSymbol) {
            row = 1;
            col = 0;
        }
        else if (gameState[1][0] == playerTwoSymbol && gameState[1][1] == emptySpaceSymbol && gameState[1][2] == playerTwoSymbol) {
            row = 1;
            col = 1;
        }
        else if (gameState[1][0] == playerTwoSymbol && gameState[1][1] == playerTwoSymbol && gameState[1][2] == emptySpaceSymbol) {
            row = 1;
            col = 2;
        }
        else if (gameState[2][0] == emptySpaceSymbol && gameState[2][1] == playerTwoSymbol && gameState[2][2] == playerTwoSymbol) {
            row = 2;
            col = 0;
        }
        else if (gameState[2][0] == playerTwoSymbol && gameState[2][1] == emptySpaceSymbol && gameState[2][2] == playerTwoSymbol) {
            row = 2;
            col = 1;
        }
        else if (gameState[2][0] == playerTwoSymbol && gameState[2][1] == playerTwoSymbol && gameState[2][2] == emptySpaceSymbol) {
            row = 2;
            col = 2;
        }

        // Vertical Wins
        else if (gameState[0][0] == emptySpaceSymbol && gameState[1][0] == playerTwoSymbol && gameState[2][0] == playerTwoSymbol) {
            row = 0;
            col = 0;
        }
        else if (gameState[0][0] == playerTwoSymbol && gameState[1][0] == emptySpaceSymbol && gameState[2][0] == playerTwoSymbol) {
            row = 1;
            col = 0;
        }
        else if (gameState[0][0] == playerTwoSymbol && gameState[1][0] == playerTwoSymbol && gameState[2][0] == emptySpaceSymbol) {
            row = 2;
            col = 0;
        }
        else if (gameState[0][1] == emptySpaceSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][1] == playerTwoSymbol) {
            row = 0;
            col = 1;
        }
        else if (gameState[0][1] == playerTwoSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][1] == playerTwoSymbol) {
            row = 1;
            col = 1;
        }
        else if (gameState[0][1] == playerTwoSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][1] == emptySpaceSymbol) {
            row = 2;
            col = 1;
        }
        else if (gameState[0][2] == emptySpaceSymbol && gameState[1][2] == playerTwoSymbol && gameState[2][2] == playerTwoSymbol) {
            row = 0;
            col = 2;
        }
        else if (gameState[0][2] == playerTwoSymbol && gameState[1][2] == emptySpaceSymbol && gameState[2][2] == playerTwoSymbol) {
            row = 1;
            col = 2;
        }
        else if (gameState[0][2] == playerTwoSymbol && gameState[1][2] == playerTwoSymbol && gameState[2][2] == emptySpaceSymbol) {
            row = 2;
            col = 2;
        }

        //Diagonal wins
        else if (gameState[0][0] == emptySpaceSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][2] == playerTwoSymbol) {
            row = 0;
            col = 0;
        }
        else if (gameState[0][0] == playerTwoSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][2] == playerTwoSymbol) {
            row = 1;
            col = 1;
        }
        else if (gameState[0][0] == playerTwoSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][2] == emptySpaceSymbol) {
            row = 2;
            col = 2;
        }
        else if (gameState[0][2] == emptySpaceSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][0] == playerTwoSymbol) {
            row = 0;
            col = 2;
        }
        else if (gameState[0][2] == playerTwoSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][0] == playerTwoSymbol) {
            row = 1;
            col = 1;
        }
        else if (gameState[0][2] == playerTwoSymbol && gameState[1][1] == playerTwoSymbol && gameState[2][0] == emptySpaceSymbol) {
            row = 2;
            col = 0;
        }


        // Horozontal Opponent Wins
        if (gameState[0][0] == emptySpaceSymbol && gameState[0][1] == playerOneSymbol && gameState[0][2] == playerOneSymbol) {
            row = 0;
            col = 0;
        }
        else if (gameState[0][0] == playerOneSymbol && gameState[0][1] == emptySpaceSymbol && gameState[0][2] == playerOneSymbol) {
            row = 0;
            col = 1;
        }
        else if (gameState[0][0] == playerOneSymbol && gameState[0][1] == playerOneSymbol && gameState[0][2] == emptySpaceSymbol) {
            row = 0;
            col = 2;
        }
        else if (gameState[1][0] == emptySpaceSymbol && gameState[1][1] == playerOneSymbol && gameState[1][2] == playerOneSymbol) {
            row = 1;
            col = 0;
        }
        else if (gameState[1][0] == playerOneSymbol && gameState[1][1] == emptySpaceSymbol && gameState[1][2] == playerOneSymbol) {
            row = 1;
            col = 1;
        }
        else if (gameState[1][0] == playerOneSymbol && gameState[1][1] == playerOneSymbol && gameState[1][2] == emptySpaceSymbol) {
            row = 1;
            col = 2;
        }
        else if (gameState[2][0] == emptySpaceSymbol && gameState[2][1] == playerOneSymbol && gameState[2][2] == playerOneSymbol) {
            row = 2;
            col = 0;
        }
        else if (gameState[2][0] == playerOneSymbol && gameState[2][1] == emptySpaceSymbol && gameState[2][2] == playerOneSymbol) {
            row = 2;
            col = 1;
        }
        else if (gameState[2][0] == playerOneSymbol && gameState[2][1] == playerOneSymbol && gameState[2][2] == emptySpaceSymbol) {
            row = 2;
            col = 2;
        }

        // Vertical Opponent Wins
        else if (gameState[0][0] == emptySpaceSymbol && gameState[1][0] == playerOneSymbol && gameState[2][0] == playerOneSymbol) {
            row = 0;
            col = 0;
        }
        else if (gameState[0][0] == playerOneSymbol && gameState[1][0] == emptySpaceSymbol && gameState[2][0] == playerOneSymbol) {
            row = 1;
            col = 0;
        }
        else if (gameState[0][0] == playerOneSymbol && gameState[1][0] == playerOneSymbol && gameState[2][0] == emptySpaceSymbol) {
            row = 2;
            col = 0;
        }
        else if (gameState[0][1] == emptySpaceSymbol && gameState[1][1] == playerOneSymbol && gameState[2][1] == playerOneSymbol) {
            row = 0;
            col = 1;
        }
        else if (gameState[0][1] == playerOneSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][1] == playerOneSymbol) {
            row = 1;
            col = 1;
        }
        else if (gameState[0][1] == playerOneSymbol && gameState[1][1] == playerOneSymbol && gameState[2][1] == emptySpaceSymbol) {
            row = 2;
            col = 1;
        }
        else if (gameState[0][2] == emptySpaceSymbol && gameState[1][2] == playerOneSymbol && gameState[2][2] == playerOneSymbol) {
            row = 0;
            col = 2;
        }
        else if (gameState[0][2] == playerOneSymbol && gameState[1][2] == emptySpaceSymbol && gameState[2][2] == playerOneSymbol) {
            row = 1;
            col = 2;
        }
        else if (gameState[0][2] == playerOneSymbol && gameState[1][2] == playerOneSymbol && gameState[2][2] == emptySpaceSymbol) {
            row = 2;
            col = 2;
        }

        //Diagonal Opponent wins
        else if (gameState[0][0] == emptySpaceSymbol && gameState[1][1] == playerOneSymbol && gameState[2][2] == playerOneSymbol) {
            row = 0;
            col = 0;
        }
        else if (gameState[0][0] == playerOneSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][2] == playerOneSymbol) {
            row = 1;
            col = 1;
        }
        else if (gameState[0][0] == playerOneSymbol && gameState[1][1] == playerOneSymbol && gameState[2][2] == emptySpaceSymbol) {
            row = 2;
            col = 2;
        }
        else if (gameState[0][2] == emptySpaceSymbol && gameState[1][1] == playerOneSymbol && gameState[2][0] == playerOneSymbol) {
            row = 0;
            col = 2;
        }
        else if (gameState[0][2] == playerOneSymbol && gameState[1][1] == emptySpaceSymbol && gameState[2][0] == playerOneSymbol) {
            row = 1;
            col = 1;
        }
        else if (gameState[0][2] == playerOneSymbol && gameState[1][1] == playerOneSymbol && gameState[2][0] == emptySpaceSymbol) {
            row = 2;
            col = 0;
        }



        // CPU first move
        else if (gameState[1][1] == emptySpaceSymbol){
            row=1;
            col=1;
        }
        else if (gameState[0][2] == emptySpaceSymbol){
            row=0;
            col=2;
        }
        else if (gameState[0][0] == emptySpaceSymbol){
            row=0;
            col=0;
        }
        else if (gameState[2][0] == emptySpaceSymbol){
            row=2;
            col=0;
        }
        else if (gameState[2][2] == emptySpaceSymbol){
            row=2;
            col=2;
        }
        else if (gameState[0][1] == emptySpaceSymbol){
            row=0;
            col=1;
        }
        else if (gameState[1][0] == emptySpaceSymbol){
            row=1;
            col=0;
        }
        else if (gameState[2][1] == emptySpaceSymbol){
            row=2;
            col=1;
        }
        else if (gameState[1][2] == emptySpaceSymbol){
            row=1;
            col=2;
        }
        else {
            currentState=getEasyCPUMove(gameState);
        }



        int[] computerMove = new int[]{row, col};
        if (checkValidMove(computerMove, currentState)) {
            currentState[row][col] = playerTwoSymbol;

        }

        return currentState;
    }

    // Given a game state, return an ArrayList of [row, column] positions that are unclaimed on the board
    private static ArrayList<int[]> getValidMoves(char[][] gameState) {
        ArrayList<int[]> validMoves = new ArrayList<>();
        for (int row = 0; row < gameState.length; row++) {
            for (int col = 0; col < gameState[row].length; col++) {
                if (gameState[row][col] == emptySpaceSymbol){
                    int[] move = new int[]{row,col};
                    validMoves.add(move);
                }
            }
        }
        return validMoves;
    }

    // Given player names and the game history, display the past game as in the PDF sample code output
    private static void runGameHistory(String[] playerNames, ArrayList<char[][]> gameHistory) {
        // TODO
        // We have the names of the players in the format [playerOneName, playerTwoName]
        // Player one always gets 'X' while player two always gets 'O'
        // However, we do not know yet which player went first, but we'll need to know...
        // Hint for the above: which symbol appears after one turn is taken?

        // Hint: iterate over gameHistory using a loop
        System.out.println(playerNames[0] + "(" + playerOneSymbol + ") vs " + playerNames[1] + "(" + playerTwoSymbol + ")");
        boolean isUserFirst = false;
        for (int i = 0; i < gameHistory.size(); i++) {
            for (int j = 0; j < gameHistory.get(i).length; j++) {
                for (int k = 0; k < gameHistory.get(i)[j].length; k++) {
                    if (gameHistory.get(i)[j][k] == playerOneSymbol) {
                        isUserFirst = true;
                    }
                }
            }
        }
        for (int i = 0; i < gameHistory.size(); i++) {
            if (isUserFirst){
                System.out.println(playerNames[0] + ":");
                isUserFirst=false;
            }
            else{
                System.out.println(playerNames[1] + ":");
                isUserFirst = true;
            }
            System.out.println(Arrays.deepToString(gameHistory.get(i)));
            System.out.println();
        }
    }
}