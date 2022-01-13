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
        if(cursor >= questionAndAnswers.size()) {
            return null;
        }
        return questionAndAnswers.get(cursor++);
    }

    public List<QuestionAndAnswer> getQuestionAndAnswers() {
        return questionAndAnswers;
    }

    public void setQuestionAndAnswers(List<QuestionAndAnswer> questionAndAnswers) {
        this.questionAndAnswers = questionAndAnswers;
        randomize();
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }
}
