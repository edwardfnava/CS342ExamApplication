/*

This is the Short Answer Answer Class which inherits the Answer class

Methods:

print(): void
getCredit(rightAnswer: Answer): double

*/
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class SAAnswer extends Answer{
  private String text;

  //Constructor for the class
  public SAAnswer(String input){
    this.text = input;
  }

  public SAAnswer(Scanner s){
    this.text = s.nextLine();
  }

  //Prints the text to this Answer
  public void print(){
    System.out.println(text + "\n");
  }

  public String getText(){
    return text;
  }

  //This method compares the current answer to the correct answer(passed in),
  //and returns a 0.0 for wrong answers, 1.0 for answers deserving full credit,
  //and something in between for answers deserving partial credit

  //Select Answers in the Exam Test Driver
  public double getCredit(Answer rightAnswer){

    if(this.getText() == rightAnswer.getText()){
      return 1.0;
    }
    else{
      return 0;
    }
  }

  public void save(PrintWriter p){
    p.println(this.text + "\r\n");
  }
}
