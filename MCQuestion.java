/*


Multiple Choice Question class inherits from Question Class

Methods:
print(): void
addAnswer(Answer)
reorderAnswers(): void
getValue(MCAnswer): double
save(PrintWriter): void


*/
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.io.PrintWriter;
import java.io.File;

public class MCQuestion extends Question{

  protected ArrayList<MCAnswer> answers;
  //Abstract for the proper constructor to be called
  public MCQuestion(){
    answers = new ArrayList<MCAnswer>();
  }
  //Constructs the multiple choice question based off of read in text
  public MCQuestion(Scanner sc){
	  super(sc);
	  answers = new ArrayList<MCAnswer>();
  }
  //Prints the list of Answers that belong to the quesiton
  //Questions can contain 9 choices at most
  public void print(){
    System.out.println("\n-------------------------------------------\n");
    System.out.println(this.getText());
    System.out.println("\n-------------------------------------------\n");
    int i = 0;
    for(Answer a: answers){
      if(i ==0){
        System.out.println("\nA) ");
      }
      else if(i ==1){
        System.out.println("\nB) ");
      }
      else if(i ==2){
        System.out.println("\nC) ");
      }
      else if(i ==3){
        System.out.println("\nD) ");
      }
      else if(i ==4){
        System.out.println("\nE) ");
      }
      else if(i ==5){
        System.out.println("\nF) ");
      }
      else if(i ==6){
        System.out.println("\nG) ");
      }
      else if(i ==7){
        System.out.println("\nH) ");
      }
      else if(i ==8){
        System.out.println("\nI) ");
      }
      else if(i ==9){
        System.out.println("\nJ) ");
      }
      else if(i ==10){
        System.out.println("\nK) ");
      }
      else if(i ==11){
        System.out.println("\nL) ");
      }
      else if(i ==12){
        System.out.println("\nM) ");
      }
      else if(i ==13){
        System.out.println("\nN) ");
      }
      else if(i ==14){
        System.out.println("\nO) ");
      }
      else if(i ==15){
        System.out.println("\nP) ");
      }
      else if(i ==16){
        System.out.println("\nQ) ");
      }
      else if(i ==17){
        System.out.println("\nR) ");
      }
      else if(i ==18){
        System.out.println("\nS) ");
      }
      else if(i ==19){
        System.out.println("\nT) ");
      }
      else if(i ==20){
        System.out.println("\nU) ");
      }
      else if(i ==21){
        System.out.println("\nV) ");
      }
      else if(i ==22){
        System.out.println("\nW) ");
      }
      else if(i ==23){
        System.out.println("\nX) ");
      }
      else if(i ==24){
        System.out.println("\nY) ");
      }
      else if(i ==25){
        System.out.println("\nZ) ");
      }
      a.print();
      System.out.println("\n");
      i++;
    }
  }

  //Adds the answer to the array list
  //To add, first create the right kind of answer, then
  //call the add Answer funciton
  public void addAnswer(MCAnswer input){
    answers.add(input);
  }

  public void addMCSAAnswer(MCSAAnswer input){
    answers.add(input);
  }

  //Shuffles the questions in the array list
  public void reorderAnswers(){
    Collections.shuffle(answers);
  }

  public double getValue(MCAnswer a){
    //Go through the answers array
    for(MCAnswer ans: answers){
      //If the answer matches a correct answer, then return the credit
      //times the max question Value

      //If the current answer in the array has a credit greater than 0
      //(is correct)
      if(ans.getCredit(this.getRightAnswer()) > 0){
        //...And if the answer passed through getValue matches that answer
        if(a.getCredit(ans) > 0){
          //...Then multiple by the quesiton value by credit
          //and return the value earned
          double value = this.getQuestionValue() * a.getCredit(ans);
        //  return value;
        }
      }
    }
    return 0.0;
  }

  public void save(PrintWriter p){
    //Write the entire array of Multiple choice questions
    //First we write the correct type of Question (MCSA or MCMA)
    //handles the correct type of Question in MCSA and MCMA first by calling
    //super

    //Then we write the value of the question
    String s = String.valueOf(this.getQuestionValue());
    p.println(s + "\r\n");
    //Then we write the actual question
    p.println(this.getText() + "\r\n");
    //Then we write the Number of Answers
    int i = 0;
    for(Answer a: answers){
      i++;
    }
    //Number of Answers
    p.println(i + "\r\n");
    //Then we write the list of Answers to the question
    //Answers text saved next to credit text
    for(Answer a: answers){
      a.save(p);
    }
  }
}
