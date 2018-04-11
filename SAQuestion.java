/*

Short Answer Question class inherits from the Question Class

Methods:
getNewAnswer(): Answer
getAnswerFromStudent(): Answer
getValue(): double

*/
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class SAQuestion extends Question{
  //Consturctor
  public SAQuestion(String input, double value){
    this.setText(input);
    this.setQuestionValue(value);
  }

  public SAQuestion(Scanner s){
    //Question Value
	System.out.println("Enter Value followed by the Question");  
    double value = s.nextDouble();
    this.setQuestionValue(value);
    //Question Text
    this.setText(s.nextLine());
    //Right Answer and sets it
    System.out.println("Enter the Right answer to set");
    Answer a = new SAAnswer(s);
    System.out.println("HERE");
    this.setRightAnswer(a);
  }

  public SAAnswer getNewAnswer(String input){
    //Creates a new Short Answer Answer for the Question
    SAAnswer ans = new SAAnswer(input);
    return ans;
  }

  //Creates a new Answer from the student and sets it as the student input
  public SAAnswer getAnswerFromStudent(String input){
    SAAnswer ans = new SAAnswer(input);
    this.setStudentAnswer(ans);
    return ans;
  }

  //Returns the value of this question
  public double getValue(){
    double value;
    value = getQuestionValue();
    return value;
  }
  //Saves to current Print Writer
  public void save(PrintWriter p){
    //Save Question, followed by right answer
    //Each Question is preceeded by a blank line
    p.println("\r\nSAQuestion\r\n");
    //Then we give the value of the question
    String s = String.valueOf(this.getQuestionValue());
    p.println(s + "\r\n");
    //Then we give the text of the question;
    p.println(this.getText() + "\r\n");
    //Then the correct answer is printed
    Answer r = this.getRightAnswer();
    r.save(p);
  }


  public void setStudentAnswer(SAAnswer input){
    super.setStudentAnswer(input);
  }

  public void setRightAnswer(SAAnswer input){
    super.setRightAnswer(input);
  }


}
