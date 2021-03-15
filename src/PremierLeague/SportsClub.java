package PremierLeague;

import java.io.Serializable;

public class SportsClub implements Serializable {

    private String clubName;
    private String clubLocation;
    private int clubID;

    public SportsClub(String clubName, String clubLocation, int clubID) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
        this.clubID = clubID;
    }



    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public int getclubName() {
        return clubID;
    }

    public void setClubID(int clubID) {
        this.clubID = clubID;
    }

    //toString method
    public String toString() {
        return "SportsClub >>>  " + ", clubName:- " + clubName + ", clubLocation:- " + clubLocation + "clubID:- " + clubID  ;
    }
}
