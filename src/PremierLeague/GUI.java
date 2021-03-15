package PremierLeague;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;


public class GUI extends Application {
    Scene scene1, scene2,scene3, scene6;
    private ArrayList<FootballClub> clubs = new ArrayList<>();
    private ArrayList<Match> footballMatch = new ArrayList<>();
    ObservableList<Object> allClubs = FXCollections.observableArrayList();
    ObservableList<Object> allMatches = FXCollections.observableArrayList();
    ObservableList<Object> search = FXCollections.observableArrayList();
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    int day,month,year;


    public ObservableList<Object> getClubsData() {
        try {
            FileInputStream input = new FileInputStream("football.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(input);
            clubs = (ArrayList<FootballClub>) objectInputStream.readObject();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("File created");
        }catch (NullPointerException e){
            System.out.println("No clubs listed yet");
        }
        allClubs.clear();
        Comparator<FootballClub> sortByPoints = Comparator.comparing(FootballClub::getTotalPoints).thenComparing(FootballClub::getGoalDeference);
        clubs.sort(sortByPoints.reversed());
        allClubs.addAll(clubs);
        return allClubs;
    }

    public ObservableList<Object> getMatches() {
        try {
            FileInputStream inputMatchHistory = new FileInputStream("footballMatch.ser");
            ObjectInputStream objectInputMatchHistory = new ObjectInputStream(inputMatchHistory);
            footballMatch = (ArrayList< Match >) objectInputMatchHistory.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File created");
        } catch (NullPointerException e) {
            System.out.println("No matches have been played yet");
        }
        allMatches.clear();
        allMatches.addAll(footballMatch);
        return allMatches;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Premier League 2020");


        ////search
        TableView<Object> table1 = new TableView<>();
        //table
        TableColumn< Object ,String > t1 = new TableColumn<>("Team 1");
        t1.setCellValueFactory(new PropertyValueFactory<>("t1Name"));
        t1.setMinWidth(110);


        TableColumn< Object,Integer > t1Goals = new TableColumn<>("Team 1 Goals");
        t1Goals.setCellValueFactory(new PropertyValueFactory<>("t1ScGoals"));
        t1Goals.setMinWidth(110);

        TableColumn< Object,String > t2 = new TableColumn<>("Team 2");
        t2.setCellValueFactory(new PropertyValueFactory<>("t2Name"));
        t2.setMinWidth(100);

        TableColumn< Object,Integer > t2Goals = new TableColumn<>("Team 2 Goals");
        t2Goals.setCellValueFactory(new PropertyValueFactory<>("t2ScGoals"));
        t2Goals.setMinWidth(110);

        TableColumn< Object,String> day1 = new TableColumn<>("Date");
        day1.setCellValueFactory(new PropertyValueFactory<>("date"));
        day1.setMinWidth(110);

        table1.getColumns().addAll(t1, t1Goals, t2, t2Goals, day1);
        table1.setItems(getMatches());
        table1.setMinWidth(700);
        table1.setMinHeight(600);
        ///end of the table

        TextField dayTf1 = new TextField();
        dayTf1.setLayoutX(800);
        dayTf1.setLayoutY(25);

        TextField monthTf1 = new TextField();
        monthTf1.setLayoutX(800);
        monthTf1.setLayoutY(75);

        TextField yearTf1 = new TextField();
        yearTf1.setLayoutX(800);
        yearTf1.setLayoutY(125);

        Label lbDay1 = new Label("Day");
        lbDay1.setLayoutX(740);
        lbDay1.setLayoutY(25);
        lbDay1.setStyle("-fx-font: normal  18px 'serif' ");
        lbDay1.setTextFill(Color.BLACK);


        Label lbMonth1 = new Label("Month");
        lbMonth1.setLayoutX(740);
        lbMonth1.setLayoutY(75);
        lbMonth1.setStyle("-fx-font: normal  18px 'serif' ");
        lbMonth1.setTextFill(Color.BLACK);


        Label lbYear1 = new Label("Year");
        lbYear1.setLayoutX(740);
        lbYear1.setLayoutY(125);
        lbYear1.setStyle("-fx-font: normal  18px 'serif' ");
        lbYear1.setTextFill(Color.BLACK);


        Button backBtn = new Button("Back");
        backBtn.setLayoutX(970);
        backBtn.setLayoutY(175);
        backBtn.setPrefSize(100, 30);
        backBtn.setStyle(
                "-fx-background-color: aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        backBtn.setOnAction(e -> primaryStage.setScene(scene1));

    ///Clear Button
        Button clearBtn = new Button("Clear");
        clearBtn.setLayoutX(850);
        clearBtn.setLayoutY(175);
        clearBtn.setPrefSize(100, 30);
        clearBtn.setStyle(
                "-fx-background-color: aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        clearBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                table1.getItems().clear();
                dayTf1.clear();
                monthTf1.clear();
                yearTf1.clear();
            }
        });

    ///Search Button
        Button searchBtn = new Button("Search");
        searchBtn.setLayoutX(710);
        searchBtn.setLayoutY(175);
        searchBtn.setPrefSize(100, 30);
        searchBtn.setStyle(
                "-fx-background-color: aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                search.clear();
                try{
                    day = Integer.parseInt(dayTf1.getText());
                    month = Integer.parseInt(monthTf1.getText());
                    year = Integer.parseInt(yearTf1.getText());
                }catch (Exception e){
                    System.out.println("Invalid Date!!");
                    System.out.println("Please Enter the valid date!!");
                }
                int a = 0;
                for (Match matches: footballMatch){
                    if(day == matches.getDate().getDay() && month == matches.getDate().getMonth() && year == matches.getDate().getYear()){
                      search.add(matches);
                        a=-1;
                        break;
                    }
                    a++;
                }
                if (a!=-1){
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                    a1.setHeaderText("Error !!");
                    a1.setContentText("Invalid Date !!");
                    a1.showAndWait();
                }
                table1.setItems(search);
            }
        });




        Pane root6 = new Pane(table1,backBtn,clearBtn,dayTf1,monthTf1,yearTf1,searchBtn,lbDay1,lbMonth1,lbYear1);
        scene6 = (new Scene(root6, 1100, 640));
        primaryStage.setScene(scene6);



        ////RandomMatchGenerate

        TableView table3 = new TableView();
        //table
        TableColumn< Object ,String > team1 = new TableColumn<>("Team 1");
        team1.setCellValueFactory(new PropertyValueFactory<>("t1Name"));
        team1.setMinWidth(110);


        TableColumn< Object,Integer > team1Goals = new TableColumn<>("Team 1 Goals");
        team1Goals.setCellValueFactory(new PropertyValueFactory<>("t1ScGoals"));
        team1Goals.setMinWidth(110);

        TableColumn< Object,String > team2 = new TableColumn<>("Team 2");
        team2.setCellValueFactory(new PropertyValueFactory<>("t2Name"));
        team2.setMinWidth(100);

        TableColumn< Object,Integer > team2Goals = new TableColumn<>("Team 2 Goals");
        team2Goals.setCellValueFactory(new PropertyValueFactory<>("t2ScGoals"));
        team2Goals.setMinWidth(110);

        TableColumn< Object,String> day = new TableColumn<>("Date");
        day.setCellValueFactory(new PropertyValueFactory<>("date"));
        day.setMinWidth(100);


        table3.getColumns().addAll(team1, team1Goals, team2, team2Goals, day);
        table3.setItems(getMatches());
        table3.setMinWidth(700);
        ///end of the table

        Button btnback = new Button("Back");
        btnback.setLayoutX(85);
        btnback.setLayoutY(425);
        btnback.setPrefWidth(140);
        btnback.setPrefHeight(30);
        btnback.setStyle(
                "-fx-background-color: aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        btnback.setOnAction(event -> primaryStage.setScene(scene1));

        ///generateButton
        Button playBtn = new Button("Generate");
        playBtn.setLayoutX(245);
        playBtn.setLayoutY(425);
        playBtn.setPrefWidth(140);
        playBtn.setPrefHeight(30);
        playBtn.setStyle(
                "-fx-background-color: aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        playBtn.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    System.out.println("Generate!");
                                    premierLeagueManager.generateRandomMatch();
                                }
                            });


        Pane root3 = new Pane(table3,btnback,playBtn);
        scene3 = (new Scene(root3, 700, 600));
        primaryStage.setScene(scene3);


        ////printSortClubList

        TableView table = new TableView();
        //table
        TableColumn<  Object,String > clubName = new TableColumn<>("Club Name");
        clubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        clubName.setMinWidth(110);

        TableColumn< Object,Integer> totalPoints = new TableColumn<>("Total Points");
        totalPoints.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));
        totalPoints.setMinWidth(110);

        TableColumn<  Object ,Integer> noOfWins = new TableColumn<>("Wins");
        noOfWins.setCellValueFactory(new PropertyValueFactory<>("noOfWins"));

        TableColumn<Object,Integer > noOfDefeats = new TableColumn<>("Defeats");
        noOfDefeats.setCellValueFactory(new PropertyValueFactory<>("noOfDefeats"));

        TableColumn< Object,Integer > noOfDraws = new TableColumn<>("Draws");
        noOfDraws.setCellValueFactory(new PropertyValueFactory<>("noOfDraws"));

        TableColumn< Object,Integer > noOfScoredGoals = new TableColumn<>("Scored Goals");
        noOfScoredGoals.setCellValueFactory(new PropertyValueFactory<>("noOfScoredGoals"));
        noOfScoredGoals.setMinWidth(110);

        TableColumn<  Object,Integer > noOfReceivedGoals = new TableColumn<>("Received Goals");
        noOfReceivedGoals.setCellValueFactory(new PropertyValueFactory<>("noOfReceivedGoals"));
        noOfReceivedGoals.setMinWidth(110);

        TableColumn<  Object,Integer> noOfPlayedMatches = new TableColumn<>("Matches");
        noOfPlayedMatches.setCellValueFactory(new PropertyValueFactory<>("noOfPlayedMatches"));

        table.getColumns().addAll(clubName, totalPoints, noOfWins, noOfDefeats, noOfDraws, noOfScoredGoals, noOfReceivedGoals, noOfPlayedMatches);
        table.setItems(getClubsData());
        //end of the table


        Button btn = new Button("Club List order by Total Points"); ///sortByPoints
        btn.setLayoutX(175);
        btn.setLayoutY(405);
        btn.setPrefWidth(400);
        btn.setPrefHeight(30);
        btn.setStyle(
                        "-fx-background-color: aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        btn.setOnAction(new EventHandler< ActionEvent >() {
            @Override
            public void handle(ActionEvent event) {
                allClubs.clear();
                Comparator< FootballClub > sortByPoints = Comparator.comparing(FootballClub::getTotalPoints).thenComparing(FootballClub::getGoalDeference);
                clubs.sort(sortByPoints.reversed());
                allClubs.addAll(clubs);
            }
        });


        Button btn2 = new Button("Club List order by Scored Goals");  ///sortByScoredGoals
        btn2.setLayoutX(175);
        btn2.setLayoutY(455);
        btn2.setPrefWidth(400);
        btn2.setPrefHeight(30);
        btn2.setStyle(
                "-fx-background-color:  aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        btn2.setOnAction(new EventHandler< ActionEvent >() {
            @Override
            public void handle(ActionEvent event) {
                allClubs.clear();
                Comparator< FootballClub > sortByScoredGoals = Comparator.comparing(FootballClub::getNoOfScoredGoals);
                clubs.sort(sortByScoredGoals.reversed());
                allClubs.addAll(clubs);
            }
        });

        Button btn3 = new Button("Club List order by Wins"); ///sortByWins
        btn3.setLayoutX(175);
        btn3.setLayoutY(505);
        btn3.setPrefWidth(400);
        btn3.setPrefHeight(30);
        btn3.setStyle(
                "-fx-background-color:  aquamarine;-fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        btn3.setOnAction(new EventHandler< ActionEvent >() {
            @Override
            public void handle(ActionEvent event) {
                allClubs.clear();
                Comparator< FootballClub > sortByMatchWins = Comparator.comparing(FootballClub::getNoOfWins);
                clubs.sort(sortByMatchWins.reversed());
                allClubs.addAll(clubs);
            }
        });

        Button btnback1 = new Button("Back");
        btnback1.setLayoutX(335);
        btnback1.setLayoutY(555);
        btnback1.setPrefWidth(80);
        btnback1.setPrefHeight(30);
        btnback1.setStyle(
                "-fx-background-color: aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        btnback1.setOnAction(new EventHandler< ActionEvent >() {
            @Override
            public void handle(ActionEvent event) {
                        primaryStage.setScene(scene1);
                    }
        });

        Pane root2 = new Pane(table, btn, btn2, btn3, btnback1);
        scene2 = (new Scene(root2, 769, 620));
        primaryStage.setScene(scene2);



        ////mainPage

        Label lbF = new Label("Welcome to Premier League Manager !!!");
        lbF.setLayoutX(35);
        lbF.setLayoutY(20);
        lbF.setStyle("-fx-font: normal bold 30px 'serif';-fx-alignment: center");


        Button btn1 = new Button("Club List ");
        btn1.setLayoutX(115);
        btn1.setLayoutY(100);
        btn1.setPrefWidth(300);
        btn1.setPrefHeight(30);
        btn1.setStyle(
                "-fx-background-color:  aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        btn1.setOnAction(new EventHandler< ActionEvent >() {
            @Override
            public void handle(ActionEvent event) {
                        primaryStage.setScene(scene2);
                    }
        });


        Button btn4 = new Button("Matches");
        btn4.setLayoutX(115);
        btn4.setLayoutY(150);
        btn4.setPrefWidth(300);
        btn4.setPrefHeight(30);
        btn4.setStyle(
                "-fx-background-color:  aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        btn4.setOnAction(new EventHandler< ActionEvent >() {
            @Override
            public void handle(ActionEvent event) {
                        primaryStage.setScene(scene3);
                    }
        });

        Button btn5 = new Button("Search Match");
        btn5.setLayoutX(115);
        btn5.setLayoutY(200);
        btn5.setPrefWidth(300);
        btn5.setPrefHeight(30);
        btn5.setStyle(
                "-fx-background-color:  aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        btn5.setOnAction(new EventHandler< ActionEvent >() {
            @Override
            public void handle(ActionEvent event) {
                        primaryStage.setScene(scene6);
                    }
        });

        Button btn7 = new Button("EXIT");
        btn7.setLayoutX(115);
        btn7.setLayoutY(250);
        btn7.setPrefWidth(300);
        btn7.setPrefHeight(30);
        btn7.setStyle(
                "-fx-background-color:  aquamarine; -fx-font: normal bold 18px 'serif';-fx-textfill: black;");
        btn7.setOnAction(new EventHandler< ActionEvent >() {
            @Override
            public void handle(ActionEvent event) {
                        primaryStage.close();
                    }
        });


        Pane root1 = new Pane();
        root1.getChildren().addAll(lbF, btn1, btn4, btn5, btn7);
        scene1 = (new Scene(root1, 570, 400));
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}


