/**
 * The WordSearch class creates a new instance of a multidimensional array and contains the play
 * method which prints out the array in the file that the driver reads and then prompts the user for
 * a word that the program will then search for in the letter grid and determine whether the word is
 * in the grid or not. If in the grid, the program will tell the user where the word was found in the 
 * grid and at what orientation (horizontal, vertical, or diagonal).
 * 
 * @author (Brandon Sladek) 
 * @version (4.02.14)
 */

import java.util.Scanner;

public class WordSearch
{  
    private char[][] array; //an instance variable for a 2d char array
    private String response; //global user input instance variable used in multiple methods
    
    //constructor creates a new WordSearch instance with a 2d char array parameter
    public WordSearch(char[][] array)
    {  
        this.array = array;
    }

    private void print()
    {
        //for loop to print out block of text from file
        for(int r = 0; r < 10; r++)
        {
            System.out.println(array[r]);
        }
        System.out.println();
    }

    public void play()
    {
        boolean run = true; //set to true in order to enter while loop
        while(run)
        {
            print(); //grid is printed each time before user is asked for input

            Scanner in = new Scanner(System.in);
            System.out.print("What word do you want to search for? (type end to quit) > ");
            response = in.nextLine(); //response is user input variable
            System.out.println();

            if(response.equals("end"))
            {
                run = false; //if user types "end" the while loop will stop running
                System.out.println("-------------------------------------------------------------");
                System.out.println("Thank you for using WordSearch.");
            }
            else
            {
                search(); //otherwise the program will search the grid for the user input word
            }
        }
    }

    private void search()
    {
        boolean found = false; //variable that is determined by lookR, lookD, and lookDia methods
        boolean wordNotFound = true; //variable to determine if word was not found at all
        
        //for loop to search through the 2d array
        for(int r = 0; r < 10; r++)
        {
            for(int c = 0; c < 15; c++)
            {
                if(array[r][c] == response.charAt(0))
                {
                    //if the first letter of the input word is found, the program looks right
                    found = lookR(r,c);

                    if(found)
                    {
                        System.out.println(response + " was found horizontally at row " + r +
                            ", column " + c + ".");
                        wordNotFound = false; //wordNotFound variable is false if word is found
                    }
                    else
                    {
                        //if the word is not to the right, the program looks down
                        found = lookD(r,c);

                        if(found)
                        {
                            System.out.println(response + " was found vertically at row " + r +
                                ", column " + c + ".");
                            wordNotFound = false;
                        }
                        else
                        {
                            //if the word is not down, the program looks diagonally
                            found = lookDia(r,c);

                            if(found)
                            {
                                System.out.println(response + " was found diagonally at row " +
                                    r + ", column " + c + ".");
                                wordNotFound = false;
                            }
                            else
                            {
                                //the word was not found in any orientation from the first char
                            }
                        }
                    }
                }
            }
        }
        
        //if wordNotFound is true, the word was not found and the program prints out this output
        if(wordNotFound)
        {
            System.out.println(response + " was not found!");
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println();
    }

    //look right method that looks to the right if the first char of the user input is found in array
    private boolean lookR(int r, int c)
    {
        //for loop looks to the right from the first matching char
        for(int i = 1; i < response.length(); i++)
        {
            //the word cannot go past the array index to the right
            if((c + response.length()) > 15)
            {
                return false;
            }
            else if(array[r][c+i] != response.charAt(i)) //tests if characters to the right match
            {
                return false;
            }
        } 
        return true;
    }

    //look down method that looks down if the first char of the user input is found in array
    private boolean lookD(int r, int c)
    {
        //for loop looks down from first matching character
        for(int i = 1; i < response.length(); i++)
        {
            //the word cannot go past the array index downwards
            if((r + response.length()) > 10)
            {
                return false;
            }
            else if(array[r+i][c] != response.charAt(i)) //tests if downwards characters match
            {
                return false;
            }
        }
        return true;
    } 

    //look diagonal method that looks diagonally if the first char of the user input is found in array
    private boolean lookDia(int r, int c)
    {
        //for loop looks diagonally from first matching character
        for(int i = 1; i < response.length(); i++)
        {
            //the word cannot go past the array index diagonally
            if(((r + response.length()) > 10) || ((c + response.length()) > 15))
            {
                return false;
            }
            else if(array[r+i][c+i] != response.charAt(i)) //tests if characters match diagonally
            {
                return false;
            }
        }
        return true;
    } 
}