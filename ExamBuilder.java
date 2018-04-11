import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.io.*;
import java.util.Scanner;

public class ExamBuilder {
	
	static int userChoice =0;
    static Exam test;
	
	public static void main(String args[]) throws FileNotFoundException {
	    System.out.println("Enter 1 followed by the name of the exam you would like to load from file or enter any other number to create new exam");
	//    while(userChoice != 7)

	    
	    //Scanner scan; //= ScannerFactory.getKeyboardScanner();
	    userChoice = ScannerFactory.getKeyboardScanner().nextInt();

	    switch( userChoice) {
	    	case 1 :
	    		//scan = ScannerFactory.getKeyboardScanner();
	    		Scanner sca = ScannerFactory.getKeyboardScanner();
	    		String filename = sca.next();
	    		System.out.printf("THIS IS THE FILE NAME, %s \n\n",filename);
	    	//	File file = new File("exam.txt");
	    		File file = new File(filename);
//			try {
//				System.out.println("Attempting to read from file in: " +file.getCanonicalPath());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	    	//	System.out.print(file);
	    	 //   PrintWriter pwExam = new PrintWriter(file);
	    //	    PrintWriter pwAnswers = new PrintWriter("answers.txt");
	    	    Scanner fileScanner = new Scanner(file);
//	            while (fileScanner.hasNextLine()) {
//	        	    System.out.println("TEST");
//	                String i = fileScanner.nextLine();
//	                System.out.println(i);
//	            }
	    		test = new Exam(fileScanner);
	    		break;
	    	default :
	    		System.out.println("Now creating a new exam. Enter the Name of the Exam");
	    		
	    		Scanner ExamTitle = ScannerFactory.getKeyboardScanner();
	    		test = new Exam(ExamTitle);
	    		break;
	    }

	    test.print();
	    System.out.println("Enter 1 to Add questions");
	    System.out.println("Enter 2 to Remove questions");
	    System.out.println("Enter 3 to Reorder questions, and/or answers");
	    System.out.println("Enter 4 to Print the Exam, to the screen or to"
	    				 + " txt file for printing");
	    System.out.println("Enter 5 to Save the Exam");
	    System.out.println("Enter 6 to Quit");
	    
	    userChoice = ScannerFactory.getKeyboardScanner().nextInt();
	    while(userChoice != 6) {

	    switch(userChoice) {
	    	case 1 :
	    		System.out.println("What kind of question would you like to add?"
	    						 + "\n( MCSAQuestion, SAQuestion, MCMAQuestion ) ");
	    		//scan = ScannerFactory.getKeyboardScanner();
	    		String questionType = ScannerFactory.getKeyboardScanner().next();
	    		switch(	questionType) {
	    			case "MCSAQuestion" :
	    				System.out.println("Type of Question is MultipleChoice Single Answer enter double + question");
	    				 MCSAQuestion mc_question = new MCSAQuestion( ScannerFactory.getKeyboardScanner() );	    		 
	    		         test.addQuestion(mc_question);
	    		         break;

	    			case "SAQuestion" :
	    				System.out.println("Question type is Single Answer");
	    				SAQuestion sA = new SAQuestion(ScannerFactory.getKeyboardScanner());
	    				test.addQuestion(sA);
	    			//	SAQuestion sa_question = new SAQuestion(scan);
	    				break;
	    			case "MCMAQuestion" :
	    				System.out.println("Question type is Multiple Choice Multiple Answer ENTER double + question");
	    				 MCMAQuestion mcm_question = new MCMAQuestion( ScannerFactory.getKeyboardScanner() );
	    				 test.addQuestion(mcm_question);
	    				break;
// ********** UNCOMMENT OUT ONCE NUMQUESTION CLASS IS COMPLETE ************	    				
//	    			case "NumQuestion" : // depends on part 1 of division of labor
//	    				System.out.println("Question type is Number Question Specifics for ")
//	    				NumQuestion num_q = new NumQuestion( ScannerFactory.getKeyboardScanner());
//	    				test.addQuestion(num_q);
//	    				break;
	    			default :
	    				System.out.println("INVALID Option please type exactly as shown");
	    				break;
	    		}
	    		break;
	    	case 2 : // remove
	    		System.out.println("Please enter the Question number you wish to remove");
	    		int qNum = ScannerFactory.getKeyboardScanner().nextInt();
	    		test.removeQuestion(qNum-1);
	    		break;
	    	case 3 : //shuffle
				test.reorderQuestions();

				for(Question e: test.getQuestion() ) {
					test.reorderMCAnswers(-1);
				}
	    	case 4 : // print exam
	    		System.out.println("Now printing the exam to console");
	    		test.print();
	    		break;
	    	case 5 : // save exam
				File savedFileExam = new File("SavedExam.txt");
				PrintWriter write = new PrintWriter(savedFileExam);
				test.save(write);
				write.close();
				break;
	    	case 6 :
	    		System.out.println("Now exiting. . .");
	    		return;
	    }
	    System.out.println("Enter 1 to Add questions");
	    System.out.println("Enter 2 to Remove questions");
	    System.out.println("Enter 3 to Reorder questions, and/or answers");
	    System.out.println("Enter 4 to Print the Exam, to the screen or to"
	    				 + " txt file for printing");
	    System.out.println("Enter 5 to Save the Exam");
	    System.out.println("Enter 6 to Quit");
	    userChoice = ScannerFactory.getKeyboardScanner().nextInt();
		}// end while
	}
}
