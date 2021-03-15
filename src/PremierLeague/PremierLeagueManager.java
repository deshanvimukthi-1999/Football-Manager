package PremierLeague;


import java.io.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    static Scanner input = new Scanner(System.in);

     ArrayList< FootballClub > clubs = new ArrayList<>(); //arrays

     public ArrayList getClubList() {
        return clubs;
    }
    ArrayList< Match > footballMatch = new ArrayList<>();//matchArray


    Scanner sc = new Scanner(System.in);
    {
        try {
            FileInputStream fileInputStream = new FileInputStream("football.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            clubs = (ArrayList<FootballClub>)objectInputStream.readObject();
            objectInputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            System.out.println("football.ser created!");
        }
    }

    static void serializeClub(ArrayList<FootballClub> clubs) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("football.ser", false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(clubs);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            FileInputStream fileInputStreamMatches = new FileInputStream("footballMatch.ser");
            ObjectInputStream objectInputStreamMatches = new ObjectInputStream(fileInputStreamMatches);
            footballMatch = (ArrayList<Match>)objectInputStreamMatches.readObject();
            objectInputStreamMatches.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("footballMatch.ser created!");
        }
    }



    static void serializeMatches(ArrayList<Match> footballMatch){
        try {
            FileOutputStream fileOutputStreamMatches = new FileOutputStream("footballMatch.ser",false);
            ObjectOutputStream objectOutputStreamMatches = new ObjectOutputStream(fileOutputStreamMatches);
            objectOutputStreamMatches.writeObject(footballMatch);
            objectOutputStreamMatches.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    @Override
    public void addClub(FootballClub footballClub) {

        if (footballClub != null) {
            clubs.add(footballClub);
            System.out.println(footballClub.getClubName() + " successfully added!");

        } else {

            System.out.println("Please add the correct details");
        }
        serializeClub(clubs);
    }






    @Override
    public void deleteClub() {
        System.out.println("Delete a Club");
        System.out.print("Enter the Name of the Club: ");
        String delClub = input.next();

        for (FootballClub fc : clubs) {
            if (fc.getClubName().equals(delClub)) {
                clubs.remove(fc);
                System.out.println("The Club Name which " + fc.getClubName() + " is Deleted!");
                serializeClub(clubs);
                return;
            }else {
                System.out.println("Please Enter a Valid Club!");
            }
        }
    }
    @Override
    public void displayStatistics() {
        System.out.println("Display Statistics");
        if (clubs.size() == 0) {
            System.out.println("Enter the valid Club Name!! Please try again later.");
            return;
        }
        System.out.print("Enter the Club name here:");
        String clubName = input.next();

        for (FootballClub club : clubs) {
            if (club.getClubName().equals(clubName)) {
                System.out.println("Wins " + club.getNoOfWins());
                System.out.println("Defeats " + club.getNoOfDefeats());
                System.out.println("Draws " + club.getNoOfDraws());
                System.out.println("Scored Goals " + club.getNoOfScoredGoals());
                System.out.println("Received Goals " + club.getNoOfReceivedGoals());
                System.out.println("Total Points " + club.getTotalPoints());
                System.out.println("Matches " + club.getNoOfPlayedMatches());
                return;
            }

        }
    }


    @Override
    public void displayTable() {

        System.out.println(" Display Table of League");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-30s %-15s %-15s %-15s %-15s %-15s %n", "Club Name", "Club Location", "Points", "Wins", "Defeats", "Draws");
        System.out.println("-----------------------------------------------------------------------------------------------------------");

        Comparator<FootballClub> pointSort = Comparator.comparing(FootballClub::getTotalPoints)  ///sortByPoints
                .thenComparing(FootballClub::getGoalDeference);
        clubs.sort(pointSort);
        Collections.reverse(clubs);
        for (FootballClub viewList : clubs) {
            System.out.printf("%-30s %-15s %-15s %-15s %-15s %-15s %n", viewList.getClubName(), viewList.getClubLocation(), viewList.getTotalPoints(), viewList.getNoOfWins(),
                    viewList.getNoOfDefeats(), viewList.getNoOfDraws());

        }
    }



    @Override
   public void addMatch(){

       int num = 1;
       for (FootballClub club : clubs){
           System.out.println(num + "." + club.getClubName());
           num ++;
       }
       System.out.println("Add a Match");
       System.out.println("Enter the teams that played by it's Number");
       System.out.println("Team one : ");
       int t1 = input.nextInt() - 1;
       System.out.println("Scored Goals : ");
       int t1Goals = input.nextInt();
       System.out.println("Team Two : ");
       int t2 = input.nextInt() - 1;
       System.out.println("Scored Goals : ");
       int t2Goals = input.nextInt();
       System.out.println("Enter day ");
       int day = input.nextInt();
       System.out.println("Enter Month");
       int month = input.nextInt();
       System.out.println("Enter year");
       int year = input.nextInt();

       Date date = new Date(day,month,year);

       clubs.get(t1).setNoOfScoredGoals(clubs.get(t1).getNoOfScoredGoals() + t1Goals);
       clubs.get(t1).setNoOfReceivedGoals(clubs.get(t2).getNoOfReceivedGoals() + t2Goals);
       clubs.get(t2).setNoOfScoredGoals(clubs.get(t2).getNoOfScoredGoals() + t2Goals);
       clubs.get(t2).setNoOfReceivedGoals(clubs.get(t1).getNoOfReceivedGoals() + t1Goals);
       if (t1Goals > t2Goals){
           clubs.get(t1).setNoOfWins(clubs.get(t1).getNoOfWins() + 1);
           clubs.get(t2).setNoOfDefeats(clubs.get(t2).getNoOfDefeats() + 1);
       }else if (t1Goals == t2Goals){
           clubs.get(t1).setNoOfDraws(clubs.get(t1).getNoOfDraws() + 1);
           clubs.get(t2).setNoOfDraws(clubs.get(t2).getNoOfDraws() + 1);
       }
       //t1Goals < t2Goals
       else{
           clubs.get(t2).setNoOfWins(clubs.get(t2).getNoOfWins() + 1);
           clubs.get(t1).setNoOfDefeats(clubs.get(t1).getNoOfDefeats()+ 1);
       }
        System.out.println("Match was added!!");
       Match match = new Match(date,clubs.get(t1).getClubName(),t1Goals,clubs.get(t2).getClubName(),t2Goals);
       footballMatch.add(match);

       serializeClub(clubs);
       serializeMatches(footballMatch);
   }


   ///generateRandomMatch
    public void generateRandomMatch() {
        if (clubs.size() <= 1) {
            System.out.println("Need two clubs to play a match!!");
        } else {
            Random randomNo = new Random();
            int t1;
            int t2;

            t1 = randomNo.nextInt(clubs.size());
            do {
                t2 = randomNo.nextInt(clubs.size());
            } while (t1 == t2);

            //goals
            int t1Goals = randomNo.nextInt(9);
            int t2Goals = randomNo.nextInt(9);

           //date
            int day = randomNo.nextInt(29) + 1;
            int month = randomNo.nextInt(11) + 1;
            int year = randomNo.nextInt(2) + 2019;

            Date date = new Date(day, month, year);


            clubs.get(t1).setNoOfScoredGoals(clubs.get(t1).getNoOfScoredGoals() + t1Goals);
            clubs.get(t1).setNoOfReceivedGoals(clubs.get(t2).getNoOfReceivedGoals() + t2Goals);
            clubs.get(t2).setNoOfScoredGoals(clubs.get(t2).getNoOfScoredGoals() + t2Goals);
            clubs.get(t2).setNoOfReceivedGoals(clubs.get(t1).getNoOfReceivedGoals() + t1Goals);
            if (t1Goals > t2Goals) {
                clubs.get(t1).setNoOfWins(clubs.get(t1).getNoOfWins() + 1);
                clubs.get(t2).setNoOfDefeats(clubs.get(t2).getNoOfDefeats() + 1);
            } else if (t1Goals == t2Goals) {
                clubs.get(t1).setNoOfDraws(clubs.get(t1).getNoOfDraws() + 1);
                clubs.get(t2).setNoOfDraws(clubs.get(t2).getNoOfDraws() + 1);
            }
            //t1Goals < t2Goals
            else {
                clubs.get(t2).setNoOfWins(clubs.get(t2).getNoOfWins() + 1);
                clubs.get(t1).setNoOfDefeats(clubs.get(t1).getNoOfDefeats() + 1);
            }

            Match match = new Match(date, clubs.get(t1).getClubName(),t1Goals, clubs.get(t2).getClubName(),t2Goals);
            footballMatch.add(match);

            serializeClub(clubs);
            serializeMatches(footballMatch);
        }
    }

    @Override
    public void GUI() {
        System.out.println("GUI will pop Up!!");
        GUI.main(null);


    }

}






