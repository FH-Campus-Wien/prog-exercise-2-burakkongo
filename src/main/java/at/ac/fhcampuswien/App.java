package at.ac.fhcampuswien;

import java.util.Scanner;

public class App {

    //todo Task 1
    public void largestNumber(){

        boolean status = false;

        double currentNumber;
        double maxNumber = 0;

        int counter = 0;

        Scanner input = new Scanner(System.in);

        do {
            counter++;
            System.out.print(("Number " + counter + ": "));
            currentNumber = input.nextDouble();

            if ((currentNumber <= 0) && (counter == 1))
            {
                status = false;
                System.out.print("No number entered.");
                System.out.println();
                break;
            }
            if ((currentNumber <= 0) && (counter != 1)) {
                status = true;
                break;
            }
            if (currentNumber >= maxNumber)
            {
                maxNumber = currentNumber;
            }

        }while(!status);

        if (status) {
            String s = String.format("%.2f", maxNumber);
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

        if (remainder != 0) {

            if (h >= 0 && h % 2 != 0) {

                int asciiValue = c;

                int center = h / 2;

                int smallestValue = asciiValue - center;

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

                    int smallestValueInLine = 0;

                    if (i <= center) {
                        smallestValueInLine = asciiValue - i;
                    } else {
                        smallestValueInLine = smallestValue + (i - center);
                    }

                    for (int k = smallestValueInLine; k <= asciiValue; k++) {

                        System.out.print((char) k);
                    }

                    for (int k = asciiValue - 1; k >= smallestValueInLine; k--) {

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

        int negativeMarks = 0;
        int lengthCounter = 0;
        int marksSum = 0;
        int currentNumber;
        float average;

        Scanner input = new Scanner(System.in);

        do
        {
            System.out.print("Mark "+(lengthCounter+1)+": ");
            currentNumber = input.nextInt();

            if (currentNumber == 0) {
                break;
            }
            else if(currentNumber < 0 || currentNumber > 5) {
                System.out.println("Invalid mark!");
                continue;

            } else {
                if(currentNumber == 5) {
                    marksSum += currentNumber;
                    lengthCounter += 1;
                    negativeMarks += 1;
                }
                else{
                    marksSum += currentNumber;
                    lengthCounter += 1;
                }
            }
            System.lineSeparator();
        }while(currentNumber != 0);

        // increasing counter to not divide by 0 if length counter is 0 due to invalid input
        if(lengthCounter == 0) lengthCounter+=1;

        average = marksSum/(float)lengthCounter;

        System.out.println("Average: " + String.format("%.2f",average));
        System.out.println("Negative marks: " + negativeMarks);

    }

    //todo Task 6
    public void happyNumbers(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("n: ");
        int startNumber = scanner.nextInt();
        int sum = 0;
        int currentNumber = startNumber;

        while(sum != 1 && sum != 4)
        {
            String numberString = "" + currentNumber;
            if (currentNumber/100>0)
            {
                char firstChar = numberString.charAt(0);
                int firstDigit = Integer.parseInt("" + firstChar);
                char secondChar = numberString.charAt(1);
                int secondDigit = Integer.parseInt("" + secondChar);
                char thirdChar = numberString.charAt(2);
                int thirdDigit = Integer.parseInt("" + thirdChar);

                sum = firstDigit*firstDigit + secondDigit*secondDigit + thirdDigit*thirdDigit;
            }
            else if (currentNumber/10>0)
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
            currentNumber = sum;

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