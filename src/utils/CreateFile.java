package utils;

import exam.Student;
import exam.Subject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateFile {
  public static void generateresponse(Student student) {
    File myObj = new File("resource/result/",student.getId()+".txt");
    try {
      myObj.createNewFile();
      FileWriter myWriter = new FileWriter("resource/result/"+student.getId()+".txt");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\n\t\t\t\t\t\t\t\t::::::::::::::::::::::::::::RESPONSE SHEET::::::::::::::::::::::::::::\n\n");
      stringBuilder.append("Student ID: "+student.getId());
      stringBuilder.append('\n');
      stringBuilder.append("Student Name: "+student.getName());
      stringBuilder.append('\n');
      stringBuilder.append("\n----------------------------------------------APTITUDE-------------------------------------------------\n\n");
      String questionanswerapti = generateQnA(student.getAptitude());
      stringBuilder.append(questionanswerapti);
      myWriter.write(stringBuilder.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("\n----------------------------------------------VERBAL--------------------------------------------------\n\n");
      String questionanswerverb = generateQnA(student.getLanguage());
      stringBuilder1.append(questionanswerverb);
      myWriter.write(stringBuilder1.toString());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("\n-----------------------------------------------MATHS--------------------------------------------------\n\n");
      String questionanswermath = generateQnA(student.getMaths());
      stringBuilder2.append(questionanswermath);
      myWriter.write(stringBuilder2.toString());
      StringBuilder stringBuilder3 = new StringBuilder();
      String result = generateresult(student);
      stringBuilder3.append("\n===============================================================================================================================\n\n");
      stringBuilder3.append(result);
      myWriter.write(stringBuilder3.toString());
      myWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public static String generateQnA(Subject  subject) {
    StringBuilder stringBuilder = new StringBuilder();
    for(int i =0; i < subject.getSets().size();++i) {
      stringBuilder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t*********:SET"+(i+1)+":*********");
      stringBuilder.append('\n');
      for(int j =0; j < subject.getSets().get(i).getEvaluations().size();++j) {
          stringBuilder.append(" Question : "+subject.getSets().get(i).getEvaluations().get(j).getQuestion());
        stringBuilder.append('\n');

        stringBuilder.append(" Answer : "+subject.getSets().get(i).getEvaluations().get(j).getAnswer());
        stringBuilder.append('\n');

        stringBuilder.append(" Response : "+subject.getSets().get(i).getEvaluations().get(j).getResponse());
        stringBuilder.append('\n');

      }
    }
    return stringBuilder.toString();
  }
  public static String generateresult(Student student){
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\t\t\t\t\t\t\t\t*********:EXAM RESULT:*********\n\n");
    stringBuilder.append("\t\t\t\t\t:APTITUDE Processed Score: "+student.getAptitude().getTotal_score()+"\n");
    stringBuilder.append("\t\t\t\t\t:VERBAL Processed Score: "+student.getLanguage().getTotal_score()+"\n");
    stringBuilder.append("\t\t\t\t\t:MATHS Processed Score: "+student.getMaths().getTotal_score()+"\n");
    stringBuilder.append("\t\t\t\t\t:Rank: "+student.getRank()+"\n");
    stringBuilder.append("\t\t\t\t\t:Percentile: "+student.getPercentile()+"\n");
    stringBuilder.append("\t\t\t\t\t\t\t\t*******************************");
    return stringBuilder.toString();

  }
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}