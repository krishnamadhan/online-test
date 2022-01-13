import exam.Evaluation;
import exam.Set;
import exam.Subject;
import questions.QuestionAndAnswer;
import questions.QuestionPaperRepo;
import questions.SubjectRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class OnlineTestApplication {

    public  static QuestionPaperRepo questionPaperRepo;
    public  static  int questionsInSet=10;

    public static void main(String[] args) {
        QuestionPaperRepo questionPaperRepo = new QuestionPaperRepo();

        takeTest(questionPaperRepo.getAptitude());
        takeTest(questionPaperRepo.getLanguage());
        takeTest(questionPaperRepo.getMaths());

    }
    public static String getRandomAnswer() {
        List<String> options = new ArrayList<>();
        options.add("a");
        options.add("b");
        options.add("c");
        options.add("d");
        int i = new Random().nextInt(options.size());
        return options.get(i);
    }
    public static Subject takeTest(SubjectRepo subjectRepo) {
        Scanner sc = new Scanner(System.in);
//raakesh
        Subject subject = new Subject();
        List<Set> sets = new ArrayList<>();
        int numberOfSets = subject.getTotal_sets();
        for (int i = 0; i < numberOfSets; i++) {
            int level = subject.getCurrentLevel();
            Set set = new Set();
            set.setLevel(level);
            int total_questions = set.getTotal_questions();
            List<Evaluation> evaluationList = new ArrayList<>();
            for(int j=0; j<total_questions; j++)
            {
                QuestionAndAnswer questionAndAnswer = subjectRepo.getLevels().get(level - 1).getRandomQuestion();
                System.out.println(questionAndAnswer.getQuestion());
                String ans;
                ans = getRandomAnswer();
                Evaluation evaluation = new Evaluation();
                evaluation.setQuestion(questionAndAnswer.getQuestion());
                evaluation.setAnswer(questionAndAnswer.getAnswer());
                evaluation.setResponse(ans);
                evaluationList.add(evaluation);


            }
            set.setEvaluations(evaluationList);
            set.setCorrect_answers();
            subject.getSetWiseMark().add(set.getCorrect_answers());
            subject.setNextLevel();
            subject.getSets().add(set);







        }
        return subject;

    }



}
