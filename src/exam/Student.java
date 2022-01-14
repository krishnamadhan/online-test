package exam;

import java.util.UUID;

public class Student {
    private final String id;
    private String name;
    private Subject maths;
    private Subject language;
    private Subject aptitude;
    private Integer rank;
    private Integer total_mark;
    private Double percentile;

    public Student() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getMaths() {
        return maths;
    }

    public void setMaths(Subject maths) {
        this.maths = maths;
    }

    public Subject getLanguage() {
        return language;
    }

    public void setLanguage(Subject language) {
        this.language = language;
    }

    public Subject getAptitude() {
        return aptitude;
    }

    public void setAptitude(Subject aptitude) {
        this.aptitude = aptitude;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getTotal_mark() {
        return total_mark;
    }

    public void setTotal_mark(Integer total_mark) {
        this.total_mark = total_mark;
    }

    public Double getPercentile() {
        return percentile;
    }

    public void setPercentile(Double percentile) {
        this.percentile = percentile;
    }
}