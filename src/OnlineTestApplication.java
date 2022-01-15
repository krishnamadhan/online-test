import exam.*;
import exam.Set;
import questions.LevelRepo;
import questions.QuestionAndAnswer;
import questions.QuestionPaperRepo;
import questions.SubjectRepo;
import utils.CreateFile;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class OnlineTestApplication {

    public static QuestionPaperRepo questionPaperRepo;
    public static int questionsInSet = 10;
    public static final int setTimer = 0;
    public static final int subjectTimer = 0;
    public static final int studentTimer = 0;
    public static final int autoFillCorrectAnswer = 9;

    public static void main(String[] args) throws InterruptedException {
        QuestionPaperRepo questionPaperRepo = new QuestionPaperRepo();
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\tWELCOME TO PROMETRIC BASED EXAM:\n");
        System.out.println("Enter number of students going to take exam: ");
        int count;
        Scanner s = new Scanner(System.in);
        count = s.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Student std = new Student();
            std.setId("StudentID-"+(i+1));
            System.out.println("Enter the name of Student: ");
            String name;
            Scanner sc = new Scanner(System.in);
            name = sc.nextLine();
            std.setName(name);
            std.setAptitude(takeTest(questionPaperRepo.getAptitude()));
            std.setLanguage(takeTest(questionPaperRepo.getLanguage()));
            std.setMaths(takeTest(questionPaperRepo.getMaths()));
            students.add(std);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("\t\t\t\t\t\tRESULT:");
            System.out.println("\nProcessed Score of Student " + (i + 1) + " :");
            System.out.println("Aptitude: " + std.getAptitude().getTotal_score());
            System.out.println("Language: " + std.getLanguage().getTotal_score());
            System.out.println("Maths: " + std.getMaths().getTotal_score());
            std.setTotal_mark(std.getAptitude().getTotal_score() + std.getLanguage().getTotal_score() + std.getMaths().getTotal_score());
            resetQuestionPaper(questionPaperRepo);
            System.out.println("\n=============================================================================================================================================");
        }
        System.out.println("\n\n:FINAL COMPILATION OF RESULT:\n\n");
        finalresult(students);
        finalranklist(students);
        for(int i=0;i<students.size();i++) {
            CreateFile.generateresponse(students.get(i));
        }


    }
    public static void finalresult(List<Student>students){
        for( int i=0;i<students.size();i++){
            System.out.println("\n=========================================================================================\n");
            System.out.println("Student ID: "+ students.get(i).getId());
            System.out.println("Student Name: "+ students.get(i).getName());
            System.out.println("\n-----------------APTITUDE---------------------");
            for(int j=0;j<students.get(i).getAptitude().getSetWiseMark().size();j++) {
                System.out.println("SET "+(j+1)+" Mark:"+students.get(i).getAptitude().getSetWiseMark().get(j));
            }
            System.out.println("\n--------------------VERBAL----------------------");
            for(int j=0;j<students.get(i).getLanguage().getSetWiseMark().size();j++) {
                System.out.println("SET "+(j+1)+" Mark:"+students.get(i).getLanguage().getSetWiseMark().get(j));
            }
            System.out.println("\n--------------------MATHS---------------------");
            for(int j=0;j<students.get(i).getMaths().getSetWiseMark().size();j++) {
                System.out.println("SET "+(j+1)+" Mark:"+students.get(i).getMaths().getSetWiseMark().get(j));
            }

        }



    }
    public static void finalranklist(List<Student>students){
        setRank(students);
        System.out.println("\n:RANK LIST: ");
        for(int i=0;i<students.size();i++)
        {
            System.out.print("Rank "+(i+1)+":"+students.get(i).getName()+"\t");
            System.out.println(" Percentile: "+(Double.valueOf(students.size()-i)/students.size())*100);
        }

    }

    public static void resetQuestionPaper(QuestionPaperRepo questionPaperRepo) {
        resetCursor(questionPaperRepo.getAptitude().getLevels());
        resetCursor(questionPaperRepo.getLanguage().getLevels());
        resetCursor(questionPaperRepo.getMaths().getLevels());
    }

    public static void resetCursor(List<LevelRepo> levels) {
        for (int i = 0; i < levels.size(); ++i) {
            levels.get(i).setCursor(0);
        }

    }

    public static void setRank(List<Student> students) {
        Collections.sort(students, new MarkComparator());
        for (int i = 0; i < students.size(); ++i) {
            students.get(i).setRank(i + 1);
        }
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

    public static Subject takeTest(SubjectRepo subjectRepo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Subject subject = new Subject();
        List<Set> sets = new ArrayList<>();//declaring an arraylist of type Set.....variable is 'sets'
        int numberOfSets = subject.getTotal_sets();//assigns value to numberOfSets
        for (int i = 0; i < numberOfSets; i++) {
            int level = subject.getCurrentLevel();//assigning the current level
            Set set = new Set();
            set.setLevel(level);
            int total_questions = set.getTotal_questions();
            List<Evaluation> evaluationList = new ArrayList<>();
            Integer correctAnswersLeft = autoFillCorrectAnswer;
            for (int j = 0; j < total_questions; j++)//loop runs for every question inside a set (set object)....
            {
                QuestionAndAnswer questionAndAnswer = subjectRepo.getLevels().get(level - 1).getRandomQuestion();
                //As QuestionAndAnswer has question and answer getter setter we create an object of the class
                //and assigning the question and the answer by...
                //subjectRepo object will be of any subject type(has questions and answers level wise)
                //the object subjectrepo calls the function getLevels() to return the level arraylist of LevelRepo
                //now the getlevels() function return the (currentlevel -1)th entity in the level array list..
                //inside the entity we call getRandomQuestion() which returns some random question of the current level.

                System.out.println(questionAndAnswer.getQuestion());
                String ans;
                if(correctAnswersLeft>0) {
                    ans= questionAndAnswer.getAnswer();
                    correctAnswersLeft--;
                }else {
                    ans = getRandomAnswer();
                }//random answer is generated..
                System.out.println("Ans: " + ans);
                Evaluation evaluation = new Evaluation();//creeating evaluation object to setting which question stored , what is the correct answer and what is the response
                evaluation.setQuestion(questionAndAnswer.getQuestion());
                evaluation.setAnswer(questionAndAnswer.getAnswer());
                evaluation.setResponse(ans);
                evaluationList.add(evaluation);//storing the object in evaluationlist array list..


            }//after total number of the question in that set gets completed(i.e. 10 quests)

            System.out.println("\nCurrent level: " + level);
            System.out.println("Set " + (i + 1) + " over");
            set.setEvaluations(evaluationList);//Storing the evaluationlist set wise for all the 4 sets
            set.setCorrect_answers();//calculating the raw score setwise
            subject.getSetWiseMark().add(set.getCorrect_answers());//adding setwisemark for this particular subject in getSetWiseMark list
            subject.getSets().add(set);
            subject.setNextLevel();//returns the next level...
            System.out.println("Set Wise Raw Score: " + subject.getSetWiseMark());
            subject.getSets().forEach(set1 -> System.out.println("Set wise Level : "+set1.getLevel()));

            subject.setTotalScore();
            System.out.println("Set Wise Processed Score: " + subject.getTotal_score());
            TimeUnit.SECONDS.sleep(setTimer);

        }
        TimeUnit.SECONDS.sleep(subjectTimer);

        return subject;

    }


}






