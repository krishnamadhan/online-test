package questions;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionPaperRepo {
    private SubjectRepo aptitude;//creating 3 objects for SubjectRepo class
    private SubjectRepo language;
    private SubjectRepo maths;
//constructor....
    public QuestionPaperRepo() {
       String aptitudeFilePath = "resource/aptitiudeQuestionAndAnswer.txt";//storing the filepath in variable
       String mathsFilePath = "resource/math.txt";
       String verbalFilePath = "resource/verbalQuestions.txt";
       this.aptitude = getLevelRepos(aptitudeFilePath);//calling function by passing filepath as arguement...to store file
       this.language = getLevelRepos(verbalFilePath);
       this.maths = getLevelRepos(mathsFilePath);


    }
//storing question and answer in level as objects.
    public SubjectRepo getLevelRepos(String filePath) {
        File file = new File(filePath);
        SubjectRepo subjectRepo = new SubjectRepo();//creating a new object 'subjectRepo'...
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String text;
            List<QuestionAndAnswer> questionAndAnswers = new ArrayList<>();//Name of the array list is questionAndAnswer and of the type QuestionAndAnswer class
            List<LevelRepo> levelRepos = new ArrayList<>();
            while((text = br.readLine()) != null) {
                if(!text.contains("x-x-x-x")) {//storing level-wise question and answer
                    questionAndAnswers.add(getQnA(text));//we are adding each line of quest and ans to the arraylist questionAndAnswer
                    // as an object of class QuestionAndAnswer
                }
                else {
                    LevelRepo levelRepo = new LevelRepo();//creating a new LevelRepo object to bundle level wise question and answers
                    levelRepo.setQuestionAndAnswers(questionAndAnswers);
                    levelRepos.add(levelRepo);//Adding the (level-wise quest and ans) stored in levelRepo object in the levelRepos arraylist
                    questionAndAnswers = new ArrayList<>();//empties the questionAndAnswer array????(doubt)

                }
            }

            subjectRepo.setLevels(levelRepos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return subjectRepo;

    }
//splitting the question and answer individually and storing them as objects
    private QuestionAndAnswer getQnA(String text) {//Spliting questions an correct answer using spilt
        QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();//declaring a new object
        String[] split = text.split("\\|");
        questionAndAnswer.setQuestion(split[0]);//setting only the question to the object
       /* if(split.length==1) {
            System.out.println(text);
        }*/
        questionAndAnswer.setAnswer(split[1]);
        return questionAndAnswer;//returning object of QuestionAndAnswer with question and answer separately..
    }
//Getter Setter functions for the datamember(objects of SubjectRepo)
    public SubjectRepo getAptitude() {
        return aptitude;
    }

    public void setAptitude(SubjectRepo aptitude) {
        this.aptitude = aptitude;
    }

    public SubjectRepo getLanguage() {
        return language;
    }

    public void setLanguage(SubjectRepo language) {
        this.language = language;
    }

    public SubjectRepo getMaths() {
        return maths;
    }

    public void setMaths(SubjectRepo maths) {
        this.maths = maths;
    }
}
