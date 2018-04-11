/*

NumAnswer class inherits from Answer Class

Methods:
public NumAnswer(double)
public NumAnswer(Scanner)
public print(): void
public getCredit(rightAnswer: Answer): double_Answer
public save(PrintWriter): void
*/

import java.util.Scanner;
import java.io.PrintWriter;

public class NumAnswer extends Answer{
public String text;

public NumAnswer(String text){
  this.text = text;
}

public NumAnswer(Scanner scan){
  Scanner keyboard = scan;
  String input = keyboard.nextLine();
  this.text = input;
}

public void print(){
  System.out.println(text);
}

public double getCredit(Answer answer){
  // Dont really ned this one since its only used in NumQuestion and
  // conditions are checked there
  return 0.0;
}

public String getText(){
  return this.text;
}

public void save(PrintWriter p){
  p.println(this.text + "\r\n");
}

}
