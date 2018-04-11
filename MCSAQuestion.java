/*

Mutliple Choice Single Answer Question inherits from MCQuestion

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

public class MCSAQuestion extends MCQuestion{

  //Constuctor for MCSAQuestion
  public MCSAQuestion(String input, double value){
    this.setText(input);
    this.setQuestionValue(value);
  }

  //Construct with scanner
  public MCSAQuestion(Scanner s){
	  

//
//    this.setText(s.nextLine());//Text of the Question
//
//      //Adds the answer to the array list of Questions
//      System.out.println("Enter answer using ( Double String ) format ");
	  Double d = s.nextDouble();//Value of the Question
	  this.setQuestionValue(d);
	  this.setText(s.nextLine());
      this.answers = new ArrayList<MCAnswer>();
      System.out.println("Enter the number of answers for this question");
	  int numAs = Integer.parseInt(s.nextLine());
	  for(int i = 0; i < numAs; i++) {
		  System.out.println("Enter Double String for new answer ");
		double CiSCnS = s.nextDouble();
		String Answer = s.nextLine().trim();
		
		MCSAAnswer nAns = new MCSAAnswer(Answer,CiSCnS);
		
		answers.add(nAns);
	  }	  
  }

  public MCSAAnswer getNewAnswer(String input, double credit){
    //Creates a new Multiple Choice Single Answer Answer for the Question
    MCSAAnswer ans = new MCSAAnswer(input, credit);
    return ans;
  }

  //Creates a new Answer from the student and sets it as the studentinput
  //Since it is a multiple choice question, only one character should be read in
  //input
  public void getAnswerFromStudent(String input){
    //Set the credit to 0 since it is a student answer and Not
    //part of the actual test
    MCSAAnswer ans = new MCSAAnswer(input, 0);
    this.setStudentAnswer(ans);
  }

  //Return the value of the question
  public double getValue(){
    MCSAAnswer ans = (MCSAAnswer)this.getStudentAnswer();
    return super.getValue(ans);
  }

  //Just writes the Question type, the rest is handled in MCQuestion
  public void save(PrintWriter p){
    //Each Question is preceeded by a blank line
    p.println("\r\nMCSAQuestion\r\n");

    //Uses the MCQuestion save method which saves all
    //of the answers and their credit value in the correct format
    super.save(p);
  }


}
