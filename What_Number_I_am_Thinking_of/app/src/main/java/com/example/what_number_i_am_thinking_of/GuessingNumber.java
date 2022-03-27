package com.example.what_number_i_am_thinking_of;
import java.io.*;


import static java.lang.Integer.parseInt;

public class GuessingNumber {
    public int answer;
    public int number;
    public int result;
    private String difficulty;
    public int counter=0;

    public void setDifficulty(String newDiff){
        this.difficulty = difficulty;
    }

    public String getDifficulty(){
        return difficulty;
    }
    public void GenerateNumber(String difficulty) {
        //生成随机数
        int max=30;
        if (difficulty.equals("Easy")){
            max=30;
        }
        if (difficulty.equals("Normal")){
            max=60;//0-60
        }
        if (difficulty.equals("Hard")){
            max=100;//0-100
        }
        answer=parseInt(String.valueOf(Math.random()*max+1),10);
    }

    public void CompareNumber(int Number) {
        //比较随机数，
        //返回结果
        this.number=Number;
        if(answer==number){
            result=0;
        }
        else{
            result=answer-number;//小于0太小， 大于0太大
        }
        Result(result);
    }

    public String Result(int result) {
        //返回结果
        String Result="erro";
        if(result==0) {
            Result = "YOU WIN"; //胜利！
        }
        if(result<0){
            if(result>-10){
                Result= "Close";
            }
            else{
                Result= "Try a smaller number";
            }
        }
        if(result>0){
            if(result<10){
                Result= "Close";
            }
            else{
                Result= "Try a biger number";
            }
        }
        return Result;
    }

    public void setCounter(){
        counter+=1;
        if (counter==10){//10次就输
            //Result=
        }
    }

    public void submit(int number){  //link to submit button
        CompareNumber(number);
        setCounter();
    }
    public void getGuess(){
        //读取输入值
    }
    //历史记录
    /*public static void writeMatchHistory(String message) throws IOException {
        //File HistoryFile = new File("C:\\Users\\zhang\\OneDrive\\Guessing_Number\\What_Number_I_am_Thinking_of\\app\\History.txt");
        try {
            FileWriter fw = new FileWriter("History.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(message);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }*/
}