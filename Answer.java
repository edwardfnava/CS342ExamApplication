//Edward Nava
//enava
import java.io.PrintWriter;
import java.io.File;
import java.io.*;
import java.util.Scanner;
//Answer is now an abstract parent class for all kinds of Answers,
//corresponding to the matching kinds of Quetions
public abstract class Answer{

  //Abstract Constructor
  public Answer(){};

  public Answer(Scanner s){
  }
  //Abstract so that the right type of Answer is printed
  public abstract void print();

  public abstract double getCredit(Answer rightAnswer);

  public abstract void save(PrintWriter p);

  public abstract String getText();

}
