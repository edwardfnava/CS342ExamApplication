/*

This is the Multiple Choice Multiple Answer Class, this Class
inherits the Multiple Choice Answer class

Methods:
Constructor

*/
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class MCMAAnswer extends MCAnswer{
  //Public constructor for the Multiple Choice Single Answer Answer

  public MCMAAnswer(String input, double creditIfSelected){
    this.setText(input);
    this.setCredit(creditIfSelected);
  }
  //This one needs to be parsed with a space for every line it reads
  //"double_Answer"
  public MCMAAnswer(Scanner s){
    String line = s.nextLine();
    //Splits the string based on the space in between the two contents
    String[] split = line.split("\\s+");
    double d =Double.parseDouble(split[0]);//First is the credit
    this.setCredit(d);

    //Set the text of the answer to the second parsed string on the line
    this.setText(split[1]);
  }
}
