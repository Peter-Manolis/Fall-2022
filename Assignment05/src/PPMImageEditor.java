import java.io.*;
import java.util.Scanner;
/*
Hello, my name is Peter Manolis, and I am going to outline what the goal of this code is. The goal of this code is to
take a ppm file that is provided by the user and then make an output file, that is a copy of the input file. After
the user provides the input and output file, they are prompted with 9 options on how they want to change their image.
After they choose the change they want to make to the image, that specific change will be made. Then the user is asked if
they want to change the image even more, and if they want to change the input or output file. This process goes until
the user asks for it to stop.

Step-by-step process:
1. The user provides the name of their input variable
2. I created a makeArray method, that converts the rgb values found in the input file into a 3D array. This 3D array is
stored as inputArray and outputArray initially
3. I create an empty output file
4. I created 8 methods for all the possible changes the user can do to the image. all of these methods traverse through
the 3D array previously created, adn change the necessary values.
5. I print out a menu screen, that prompts the user to enter a number, 0-8, that corresponds to a method that changes
the image
6. As each number is chosen, the 3D array is updated with the changes to the image, and then the output file is created
with the changes.
7. After the user makes their initial change, they are prompted if they want to make more changes, and if they
want to change the input or output file
8. If they select to make changes to the input or output file, then each variable is updated with the new names
respectively
9. steps 5-8 are repeated until the user selects to end the code.

 */

public class PPMImageEditor {
    public static void main(String[] args) throws IOException {
        // Phase 1
        System.out.println("Portable Pixmap (PPM) Image Editor!");


        // Create input file
        System.out.println("Enter name of image file: ");
        Scanner in1 = new Scanner(System.in);
        String inputFile = ("C:\\C212\\Assignments\\Assignmnet05\\src\\") + in1.nextLine();



        //Creates the output file
        Scanner in2 = new Scanner(System.in);
        System.out.println("Enter name of output file: ");
        String outputFileName = in2.nextLine();

        //Phase 2


        Scanner in3 = new Scanner(System.in);
        boolean validMenuChoice = true;
        while (true){
            int[][][] rgbArray = makeArray(inputFile);
            //prompts the user how to change the image
            System.out.println("Here are your choices:");
            System.out.println("[0] exit");
            System.out.println("[1] convert to greyscale");
            System.out.println("[2] flip horizontally");
            System.out.println("[3] negative of red");
            System.out.println("[4] negative of green");
            System.out.println("[5] negative of blue");
            System.out.println("[6] just the reds");
            System.out.println("[7] just the greens");
            System.out.println("[8] just the blues");

            System.out.println("Enter choice: ");
            String menuChoice = in3.next();
            if (menuChoice.equals("0")) { // creates the output file with no changes
                createOutputFile(rgbArray, outputFileName);
                System.out.println("Bye bye.");
                break;

            } else if (menuChoice.equals("1")) { //changes the image anc creates the output file with grey scale
                greyScale(rgbArray);
                createOutputFile(rgbArray, outputFileName);
                System.out.println(outputFileName + " created with affect, \"convert to grey scale\"");

            } else if (menuChoice.equals("2")) { //changes the image anc creates the output file with flip horizontal
                flipHorizontal(rgbArray);
                createOutputFile(rgbArray, outputFileName);
                System.out.println(outputFileName + " created with affect, \"flip horizontal\"");

            } else if (menuChoice.equals("3")) { //changes the image anc creates the output file with negate red
                negateRed(rgbArray);
                createOutputFile(rgbArray, outputFileName);
                System.out.println(outputFileName + " created with affect, \"negate red\"");

            } else if (menuChoice.equals("4")) { //changes the image anc creates the output file with negate green
                negateGreen(rgbArray);
                createOutputFile(rgbArray, outputFileName);
                System.out.println(outputFileName + " created with affect, \"negate green\"");

            } else if (menuChoice.equals("5")) { //changes the image anc creates the output file with negate blue
                negateBlue(rgbArray);
                createOutputFile(rgbArray, outputFileName);
                System.out.println(outputFileName + " created with affect, \"negate blue\"");

            } else if (menuChoice.equals("6")) { //changes the image anc creates the output file with flatten red
                flattenRed(rgbArray);
                createOutputFile(rgbArray, outputFileName);
                System.out.println(outputFileName + " created with affect, \"flatten red\"");

            } else if (menuChoice.equals("7")) { //changes the image anc creates the output file with flatten green
                flattenGreen(rgbArray);
                createOutputFile(rgbArray, outputFileName);
                System.out.println(outputFileName + " created with affect, \"flatten green\"");

            } else if (menuChoice.equals("8")) { //changes the image anc creates the output file with flatten blue
                flattenBlue(rgbArray);
                createOutputFile(rgbArray, outputFileName);
                System.out.println(outputFileName + " created with affect, \"flatten blue\"");

            } else { // doesnt select a number 0-8
                System.out.println("Invalid selection, please try again");
            }
            System.out.println("Do you want to do more operations (y or n): ");
            while(true) {
                menuChoice = in1.nextLine();
                if (menuChoice.equals("Y") || menuChoice.equals("y")){
                    while(true){
                        System.out.println("Do you want to change input file (y or n): ");
                        menuChoice = in1.nextLine();
                        if (menuChoice.equals("Y") || menuChoice.equals("y")){
                            System.out.println("Enter name of image file: ");
                            inputFile = in1.nextLine();
                            break;
                        }
                        else if(menuChoice.equals("n") || menuChoice.equals("N")){
                            break;
                        }
                    }
                    while(true){
                        System.out.println("Do you want to change output file (y or n): ");
                        menuChoice = in1.nextLine();
                        if (menuChoice.equals("Y") || menuChoice.equals("y")){
                            System.out.println("Enter name of output file: ");
                            outputFileName = in2.nextLine();
                            break;
                        }
                        else if(menuChoice.equals("n") || menuChoice.equals("N")){
                            break;
                        }
                    }
                    break;
                }
                else if (menuChoice.equals("n")){
                    System.out.println("Bye Bye");
                    System.exit(0);
                }
            }

        }
    }
    private static int[][][] makeArray(String inputFile) throws FileNotFoundException, ArrayIndexOutOfBoundsException { //makes a 3d array of the rgb values from the given input file
        int lineNum = 0;
                File file = new File(inputFile);
                Scanner in = new Scanner(file);
                in.nextLine();
                int cols = in.nextInt();
                int rows = in.nextInt();
                int colorVal = in.nextInt();
                int[][][] inputImageArray = new int[rows][cols][3];
                while (in.hasNext()) {
                    for (int i = 0; i < inputImageArray.length; i++) {
                        for (int j = 0; j < inputImageArray[i].length; j++) {
                            for (int k = 0; k < inputImageArray[i][j].length; k++) {
                                int rgbNumber = in.nextInt();
                                inputImageArray[i][j][k] = rgbNumber;
                            }
                        }
                    }
                }
            return inputImageArray;

    }
    public static void createOutputFile (int[][][] rgbArray, String outputFileName) throws FileNotFoundException {
        File file = new File(outputFileName);
        PrintWriter writer = new PrintWriter(file);
        writer.println("P3");
        int cols = rgbArray[0].length;
        int rows = rgbArray.length;
        writer.println(cols + " " + rows); // cols rows
        writer.println(255);
        for (int[][] row : rgbArray) {
            for (int[] col : row) {
                for (int num : col) {
                    writer.print(num + " ");
                }
                writer.print("    ");
            }
            writer.println();
        }
        writer.close();
    }

