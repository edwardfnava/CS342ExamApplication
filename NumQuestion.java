/*

NumQuestion class inherits from Question Class

Methods:
+NumQuestion(text: String, maxValue: double, tolerance: double)
+NumQuestion(Scanner)
+getNewANswer(): Answer
+getAnswerFromStudent(): void
+getValue(): double_Answer
+save(PrintWriter)

*/
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;

public class NumQuestion extends Question{

  //NumQuestion
  private double tolerance;

  public NumQuestion(String text, double maxValue, double tolerance){
    this.tolerance = tolerance;
    setText(text);
    setQuestionValue(maxValue);
  }

  public NumQuestion(Scanner scan){
    Scanner keyboard = ScannerFactory.getKeyboardScanner();
    String inRightAnswer= keyboard.nextLine();
    setText(inRightAnswer);
  }
/*
  public Answer getNewAnswer(){
  }
*/

  public NumAnswer getAnswerFromStudent(){
    Scanner keyboard = ScannerFactory.getKeyboardScanner();
    String input = keyboard.nextLine();
    NumAnswer numAnswer = new NumAnswer(input);
    this.setStudentAnswer(numAnswer);
    return numAnswer;
  }

  public void getAnswerFromStudent(String input){
    NumAnswer numAnswer = new NumAnswer(input);
    this.setStudentAnswer(numAnswer);
  }

  public double getValue(){
      double rightAnswer       = Double.parseDouble(this.getRightAnswer().getText());
      double theStudentsAnswer = Double.parseDouble(this.getStudentAnswer().getText());

      double ub = rightAnswer + tolerance; // upperbound
      double lb = rightAnswer - tolerance; // lowerbound
      if((rightAnswer >= lb)  && (rightAnswer <= ub)){
          double value = this.getQuestionValue();
          return value;
      }
      else{
        return 0;
      }
  }

  public void save(PrintWriter p){
    p.println("\r\nNumQuestion\r\n");
    String s = String.valueOf(this.getQuestionValue());
    p.println(s + "\r\n");
    p.println(this.getText() + "\r\n");
    p.println(this.getRightAnswer().getText() + "\r\n");
    p.println(this.tolerance + "\r\n");
  }
}
