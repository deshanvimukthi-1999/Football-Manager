package PremierLeague;

import java.io.Serializable;

public class Match implements Serializable {

    private Date date;
    private String t1Name;
    private int t1ScGoals;
    private String t2Name;
    private int t2ScGoals;

    public Match(Date date, String t1Name, int t1ScGoals, String t2Name, int t2ScGoals) {
        this.date = date;
        this.t1Name = t1Name;
        this.t1ScGoals = t1ScGoals;
        this.t2Name = t2Name;
        this.t2ScGoals = t2ScGoals;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getT1Name() {
        return t1Name;
    }

    public void setT1Name(String t1Name) {
        this.t1Name = t1Name;
    }

    public int getT1ScGoals() {
        return t1ScGoals;
    }

    public void setT1ScGoals(int t1ScGoals) {
        this.t1ScGoals = t1ScGoals;
    }

    public String getT2Name() {
        return t2Name;
    }

    public void setT2Name(String t2Name) {
        this.t2Name = t2Name;
    }

    public int getT2ScGoals() {
        return t2ScGoals;
    }

    public void setT2ScGoals(int t2ScGoals) {
        this.t2ScGoals = t2ScGoals;
    }
}