import java.io.File;
import java.io.*;
import java.util.*;

/*
  The only method you need to use is
  the constructor and gradeExam() method
  which basically does all the
*/
public class ExamGrader{

  private File answersFile;
  private File examFile;
  private String student;
  private Exam exam;

  /*
    Accepts an answers file, parses the first few lines for
    corresponding exam file;
  */

  public ExamGrader(String answersFile){
    System.out.println("Name: Kevin Benitez\nACCC: kbenit4\nUIN: 654044015\n");
   System.out.println("worked on: ExamGrader, Answer, SAQuestion, SAAnswer, NumQuestion, and NumAnswer.");
    setAnswersFile(answersFile);
    try{
      Scanner scan = new Scanner(this.answersFile);
      this.student = scan.nextLine();
      scan.nextLine();
      String examFile = scan.nextLine();
      setExamFile(examFile);
      scan.close();
    }
    catch(FileNotFoundException e){
      e.printStackTrace();
    }
  }

  /*
    parses exam file, creates and returns Exam object
  */

  private Exam LoadExam(){

    try {
        File file = this.examFile;
        Scanner scan = new Scanner(file);
        String examTitle = scan.nextLine();
        Exam exam = new Exam(examTitle);

        while (scan.hasNext()) {

            String label = scan.nextLine();

            if(label.equals("SAQuestion")){

                double totalCredit   = Double.parseDouble(scan.nextLine());
                String question = scan.nextLine();
                String answer   = scan.nextLine();
                SAQuestion saquestion = new SAQuestion(question, totalCredit);
                saquestion.setRightAnswer(new SAAnswer(answer));
                exam.addQuestion(saquestion);
            }

            else if(label.equals("MCSAQuestion")){

                double totalCredit      = Double.parseDouble(scan.nextLine());
                String question         = scan.nextLine();
                int numQuestions        = Integer.parseInt(scan.nextLine());

                MCSAQuestion mcsaQuestion = new MCSAQuestion(question, totalCredit);
                mcsaQuestion.setQuestionValue(totalCredit);
                for(int i = 0; i < numQuestions; i++){
                  String[] splitString = scan.nextLine().split("\\s+");
                  double credit = Double.parseDouble(splitString[0]);
                  String answer = splitString[1];
                  mcsaQuestion.addMCSAAnswer(new MCSAAnswer(answer, credit));

                }
                exam.addQuestion(mcsaQuestion);
            }

            else if(label.equals("MCMAQuestion")){

              double totalCredit      = Double.parseDouble(scan.nextLine());
              String question         = scan.nextLine();
              double baseCredit       = Double.parseDouble(scan.nextLine());
              int numQuestions        = Integer.parseInt(scan.nextLine());

              MCMAQuestion mcmaQuestion = new MCMAQuestion(question, totalCredit);

              for(int i = 0; i < numQuestions; i++){
                String[] splitString = scan.nextLine().split("\\s+");
                double credit = Double.parseDouble(splitString[0]);
                String answer = splitString[1];
                mcmaQuestion.addAnswer(mcmaQuestion.getNewAnswer(answer,credit));
              }
               exam.addQuestion(mcmaQuestion);
            }

            else if(label.equals("NumQuestion")){

              double maxValue      = Double.parseDouble(scan.nextLine());
              String question      = scan.nextLine();
              String answer        = scan.nextLine();
              double tolerance     = Double.parseDouble(scan.nextLine());
              NumQuestion numQuestion = new NumQuestion(question, maxValue, tolerance);
              numQuestion.setRightAnswer(new NumAnswer(answer));
              exam.addQuestion(numQuestion);
            }

        }
        System.out.println("\n");

        scan.close();
        return exam;
    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    return null;
  }

  /*
     marks the exam using the answers file
  */

  private void markExam(){
    try{
      Scanner scan = new Scanner(this.answersFile);
      ArrayList<Question> questions = exam.getQuestions();
      Answer answer;
      String studentName = scan.nextLine();

      scan.nextLine();
      scan.nextLine();
      scan.nextLine();

      for(Question q: questions){
        scan.nextLine();
        if(q instanceof MCMAQuestion){
          int numOfAns = Integer.parseInt(scan.nextLine());
          for(int i = 0; i < numOfAns; i++ ){
          q.getAnswerFromStudent(scan.nextLine());
          }
        }
         else{
          q.getAnswerFromStudent(scan.nextLine());
        }
        if(scan.hasNext())
          scan.nextLine();
      }
    }
    catch(FileNotFoundException e){
      e.printStackTrace();
    }
  }

 /*
  basically gets credit for exam, and creates a csv file with the
 */

  public void gradeExam(){
    this.exam = LoadExam();
    this.markExam();
    System.out.println((exam.getValue()));
    this.storeAsCSV(exam);
  }

  /*
   Stores exam results in CSV format
  */

  private void storeAsCSV(Exam exam){
    try{
      PrintWriter printWriter = new PrintWriter ("score.csv");
      ArrayList<Question> questions = exam.getQuestions();

      printWriter.print(this.student);
      printWriter.print(exam.getValue());

      for(Question q: questions){
        double value = q.getValue();
        printWriter.print("," + value);
      }
      printWriter.close();
    }
    catch(FileNotFoundException e){
      e.printStackTrace();
    }
  }

  public void setAnswersFile(String answersFile){
    this.answersFile = new File(answersFile);
  }

  public void setExamFile(String examFile){
    this.examFile = new File(examFile);
  }
}
