package com.Feigenheimer_P1;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main
{

    public static int chooseType(Scanner in, SecureRandom random)
    {
        int probType = in.nextInt();
        while (probType > 5 || probType < 1)
        {
            System.out.println("Incorrect option. Choose a value from 1 to 5.");
            probType = in.nextInt();
        }
        if (probType == 5)
            probType = random.nextInt(4) + 1;
        return probType;
    }

    public static int chooseDifficulty(Scanner in)
    {
        int studentDifficulty = in.nextInt();
        while (studentDifficulty > 4 || studentDifficulty < 1)
        {
            System.out.println("Incorrect level please try again. Choose a value from 1 to 4.");
            studentDifficulty = in.nextInt();
        }

        return studentDifficulty;
    }

    public static int getDifficulty(int setting, SecureRandom random)
    {
        int difficulty = 0;
        Scanner in = new Scanner(System.in);
        while (setting > 4 || setting < 1)
        {
            System.out.println("That is not a correct level, please choose from 1 to 4.");
            setting = in.nextInt();
        }
        switch (setting)
        {
            case 1:
                difficulty = random.nextInt(9) + 1;
                break;
            case 2:
                difficulty = random.nextInt(90) + 10;
                break;
            case 3:
                difficulty = random.nextInt(900) + 100;
                break;
            case 4:
                difficulty = random.nextInt(9000) + 1000;
                break;

        }

        return difficulty;
    }

    public static boolean getPercentage(int count1, int count2)
    {
        int total = count1 + count2;
        double percentage = (double) count1 / total;
        System.out.printf("Number correct: %d\nNumber incorrect: %d\n\n",count1,count2);
        if (percentage >= .745)
            System.out.println("Congratulations, you are ready to go to the next level!");
        else
            System.out.println("Please ask your teacher for extra help.");

        return false;
    }

    public static void getGoodResponse(int choice)
    {
        switch (choice)
        {
            case 0:
                System.out.println("Very good!");
                break;
            case 1:
                System.out.println("Excellent!");
                break;
            case 2:
                System.out.println("Nice work!");
                break;
            default:
                System.out.println("Keep up the good work!");
                break;

        }
    }

    public static void getBadResponse(int choice)
    {
        switch (choice)
        {
            case 0:
                System.out.println("No. please try again.");
                break;
            case 1:
                System.out.println("Wrong. Try once more.");
                break;
            case 2:
                System.out.println("Don't give up!");
                break;
            default:
                System.out.println("No. Keep trying.");
                break;

        }
    }

    public static void questionPrompt(int x, int y, int probType)
    {
        switch (probType)
        {
            case 1:
                System.out.println("How much is " + x + " plus " + y + "?");
                break;
            case 2:
                System.out.println("How much is " + x + " times " + y + "?");
                break;
            case 3:
                System.out.println("How much is " + x + " minus " + y + "?");
                break;
            case 4:
                System.out.println("How much is " + x + " divided by " + y + "? (Round to the nearest hundreth.)");
                break;
        }
    }

    public static double mathQuestion(int x, int y, int probType, SecureRandom random)
    {
        double questionAnswer = 0;

        switch (probType)
        {
            case 1:
                questionAnswer = (double) x + y;
                questionPrompt(x, y, probType);
                break;
            case 2:
                questionAnswer = (double) x * y;
                questionPrompt(x, y, probType);
                break;
            case 3:
                questionAnswer = (double) x - y;
                questionPrompt(x, y, probType);
                break;
            case 4:
                questionAnswer = (double) x / y;
                questionPrompt(x, y, probType);
                break;
        }
        return questionAnswer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        int x = 0, y = 0, choice = 0, goodCount = 0, badCount = 0, count = 0;
        int diffSetting = 0, probType = 0;
        double answer = 0.0, studentAnswer = 0.0, percentage = 0.0;
        boolean done = false, studentNew = true;


        while (!done)
        {
            if (studentNew)
            {
                System.out.println("Choose difficulty from 1 to 4");
                diffSetting = chooseDifficulty(in);
                System.out.println("Choose type of math problem: 1 for addition, 2 for multiplication, " +
                                           "3 for multiplication, 4 for division, 5 for mixture");
                probType = chooseType(in, random);
                studentNew = false;
            }

            x = getDifficulty(diffSetting, random);
            y = getDifficulty(diffSetting, random);

            answer = mathQuestion(x, y, probType, random);

            studentAnswer = in.nextDouble();

            if (Math.abs(answer - studentAnswer) < .01)
            {
                choice = random.nextInt(4);
                getGoodResponse(choice);
                count++;
                goodCount++;
            }
            else
            {
                choice = random.nextInt(4);
                getBadResponse(choice);
                count++;
                badCount++;
            }

            if (count == 10)
            {
                done = getPercentage(goodCount, badCount);
                if (!done)
                {
                    studentNew = true;
                    count = 0;
                }
                else
                    studentNew = false;
            }


        }

    }
}