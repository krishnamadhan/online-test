package exam;

import java.util.Comparator;

public class MarkComparator implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getTotal_mark()<o2.getTotal_mark()){
            return -1;
        }
        else if(o1.getTotal_mark()>o2.getTotal_mark()){
            return 1;
        }
        else if(o1.getTotal_mark()==o2.getTotal_mark()){
            if(o1.getMaths().getTotal_score()<o2.getMaths().getTotal_score()){
                return -1;
            }
            else if(o1.getMaths().getTotal_score()>o2.getMaths().getTotal_score()){
                return 1;
            }
            else if(o1.getMaths().getTotal_score()==o2.getMaths().getTotal_score()){
                if(o1.getAptitude().getTotal_score()<o2.getAptitude().getTotal_score()){
                    return -1;
                }
                else if(o1.getAptitude().getTotal_score()>o2.getAptitude().getTotal_score()){
                    return 1;
                }
                else if(o1.getAptitude().getTotal_score()==o2.getAptitude().getTotal_score()){
                    if(o1.getLanguage().getTotal_score()<o2.getLanguage().getTotal_score()){
                        return -1;
                    }
                    else
                        return 0;
                }
            }
        }
        return 0;
    }
}