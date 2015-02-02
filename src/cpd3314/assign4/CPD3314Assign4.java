/*
 * Copyright 2015 Mark Russell <mark.russell@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* The following exercises are adapted from:
 * Gaddis, T. (2013). Starting Out with Java: From Control Structures through 
 * Objects. (5th ed.). Upper Saddle River, NJ: Pearson Education.
 * ISBN: 978-0-13-285583-9
 */
package cpd3314.assign4;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @au0thor Len Payne <len.payne@lambtoncollege.ca>
 */
public class CPD3314Assign4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String[] questions = {
            "1. Sum of Numbers",
            "3. Distance Traveled File",
            "10. Largest and Smallest",
            "11. Celsius and Fahrenheit Table",
            "14. Line Numbers",
            "18. Random Number Guessing Game"
        };
        int choice = 0;
        do {
            for (String q : questions) {
                System.out.println(q);
            }
            System.out.print("Which Exercise Do You Want to View? (0 to quit): ");
            try {
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        doExercise1();
                        break;
                    case 3:
                        doExercise3();
                        break;
                    case 10:
                        doExercise10();
                        break;
                    case 11:
                        doExercise11();
                        break;
                    case 14:
                        doExercise14();
                        break;
                    case 18:
                        doExercise18();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Not a valid choice.");
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("That is not a valid choice.");
            }
        } while (choice != 0);
    }

    /*
     * Exercise #1 - Sum of Numbers
     *
     * Write a program that asks the user for a positive nonzero integer 
     * value. The program should use a loop to get the sum of all the 
     * integers from 1 up to the number entered. For example, if the user 
     * enters 50, the loop will find the sum of 1, 2, 3, 4, ... 50.
     *
     * Sample Output:
     * ==============
     * 
     *   Enter a positive, nonzero integer value:
     *   50
     *   The sum of all integers up to 50 is 1275.
     */
    public static void doExercise1() {
        // TODO: Com[plete Exercise 1 Below

        int n;

        System.out.println("Enter a positive, nonzero integer value:");
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        if (n <= 0) {
            System.out.println("Enter a positive, nonzero integer value");

        } else {
            int sum = 0;
            for (int i = 0; i <= n; i++) {

                sum = sum + i;

            }
            System.out.println("The sum of all integers up to " + n + " is " + sum);

        }

    }

    /*
     * Exercise #2 & 3 - Distance Traveled File
     * 
     * The distance a vehicle travels can be calculated as follows:
     *     Distance = Speed * Time
     * For example, if a train travels 40 miles-per-hour for three hours, the 
     * distance traveled is 120 miles. Write a program that asks for the speed 
     * of a vehicle (in miles-per-hour) and the number of hours it has traveled. 
     * It should use a loop to display the distance a vehicle has traveled for 
     * each hour of a time period specified by the user. For example, if a 
     * vehicle is traveling at 40mph for a three-hour time period, it should 
     * output a report similar to the one that follows to a file named 
     * "ex3output.txt":
     * 
     * ex3output.txt:
     * ==============
     *   Hour    Distance Traveled
     *   -------------------------
     *   1               40
     *   2               80
     *   3              120
     * 
     * Input Validation: Do not accept a negative number for speed and do not 
     * accept any value less than 1 for time traveled.
     */
    public static void doExercise3() throws IOException {
        // TODO: Complete Exercise 2 & 3 Below
        int speed, hours, sum = 0;

        Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ex3output.txt"), "UTF-8"));
        try {

            Scanner s = new Scanner(System.in);

            System.out.println("Enter speed:");
            speed = s.nextInt();
            System.out.println("Enter hours:");
            hours = s.nextInt();

            if (speed < 1 || hours < 1) {
                System.out.println("Enter positive value for speed and hours");
            }

            w.write("Hour    Distance Traveled" + System.getProperty("line.separator"));
            w.write("---------------------------" + System.getProperty("line.separator"));
            for (int i = 1; i <= hours; i++) {
                sum = sum + speed;
                w.write(+i + "         " + sum + System.getProperty("line.separator"));

            }
            w.close();
        } catch (Exception e) {
        }

    }
    /*
     * Exercise 10 - Largest and Smallest
     * 
     * Write a program with a loop that lets the user enter a series of 
     * integers. The user should enter -99 to signal the end of the series. 
     * After all the numbers have been entered, the program should display the 
     * largest and smallest numbers entered.
     * 
     * To pass the unit tests, you final two lines of output must match the pattern:
     * Smallest number is x.
     * Largest number is y.
     *
     * Sample Output:
     * ==============
     *   Enter an integer (-99 to quit):
     *   4
     *   Enter an integer (-99 to quit):
     *   5
     *   Enter an integer (-99 to quit):
     *   7
     *   Enter an integer (-99 to quit):
     *   3
     *   Enter an integer (-99 to quit):
     *   -99
     *   Smallest number is 3.
     *   Largest number i   s 7.
     */

    public static void doExercise10() {
        // TODO: Complete Exercise 10 Below

        
        
        int num=0;
       
  Scanner s = new Scanner(System.in);
        
      

        int largest = 0, smallest=999999;
 
        while(num != -99){

            System.out.println("Enter an integer (-99 to quit):");

            num = s.nextInt();

            if (num > largest && num != -99) {

                largest = num;
            } 
            if (num < smallest && num!= -99 ) {
                
                smallest = num;
            }

        }
        System.out.println("smallest number is " + smallest + ".");
        System.out.println("Largest number i   s " + largest + ".");

    }

    /*
     * Exercise 11 - Celsius to Fahrenheit Table
     * 
     * Write a program that displays a table of the Celsius temperatures 0 
     * through 100 and their Fahrenheit equivalents. The formula for converting 
     * a temperature from Celsius to Fahrenheit is:
     *     F = (9.0/5.0) * C + 32
     * where F is the Fahrenheit temperature and C is the Celsius temperature. 
     * Your program must use a loop to display the table.
     * Round your answers to one decimal place.
     * 
     * Sample Output:
     * ==============
     *   C        F
     *   -------------
     *   0.0      32.0
     *   .        .
     *   .        .
     *   .        .
     *   20.0     68.0
     *   .        .
     *   .        .
     *   .        .
     *   100.0    212.0
     */
    public static void doExercise11() {
        // TODO: Complete Exercise 11 Below

        
        
        double F;
      
        System.out.println("C           F");
        System.out.println("-------------");
        
        for(double i=0.0; i<=100.0;i++)
        {
        
            F = (9.0/5.0) * i + 32;

         System.out.printf(i+"          "+"%1$.1f",F); 
         
         System.out.println();
         //System.out.println(+i+  "  "+"  "+F);
        
        }
    }

    /*
     * Exercise 14 - Line Numbers
     * 
     * Write a program that asks the user for the name of a file. The program 
     * should display the contents of the file with each line preceded with a 
     * line number followed by a colon. The line numbering should start at 1.
     * 
     * Sample Output:
     * ==============
     *   What file do you want to read?
     *   shakespeare.txt
     * 
     *   1: Not marble, nor the gilded monuments
     *   2: Of princes shall outlive this powerful rhyme,
     *   3: But you shall shine more bright in these contents
     *   ...
     */
      public static void doExercise14() throws IOException{
        // TODO: Complete Exercise 14 Below
         
          
           
         try{
          String file;    
               System.out.println("What file do you want to read?");
          Scanner s = new Scanner(System.in);
          file = s.nextLine();
          
          File f = new File(file);
              try (Scanner p = new Scanner(f)) {
                  int i = 1;
                  while (p.hasNext()){
                      
                      String line = p.nextLine();
                      System.out.println(i+": "+line);
                      i++;
                      
                  }  
              p.close();
              }
         }
         catch(Exception e){}
              
    }

    /*
     * Exercise 17 & 18 - Random Number Guessing Game with Enhancement
     * 
     * Write a program that generates a random number 1-50 and asks the user to 
     * guess what the       number is. If the user's guess is higher than the random 
     * number, the program should display "Too high, try again." If the user's 
     * guess is lower than the random number, the program should display "Too 
     * low, try again." The program should use a loop that repeats until the user 
     * correctly guesses the random number. Make the program keep count of the 
     * number of guesses that the user makes. When the user correctly guesses 
     * the random number, the program should display the number of guesses.
     * 
     * To pass output validation, your last line should match the pattern:
     *   Correct! That took x attempts.
     * 
     * Sample Output:
     * ==============
     *   Guess my number (1-50):
     *   40
     *   Too high, try again.
     *   Guess my number (1-50):
     *   30
     *   Too low, try again.
     *   Guess my number (1-50):
     *   35
     *   Too high, try again.
     *   Guess my number (1-50):
     *   32
     *   Correct! That took 7 attempts.
     */
      public static void doExercise18(){
        // TODO: Complete Exercise 17 & 18 Below
        int x,y=0,count=1;
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        
        x = rn.nextInt(50);
        if(x==0){
        
        x=x+1;
        }
              
        while(y!=x){
 
            
          System.out.println("Guess my number (1-50):");
         y= sc.nextInt();
            
            if (y>x)
        {
        System.out.println("Too high, try again.");
        }
        else if(y<x){
        System.out.println("Too low, try again.");
        }
        else{
        System.out.println("Correct! That took "+count+" attempts.");
        }
            count++;
        }
    }
}
