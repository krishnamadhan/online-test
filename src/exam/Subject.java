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
        total_score = 0;
        for (Set set : sets) {
            Double weightage = pow(2, set.getLevel());
            int i = weightage.intValue();
            total_score = total_score + set.getCorrect_answers() * i;
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

    //constructor...
    public Subject() {
        this.currentLevel = 1;
        this.current_set = 1;
        this.total_sets = 4;
        this.setWiseMark = new ArrayList<>();
        this.sets = new ArrayList<>();
    }

    public void setNextLevel() {
        switch (current_set) {
            case 1://Set 1-2.....setting level for 2nd set
                if (setWiseMark.get(current_set - 1).intValue() > 8) {//intValue needed??
                    currentLevel = 2;
                    current_set++;
                } else {
                    current_set++;
                    currentLevel = 1;
                }
                break;
            case 2:

                switch (sets.get(current_set - 1).getLevel()) // if(sets.get(0).getLevel()==1&&)
                {
                    case 1://case for the level number that he took in the set-2
                        if (setWiseMark.get(current_set - 1).intValue() > 8) {
                            current_set++;
                            currentLevel = 2;
                        } else {
                            current_set++;
                            currentLevel = 1;
                        }
                        break;
                    case 2:
                        if (setWiseMark.get(current_set - 2).intValue() == 10 && setWiseMark.get(current_set - 1).intValue() == 10) {
                            current_set++;
                            currentLevel = 4;
                        }
                        else if (setWiseMark.get(current_set - 1).intValue() > 6 && setWiseMark.get(current_set - 1).intValue() <= 10) {
                            current_set++;
                            currentLevel = 3;
                        } else if (setWiseMark.get(current_set - 1).intValue() > 0 && setWiseMark.get(current_set - 1).intValue() <= 6) {
                            current_set++;
                            currentLevel = 2;
                        } else if (setWiseMark.get(current_set - 1).intValue() == 0) {
                            current_set++;
                            currentLevel = 1;
                        }
                        break;
                }
            break;

            case 3:
                switch (sets.get(current_set - 1).getLevel()) {
                    case 1:
                        if (setWiseMark.get(current_set - 1).intValue() > 8) {
                            current_set++;
                            currentLevel = 2;
                        } else {
                            current_set++;
                            currentLevel = 1;
                        }
                        break;
                    case 2:
                        if (setWiseMark.get(current_set - 1).intValue() > 6) {
                            current_set++;
                            currentLevel = 3;
                        } else if (setWiseMark.get(current_set - 1).intValue() <= 6) {
                            current_set++;
                            currentLevel = 2;
                        }
                        break;
                    case 3:
                        if ((setWiseMark.get(current_set - 3).intValue() == 10 || setWiseMark.get(current_set - 2).intValue() == 10) && setWiseMark.get(current_set - 1).intValue() == 10) {
                            current_set++;
                            currentLevel = 5;
                        } else if (setWiseMark.get(current_set - 1).intValue() > 4) {
                            current_set++;
                            currentLevel = 4;
                        } else if (setWiseMark.get(current_set - 1).intValue() > 0) {
                            current_set++;
                            currentLevel = 3;
                        } else {
                            current_set++;
                            currentLevel = 2;
                        }
                        break;
                    case 4:
                        if (setWiseMark.get(current_set - 3).intValue() == 10 && setWiseMark.get(current_set - 2).intValue() == 10 && setWiseMark.get(current_set - 1).intValue() == 10) {
                            current_set++;
                            currentLevel = 6;
                        } else if (setWiseMark.get(current_set - 1).intValue() > 3) {
                            current_set++;
                            currentLevel = 5;
                        } else if (setWiseMark.get(current_set - 1).intValue() > 0) {
                            current_set++;
                            currentLevel = 4;
                        } else {
                            current_set++;
                            currentLevel = 3;
                        }
                        break;
                }
                break;
            case 4:
                break;
            default:
                System.out.println("NextLevel switch case ends!!");
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
