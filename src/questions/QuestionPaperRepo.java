package questions;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionPaperRepo {
    private SubjectRepo aptitude;
    private SubjectRepo language;
    private SubjectRepo maths;

    public QuestionPaperRepo() {
       String aptitudeFilePath = "resource/aptitiudeQuestionAndAnswer.txt";
       String mathsFilePath = "resource/math.txt";
       String verbalFilePath = "resource/verbalQuestions.txt";
       this.aptitude = getLevelRepos(aptitudeFilePath);
       this.language = getLevelRepos(verbalFilePath);
       this.maths = getLevelRepos(mathsFilePath);



    }
    public SubjectRepo getLevelRepos(String filePath) {
        File file = new File(filePath);
        SubjectRepo subjectRepo = new SubjectRepo();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String text;
            List<QuestionAndAnswer> questionAndAnswers = new ArrayList<>();
            List<LevelRepo> levelRepos = new ArrayList<>();
            while((text = br.readLine()) != null) {
                if(!text.contains("x-x-x-x")) {
                    questionAndAnswers.add(getQnA(text));

                }
                else {
                    LevelRepo levelRepo = new LevelRepo();
                    levelRepo.setQuestionAndAnswers(questionAndAnswers);
                    levelRepos.add(levelRepo);
                    questionAndAnswers = new ArrayList<>();

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

    private QuestionAndAnswer getQnA(String text) {
        QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
        String[] split = text.split("\\|");
        questionAndAnswer.setQuestion(split[0]);
        if(split.length==1) {
            System.out.println(text);
        }
        questionAndAnswer.setAnswer(split[1]);
        return questionAndAnswer;
    }

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
