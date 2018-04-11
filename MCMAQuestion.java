/*

Mutliple Choice Multiple Answer Question inherits from MCQuestion

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

public class MCMAQuestion extends MCQuestion{

  //Saved student answers for this question will go in this array
  ArrayList<MCMAAnswer> studentAnswers;
  //base credit, adds all the points up
  double baseCredit;

  //Constuctor for MCMAQuestion
  public MCMAQuestion(String input, double value){
    this.setText(input);
    this.setQuestionValue(value);
  }

  //Construct with scanner
  public MCMAQuestion(Scanner s){
//	super(s);
 //   double d = s.nextDouble();//Value of the Question
 //   this.setQuestionValue(d);
    
//    this.setText(s.nextLine());//Text of the Question
	  double d = s.nextDouble();//Value of the Question
	  this.setQuestionValue(d);
	  this.setText(s.nextLine());
    this.answers = new ArrayList<MCAnswer>();
    System.out.println("Enter number of Answers for this question");
    int numberOfAnswers = Integer.parseInt(s.nextLine());
	
	for(int i = 0; i < numberOfAnswers; i++) {			
	    System.out.println("Enter value String for new answer");
		double CreditIfSelected = s.nextDouble();
		
		String answerString = s.nextLine().trim();
		System.out.println(answerString + CreditIfSelected);
		MCMAAnswer mas = new MCMAAnswer(answerString,CreditIfSelected);
		answers.add(mas);
	}
    //Adds the answer to the array list of Questions

  }

  public MCMAAnswer getNewAnswer(String input, double credit){
    //Creates a new Multiple Choice Multiple Answer Answer for the Question
    MCMAAnswer ans = new MCMAAnswer(input, credit);
    return ans;
  }

  //Creates a new Answer from the student and sets it as the studentinput in the list
  public void getAnswerFromStudent(String input){
    //Set the credit to 0 since it is a student answer and Not
    //part of the actual test
    //It is 0 because the actual answers are compared and then credit is given in
    //exam grader, all this does is add the answer to the array
    MCMAAnswer ans = new MCMAAnswer(input, 0);
    studentAnswers.add(ans);
  }

  //Return the value of the question
  public double getValue(){
    MCMAAnswer ans = (MCMAAnswer)this.getStudentAnswer();
    return super.getValue(ans);
  }

  //Just writes the Question type, the rest is handled in MCQuestion
  public void save(PrintWriter p){
    //Each Question is preceeded by a blank line
    p.println("\r\nMCMAQuestion\r\n");

    //Uses the MCQuestion save method which saves all
    //of the answers and their credit value in the correct format
    super.save(p);
  }

  public void saveStudentAnswers(PrintWriter p){
    //Print the type of Question
    String text;
    p.println("MCMAAnswer\r\n");
    //Print the Number of Answers
    for(MCMAAnswer a: studentAnswers){
      text = a.getText();
      //Print the actual answers text
      p.println(text + "\r\n");
    }

  }

  public void restoreStudentAnswers(Scanner sc){
    //Get each answer from the scanner and write it in to the program
    //This is only called when building the exam and an occurance of MCMA
    //appears in the text file

    //The line that follows MCMAQuestion is the number of Student Answers
    //THIS IS USED TO CALCULATE THE GRADE IN THE FOLLOWING WAY IF NEEDED
    // x = number of answers
    // y = total credit
    // y/x = credit of ONE answer
    // You can also just add the credit together, in which case ignore the Number
    // since we're using lists and not arrays

    int numberOfQuestions = sc.nextInt();
    String line;
    //Store answers from student in the array
    for(int i = 0; i < numberOfQuestions; i++){
      line = sc.nextLine();
      getAnswerFromStudent(line);
    }


  }

}
