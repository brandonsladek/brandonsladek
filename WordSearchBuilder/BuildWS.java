/**
 * BuildWS class for program that allows user to create a word search board.
 * 
 * @author (brandonsladek) 
 * @version (4.9.14)
 */

import java.util.Scanner;
import java.util.ArrayList;

public class BuildWS
{
    private int rows; //number of rows determined by user
    private int cols; //number of columns determined by user
    private char[][] board; //a 2d array that will become the board
    ArrayList<String> inputWords = new ArrayList<String>(); //an ArrayList for user input words

    //constructor for BuildWS class
    public BuildWS()
    {
        //no parameters needed for constructor
    }

    //this method fills the board with 1's
    private void fillBoard()
    {
        board = new char[rows][cols]; //creates a new 2d array with user specified size

        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < cols; c++)
            {
                board[r][c] = '1'; //set each element in board to 1
            }
        }
    }

    //this is the main method that will build the board
    public void build()
    {
        Scanner in = new Scanner(System.in);

        //read in the number of rows for the board
        System.out.print("How many rows would you like? > ");
        rows = in.nextInt();
        System.out.println();

        //read in the number of columns for the board
        System.out.print("How many columns would you like? > ");
        cols = in.nextInt();
        in.nextLine();
        System.out.println();

        fillBoard(); //fill the board with 1's

        boolean run = true; //boolean variable to enter while loop
        while(run)
        {
            //prompt the user for a word to put in the board
            System.out.print("Add a word to your search (type end to quit) > ");
            String word = in.next();

            //if the user types end the loop will quit, if they type any other word the word will
            //be added to the inputWords ArrayList
            if(word.equals("end"))
            {
                run = false;
            }
            else
            {
                inputWords.add(word);
            }
        }

        addWords(); //see method details
        System.out.println();
        print(); //see method details
    }

    private void addWords()
    {
        //for loop that iterates through each word in the inputWords ArrayList
        for(int i = 0; i < inputWords.size(); i++)
        {
            //the orientation of the word to be added is randomly determined
            int orientation = (int) (Math.random() * 3 + 1);

            if(orientation == 1)
            {
                boolean h = false; //boolean variable to enter while loop
                while(!h)
                {
                    int r = (int) (Math.random() * rows); //randomly choose a row
                    int c = (int) (Math.random() * cols); //randomly choose a col
                    h = addHorizontal(inputWords.get(i),r,c); //see addHorizontal method details
                }
            }

            if(orientation == 2)
            {
                boolean v = false; //boolean variable to enter while loop
                while(!v)
                {
                    int r = (int) (Math.random() * rows); //randomly choose a row
                    int c = (int) (Math.random() * cols); //randomly choose a col
                    v = addVertical(inputWords.get(i),r,c); //see addVertical method details
                }
            }

            if(orientation == 3)
            {
                boolean d = false; //boolean variable to enter while loop
                while(!d)
                {
                    int r = (int) (Math.random() * rows); //randomly choose a row
                    int c = (int) (Math.random() * cols); //randomly choose a col
                    d = addDiagonal(inputWords.get(i),r,c); //see addDiagonal method details
                }
            }
        }
    }

    //this method adds a word to the board in a horizontal orientation
    private boolean addHorizontal(String inputWord, int r, int c)
    {
        boolean add = false; //variable that method will return

        //if the randomly chosen location is too far to the right then the while loop in the
        //addWords() method with orientation == 1 will randomly determine another location
        if((c + inputWord.length()) <= cols)
        {
            for(int i = 0; i < inputWord.length(); i++)
            {
                board[r][c+i] = inputWord.charAt(i); //add input word to the board horizontally
            }
            add = true; //if word is added then the addHorizontal method returns true
        }
        return add;
    }

    //this method adds a word to the board in a vertical orientation
    private boolean addVertical(String inputWord, int r, int c)
    {
        boolean add = false; //variable that method will return

        //if the randomly chosen location is too far down in the board then the while loop in the
        //addWords() method with orientation == 2 will randomly determine another location
        if((r + inputWord.length()) <= rows)
        {
            for(int i = 0; i < inputWord.length(); i++)
            {
                board[r+i][c] = inputWord.charAt(i); //add input word to the board vertically
            }
            add = true; //if word is added then the addVertical method returns true
        }
        return add;
    }

    //this method adds a word to the board in a diagonal orientation
    private boolean addDiagonal(String inputWord, int r, int c)
    {
        boolean add = false; //variable that method will return

        //if the randomly chosen location is too close to the edge of the board then the while loop 
        //in the addWords() method with orientation == 3 will randomly determine another location
        if(((c + inputWord.length()) <= cols) && ((r + inputWord.length()) <= rows))
        {
            for(int i = 0; i < inputWord.length(); i++)
            {
                board[r+i][c+i] = inputWord.charAt(i); //add input word to the board diagonally
            }
            add = true; //if word is added then the addDiagonal method returns true
        }
        return add;
    }

    //this method prints out the final board with the input words
    private void print()
    {
        String letters = "abcdefghijklmnopqrstuvwxyz"; //variable for inserting random letters

        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < cols; c++)
            {
                //any element in the board that is still 1 will be changed to a random letter
                if(board[r][c] == '1')
                {
                    int i = ((int) (Math.random()*26));
                    board[r][c] = letters.charAt(i);
                }
            }
            System.out.println(board[r]); //prints out the final board with the input words
        }
    }
}