package com.example.what_number_i_am_thinking_of;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void generateNumber(){
        GuessingNumber g = new GuessingNumber();
        int number = g.GenerateNumber("Easy");
        int number2 = g.GenerateNumber("Normal");
        int number3 = g.GenerateNumber("Hard");
        System.out.println(number);
        System.out.println(number2);
        System.out.println(number3);
    }

    @Test
    public void TestCompareNumber(){
        GuessingNumber g = new GuessingNumber();
        int answer = 50;
        int number = g.GenerateNumber("Hard");
        System.out.println(number);
        System.out.println(answer);
        System.out.println(g.CompareNumber(number,answer));
    }
    @Test
    public void TestCompareNumber2(){
        GuessingNumber g = new GuessingNumber();
        int answer = 50;
        int number = 50;
        System.out.println(number);
        System.out.println(answer);
        System.out.println(g.CompareNumber(number,answer));
    }
    @Test
    public void TestCompareNumber3(){
        GuessingNumber g = new GuessingNumber();
        int answer = 50;
        int number = 41;
        int number2 = 59;
        System.out.println(number);
        System.out.println(answer);
        System.out.println(g.CompareNumber(number,answer));
        System.out.println(number2);
        System.out.println(answer);
        System.out.println(g.CompareNumber(number2,answer));
    }
    @Test
    public void TestCompareNumber4(){
        GuessingNumber g = new GuessingNumber();
        int answer = 50;
        int number = 40;
        int number2 = 60;
        System.out.println(number);
        System.out.println(answer);
        System.out.println(g.CompareNumber(number,answer));
        System.out.println(number2);
        System.out.println(answer);
        System.out.println(g.CompareNumber(number2,answer));
    }
    @Test
    public void TestCompareNumber5(){
        GuessingNumber g = new GuessingNumber();
        int answer = 10;
        System.out.println(answer);
        for(int i = 1; i < 11; i++){
            System.out.println(i);
            System.out.println(g.CompareNumber(i,answer));
        }
    }
    @Test
    public void TestCompareNumber6(){
        GuessingNumber g = new GuessingNumber();
        int answer = 15;
        System.out.println(answer);
        for(int i = 1; i < 11; i++){
            System.out.println(i);
            System.out.println(g.CompareNumber(i,answer));
        }
    }
}