package PremierLeague;



public class UniversityFootballClub extends FootballClub {

    private String uniName;
    private int uniCode ;

    public UniversityFootballClub(String clubName, String clubLocation, int clubID, int noOfWins, int noOfDefeats, int noOfDraws, int noOfScoredGoals, int noOfReceivedGoals, int totalPoints, int noOfPlayedMatches, String uniName, int uniCode) {
        super(clubName, clubLocation, clubID, noOfWins, noOfDefeats, noOfDraws, noOfScoredGoals, noOfReceivedGoals, totalPoints, noOfPlayedMatches);
        this.uniName = uniName;
        this.uniCode = uniCode;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public int getUniCode() {
        return uniCode;
    }

    public void setUniCode(int uniCode) {
        this.uniCode = uniCode;
    }

    public String toString() {
        return "University Football Club >>>" + "uniName:- " + uniName + ", uniCode:- " + uniCode   ;
    }

}