    private static void negateRed(int[][][] rgbArray) { //makes all red values their negative counterpart
        for (int i = 0; i < rgbArray.length; i++) {
            for (int j = 0; j < rgbArray[i].length; j++) {
                int difference = 255 - rgbArray[i][j][1];
                if (rgbArray[i][j][0] >= 128) {
                    rgbArray[i][j][0] = difference;
                }
                if (rgbArray[i][j][0] <= 127) {
                    rgbArray[i][j][0] = difference;
                }
            }
        }
    }
    private static void  negateGreen(int[][][] rgbArray) { //makes all green values their negative counterpart
        for (int i = 0; i < rgbArray.length; i++) {
            for (int j = 0; j < rgbArray[i].length; j++) {
                int difference = 255 - rgbArray[i][j][1];
                if (rgbArray[i][j][1] >= 128) {
                    rgbArray[i][j][1] = difference;
                }
                if (rgbArray[i][j][1] <= 127) {
                    rgbArray[i][j][1] = difference;
                }
            }
        }
    }
    private static void negateBlue(int[][][] rgbArray) { //makes all blue values their negative counterpart
        for (int i = 0; i < rgbArray.length; i++) {
            for (int j = 0; j < rgbArray[i].length; j++) {
                int difference = 255 - rgbArray[i][j][1];
                if (rgbArray[i][j][2] >= 128) {
                    rgbArray[i][j][2] = difference;
                }
                if (rgbArray[i][j][2] <= 127) {
                    rgbArray[i][j][2] = difference;
                }
            }
        }
    }
    private static void flipHorizontal(int[][][] rgbArray) { //flips pixels on the far right of the row with those on the far left
        for (int i = 0; i < rgbArray.length; i++) {
            int [][] switchArray = new int [rgbArray[i].length][3];
            for (int j = 0; j < rgbArray[i].length; j++) {
                int saveValue = rgbArray[i].length - j - 1;
                switchArray[saveValue] = rgbArray[i][j];
            }
            for (int j = 0;j < rgbArray[i].length; j++){
                rgbArray[i][j] = switchArray[j];
            }
        }
    }
    private static void greyScale(int[][][] rgbArray){//makes all rgb values the average of their given pixel
        double sum = 0;
        double average = 0.0;
        for (int i = 0; i < rgbArray.length; i++) {
            for (int j = 0; j < rgbArray[i].length; j++) {
                sum += rgbArray[i][j][0];
                sum += rgbArray[i][j][1];
                sum += rgbArray[i][j][2];
                average = sum/3;
                for (int k = 0; k < rgbArray[i][j].length; k++) {
                    rgbArray[i][j][k] = (int)average;
                    sum= 0;
                }
            }
        }
    }
    private static void flattenRed(int[][][] rgbArray) {//makes all red values equal to 0
        for (int i = 0; i < rgbArray.length; i++) {
            for (int j = 0; j < rgbArray[i].length; j++) {
                rgbArray[i][j][0] = 0;
            }
        }
    }
    private static void flattenGreen(int[][][] rgbArray) {//makes all green values equal to 0
        for (int i = 0; i < rgbArray.length; i++) {
            for (int j = 0; j < rgbArray[i].length; j++) {
                rgbArray[i][j][1] = 0;
            }
        }
    }
    private static void flattenBlue(int[][][] rgbArray) {//makes all blue values equal to 0
        for (int i = 0; i < rgbArray.length; i++) {
            for (int j = 0; j < rgbArray[i].length; j++) {
                rgbArray[i][j][2] = 0;
            }
        }
    }

}