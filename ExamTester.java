//Edward Nava
//enava

/*
This is the Exam Tester Dirver
Starting this up allows you to input Exam files, and then answer them with
answer files

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
***************************************************************************************
DONT USE THIS, THIS IS FROM THE PREVIOUS HOMEWORKS
Use this as reference when building you new class if you wish
***************************************************************************************
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
*/


import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class ExamTester{
  /*
  Create an Exam with at least two of each kind of question
  Print the Exam
  Randomly Reorder the questions on the exam and randomly
  reorder the answers to multiple choice questions. Print again
  Get student answers from the person
  Grade the exam

  */
  public static void main(String args[]) {
    System.out.println("Name: Edward F. Nava\nACCC: enava\nUIN: 650038081\n");
    try{
      //New Scanner
      Scanner sc = ScannerFactory.getKeyboardScanner();

      File exam = new File("textFiles/exam.txt");

      //Creates a new print write for a file named exam.txt
      PrintWriter pwExam = new PrintWriter(exam);
      //Creates a new print writer for a file named answers.txt
      PrintWriter pwAnswers = new PrintWriter("answers.txt");
      //Read in File from input and Create Exam
      //Construct Exam via Scanner
      Exam test = new Exam(sc);

      //Now that we have an exam constructed
      //We must run through the rest of the file
      //This means adding all the answers to each Question
      //and then adding the Quesitons to the test
      String s;

      while(sc.hasNextLine()){
        s = sc.nextLine();
        //All the cases for the different types of questions

        //The MSCAQuesion Case
        if(s == "MCSAQuestion"){
          //This will create a MCSAQuestion which will
          //read in from the Scanner and crea/home/ubuntu/Documentste the question
          //appropriately
          MCSAQuestion mc_question = new MCSAQuestion(sc);
          //This is the multiple choice question, and therefore
          //it can have up to 26 answers within it, because of This
          //we loop, scan and break once we hit a blank line
          while(sc.hasNextLine()){
            //The constructor handles the scanned in values
            //and assigns them to the answer accordingly
            MCSAAnswer mc_ans = new MCSAAnswer(sc);

            //If a new line character is read in, this indicates the Start
            //of a new question, so we break and continue
            //to scan through the file
            if(sc.nextLine() == "\n"){
              break;
            }
          }
          //Add the question to the exam
          test.addQuestion(mc_question);
        }

        //The SAQuestion case
        if(s == "SAQuestion"){
          //This will create a SAQuestion which will
          //read in from the Scanner
          SAQuestion sa_question = new SAQuestion(sc);

          //Add the quesiton to the exam
          test.addQuestion(sa_question);
        }
        else{
          //Proceed to the next line if the line is empty
          if(sc.hasNextLine()){//Extra check to prevent seg faults
            s = sc.nextLine();
          }
        }
      }

      //Now that we have all our questions and answers added
      //we'll reorder the exam and then save it to a different file

      //Reorder the questions on the test
      test.reorderQuestions();
      //Reorder all MCAnswers
      test.reorderMCAnswers(-1);


      //Now that all the answers and Questions are reodered,
      //save the new exam into a different file we created above
      test.save(pwExam);
      pwExam.close();
      pwAnswers.close();
    }

    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }
}
