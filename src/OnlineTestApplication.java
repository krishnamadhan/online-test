import exam.*;
import exam.Set;
import questions.QuestionAndAnswer;
import questions.QuestionPaperRepo;
import questions.SubjectRepo;

import java.util.*;

public class OnlineTestApplication {

    public static QuestionPaperRepo questionPaperRepo;
    public static int questionsInSet = 10;

    public static void main(String[] args) {
        QuestionPaperRepo questionPaperRepo = new QuestionPaperRepo();

            takeTest(questionPaperRepo.getAptitude());//calling takeTest func. by passing aptitude question and answer (to start test)
            takeTest(questionPaperRepo.getLanguage());
            takeTest(questionPaperRepo.getMaths());*/
        System.out.println("WELCOME TO PROMETRIC BASED EXAM:\n");
        System.out.println("Enter number of students going to take exam: ");
        int count;
        Scanner s = new Scanner(System.in);
        count = s.nextInt();
        for(int i=0;i<count;i++) {
            QuestionPaperRepo questionPaperRepo = new QuestionPaperRepo();
            List<Student> students = new ArrayList<>();
            takeTest(questionPaperRepo.getAptitude());//calling takeTest func. by passing aptitude question and answer (to start test)
            takeTest(questionPaperRepo.getLanguage());
            takeTest(questionPaperRepo.getMaths());
            Student std = new Student();
            std.setAptitude(takeTest(questionPaperRepo.getAptitude()));
            std.setLanguage(takeTest(questionPaperRepo.getLanguage()));
            std.setMaths(takeTest(questionPaperRepo.getMaths()));
            students.add(std);
            System.out.println("\n\nProcessed Score of Student "+(i+1)+" :");
            System.out.println("Aptitude: "+std.getAptitude().getTotal_score());
            System.out.println("Language: "+std.getLanguage().getTotal_score());
            System.out.println("Maths: "+std.getMaths().getTotal_score());
           }

        //System.out.println("Rank list: ");
        //setRank();

    }
    public static void setRank(List<Student> students) {
        Collections.sort(students,new MarkComparator());
        for(int i=0;i<students.size();++i) {
            students.get(i).setRank(i+1);
        }
    }

            public static String getRandomAnswer () {
                List<String> options = new ArrayList<>();
                options.add("a");
                options.add("b");
                options.add("c");
                options.add("d");
                int i = new Random().nextInt(options.size());
                return options.get(i);
            }
            public static Subject takeTest (SubjectRepo subjectRepo){
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
                        ans = getRandomAnswer();//random answer is generated..
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
                    subject.setNextLevel();//returns the next level...
                    subject.getSets().add(set);
                    System.out.println("Set Wise Raw Score: " + subject.getSetWiseMark());
                    subject.setTotalScore();
                    System.out.println("Set Wise Processed Score: " + subject.getTotal_score());

                }
                return subject;
            }


        }






