/*
This class is used to take the exam.
It saves the exam, steps through it, collects the answers, and stores them.

*/
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class ExamTaker{
  private Exam exam;
  private String studentInfo;

  //Constructor for the Exam Taker class
  public ExamTaker(Exam test){
    exam = test;
    //default case, shouldnt appear
    studentInfo = "not provided";
  }
  //Returns the student information at the beginning of the Answer file
  public String getStudentInfo(){
    return studentInfo;
  }


  //Goes through the exam and prints each question
  //Collects input from the student/file in accordance to each question
  //saves those questions to the printwriter for the text file
  //of student answers to be collected
  public void takeTest(Scanner sc, PrintWriter pw){
    //First line of the file should take the students info
    System.out.println("Please enter your name: ");
    studentInfo = sc.nextLine();
    //FIRST LINE OF THE STUDENT ANSWERS TEXT FILE
    pw.println(studentInfo + "\r\n");
    //SECOND LINE IS THE NAME OF THE EXAM
    pw.println(exam.getExamName() + "\r\n");
    //The next line is blank
    pw.println("\r\n");

    //Now we loop through the exam and collect the answers based on the type of
    //question

    //Get the list of questions
    //We use the getAnswerFromStudent method to input the answers to each
    //question so we can change them later on
    ArrayList<Question> questions = exam.getQuestions();
    //Used to number the questions
    int questionNumber = 1;
    //Decalre the string here to make program more efficient
    String scannerString;
    //Used for NumQuestion
    int scannerInt;

    for(Question q: questions){
      //Prints the text of the question to the student
      System.out.println("Question " + questionNumber + "\r\n");
      q.print();

      //MCSA Question collection
      if(q instanceof MCSAQuestion){
        /*
        FORMAT EXAMPLE:
        MCSAAnswer
        Peanut butter and jelly
        */

        System.out.println("\r\nYour Answer: ");
        scannerString = sc.nextLine();
        //set to 0 since this is not being used to grade
        MCSAAnswer answer = new MCSAAnswer(scannerString, 0);
        //Sets the student answer to that question
        q.setStudentAnswer(answer);
      }

      //MCMA Question collection
      else if(q instanceof MCMAQuestion){
        /*
        FORMAT EXAMPLE:
        MCMAAnswer
        3
        Harry Potter
        Rubeus Hagrid
        Bilbo Baggins
        */

        System.out.println("\r\nEnter Your Answers then type 'done' on a new line and press return: ");

        scannerString = sc.nextLine();

        while(scannerString != "done"){
          //Adds the answer to the Question's Answer Array
          ((MCMAQuestion)q).getAnswerFromStudent(scannerString);
          scannerString = sc.nextLine();
        }
        //Since student answers are stored in an array of the question
        // we dont need to set the student answer for the question
      }

      else if(q instanceof SAQuestion){
        /*
        FORMAT EXAMPLE:
        SAAnswer
        Encapsulation
        */
        scannerString = sc.nextLine();
        System.out.println("\r\nYour Answer: ");
        SAAnswer answer = new SAAnswer(scannerString);
        q.setStudentAnswer(answer);
      }

      /*
      //UNCOMMENT WHEN NUMQUESTION IS ADDED
      else if(q instance of NumQuestion){
      scannerString = sc.nextDouble();
      System.out.println("\r\nYour Answer: ");
      NumAnswer answer = new NumAnswer(scannerString);
      q.setStudentAnswer(answer);
    }
    */
  }//End of Questions

  //***************************************************************************************

  //Now we ask if they want to change anything
  System.out.println("\r\nWould you like to change any answers? Y/n");
  scannerString = sc.nextLine();
  //If yes enter loop until they are done
  if(scannerString == "Y"){

    //which question?.....
    System.out.println("\r\nWhich question would you like to change the answer to?");
    scannerInt = sc.nextInt();

    //If the question is out range....
    if(scannerInt > questions.size() || scannerInt < 1){
      System.out.println("\r\nThat question is out of range");
    }

    //if the question at the position given is MCMA, then we need to ask for
    //Multiple Answers
    if(questions.get(scannerInt -1) instanceof MCMAQuestion){
      System.out.println("\r\nEnter Your Answers then type 'done' on a new line and press return: ");

      //Temporary qeustion
      MCMAQuestion question = new MCMAQuestion("temp", 0);
      scannerString = sc.nextLine();

      while(scannerString != "done"){
        //Adds the answer to the Question's Answer Array
        question.getAnswerFromStudent(scannerString);
        scannerString = sc.nextLine();
      }
      //Set the question back to the position it was in
      questions.set(scannerInt -1, question);
    }

    else if(questions.get(scannerInt-1) instanceof MCSAQuestion){
      System.out.println("\r\nNew Answer: ");
      scannerString = sc.nextLine();
      MCSAAnswer ans = new MCSAAnswer(scannerString,0);
      MCSAQuestion q = new MCSAQuestion("temp", 0);
      q.setStudentAnswer(ans);
      questions.set(scannerInt -1, q);
    }

    /*
    UNCOMMENT AFTER NUMQUESTION IS ADDED
    else if(questions.get(scannerInt-1) instanceof NumQuestion){
    System.out.println("\r\nNew Answer: ");
    scannerString = sc.nextLine();
    NumAnswer ans = new SAAnswer(scannerString);
    NumQuestion q = new SAQuestion("temp", 0);
    q.setStudentAnswer(ans);
    questions.set(scannerInt -1, q);
  }
  */

  else if(questions.get(scannerInt-1) instanceof SAQuestion){
    System.out.println("\r\nNew Answer: ");
    scannerString = sc.nextLine();
    SAAnswer ans = new SAAnswer(scannerString);
    SAQuestion q = new SAQuestion("temp", 0);
    q.setStudentAnswer(ans);
    questions.set(scannerInt -1, q);
  }
}

else if(scannerString == "n"){
  System.out.println("Printing text file of student Answers");
}
}
}
