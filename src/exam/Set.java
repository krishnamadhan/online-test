package exam;


import java.util.ArrayList;
import java.util.List;

public class Set {
    private Integer level;
    private Integer correct_answers;
    private Integer total_questions;

    private List<Evaluation> evaluations;
    public Set() {
        this.total_questions=10;
        this.evaluations = new ArrayList<>();
    }

    public Integer getCorrect_answers() {
        return correct_answers;
    }


    public Integer getTotal_questions() {
        return total_questions;
    }


    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public void setCorrect_answers() {
        correct_answers=0;
        for(int i = 0; i< evaluations.size(); i++) {
            if(evaluations.get(i).getAnswer().equals(evaluations.get(i).getResponse())) {
                correct_answers++;

            }
        }
    }



    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }



}
