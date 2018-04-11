/*
Multiple Choice Answer class inherits from Answer class

Methods:
print(): void
setSelected(slected: boolean) void

*/
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;



public class MCAnswer extends Answer{

  private String text;
  private double creditIfSelected;

  //Abstract Constuctor for both MCSA MCMA
  public MCAnswer(){};

  public MCAnswer(Scanner s){

  }

  public void print(){
    System.out.println(text);
  }

  public void setText(String input){
    text = input;
  }
  public String getText(){
    return text;
  }

  public void setCredit(double d){
    this.creditIfSelected = d;
  }

  public double getCredit(Answer rightAnswer){
    if(this.getText() == rightAnswer.getText()){
        return creditIfSelected;
    }
    else{
      return 0;
    }
  }

  public void save(PrintWriter p){
    String credit;
    credit = String.valueOf(creditIfSelected);
    p.println(credit + " " + text + "\r\n");
  }

}
