package PremierLeague;

public class SchoolFootballClub extends FootballClub {

    private String sclName;
    private int sclID;

    public SchoolFootballClub(String clubName, String clubLocation, int clubID, int noOfWins, int noOfDefeats, int noOfDraws, int noOfScoredGoals, int noOfReceivedGoals, int totalPoints, int noOfPlayedMatches, String sclName, int sclID) {
        super(clubName, clubLocation, clubID, noOfWins, noOfDefeats, noOfDraws, noOfScoredGoals, noOfReceivedGoals, totalPoints, noOfPlayedMatches);
        this.sclName = sclName;
        this.sclID = sclID;
    }

    public String getSclName() {
        return sclName;
    }

    public void setSclName(String sclName) {
        this.sclName = sclName;
    }

    public int getSclID() {
        return sclID;
    }

    public void setSclID(int sclID) {
        this.sclID = sclID;
    }

    public String toString() {
        return "School Football Club >>>" + "schoolName:- " + sclName + ", schoolId:- " + sclID  ;
    }
}
