/*

Scanner Factory Class

Methods:
getKeyboardScanner(): getKeyboardScanner

*/
import java.io.*;
import java.util.Scanner;

public class ScannerFactory{
  //Scanner for input
  private static Scanner sc;

  //Gets the scanner we created for the fill
  public static Scanner getKeyboardScanner(){
    if(sc == null){
      sc = new Scanner(System.in);
      return sc;
    }
    else{
      return sc;
    }
  }
}
