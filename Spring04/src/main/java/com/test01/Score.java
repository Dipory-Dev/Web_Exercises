package com.test01;

public class Score {
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int sum;
    private double avg;
    private String grade;

    public Score() {}

    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public Score(String name, int kor, int eng, int math, int sum, double avg, String grade) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.sum = sum;
        this.avg = avg;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", " +
                "sum=" + sum + ", avg=" + avg + ", grade=" + grade + "]";
    }

    public void scoreSum() {
        this.sum = this.kor + this.eng + this.math;
    }

    public void scoreAvg() {
        this.avg = this.sum / 3.0;
    }

    public void scoreGrade() {
        int select = (int)(avg / 10);
        switch (select) {
            case 10:
            case 9:
                this.grade = "A";
                break;
            case 8:
                this.grade = "B";
                break;
            case 7:
                this.grade = "C";
                break;
            case 6:
                this.grade = "D";
                break;
            default:
                this.grade = "F";
        }
    }
}
