/*
  Question class

  Methods:

  Question(text: String, maxValue: double)
  print(): void
  setRightAnswer(ans: Answer) : void
  getNewAnswer(): abstract Answer
  getValue(): abstract double
  save(PrintWriter): abstract void
  restoreStudentAnswers(Scanner): void

*/

//Edward Nava
//enava

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class Question{

  //Question text
  private String text;
  //The Max Value This Question can have
  private double maxValue;
  //Student Answer
  private Answer studentAnswer;
  //Correct Answer
  private Answer rightAnswer;

  //Constructor that sets the text of the question and the max value of the question
  //Abstract
  public Question(){
  }
  protected Question(Scanner sc) {
	  this.maxValue = Double.parseDouble(sc.nextLine());
	  this.text = sc.nextLine();
  }

  //Print Method
  public void print(){
    System.out.println("\n-------------------------------------------\n");
    System.out.println(text);
    System.out.println("\n-------------------------------------------\n");
  }

  //Set the right answer to the answer passed
  public void setRightAnswer(Answer a){
    rightAnswer = a;
  }

  public void setStudentAnswer(Answer a){
    studentAnswer = a;
  }
  //Abstract here so the right type of Answer is found
  public Answer getNewAnswer(){
    return this.getNewAnswer();
  }
  //Abstract here so the right type of Answer is found
  public Answer getAnswerFromStudent(){
    return this.getAnswerFromStudent();
  }

  //Get the number of points this Question contributes to the exam using
  //get Credit, use this to score the Exam
  //Abstract
  public double getValue(){
    return this.getValue();
  }
  //Gets the overall max value of the question
  public double getQuestionValue(){
    return maxValue;
  }

  public void save(PrintWriter p){
  }

  public void saveStudentAnswer(PrintWriter p){

  }

  public void restoreStudentAnswers(Scanner s){

  }

  public void setQuestionValue(double value){
    this.maxValue = value;
  }

  public void setText(String input){
    text = input;
  }

  public String getText(){
    return text;
  }

  public Answer getRightAnswer(){
    return rightAnswer;
  }
  public Answer getStudentAnswer(){
    return studentAnswer;
  }


}
