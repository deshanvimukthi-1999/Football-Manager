package PremierLeague;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;


class FootballClubTest {

    FootballClub footballClub = new FootballClub("fcb","spain",1,1,1,1,4,3,4,3);
    @Test
    void getNoOfWins() {
        assertEquals(1,footballClub.getNoOfWins());
    }

    @Test
    void setNoOfWins() {
        int wins = 1;
       footballClub.setNoOfWins(wins);
        assertEquals(wins,footballClub.getNoOfWins());
    }

    @Test
    void getNoOfDefeats() {
        assertEquals(1,footballClub.getNoOfDefeats());
    }

    @Test
    void setNoOfDefeats() {
        int defeats = 1;
        footballClub.setNoOfDefeats(defeats);
        assertEquals(defeats,footballClub.getNoOfDefeats());
    }

    @Test
    void getNoOfDraws() {
        assertEquals(1,footballClub.getNoOfDraws());
    }

    @Test
    void setNoOfDraws() {
        int draws= 1;
        footballClub.setNoOfDraws(draws);
        assertEquals(draws,footballClub.getNoOfDraws());
    }
    @Test
    void getTotalPoints(){
        assertEquals(4,footballClub.getTotalPoints());
    }

    @Test
    void setTotalPoints() {
        int points= 4;
        footballClub.setTotalPoints(points);
        assertEquals(points,footballClub.getTotalPoints());
    }

    @Test
    void getNoOfPlayedMatches(){
        assertEquals(3,footballClub.getNoOfPlayedMatches());
    }
    @Test
    void setNoOfPlayedMatches(){
        int matchse= 3;
        footballClub.setNoOfPlayedMatches(matchse);
        assertEquals(matchse,footballClub.getNoOfPlayedMatches());
    }

    @Test
    void getNoOfScoredGoals() {
        assertEquals(4,footballClub.getNoOfScoredGoals());
    }

   @Test
    void setNoOfScoredGoals() {
       int scGoals= 4;
       footballClub.setNoOfScoredGoals(scGoals);
       assertEquals(scGoals,footballClub.getNoOfScoredGoals());
    }

    @Test
   void getNoOfReceivedGoals() {
        assertEquals(3,footballClub.getNoOfReceivedGoals());
    }
    @Test
    void setNoOfReceivedGoals() {
        int rGoals= 3;
        footballClub.setNoOfReceivedGoals(rGoals);
        assertEquals(rGoals,footballClub.getNoOfReceivedGoals());
    }
}