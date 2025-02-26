package com.el.controller;

public class Score {
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int sum;
    private double avg;

    public Score() {}

    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        setSum();
        setAvg();
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

    public void setSum() {
        this.sum = kor + eng + math;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg() {
        this.avg = (kor + eng + math) / 3;
    }

    @Override
    public String toString() {
        return "Score{" +
                "name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", sum=" + sum +
                ", avg=" + avg +
                '}';
    }
}
