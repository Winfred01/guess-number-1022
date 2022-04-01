package com.example.what_number_i_am_thinking_of;
import static java.lang.Integer.parseInt;

public class GuessingNumber {
    public int answer;
    public int number;
    public int result;
    private String difficulty;
    public int counter=0;

    public void setDifficulty(String newDiff){
        this.difficulty = newDiff;
    }

    public String getDifficulty(){
        return difficulty;
    }

    public int GenerateNumber(String difficulty) {
        //generate number
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
        answer= (int) Math.floor((Math.random() * max) + 1);
        return answer;
        //System.out.println(answer);
    }

    public String CompareNumber(int Number, int answer) {
        //compare number，
        //return result
        this.number=Number;
        if(answer==number){
            result=0;
        }
        else{
            result=answer-number;
        }
        return Result(result);
    }

    public String Result(int result) {
        //return result
        String Result="error";
        if(result==0) {
            Result = "YOU WIN";
        }
        if(result<0){
            counter+=1;
            if(result>-10){
                Result= "You are close, the difference is within 10";
            }
            else{
                Result= "You can try a smaller number";
            }
        }
        if(result>0){
            counter+=1;
            if(result<10){
                Result= "You are close, the difference is within 10";
            }
            else{
                Result= "You can try a bigger number";
            }
        }
        if(counter==10){
            Result="You LOSE";
        }
        return Result;
    }

}