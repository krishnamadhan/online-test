package exam;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class Subject {
    private Integer currentLevel;
    private Integer current_set;
    private Integer total_sets;
    private Integer total_score;
    private List<Set> sets;
    private List<Integer> setWiseMark;

    public void setTotalScore() {
        total_score=0;
        for (Set set : sets) {
            Double weightage = pow(2, set.getLevel());
            int i = weightage.intValue();
            total_score =  total_score + set.getCorrect_answers()*i;
        }

    }



    public Integer getCurrent_set() {
        return current_set;
    }

    public void setCurrent_set(Integer current_set) {
        this.current_set = current_set;
    }

    public Integer getTotal_sets() {
        return total_sets;
    }

    public void setTotal_sets(Integer total_sets) {
        this.total_sets = total_sets;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

    public List<Integer> getSetWiseMark() {
        return setWiseMark;
    }

    public void setSetWiseMark(List<Integer> setWiseMark) {
        this.setWiseMark = setWiseMark;
    }

    public Subject() {
        this.currentLevel=1;
        this.current_set=1;
        this.total_sets=4;
        this.setWiseMark = new ArrayList<>();
        this.sets = new ArrayList<>();
    }
    public void setNextLevel() {
        //TODO: conditions
        switch(current_set) {
            case 1:
                if(setWiseMark.get(current_set-1).intValue()>2) {
                    currentLevel=2;
                }else
                    currentLevel=1;
            case 2:
              //  if(sets.get(0).getLevel()==1&&)

        }



    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Integer getTotal_score() {
        return total_score;
    }

    public void setTotal_score(Integer total_score) {
        this.total_score = total_score;
    }


}
