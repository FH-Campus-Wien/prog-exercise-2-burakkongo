package at.ac.fhcampuswien;

import jdk.internal.misc.ScopedMemoryAccess;
import org.graalvm.compiler.phases.graph.ScheduledNodeIterator;

import java.util.Scanner;

public class App {

    //todo Task 1
    public void largestNumber(){

        boolean status = false;

        double current_number;
        double max_number = 0;

        int counter = 0;

        Scanner input = new Scanner(System.in);

        do {
            counter++;
            System.out.print(("Number " + counter + ": "));
            current_number = input.nextDouble();

            if ((current_number <= 0) && (counter == 1))
            {
                status = false;
                System.out.print("No number entered.");
                System.out.println();
                break;
            }
            if ((current_number <= 0) && (!(counter == 1))) {
                status = true;
                break;
            }
            if (current_number >= max_number)
            {
                max_number = current_number;
            }

        }while(status == false);

        if ((status == true)) {
            String s = String.format("%.2f", max_number);
            System.out.println("The largest number is " + s);
        }
    }

    //todo Task 2
    public void stairs(){
        int line = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("n: ");
        line = input.nextInt();
        if (line > 0) {
            int index = 0;
            for (int i = 0; i < line; i++) {
                for (int j = 0; j <= i; j++) {
                    index++;
                    System.out.print(index + " ");
                }
                System.out.println();
            }
        }
        if (line <= 0)
        {
            System.out.println("Invalid number!");
        }
    }

    //todo Task 3
    public void printPyramid(){

        int l = 6;
        for(int i = 1; i <= 6; i++)
        {
            //loop to print spaces
            for(int j = 1; j < l; j++)
            {
                System.out.print(" ");
            }

            l = l-1;
            //loop to print stars
            for(int k = 1; k < i*2; k++)
            {
                System.out.print("*");
            }
            //create a new Line
            System.out.println();
        }
    }

    //todo Task 4
    public void printRhombus(){

        //Source: https://www.java-forum.org/thema/ascii-raute.179451/

        Scanner input = new Scanner(System.in);

        System.out.print("h: ");
        int h = input.nextInt();

        System.out.print("c: ");
        char c = input.next().charAt(0);
        int remainder = h % 2;

        if (!(remainder == 0)) {

            if (h >= 0 && h % 2 != 0) {

                int ascii_number = (int) c;

                int center = h / 2;

                int smallest_value = ascii_number - center;

                for (int i = 0; i < h; i++) {
                    int x = 0;

                    if (i <= center) {
                        x = center - i;
                    } else {
                        x = i - center;
                    }

                    for (int k = 0; k < x; k++) {
                        System.out.print(" ");
                    }

                    int smallest_value_inLine = 0;

                    if (i <= center) {
                        smallest_value_inLine = ascii_number - i;
                    } else {
                        smallest_value_inLine = smallest_value + (i - center);
                    }

                    for (int k = smallest_value_inLine; k <= ascii_number; k++) {

                        System.out.print((char) k);
                    }

                    for (int k = ascii_number - 1; k >= smallest_value_inLine; k--) {

                        System.out.print((char) k);
                    }

                    System.out.print("\n");
                }
            }
        }
        if ((remainder == 0))
        {
            System.out.println("Invalid number!");
        }
    }

    //todo Task 5
    public void marks(){

        int negative_marks = 0;
        int length_counter = 0;
        int mark_sum = 0;
        int current_number;
        float average = 0;

        Scanner input = new Scanner(System.in);

        do
        {
            System.out.print("Mark "+(length_counter+1)+": ");
            current_number = input.nextInt();

            if (current_number == 0) {
                break;
            }
            else if(current_number < 0 || current_number > 5) {
                System.out.println("Invalid mark!");
                continue;

            } else {
                if(current_number == 5) {
                    mark_sum += current_number;
                    length_counter += 1;
                    negative_marks += 1;
                }
                else{
                    mark_sum += current_number;
                    length_counter += 1;
                }
            }
            System.lineSeparator();
        }while(current_number != 0);

        // increasing counter to not divide by 0 if length counter is 0 due to invalid input
        if(length_counter == 0) length_counter+=1;

        average = mark_sum/(float)length_counter;

        System.out.println("Average: " + String.format("%.2f",average));
        System.out.println("Negative marks: " + negative_marks);

    }

    //todo Task 6
    public void happyNumbers(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("n: ");
        int start_number = scanner.nextInt();
        int sum = 0;
        int current_number = start_number;

        while(sum != 1 && sum != 4)
        {
            String numberString = "" + current_number;
            if (current_number/100>0)
            {
                char firstChar = numberString.charAt(0);
                int firstDigit = Integer.parseInt("" + firstChar);
                char secondChar = numberString.charAt(1);
                int secondDigit = Integer.parseInt("" + secondChar);
                char thirdChar = numberString.charAt(2);
                int thirdDigit = Integer.parseInt("" + thirdChar);

                sum = firstDigit*firstDigit + secondDigit*secondDigit + thirdDigit*thirdDigit;
            }
            else if (current_number/10>0)
            {
                char firstChar = numberString.charAt(0);
                int firstDigit = Integer.parseInt("" + firstChar);
                char secondChar = numberString.charAt(1);
                int secondDigit = Integer.parseInt("" + secondChar);

                sum = firstDigit*firstDigit + secondDigit*secondDigit;
            }
            else
            {
                char firstChar = numberString.charAt(0);
                int firstDigit = Integer.parseInt("" + firstChar);
                sum = firstDigit*firstDigit;
            }
            current_number = sum;

        }
        if(sum == 1) System.out.println("Happy number!");
        else System.out.println("Sad number!");

    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}