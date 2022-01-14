package questions;

import java.util.Collections;
import java.util.List;

public class LevelRepo {
    private List<QuestionAndAnswer> questionAndAnswers;
    private int cursor;
    public LevelRepo() {
        cursor=0;
    }
    public void randomize() {
        Collections.shuffle(questionAndAnswers);
    }
    public QuestionAndAnswer getRandomQuestion() {
        if(cursor >= questionAndAnswers.size()) {//questionAndAnswers.size() returns the no of entities in the arraylist
            return null;
        }
        return questionAndAnswers.get(cursor++);//.get(i) returns the ith index of the questionAndAnswers array list(which has just question and answer)
    }

    public List<QuestionAndAnswer> getQuestionAndAnswers() {
        return questionAndAnswers;
    }

    public void setQuestionAndAnswers(List<QuestionAndAnswer> questionAndAnswers) {
        this.questionAndAnswers = questionAndAnswers;//Here also we have an arraylist named questionAndAnswer so we assign level wise quest and ans
        randomize();
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }
}
