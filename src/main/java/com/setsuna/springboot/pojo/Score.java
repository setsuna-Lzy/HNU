package com.setsuna.springboot.pojo;

public class Score {
    private Integer score_id;
    private String stu_no;
    private String c_name;
    private Integer grade;

    public Integer getScore_id() {
        return score_id;
    }

    public void setScore_id(Integer score_id) {
        this.score_id = score_id;
    }

    public String getStu_no() {
        return stu_no;
    }

    public void setStu_no(String stu_no) {
        this.stu_no = stu_no;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Score(Integer score_id, String stu_no, String c_name, Integer grade) {
        this.score_id = score_id;
        this.stu_no = stu_no;
        this.c_name = c_name;
        this.grade = grade;
    }

    public Score() {
    }

    @Override
    public String toString() {
        return "Score{" +
                "score_id=" + score_id +
                ", stu_no='" + stu_no + '\'' +
                ", c_name='" + c_name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
