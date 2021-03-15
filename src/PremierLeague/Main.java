package PremierLeague;


import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    public static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();



    public static void main(String[] args) {
        System.out.println("Welcome to Football Premier League 2020");
            int option = 0;

            while (option != 7) {
                System.out.println("----------------------------------------------");
                System.out.println("Console");
                System.out.println("Select Option");
                System.out.println("1.Add New Football Club into the Premier League");
                System.out.println("2.Delete a Club from Premier League");
                System.out.println("3.View Statistics");
                System.out.println("4.View Table");
                System.out.println("5.Add a Match");
                System.out.println("6.View GUI");
                System.out.println("7.Exit");
                System.out.println("----------------------------------------------");

                System.out.print("Your Choice : ");
                option = inputValidation();

                switch (option) {
                    case 1:
                        addClub();
                        break;
                    case 2:
                        deleteClub();
                        break;
                    case 3:
                        displayStatistics();
                        break;
                    case 4:
                        displayTable();
                        break;
                    case 5:
                        addMatch();
                        break;
                    case 6:
                       viewGUI();;
                       break;
                    case 7:
                        System.out.println("Thank You & See you Again!!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid selection, please re-enter the correct value !!");
                }
                }

            }

    private static void viewGUI() {
        premierLeagueManager.GUI();
    }


    private static void addMatch() {
        premierLeagueManager.addMatch();
    }



    private static void displayTable() {
         premierLeagueManager.displayTable();
    }

    private static void displayStatistics() {
        premierLeagueManager.displayStatistics();
    }

    private static void deleteClub() {
        premierLeagueManager.deleteClub();
    }

    private static void addClub() {

        System.out.println("Enter the club details you want to add");

        System.out.print("Enter Club Name: ");
        String clubName  = input.next();

        System.out.print("Enter Club ID: ");
        int clubId  = input.nextInt();

        System.out.print("Enter Club Location: ");
        String clubLocation  = input.next();

        System.out.print("Enter number Of Wins: ");
        int numberOfWins  = input.nextInt();

        System.out.print("Enter number Of Defeats: ");
        int numberOfDefeats  = input.nextInt();

        System.out.print("Enter number Of Draws: ");
        int numberOfDraws  = input.nextInt();

        System.out.print("Enter number Of Scored Goals: ");
        int numberOfScoredGoals  = input.nextInt();

        System.out.print("Enter number Of Received Goals: ");
        int numberOfReceivedGoals   = input.nextInt();

        System.out.print("Enter Total Points: ");
        int numberOfTotalPoints  = input.nextInt();

        System.out.print("Enter number Of Played Matches: ");
        int numberOfPlayedM  = input.nextInt();

        FootballClub footballClub = new FootballClub(clubName,clubLocation,clubId,numberOfWins,numberOfDefeats,numberOfDraws,numberOfScoredGoals,numberOfReceivedGoals ,numberOfTotalPoints,numberOfPlayedM);
        premierLeagueManager.addClub(footballClub);
    }


    //Validate
    private static int inputValidation() {
        while (!input.hasNextInt()) {
            System.out.println("Re-Enter!!");
            input.next();
        }
        return input.nextInt();
    }


}