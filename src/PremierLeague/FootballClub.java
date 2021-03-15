package PremierLeague;


public class FootballClub extends SportsClub  {

    private int noOfWins;
    private int noOfDefeats;
    private int noOfDraws;
    private int noOfScoredGoals;
    private int noOfReceivedGoals;
    private int totalPoints = noOfWins * 3 + noOfDraws;
    private int noOfPlayedMatches = noOfWins + noOfDefeats + noOfDraws;
    private int goalDeference = noOfScoredGoals- noOfReceivedGoals;



    public FootballClub(String clubName, String clubLocation, int clubID, int noOfWins, int noOfDefeats, int noOfDraws, int noOfScoredGoals, int noOfReceivedGoals, int totalPoints, int noOfPlayedMatches) {
        super(clubName, clubLocation, clubID);
        this.noOfWins = noOfWins;
        this.noOfDefeats = noOfDefeats;
        this.noOfDraws = noOfDraws;
        this.noOfScoredGoals = noOfScoredGoals;
        this.noOfReceivedGoals = noOfReceivedGoals;
        this.totalPoints = totalPoints;
        this.noOfPlayedMatches = noOfPlayedMatches;
    }

    public int getGoalDeference() {
        return noOfScoredGoals - noOfReceivedGoals;
    }

    public void setGoalDeference(int goalDeference) {
        this.goalDeference = goalDeference;
    }

    public int getNoOfWins() {
        return noOfWins;
    }

    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    public int getNoOfDefeats() {
        return noOfDefeats;
    }

    public void setNoOfDefeats(int noOfDefeats) {
        this.noOfDefeats = noOfDefeats;
    }

    public int getNoOfDraws() {
        return noOfDraws;
    }

    public void setNoOfDraws(int noOfDraws) {
        this.noOfDraws = noOfDraws;
    }

    public int getNoOfScoredGoals() {
        return noOfScoredGoals;
    }

    public void setNoOfScoredGoals(int noOfScoredGoals) {
        this.noOfScoredGoals = noOfScoredGoals;
    }

    public int getNoOfReceivedGoals() {
        return noOfReceivedGoals;
    }

    public void setNoOfReceivedGoals(int noOfReceivedGoals) {
        this.noOfReceivedGoals = noOfReceivedGoals;
    }

    public int getTotalPoints() {
        return (noOfWins * 3 + noOfDraws);
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getNoOfPlayedMatches() {
        return (noOfWins+noOfDefeats+noOfDraws);
    }

    public void setNoOfPlayedMatches(int noOfPlayedMatches) {
        this.noOfPlayedMatches = noOfPlayedMatches;
    }


    //toString method
    public String toString() {
        return "Football Club >>>" +
                "noOfWins:- " + noOfWins + ", noOfDraws:- " + noOfDraws + ", noOfDefeats:- " + noOfDefeats + ", noOfScoredGoals:- " + noOfScoredGoals + ", noOfReceived:- " + noOfReceivedGoals + ", totalPoints:- " + totalPoints + ", noOfPlayedMatches:- " + noOfPlayedMatches;
    }





}
