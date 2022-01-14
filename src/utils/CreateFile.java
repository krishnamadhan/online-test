package utils;

import exam.Student;
import exam.Subject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
  public static void createRaakesh(Student student) {
    File myObj = new File("resource/result/",student.getId()+".txt");
    try {
      myObj.createNewFile();
      FileWriter myWriter = new FileWriter("resource/result/"+student.getId()+".txt");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("                      Result                     ");
      stringBuilder.append('\n');
      stringBuilder.append('\n');
      stringBuilder.append('\n');
      stringBuilder.append("-----------------------Aptitude---------------------");
      stringBuilder.append('\n');


      String raakeshVasudha = createRaakeshVasudha(student.getAptitude());
      stringBuilder.append(raakeshVasudha);
      myWriter.write(stringBuilder.toString());
      myWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public static String createRaakeshVasudha(Subject  subject) {
    StringBuilder stringBuilder = new StringBuilder();
    for(int i =0; i < subject.getSets().size();++i) {
      stringBuilder.append("           Set"+(i+1)+"              ");
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