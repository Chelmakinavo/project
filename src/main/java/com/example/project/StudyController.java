package com.example.project;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class StudyController {
    public Region WALL;
    public Circle Stone;
    public Circle Stone1;
    @FXML
    public Label ZapasKamney;
    public int zapas = 1 ;
    public Label ZapasUskor;
    public Circle UscorF;
    public Button Prisoner;
    public Rectangle EXIT;
    public Region WALL1;
    public Region WALL2;
    public Region WALL3;
    public Region WALL4;
    public Region WALL5;
    public Region WALL6;
    public Region WALL7;
    public Region WALL8;
    public Region WALL9;
    public Region WALL10;
    public Region WALL11;
    public Region WALL12;
    public Region WALL13;
    public Region WALL14;
    public Region WALL15;
    public Region WALL16;
    public Button OUT;
    public Rectangle Instruct;
    public Label in1;
    public Label in2;
    public Label in3;
    public Label in4;
    public Label in5;
    public Label in6;
    public Label in7;
    public Label in8;
    public Label in9;
    public Label in10;
    public Label in11;
    public Label in12;
    public Label in13;
    public Label in14;
    public Label label1;
    public Label label11;
    private Stage stage;
    private Scene Main;
    @FXML
    private int Uscor = 0;
    double exitX;
    double exitYmin;
    private int PrisonStop;
    double exitYmax;
    private int zapasU = 1;
    private int beg=0;
    private boolean RUN = false;
    String StoneDirect;
    public String DirectionPrison = "L";
    private boolean Bros = false;
    private boolean Take = false;
    private boolean flag = false;
    private boolean HitPolice = false;
    private boolean HitPrison = false;
    private boolean Enter;
    private String NO;
    private int PrisonStone = 1;
    private int PrisonUskor = 1;
    boolean Ruka = false;
    int time = 0;
    String Direction = "U";
    @FXML
    private Label label;
    @FXML
    private Button Policeman;
    //Клавиши
    public void MOVE(KeyEvent keyEvent) {
        //Направление движение полицейского
            if (keyEvent.getCode() == KeyCode.W) {
                Direction = "U";
            }
            ;
            if (keyEvent.getCode() == KeyCode.S) {
                Direction = "D";
            }
            ;
            if (keyEvent.getCode() == KeyCode.A) {
                Direction = "L";

            };
            if (keyEvent.getCode() == KeyCode.D) {
                Direction = "R";
            };
        //Полицейский достаёт камень
        if (keyEvent.getCode() == KeyCode.E) {
            if (zapas > 0) {
                if (Ruka == false) {
                    Ruka = true;
                } else {
                    Ruka = false;
                }
                ;
            }
        };

        //Полицейский бросает камень
        if ((Ruka == true)&&(RUN == false)) {
            if (keyEvent.getCode() == KeyCode.Q) {
                zapas--;
                StoneDirect = Direction;
                ZapasKamney.setText("X "+zapas);
                Bros = true;
            };
        };

        //Полицейский ускорение
        if (keyEvent.getCode() == KeyCode.DIGIT3) {
            if (zapasU !=0) {
                if (RUN == false) {
                    RUN = true;
                    Uscor = 2;
                    zapasU--;
                    ZapasUskor.setText("X " + zapasU);
                }
                ;
            };
        }
    }

    //От мышки всегда
    public void GO(MouseEvent mouseEvent) {
        Media media = new Media(new File("C:\\Users\\User\\IdeaProjects\\Project\\src\\main\\resources\\com\\example\\project\\music.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        label.setVisible(false);
        Instruct.setVisible(false);
        in1.setVisible(false);
        in2.setVisible(false);
        in3.setVisible(false);
        in4.setVisible(false);
        in5.setVisible(false);
        in6.setVisible(false);
        in7.setVisible(false);
        in8.setVisible(false);
        in9.setVisible(false);
        in10.setVisible(false);
        in11.setVisible(false);
        in12.setVisible(false);
        in13.setVisible(false);
        in14.setVisible(false);
        Stone.setVisible(false);
        exitX = EXIT.getLayoutX()+EXIT.getWidth();
        exitYmin = EXIT.getLayoutY();
        exitYmax = EXIT.getLayoutY()+EXIT.getHeight()-Prisoner.getHeight();


        //Очередная мультипоточность
        //Thread Prison = new Thread(new Runnable() {
           // @Override
           // public void run() {
            //    try{
             //       while (true){

                  //      Thread.sleep(22);
                  //  }
               // } catch (InterruptedException e) {
               // };
        //    }
        //  });
     //   Prison.start();

        //Основа игры + Ускорение

            Thread Game = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            // Поиск выхода и движение к нему. Победа преступника.
                            if (HitPrison == false) {
                                //if ((exitX < Prisoner.getLayoutX()) && (exitYmin > Prisoner.getLayoutY())) {
                                 //   if ((Prisoner.getLayoutX() - exitX) > (exitYmin - Prisoner.getLayoutY())) {
                                   //     DirectionPrison = "L";
                                  //  } else {
                                    //    DirectionPrison = "D";
                                    //}
                                    //;
                                //};

                                //if ((exitX < Prisoner.getLayoutX()) && (exitYmax >= Prisoner.getLayoutY()) && (exitYmin < Prisoner.getLayoutY())) {
                                  //  DirectionPrison = "L";
                                //}
                                if (exitX > Prisoner.getLayoutX()) {
                                    System.out.println("8");
                                    label1.setVisible(true);
                                    mediaPlayer.stop();
                                    Media media1 = new Media(new File("C:\\Users\\User\\IdeaProjects\\Project\\src\\main\\resources\\com\\example\\project\\DEFEAT.mp3").toURI().toString());
                                    MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
                                    mediaPlayer1.play();
                                    break;
                                }
                                ;
                                if (DirectionPrison == "R") {
                                    NO = "R";
                                    if (((Prisoner.getLayoutY() < WALL.getLayoutY() + WALL.getHeight()) && (Prisoner.getLayoutY() > WALL.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL.getLayoutX() + WALL.getWidth())) {
                                        Prisoner.setLayoutX(WALL.getLayoutX() - Prisoner.getWidth());
                                        flag = true;
                                    } else {
                                        if (((Prisoner.getLayoutY() < WALL1.getLayoutY() + WALL1.getHeight()) && (Prisoner.getLayoutY() > WALL1.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL1.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL1.getLayoutX() + WALL1.getWidth())) {
                                            Prisoner.setLayoutX(WALL1.getLayoutX() - Prisoner.getWidth());
                                            flag = true;
                                        } else {
                                            if (((Prisoner.getLayoutY() < WALL2.getLayoutY() + WALL2.getHeight()) && (Prisoner.getLayoutY() > WALL2.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL2.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL2.getLayoutX() + WALL2.getWidth())) {
                                                Prisoner.setLayoutX(WALL2.getLayoutX() - Prisoner.getWidth());
                                                flag = true;
                                            } else {
                                                if (((Prisoner.getLayoutY() < WALL3.getLayoutY() + WALL3.getHeight()) && (Prisoner.getLayoutY() > WALL3.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL3.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL3.getLayoutX() + WALL3.getWidth())) {
                                                    Prisoner.setLayoutX(WALL3.getLayoutX() - Prisoner.getWidth());
                                                    flag = true;
                                                } else {
                                                    if (((Prisoner.getLayoutY() < WALL4.getLayoutY() + WALL4.getHeight()) && (Prisoner.getLayoutY() > WALL4.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL4.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL4.getLayoutX() + WALL4.getWidth())) {
                                                        Prisoner.setLayoutX(WALL4.getLayoutX() - Prisoner.getWidth());
                                                        flag = true;
                                                    } else {
                                                        if (((Prisoner.getLayoutY() < WALL5.getLayoutY() + WALL5.getHeight()) && (Prisoner.getLayoutY() > WALL5.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL5.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL5.getLayoutX() + WALL5.getWidth())) {
                                                            Prisoner.setLayoutX(WALL5.getLayoutX() - Prisoner.getWidth());
                                                            flag = true;
                                                        } else {
                                                            if (((Prisoner.getLayoutY() < WALL6.getLayoutY() + WALL6.getHeight()) && (Prisoner.getLayoutY() > WALL6.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL6.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL6.getLayoutX() + WALL6.getWidth())) {
                                                                Prisoner.setLayoutX(WALL6.getLayoutX() - Prisoner.getWidth());
                                                                flag = true;
                                                            } else {
                                                                if (((Prisoner.getLayoutY() < WALL7.getLayoutY() + WALL7.getHeight()) && (Prisoner.getLayoutY() > WALL7.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL7.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL7.getLayoutX() + WALL7.getWidth())) {
                                                                    Prisoner.setLayoutX(WALL7.getLayoutX() - Prisoner.getWidth());
                                                                    flag = true;
                                                                } else {
                                                                    if (((Prisoner.getLayoutY() < WALL8.getLayoutY() + WALL8.getHeight()) && (Prisoner.getLayoutY() > WALL8.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL8.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL8.getLayoutX() + WALL8.getWidth())) {
                                                                        Prisoner.setLayoutX(WALL8.getLayoutX() - Prisoner.getWidth());
                                                                        flag = true;
                                                                    } else {
                                                                        if (((Prisoner.getLayoutY() < WALL9.getLayoutY() + WALL9.getHeight()) && (Prisoner.getLayoutY() > WALL9.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL9.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL9.getLayoutX() + WALL9.getWidth())) {
                                                                            Prisoner.setLayoutX(WALL9.getLayoutX() - Prisoner.getWidth());
                                                                            flag = true;
                                                                        } else {
                                                                            if (((Prisoner.getLayoutY() < WALL10.getLayoutY() + WALL10.getHeight()) && (Prisoner.getLayoutY() > WALL10.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL10.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL10.getLayoutX() + WALL10.getWidth())) {
                                                                                Prisoner.setLayoutX(WALL10.getLayoutX() - Prisoner.getWidth());
                                                                                flag = true;
                                                                            } else {
                                                                                if (((Prisoner.getLayoutY() < WALL11.getLayoutY() + WALL11.getHeight()) && (Prisoner.getLayoutY() > WALL11.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL11.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL11.getLayoutX() + WALL11.getWidth())) {
                                                                                    Prisoner.setLayoutX(WALL11.getLayoutX() - Prisoner.getWidth());
                                                                                    flag = true;
                                                                                } else {
                                                                                    if (((Prisoner.getLayoutY() < WALL12.getLayoutY() + WALL12.getHeight()) && (Prisoner.getLayoutY() > WALL12.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL12.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL12.getLayoutX() + WALL12.getWidth())) {
                                                                                        Prisoner.setLayoutX(WALL12.getLayoutX() - Prisoner.getWidth());
                                                                                        flag = true;
                                                                                    } else {
                                                                                        if (((Prisoner.getLayoutY() < WALL13.getLayoutY() + WALL13.getHeight()) && (Prisoner.getLayoutY() > WALL13.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL13.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL13.getLayoutX() + WALL13.getWidth())) {
                                                                                            Prisoner.setLayoutX(WALL13.getLayoutX() - Prisoner.getWidth());
                                                                                            flag = true;
                                                                                        } else {
                                                                                            if (((Prisoner.getLayoutY() < WALL14.getLayoutY() + WALL14.getHeight()) && (Prisoner.getLayoutY() > WALL14.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL14.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL14.getLayoutX() + WALL14.getWidth())) {
                                                                                                Prisoner.setLayoutX(WALL14.getLayoutX() - Prisoner.getWidth());
                                                                                                flag = true;
                                                                                            } else {
                                                                                                if (((Prisoner.getLayoutY() < WALL15.getLayoutY() + WALL15.getHeight()) && (Prisoner.getLayoutY() > WALL15.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL15.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL15.getLayoutX() + WALL15.getWidth())) {
                                                                                                    Prisoner.setLayoutX(WALL15.getLayoutX() - Prisoner.getWidth());
                                                                                                    flag = true;
                                                                                                } else {
                                                                                                    if (((Prisoner.getLayoutY() < WALL16.getLayoutY() + WALL16.getHeight()) && (Prisoner.getLayoutY() > WALL16.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() + Prisoner.getWidth() + 2 + Uscor > WALL16.getLayoutX()) && (Prisoner.getLayoutX() + 2 + Uscor < WALL16.getLayoutX() + WALL16.getWidth())) {
                                                                                                        Prisoner.setLayoutX(WALL16.getLayoutX() - Prisoner.getWidth());
                                                                                                        flag = true;
                                                                                                    } else {
                                                                                                        Prisoner.setLayoutX(Prisoner.getLayoutX() + 1.5 + Uscor);
                                                                                                    }
                                                                                                    ;
                                                                                                }
                                                                                                ;
                                                                                            }
                                                                                            ;
                                                                                        }
                                                                                        ;
                                                                                    }
                                                                                    ;
                                                                                }
                                                                                ;
                                                                            }
                                                                            ;
                                                                        }
                                                                        ;
                                                                    }
                                                                    ;
                                                                }
                                                                ;
                                                            }
                                                            ;
                                                        }
                                                        ;
                                                    }
                                                    ;
                                                }
                                                ;
                                            }
                                            ;
                                        }
                                        ;
                                    }
                                    ;
                                }
                                ;
                                if (DirectionPrison == "L") {
                                    NO = "L";
                                    if (((Prisoner.getLayoutY() < WALL.getLayoutY() + WALL.getHeight()) && (Prisoner.getLayoutY() > WALL.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL.getLayoutX() + WALL.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL.getLayoutX())) {
                                        Prisoner.setLayoutX(WALL.getLayoutX() + WALL.getWidth());
                                        flag = true;
                                    } else {
                                        if (((Prisoner.getLayoutY() < WALL1.getLayoutY() + WALL1.getHeight()) && (Prisoner.getLayoutY() > WALL1.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL1.getLayoutX() + WALL1.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL1.getLayoutX())) {
                                            Prisoner.setLayoutX(WALL1.getLayoutX() + WALL1.getWidth());
                                            flag = true;
                                        } else {
                                            if (((Prisoner.getLayoutY() < WALL2.getLayoutY() + WALL2.getHeight()) && (Prisoner.getLayoutY() > WALL2.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL2.getLayoutX() + WALL2.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL2.getLayoutX())) {
                                                Prisoner.setLayoutX(WALL2.getLayoutX() + WALL2.getWidth());
                                                flag = true;
                                            } else {
                                                if (((Prisoner.getLayoutY() < WALL3.getLayoutY() + WALL3.getHeight()) && (Prisoner.getLayoutY() > WALL3.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL3.getLayoutX() + WALL3.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL3.getLayoutX())) {
                                                    Prisoner.setLayoutX(WALL3.getLayoutX() + WALL3.getWidth());
                                                    flag = true;
                                                } else {
                                                    if (((Prisoner.getLayoutY() < WALL4.getLayoutY() + WALL4.getHeight()) && (Prisoner.getLayoutY() > WALL4.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL4.getLayoutX() + WALL4.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL4.getLayoutX())) {
                                                        Prisoner.setLayoutX(WALL4.getLayoutX() + WALL4.getWidth());
                                                        flag = true;
                                                    } else {
                                                        if (((Prisoner.getLayoutY() < WALL5.getLayoutY() + WALL5.getHeight()) && (Prisoner.getLayoutY() > WALL5.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL5.getLayoutX() + WALL5.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL5.getLayoutX())) {
                                                            Prisoner.setLayoutX(WALL5.getLayoutX() + WALL5.getWidth());
                                                            flag = true;
                                                        } else {
                                                            if (((Prisoner.getLayoutY() < WALL6.getLayoutY() + WALL6.getHeight()) && (Prisoner.getLayoutY() > WALL6.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL6.getLayoutX() + WALL6.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL6.getLayoutX())) {
                                                                Prisoner.setLayoutX(WALL6.getLayoutX() + WALL6.getWidth());
                                                                flag = true;
                                                            } else {
                                                                if (((Prisoner.getLayoutY() < WALL7.getLayoutY() + WALL7.getHeight()) && (Prisoner.getLayoutY() > WALL7.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL7.getLayoutX() + WALL7.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL7.getLayoutX())) {
                                                                    Prisoner.setLayoutX(WALL7.getLayoutX() + WALL7.getWidth());
                                                                    flag = true;
                                                                } else {
                                                                    if (((Prisoner.getLayoutY() < WALL8.getLayoutY() + WALL8.getHeight()) && (Prisoner.getLayoutY() > WALL8.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL8.getLayoutX() + WALL8.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL8.getLayoutX())) {
                                                                        Prisoner.setLayoutX(WALL8.getLayoutX() + WALL8.getWidth());
                                                                        flag = true;
                                                                    } else {
                                                                        if (((Prisoner.getLayoutY() < WALL9.getLayoutY() + WALL9.getHeight()) && (Prisoner.getLayoutY() > WALL9.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL9.getLayoutX() + WALL9.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL9.getLayoutX())) {
                                                                            Prisoner.setLayoutX(WALL9.getLayoutX() + WALL9.getWidth());
                                                                            flag = true;
                                                                        } else {
                                                                            if (((Prisoner.getLayoutY() < WALL10.getLayoutY() + WALL10.getHeight()) && (Prisoner.getLayoutY() > WALL10.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL10.getLayoutX() + WALL10.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL10.getLayoutX())) {
                                                                                Prisoner.setLayoutX(WALL10.getLayoutX() + WALL10.getWidth());
                                                                                flag = true;
                                                                            } else {
                                                                                if (((Prisoner.getLayoutY() < WALL11.getLayoutY() + WALL11.getHeight()) && (Prisoner.getLayoutY() > WALL11.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL11.getLayoutX() + WALL11.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL11.getLayoutX())) {
                                                                                    Prisoner.setLayoutX(WALL11.getLayoutX() + WALL11.getWidth());
                                                                                    flag = true;
                                                                                } else {
                                                                                    if (((Prisoner.getLayoutY() < WALL12.getLayoutY() + WALL12.getHeight()) && (Prisoner.getLayoutY() > WALL12.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL12.getLayoutX() + WALL12.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL12.getLayoutX())) {
                                                                                        Prisoner.setLayoutX(WALL12.getLayoutX() + WALL12.getWidth());
                                                                                        flag = true;
                                                                                    } else {
                                                                                        if (((Prisoner.getLayoutY() < WALL13.getLayoutY() + WALL13.getHeight()) && (Prisoner.getLayoutY() > WALL13.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL13.getLayoutX() + WALL13.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL13.getLayoutX())) {
                                                                                            Prisoner.setLayoutX(WALL13.getLayoutX() + WALL13.getWidth());
                                                                                            flag = true;
                                                                                        } else {
                                                                                            if (((Prisoner.getLayoutY() < WALL14.getLayoutY() + WALL14.getHeight()) && (Prisoner.getLayoutY() > WALL14.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL14.getLayoutX() + WALL14.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL14.getLayoutX())) {
                                                                                                Prisoner.setLayoutX(WALL14.getLayoutX() + WALL14.getWidth());
                                                                                                flag = true;
                                                                                            } else {
                                                                                                if (((Prisoner.getLayoutY() < WALL15.getLayoutY() + WALL15.getHeight()) && (Prisoner.getLayoutY() > WALL15.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL15.getLayoutX() + WALL15.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL15.getLayoutX())) {
                                                                                                    Prisoner.setLayoutX(WALL15.getLayoutX() + WALL15.getWidth());
                                                                                                    flag = true;
                                                                                                } else {
                                                                                                    if (((Prisoner.getLayoutY() < WALL16.getLayoutY() + WALL16.getHeight()) && (Prisoner.getLayoutY() > WALL16.getLayoutY() - Prisoner.getHeight())) && (Prisoner.getLayoutX() - 2 - Uscor < WALL16.getLayoutX() + WALL16.getWidth()) && (Prisoner.getLayoutX() + Prisoner.getWidth() - 2 - Uscor > WALL16.getLayoutX())) {
                                                                                                        Prisoner.setLayoutX(WALL16.getLayoutX() + WALL16.getWidth());
                                                                                                        flag = true;
                                                                                                    } else {
                                                                                                        Prisoner.setLayoutX(Prisoner.getLayoutX() - 1.5 - Uscor);
                                                                                                    }
                                                                                                    ;
                                                                                                }
                                                                                                ;
                                                                                            }
                                                                                            ;
                                                                                        }
                                                                                        ;
                                                                                    }
                                                                                    ;
                                                                                }
                                                                                ;
                                                                            }
                                                                            ;
                                                                        }
                                                                        ;
                                                                    }
                                                                }
                                                                ;
                                                            }
                                                            ;
                                                        }
                                                        ;
                                                    }
                                                    ;
                                                }
                                                ;
                                            }
                                            ;
                                        }
                                        ;
                                    }
                                    ;
                                }
                                ;
                                if (DirectionPrison == "U") {
                                    NO = "U";
                                    if (((Prisoner.getLayoutX() < WALL.getLayoutX() + WALL.getWidth()) && (Prisoner.getLayoutX() > WALL.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL.getLayoutY() + WALL.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL.getLayoutY())) {
                                        Prisoner.setLayoutY(WALL.getLayoutY() + WALL.getHeight());
                                        flag = true;
                                    } else {
                                        if (((Prisoner.getLayoutX() < WALL1.getLayoutX() + WALL1.getWidth()) && (Prisoner.getLayoutX() > WALL1.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL1.getLayoutY() + WALL1.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL1.getLayoutY())) {
                                            Prisoner.setLayoutY(WALL1.getLayoutY() + WALL1.getHeight());
                                            flag = true;
                                        } else {
                                            if (((Prisoner.getLayoutX() < WALL2.getLayoutX() + WALL2.getWidth()) && (Prisoner.getLayoutX() > WALL2.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL2.getLayoutY() + WALL2.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL2.getLayoutY())) {
                                                Prisoner.setLayoutY(WALL2.getLayoutY() + WALL2.getHeight());
                                                flag = true;
                                            } else {
                                                if (((Prisoner.getLayoutX() < WALL3.getLayoutX() + WALL3.getWidth()) && (Prisoner.getLayoutX() > WALL3.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL3.getLayoutY() + WALL3.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL3.getLayoutY())) {
                                                    Prisoner.setLayoutY(WALL3.getLayoutY() + WALL3.getHeight());
                                                    flag = true;
                                                } else {
                                                    if (((Prisoner.getLayoutX() < WALL4.getLayoutX() + WALL4.getWidth()) && (Prisoner.getLayoutX() > WALL4.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL4.getLayoutY() + WALL4.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL4.getLayoutY())) {
                                                        Prisoner.setLayoutY(WALL4.getLayoutY() + WALL4.getHeight());
                                                        flag = true;
                                                    } else {
                                                        if (((Prisoner.getLayoutX() < WALL5.getLayoutX() + WALL5.getWidth()) && (Prisoner.getLayoutX() > WALL5.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL5.getLayoutY() + WALL5.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL5.getLayoutY())) {
                                                            Prisoner.setLayoutY(WALL5.getLayoutY() + WALL5.getHeight());
                                                            flag = true;
                                                        } else {
                                                            if (((Prisoner.getLayoutX() < WALL6.getLayoutX() + WALL6.getWidth()) && (Prisoner.getLayoutX() > WALL6.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL6.getLayoutY() + WALL6.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL6.getLayoutY())) {
                                                                Prisoner.setLayoutY(WALL6.getLayoutY() + WALL6.getHeight());
                                                                flag = true;
                                                            } else {
                                                                if (((Prisoner.getLayoutX() < WALL7.getLayoutX() + WALL7.getWidth()) && (Prisoner.getLayoutX() > WALL7.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL7.getLayoutY() + WALL7.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL7.getLayoutY())) {
                                                                    Prisoner.setLayoutY(WALL7.getLayoutY() + WALL7.getHeight());
                                                                    flag = true;
                                                                } else {
                                                                    if (((Prisoner.getLayoutX() < WALL8.getLayoutX() + WALL8.getWidth()) && (Prisoner.getLayoutX() > WALL8.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL8.getLayoutY() + WALL8.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL8.getLayoutY())) {
                                                                        Prisoner.setLayoutY(WALL8.getLayoutY() + WALL8.getHeight());
                                                                        flag = true;
                                                                    } else {
                                                                        if (((Prisoner.getLayoutX() < WALL9.getLayoutX() + WALL9.getWidth()) && (Prisoner.getLayoutX() > WALL9.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL9.getLayoutY() + WALL9.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL9.getLayoutY())) {
                                                                            Prisoner.setLayoutY(WALL9.getLayoutY() + WALL9.getHeight());
                                                                            flag = true;
                                                                        } else {
                                                                            if (((Prisoner.getLayoutX() < WALL10.getLayoutX() + WALL10.getWidth()) && (Prisoner.getLayoutX() > WALL10.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL10.getLayoutY() + WALL10.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL10.getLayoutY())) {
                                                                                Prisoner.setLayoutY(WALL10.getLayoutY() + WALL10.getHeight());
                                                                                flag = true;
                                                                            } else {
                                                                                if (((Prisoner.getLayoutX() < WALL11.getLayoutX() + WALL11.getWidth()) && (Prisoner.getLayoutX() > WALL11.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL11.getLayoutY() + WALL11.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL11.getLayoutY())) {
                                                                                    Prisoner.setLayoutY(WALL11.getLayoutY() + WALL11.getHeight());
                                                                                    flag = true;
                                                                                } else {
                                                                                    if (((Prisoner.getLayoutX() < WALL12.getLayoutX() + WALL12.getWidth()) && (Prisoner.getLayoutX() > WALL12.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL12.getLayoutY() + WALL12.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL12.getLayoutY())) {
                                                                                        Prisoner.setLayoutY(WALL12.getLayoutY() + WALL12.getHeight());
                                                                                        flag = true;
                                                                                    } else {
                                                                                        if (((Prisoner.getLayoutX() < WALL13.getLayoutX() + WALL13.getWidth()) && (Prisoner.getLayoutX() > WALL13.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL13.getLayoutY() + WALL13.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL13.getLayoutY())) {
                                                                                            Prisoner.setLayoutY(WALL13.getLayoutY() + WALL13.getHeight());
                                                                                            flag = true;
                                                                                        } else {
                                                                                            if (((Prisoner.getLayoutX() < WALL14.getLayoutX() + WALL14.getWidth()) && (Prisoner.getLayoutX() > WALL14.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL14.getLayoutY() + WALL14.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL14.getLayoutY())) {
                                                                                                Prisoner.setLayoutY(WALL14.getLayoutY() + WALL14.getHeight());
                                                                                                flag = true;
                                                                                            } else {
                                                                                                if (((Prisoner.getLayoutX() < WALL15.getLayoutX() + WALL15.getWidth()) && (Prisoner.getLayoutX() > WALL15.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL15.getLayoutY() + WALL15.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL15.getLayoutY())) {
                                                                                                    Prisoner.setLayoutY(WALL15.getLayoutY() + WALL15.getHeight());
                                                                                                    flag = true;
                                                                                                } else {
                                                                                                    if (((Prisoner.getLayoutX() < WALL16.getLayoutX() + WALL16.getWidth()) && (Prisoner.getLayoutX() > WALL16.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() - 2 - Uscor < WALL16.getLayoutY() + WALL16.getHeight()) && (Prisoner.getLayoutY() + Prisoner.getHeight() - 2 - Uscor > WALL16.getLayoutY())) {
                                                                                                        Prisoner.setLayoutY(WALL16.getLayoutY() + WALL16.getHeight());
                                                                                                        flag = true;
                                                                                                    } else {
                                                                                                        Prisoner.setLayoutY(Prisoner.getLayoutY() - 1.5 - Uscor);
                                                                                                    }
                                                                                                    ;
                                                                                                }
                                                                                                ;
                                                                                            }
                                                                                            ;
                                                                                        }
                                                                                        ;
                                                                                    }
                                                                                    ;
                                                                                }
                                                                                ;
                                                                            }
                                                                            ;
                                                                        }
                                                                        ;
                                                                    }
                                                                    ;
                                                                }
                                                                ;
                                                            }
                                                            ;
                                                        }
                                                        ;
                                                    }
                                                    ;
                                                }
                                                ;
                                            }
                                            ;
                                        }
                                        ;
                                    }
                                    ;
                                }
                                ;
                                if (DirectionPrison == "D") {
                                    NO = "D";
                                    if (((Prisoner.getLayoutX() < WALL.getLayoutX() + WALL.getWidth()) && (Prisoner.getLayoutX() > WALL.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL.getLayoutY() + WALL.getHeight())) {
                                        Prisoner.setLayoutY(WALL.getLayoutY() - Prisoner.getHeight());
                                        flag = true;
                                    } else {
                                        if (((Prisoner.getLayoutX() < WALL1.getLayoutX() + WALL1.getWidth()) && (Prisoner.getLayoutX() > WALL1.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL1.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL1.getLayoutY() + WALL1.getHeight())) {
                                            Prisoner.setLayoutY(WALL1.getLayoutY() - Prisoner.getHeight());
                                            flag = true;
                                        } else {
                                            if (((Prisoner.getLayoutX() < WALL2.getLayoutX() + WALL2.getWidth()) && (Prisoner.getLayoutX() > WALL2.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL2.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL2.getLayoutY() + WALL2.getHeight())) {
                                                Prisoner.setLayoutY(WALL2.getLayoutY() - Prisoner.getHeight());
                                                flag = true;
                                            } else {
                                                if (((Prisoner.getLayoutX() < WALL3.getLayoutX() + WALL3.getWidth()) && (Prisoner.getLayoutX() > WALL3.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL3.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL3.getLayoutY() + WALL3.getHeight())) {
                                                    Prisoner.setLayoutY(WALL3.getLayoutY() - Prisoner.getHeight());
                                                    flag = true;
                                                } else {
                                                    if (((Prisoner.getLayoutX() < WALL4.getLayoutX() + WALL4.getWidth()) && (Prisoner.getLayoutX() > WALL4.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL4.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL4.getLayoutY() + WALL4.getHeight())) {
                                                        Prisoner.setLayoutY(WALL4.getLayoutY() - Prisoner.getHeight());
                                                        flag = true;
                                                    } else {
                                                        if (((Prisoner.getLayoutX() < WALL5.getLayoutX() + WALL5.getWidth()) && (Prisoner.getLayoutX() > WALL5.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL5.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL5.getLayoutY() + WALL5.getHeight())) {
                                                            Prisoner.setLayoutY(WALL5.getLayoutY() - Prisoner.getHeight());
                                                            flag = true;
                                                        } else {
                                                            if (((Prisoner.getLayoutX() < WALL6.getLayoutX() + WALL6.getWidth()) && (Prisoner.getLayoutX() > WALL6.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL6.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL6.getLayoutY() + WALL6.getHeight())) {
                                                                Prisoner.setLayoutY(WALL6.getLayoutY() - Prisoner.getHeight());
                                                                flag = true;
                                                            } else {
                                                                if (((Prisoner.getLayoutX() < WALL7.getLayoutX() + WALL7.getWidth()) && (Prisoner.getLayoutX() > WALL7.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL7.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL7.getLayoutY() + WALL7.getHeight())) {
                                                                    Prisoner.setLayoutY(WALL7.getLayoutY() - Prisoner.getHeight());
                                                                    flag = true;
                                                                } else {
                                                                    if (((Prisoner.getLayoutX() < WALL8.getLayoutX() + WALL8.getWidth()) && (Prisoner.getLayoutX() > WALL8.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL8.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL8.getLayoutY() + WALL8.getHeight())) {
                                                                        Prisoner.setLayoutY(WALL8.getLayoutY() - Prisoner.getHeight());
                                                                        flag = true;
                                                                    } else {
                                                                        if (((Prisoner.getLayoutX() < WALL9.getLayoutX() + WALL9.getWidth()) && (Prisoner.getLayoutX() > WALL9.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL9.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL9.getLayoutY() + WALL9.getHeight())) {
                                                                            Prisoner.setLayoutY(WALL9.getLayoutY() - Prisoner.getHeight());
                                                                            flag = true;
                                                                        } else {
                                                                            if (((Prisoner.getLayoutX() < WALL10.getLayoutX() + WALL10.getWidth()) && (Prisoner.getLayoutX() > WALL10.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL10.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL10.getLayoutY() + WALL10.getHeight())) {
                                                                                Prisoner.setLayoutY(WALL10.getLayoutY() - Prisoner.getHeight());
                                                                                flag = true;
                                                                            } else {
                                                                                if (((Prisoner.getLayoutX() < WALL11.getLayoutX() + WALL11.getWidth()) && (Prisoner.getLayoutX() > WALL11.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL11.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL11.getLayoutY() + WALL11.getHeight())) {
                                                                                    Prisoner.setLayoutY(WALL11.getLayoutY() - Prisoner.getHeight());
                                                                                    flag = true;
                                                                                } else {
                                                                                    if (((Prisoner.getLayoutX() < WALL12.getLayoutX() + WALL12.getWidth()) && (Prisoner.getLayoutX() > WALL12.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL12.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL12.getLayoutY() + WALL12.getHeight())) {
                                                                                        Prisoner.setLayoutY(WALL12.getLayoutY() - Prisoner.getHeight());
                                                                                        flag = true;
                                                                                    } else {
                                                                                        if (((Prisoner.getLayoutX() < WALL13.getLayoutX() + WALL13.getWidth()) && (Prisoner.getLayoutX() > WALL13.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL13.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL13.getLayoutY() + WALL13.getHeight())) {
                                                                                            Prisoner.setLayoutY(WALL13.getLayoutY() - Prisoner.getHeight());
                                                                                            flag = true;
                                                                                        } else {
                                                                                            if (((Prisoner.getLayoutX() < WALL14.getLayoutX() + WALL14.getWidth()) && (Prisoner.getLayoutX() > WALL14.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL14.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL14.getLayoutY() + WALL14.getHeight())) {
                                                                                                Prisoner.setLayoutY(WALL14.getLayoutY() - Prisoner.getHeight());
                                                                                                flag = true;
                                                                                            } else {
                                                                                                if (((Prisoner.getLayoutX() < WALL15.getLayoutX() + WALL15.getWidth()) && (Prisoner.getLayoutX() > WALL15.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL15.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL15.getLayoutY() + WALL15.getHeight())) {
                                                                                                    Prisoner.setLayoutY(WALL15.getLayoutY() - Prisoner.getHeight());
                                                                                                    flag = true;
                                                                                                } else {
                                                                                                    if (((Prisoner.getLayoutX() < WALL16.getLayoutX() + WALL16.getWidth()) && (Prisoner.getLayoutX() > WALL16.getLayoutX() - Prisoner.getWidth())) && (Prisoner.getLayoutY() + Prisoner.getHeight() + 2 + Uscor > WALL16.getLayoutY()) && (Prisoner.getLayoutY() + 2 + Uscor < WALL16.getLayoutY() + WALL16.getHeight())) {
                                                                                                        Prisoner.setLayoutY(WALL16.getLayoutY() - Prisoner.getHeight());
                                                                                                        flag = true;
                                                                                                    } else {
                                                                                                        Prisoner.setLayoutY(Prisoner.getLayoutY() + 1.5 + Uscor);
                                                                                                    }
                                                                                                }
                                                                                                ;
                                                                                            }
                                                                                            ;
                                                                                        }
                                                                                        ;
                                                                                    }
                                                                                    ;
                                                                                }
                                                                                ;
                                                                            }
                                                                            ;
                                                                        }
                                                                        ;
                                                                    }
                                                                    ;
                                                                }
                                                                ;
                                                            }
                                                            ;
                                                        }
                                                        ;
                                                    }
                                                    ;
                                                }
                                                ;
                                            }
                                            ;
                                        }
                                        ;
                                    }
                                    ;
                                }
                                ;
                                if ((flag == true) && (NO == "L")) {
                                    if (DirectionPrison == "L") {
                                        DirectionPrison = "D";
                                        flag = false;
                                    }
                                    ;
                                };
                                if ((exitX < Prisoner.getLayoutX()) && (exitYmax < Prisoner.getLayoutY())) {
                                    if (Prisoner.getLayoutX() - exitX > -exitYmax + Prisoner.getLayoutY()) {
                                        DirectionPrison = "L";
                                    } else {
                                        DirectionPrison = "U";
                                    }
                                    ;
                                };
                                if ((flag == true) && (NO == "D")) {
                                    if (DirectionPrison == "D") {
                                        DirectionPrison = "R";
                                        flag = false;
                                    }
                                    ;
                                };
                                if ((flag == true) && (NO == "R")) {
                                    if (DirectionPrison == "R") {
                                        DirectionPrison = "U";
                                        flag = false;
                                    }
                                    ;
                                };
                                if ((flag == true) && (NO == "U")) {
                                    if (DirectionPrison == "U") {
                                        DirectionPrison = "L";
                                        flag = false;
                                    };
                                };
                            } else {
                                if (PrisonStop == 100) {
                                    PrisonStop = 0;
                                    HitPrison = false;
                                } else {
                                    PrisonStop++;
                                }
                            }
                            ;

                            //Поимка заключённого.
                            if (Policeman.getBoundsInParent().intersects(Prisoner.getBoundsInParent())) {
                                System.out.println("7");
                                label11.setVisible(true);
                                mediaPlayer.stop();
                                Media media2 = new Media(new File("C:\\Users\\User\\IdeaProjects\\Project\\src\\main\\resources\\com\\example\\project\\VICTORY.mp3").toURI().toString());
                                MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
                                mediaPlayer2.play();
                                break;
                            }
                            ;

                            // Полицейский берёт каимни и ускорение.
                            if (Policeman.getBoundsInParent().intersects(Stone1.getBoundsInParent())) {
                                if (Stone1.isVisible() == true) {
                                    zapas++;
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            ZapasKamney.setText("X " + zapas);
                                        }

                                        ;
                                    });
                                }
                                ;
                                Stone1.setVisible(Take);
                            }
                            ;
                            if (Policeman.getBoundsInParent().intersects(UscorF.getBoundsInParent())) {
                                if (UscorF.isVisible() == true) {
                                    zapasU++;
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            ZapasUskor.setText("X " + zapasU);
                                        }

                                        ;
                                    });
                                }
                                ;
                                UscorF.setVisible(Take);
                            }
                            ;

                            //Заключённый подбирает ускорение и камни.
                            if (Prisoner.getBoundsInParent().intersects(Stone1.getBoundsInParent())) {
                                if (Stone1.isVisible() == true) {
                                    PrisonStone++;
                                }
                                ;
                                Stone1.setVisible(Take);
                            }
                            ;
                            if (Prisoner.getBoundsInParent().intersects(UscorF.getBoundsInParent())) {
                                if (UscorF.isVisible() == true) {
                                    PrisonUskor++;
                                }
                                ;
                                UscorF.setVisible(Take);
                            }
                            ;

                            //Движение полицейского.
                            if (Enter == false) {
                                if (Direction == "R") {
                                    if (((Policeman.getLayoutY() < WALL.getLayoutY() + WALL.getHeight()) && (Policeman.getLayoutY() > WALL.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL.getLayoutX() + WALL.getWidth())) {
                                        Policeman.setLayoutX(WALL.getLayoutX() - Policeman.getWidth());
                                    } else {
                                        if (((Policeman.getLayoutY() < WALL1.getLayoutY() + WALL1.getHeight()) && (Policeman.getLayoutY() > WALL1.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL1.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL1.getLayoutX() + WALL1.getWidth())) {
                                            Policeman.setLayoutX(WALL1.getLayoutX() - Policeman.getWidth());
                                        } else {
                                            if (((Policeman.getLayoutY() < WALL2.getLayoutY() + WALL2.getHeight()) && (Policeman.getLayoutY() > WALL2.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL2.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL2.getLayoutX() + WALL2.getWidth())) {
                                                Policeman.setLayoutX(WALL2.getLayoutX() - Policeman.getWidth());
                                            } else {
                                                if (((Policeman.getLayoutY() < WALL3.getLayoutY() + WALL3.getHeight()) && (Policeman.getLayoutY() > WALL3.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL3.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL3.getLayoutX() + WALL3.getWidth())) {
                                                    Policeman.setLayoutX(WALL3.getLayoutX() - Policeman.getWidth());
                                                } else {
                                                    if (((Policeman.getLayoutY() < WALL4.getLayoutY() + WALL4.getHeight()) && (Policeman.getLayoutY() > WALL4.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL4.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL4.getLayoutX() + WALL4.getWidth())) {
                                                        Policeman.setLayoutX(WALL4.getLayoutX() - Policeman.getWidth());
                                                    } else {
                                                        if (((Policeman.getLayoutY() < WALL5.getLayoutY() + WALL5.getHeight()) && (Policeman.getLayoutY() > WALL5.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL5.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL5.getLayoutX() + WALL5.getWidth())) {
                                                            Policeman.setLayoutX(WALL5.getLayoutX() - Policeman.getWidth());
                                                        } else {
                                                            if (((Policeman.getLayoutY() < WALL6.getLayoutY() + WALL6.getHeight()) && (Policeman.getLayoutY() > WALL6.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL6.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL6.getLayoutX() + WALL6.getWidth())) {
                                                                Policeman.setLayoutX(WALL6.getLayoutX() - Policeman.getWidth());
                                                            } else {
                                                                if (((Policeman.getLayoutY() < WALL7.getLayoutY() + WALL7.getHeight()) && (Policeman.getLayoutY() > WALL7.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL7.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL7.getLayoutX() + WALL7.getWidth())) {
                                                                    Policeman.setLayoutX(WALL7.getLayoutX() - Policeman.getWidth());
                                                                } else {
                                                                    if (((Policeman.getLayoutY() < WALL8.getLayoutY() + WALL8.getHeight()) && (Policeman.getLayoutY() > WALL8.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL8.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL8.getLayoutX() + WALL8.getWidth())) {
                                                                        Policeman.setLayoutX(WALL8.getLayoutX() - Policeman.getWidth());
                                                                    } else {
                                                                        if (((Policeman.getLayoutY() < WALL9.getLayoutY() + WALL9.getHeight()) && (Policeman.getLayoutY() > WALL9.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL9.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL9.getLayoutX() + WALL9.getWidth())) {
                                                                            Policeman.setLayoutX(WALL9.getLayoutX() - Policeman.getWidth());
                                                                        } else {
                                                                            if (((Policeman.getLayoutY() < WALL10.getLayoutY() + WALL10.getHeight()) && (Policeman.getLayoutY() > WALL10.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL10.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL10.getLayoutX() + WALL10.getWidth())) {
                                                                                Policeman.setLayoutX(WALL10.getLayoutX() - Policeman.getWidth());
                                                                            } else {
                                                                                if (((Policeman.getLayoutY() < WALL11.getLayoutY() + WALL11.getHeight()) && (Policeman.getLayoutY() > WALL11.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL11.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL11.getLayoutX() + WALL11.getWidth())) {
                                                                                    Policeman.setLayoutX(WALL11.getLayoutX() - Policeman.getWidth());
                                                                                } else {
                                                                                    if (((Policeman.getLayoutY() < WALL12.getLayoutY() + WALL12.getHeight()) && (Policeman.getLayoutY() > WALL12.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL12.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL12.getLayoutX() + WALL12.getWidth())) {
                                                                                        Policeman.setLayoutX(WALL12.getLayoutX() - Policeman.getWidth());
                                                                                    } else {
                                                                                        if (((Policeman.getLayoutY() < WALL13.getLayoutY() + WALL13.getHeight()) && (Policeman.getLayoutY() > WALL13.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL13.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL13.getLayoutX() + WALL13.getWidth())) {
                                                                                            Policeman.setLayoutX(WALL13.getLayoutX() - Policeman.getWidth());
                                                                                        } else {
                                                                                            if (((Policeman.getLayoutY() < WALL14.getLayoutY() + WALL14.getHeight()) && (Policeman.getLayoutY() > WALL14.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL14.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL14.getLayoutX() + WALL14.getWidth())) {
                                                                                                Policeman.setLayoutX(WALL14.getLayoutX() - Policeman.getWidth());
                                                                                            } else {
                                                                                                if (((Policeman.getLayoutY() < WALL15.getLayoutY() + WALL15.getHeight()) && (Policeman.getLayoutY() > WALL15.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL15.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL15.getLayoutX() + WALL15.getWidth())) {
                                                                                                    Policeman.setLayoutX(WALL15.getLayoutX() - Policeman.getWidth());
                                                                                                } else {
                                                                                                    if (((Policeman.getLayoutY() < WALL16.getLayoutY() + WALL16.getHeight()) && (Policeman.getLayoutY() > WALL16.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() + Policeman.getWidth() + 2 + Uscor > WALL16.getLayoutX()) && (Policeman.getLayoutX() + 2 + Uscor < WALL16.getLayoutX() + WALL16.getWidth())) {
                                                                                                        Policeman.setLayoutX(WALL16.getLayoutX() - Policeman.getWidth());
                                                                                                    } else {
                                                                                                        Policeman.setLayoutX(Policeman.getLayoutX() + 1.5 + Uscor);
                                                                                                    }
                                                                                                    ;
                                                                                                }
                                                                                                ;
                                                                                            }
                                                                                            ;
                                                                                        }
                                                                                        ;
                                                                                    }
                                                                                    ;
                                                                                }
                                                                                ;
                                                                            }
                                                                            ;
                                                                        }
                                                                        ;
                                                                    }
                                                                    ;
                                                                }
                                                                ;
                                                            }
                                                            ;
                                                        }
                                                        ;
                                                    }
                                                    ;
                                                }
                                                ;
                                            }
                                            ;
                                        }
                                        ;
                                    }
                                    ;
                                }
                                ;
                                if (Direction == "L") {
                                    if (((Policeman.getLayoutY() < WALL.getLayoutY() + WALL.getHeight()) && (Policeman.getLayoutY() > WALL.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL.getLayoutX() + WALL.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL.getLayoutX())) {
                                        Policeman.setLayoutX(WALL.getLayoutX() + WALL.getWidth());
                                    } else {
                                        if (((Policeman.getLayoutY() < WALL1.getLayoutY() + WALL1.getHeight()) && (Policeman.getLayoutY() > WALL1.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL1.getLayoutX() + WALL1.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL1.getLayoutX())) {
                                            Policeman.setLayoutX(WALL1.getLayoutX() + WALL1.getWidth());
                                        } else {
                                            if (((Policeman.getLayoutY() < WALL2.getLayoutY() + WALL2.getHeight()) && (Policeman.getLayoutY() > WALL2.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL2.getLayoutX() + WALL2.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL2.getLayoutX())) {
                                                Policeman.setLayoutX(WALL2.getLayoutX() + WALL2.getWidth());
                                            } else {
                                                if (((Policeman.getLayoutY() < WALL3.getLayoutY() + WALL3.getHeight()) && (Policeman.getLayoutY() > WALL3.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL3.getLayoutX() + WALL3.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL3.getLayoutX())) {
                                                    Policeman.setLayoutX(WALL3.getLayoutX() + WALL3.getWidth());
                                                } else {
                                                    if (((Policeman.getLayoutY() < WALL4.getLayoutY() + WALL4.getHeight()) && (Policeman.getLayoutY() > WALL4.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL4.getLayoutX() + WALL4.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL4.getLayoutX())) {
                                                        Policeman.setLayoutX(WALL4.getLayoutX() + WALL4.getWidth());
                                                    } else {
                                                        if (((Policeman.getLayoutY() < WALL5.getLayoutY() + WALL5.getHeight()) && (Policeman.getLayoutY() > WALL5.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL5.getLayoutX() + WALL5.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL5.getLayoutX())) {
                                                            Policeman.setLayoutX(WALL5.getLayoutX() + WALL5.getWidth());
                                                        } else {
                                                            if (((Policeman.getLayoutY() < WALL6.getLayoutY() + WALL6.getHeight()) && (Policeman.getLayoutY() > WALL6.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL6.getLayoutX() + WALL6.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL6.getLayoutX())) {
                                                                Policeman.setLayoutX(WALL6.getLayoutX() + WALL6.getWidth());
                                                            } else {
                                                                if (((Policeman.getLayoutY() < WALL7.getLayoutY() + WALL7.getHeight()) && (Policeman.getLayoutY() > WALL7.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL7.getLayoutX() + WALL7.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL7.getLayoutX())) {
                                                                    Policeman.setLayoutX(WALL7.getLayoutX() + WALL7.getWidth());
                                                                } else {
                                                                    if (((Policeman.getLayoutY() < WALL8.getLayoutY() + WALL8.getHeight()) && (Policeman.getLayoutY() > WALL8.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL8.getLayoutX() + WALL8.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL8.getLayoutX())) {
                                                                        Policeman.setLayoutX(WALL8.getLayoutX() + WALL8.getWidth());
                                                                    } else {
                                                                        if (((Policeman.getLayoutY() < WALL9.getLayoutY() + WALL9.getHeight()) && (Policeman.getLayoutY() > WALL9.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL9.getLayoutX() + WALL9.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL9.getLayoutX())) {
                                                                            Policeman.setLayoutX(WALL9.getLayoutX() + WALL9.getWidth());
                                                                        } else {
                                                                            if (((Policeman.getLayoutY() < WALL10.getLayoutY() + WALL10.getHeight()) && (Policeman.getLayoutY() > WALL10.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL10.getLayoutX() + WALL10.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL10.getLayoutX())) {
                                                                                Policeman.setLayoutX(WALL10.getLayoutX() + WALL10.getWidth());
                                                                            } else {
                                                                                if (((Policeman.getLayoutY() < WALL11.getLayoutY() + WALL11.getHeight()) && (Policeman.getLayoutY() > WALL11.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL11.getLayoutX() + WALL11.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL11.getLayoutX())) {
                                                                                    Policeman.setLayoutX(WALL11.getLayoutX() + WALL11.getWidth());
                                                                                } else {
                                                                                    if (((Policeman.getLayoutY() < WALL12.getLayoutY() + WALL12.getHeight()) && (Policeman.getLayoutY() > WALL12.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL12.getLayoutX() + WALL12.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL12.getLayoutX())) {
                                                                                        Policeman.setLayoutX(WALL12.getLayoutX() + WALL12.getWidth());
                                                                                    } else {
                                                                                        if (((Policeman.getLayoutY() < WALL13.getLayoutY() + WALL13.getHeight()) && (Policeman.getLayoutY() > WALL13.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL13.getLayoutX() + WALL13.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL13.getLayoutX())) {
                                                                                            Policeman.setLayoutX(WALL13.getLayoutX() + WALL13.getWidth());
                                                                                        } else {
                                                                                            if (((Policeman.getLayoutY() < WALL14.getLayoutY() + WALL14.getHeight()) && (Policeman.getLayoutY() > WALL14.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL14.getLayoutX() + WALL14.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL14.getLayoutX())) {
                                                                                                Policeman.setLayoutX(WALL14.getLayoutX() + WALL14.getWidth());
                                                                                            } else {
                                                                                                if (((Policeman.getLayoutY() < WALL15.getLayoutY() + WALL15.getHeight()) && (Policeman.getLayoutY() > WALL15.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL15.getLayoutX() + WALL15.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL15.getLayoutX())) {
                                                                                                    Policeman.setLayoutX(WALL15.getLayoutX() + WALL15.getWidth());
                                                                                                } else {
                                                                                                    if (((Policeman.getLayoutY() < WALL16.getLayoutY() + WALL16.getHeight()) && (Policeman.getLayoutY() > WALL16.getLayoutY() - Policeman.getHeight())) && (Policeman.getLayoutX() - 2 - Uscor < WALL16.getLayoutX() + WALL16.getWidth()) && (Policeman.getLayoutX() + Policeman.getWidth() - 2 - Uscor > WALL16.getLayoutX())) {
                                                                                                        Policeman.setLayoutX(WALL16.getLayoutX() + WALL16.getWidth());
                                                                                                    } else {
                                                                                                        Policeman.setLayoutX(Policeman.getLayoutX() - 1.5 - Uscor);
                                                                                                    }
                                                                                                    ;
                                                                                                }
                                                                                                ;
                                                                                            }
                                                                                            ;
                                                                                        }
                                                                                        ;
                                                                                    }
                                                                                    ;
                                                                                }
                                                                                ;
                                                                            }
                                                                            ;
                                                                        }
                                                                        ;
                                                                    }
                                                                }
                                                                ;
                                                            }
                                                            ;
                                                        }
                                                        ;
                                                    }
                                                    ;
                                                }
                                                ;
                                            }
                                            ;
                                        }
                                        ;
                                    }
                                }
                                ;
                                if (Direction == "U") {
                                    if (((Policeman.getLayoutX() < WALL.getLayoutX() + WALL.getWidth()) && (Policeman.getLayoutX() > WALL.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL.getLayoutY() + WALL.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL.getLayoutY())) {
                                        Policeman.setLayoutY(WALL.getLayoutY() + WALL.getHeight());
                                    } else {
                                        if (((Policeman.getLayoutX() < WALL1.getLayoutX() + WALL1.getWidth()) && (Policeman.getLayoutX() > WALL1.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL1.getLayoutY() + WALL1.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL1.getLayoutY())) {
                                            Policeman.setLayoutY(WALL1.getLayoutY() + WALL1.getHeight());
                                        } else {
                                            if (((Policeman.getLayoutX() < WALL2.getLayoutX() + WALL2.getWidth()) && (Policeman.getLayoutX() > WALL2.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL2.getLayoutY() + WALL2.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL2.getLayoutY())) {
                                                Policeman.setLayoutY(WALL2.getLayoutY() + WALL2.getHeight());
                                            } else {
                                                if (((Policeman.getLayoutX() < WALL3.getLayoutX() + WALL3.getWidth()) && (Policeman.getLayoutX() > WALL3.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL3.getLayoutY() + WALL3.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL3.getLayoutY())) {
                                                    Policeman.setLayoutY(WALL3.getLayoutY() + WALL3.getHeight());
                                                } else {
                                                    if (((Policeman.getLayoutX() < WALL4.getLayoutX() + WALL4.getWidth()) && (Policeman.getLayoutX() > WALL4.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL4.getLayoutY() + WALL4.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL4.getLayoutY())) {
                                                        Policeman.setLayoutY(WALL4.getLayoutY() + WALL4.getHeight());
                                                    } else {
                                                        if (((Policeman.getLayoutX() < WALL5.getLayoutX() + WALL5.getWidth()) && (Policeman.getLayoutX() > WALL5.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL5.getLayoutY() + WALL5.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL5.getLayoutY())) {
                                                            Policeman.setLayoutY(WALL5.getLayoutY() + WALL5.getHeight());
                                                        } else {
                                                            if (((Policeman.getLayoutX() < WALL6.getLayoutX() + WALL6.getWidth()) && (Policeman.getLayoutX() > WALL6.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL6.getLayoutY() + WALL6.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL6.getLayoutY())) {
                                                                Policeman.setLayoutY(WALL6.getLayoutY() + WALL6.getHeight());
                                                            } else {
                                                                if (((Policeman.getLayoutX() < WALL7.getLayoutX() + WALL7.getWidth()) && (Policeman.getLayoutX() > WALL7.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL7.getLayoutY() + WALL7.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL7.getLayoutY())) {
                                                                    Policeman.setLayoutY(WALL7.getLayoutY() + WALL7.getHeight());
                                                                } else {
                                                                    if (((Policeman.getLayoutX() < WALL8.getLayoutX() + WALL8.getWidth()) && (Policeman.getLayoutX() > WALL8.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL8.getLayoutY() + WALL8.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL8.getLayoutY())) {
                                                                        Policeman.setLayoutY(WALL8.getLayoutY() + WALL8.getHeight());
                                                                    } else {
                                                                        if (((Policeman.getLayoutX() < WALL9.getLayoutX() + WALL9.getWidth()) && (Policeman.getLayoutX() > WALL9.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL9.getLayoutY() + WALL9.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL9.getLayoutY())) {
                                                                            Policeman.setLayoutY(WALL9.getLayoutY() + WALL9.getHeight());
                                                                        } else {
                                                                            if (((Policeman.getLayoutX() < WALL10.getLayoutX() + WALL10.getWidth()) && (Policeman.getLayoutX() > WALL10.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL10.getLayoutY() + WALL10.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL10.getLayoutY())) {
                                                                                Policeman.setLayoutY(WALL10.getLayoutY() + WALL10.getHeight());
                                                                            } else {
                                                                                if (((Policeman.getLayoutX() < WALL11.getLayoutX() + WALL11.getWidth()) && (Policeman.getLayoutX() > WALL11.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL11.getLayoutY() + WALL11.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL11.getLayoutY())) {
                                                                                    Policeman.setLayoutY(WALL11.getLayoutY() + WALL11.getHeight());
                                                                                } else {
                                                                                    if (((Policeman.getLayoutX() < WALL12.getLayoutX() + WALL12.getWidth()) && (Policeman.getLayoutX() > WALL12.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL12.getLayoutY() + WALL12.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL12.getLayoutY())) {
                                                                                        Policeman.setLayoutY(WALL12.getLayoutY() + WALL12.getHeight());
                                                                                    } else {
                                                                                        if (((Policeman.getLayoutX() < WALL13.getLayoutX() + WALL13.getWidth()) && (Policeman.getLayoutX() > WALL13.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL13.getLayoutY() + WALL13.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL13.getLayoutY())) {
                                                                                            Policeman.setLayoutY(WALL13.getLayoutY() + WALL13.getHeight());
                                                                                        } else {
                                                                                            if (((Policeman.getLayoutX() < WALL14.getLayoutX() + WALL14.getWidth()) && (Policeman.getLayoutX() > WALL14.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL14.getLayoutY() + WALL14.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL14.getLayoutY())) {
                                                                                                Policeman.setLayoutY(WALL14.getLayoutY() + WALL14.getHeight());
                                                                                            } else {
                                                                                                if (((Policeman.getLayoutX() < WALL15.getLayoutX() + WALL15.getWidth()) && (Policeman.getLayoutX() > WALL15.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL15.getLayoutY() + WALL15.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL15.getLayoutY())) {
                                                                                                    Policeman.setLayoutY(WALL15.getLayoutY() + WALL15.getHeight());
                                                                                                } else {
                                                                                                    if (((Policeman.getLayoutX() < WALL16.getLayoutX() + WALL16.getWidth()) && (Policeman.getLayoutX() > WALL16.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() - 2 - Uscor < WALL16.getLayoutY() + WALL16.getHeight()) && (Policeman.getLayoutY() + Policeman.getHeight() - 2 - Uscor > WALL16.getLayoutY())) {
                                                                                                        Policeman.setLayoutY(WALL16.getLayoutY() + WALL16.getHeight());
                                                                                                    } else {
                                                                                                        Policeman.setLayoutY(Policeman.getLayoutY() - 1.5 - Uscor);
                                                                                                    }
                                                                                                    ;
                                                                                                }
                                                                                                ;
                                                                                            }
                                                                                            ;
                                                                                        }
                                                                                        ;
                                                                                    }
                                                                                    ;
                                                                                }
                                                                                ;
                                                                            }
                                                                            ;
                                                                        }
                                                                        ;
                                                                    }
                                                                    ;
                                                                }
                                                                ;
                                                            }
                                                            ;
                                                        }
                                                        ;
                                                    }
                                                    ;
                                                }
                                                ;
                                            }
                                            ;
                                        }
                                        ;
                                    }
                                    ;
                                }
                                ;
                                if (Direction == "D") {
                                    if (((Policeman.getLayoutX() < WALL.getLayoutX() + WALL.getWidth()) && (Policeman.getLayoutX() > WALL.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL.getLayoutY() + WALL.getHeight())) {
                                        Policeman.setLayoutY(WALL.getLayoutY() - Policeman.getHeight());
                                    } else {
                                        if (((Policeman.getLayoutX() < WALL1.getLayoutX() + WALL1.getWidth()) && (Policeman.getLayoutX() > WALL1.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL1.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL1.getLayoutY() + WALL1.getHeight())) {
                                            Policeman.setLayoutY(WALL1.getLayoutY() - Policeman.getHeight());
                                        } else {
                                            if (((Policeman.getLayoutX() < WALL2.getLayoutX() + WALL2.getWidth()) && (Policeman.getLayoutX() > WALL2.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL2.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL2.getLayoutY() + WALL2.getHeight())) {
                                                Policeman.setLayoutY(WALL2.getLayoutY() - Policeman.getHeight());
                                            } else {
                                                if (((Policeman.getLayoutX() < WALL3.getLayoutX() + WALL3.getWidth()) && (Policeman.getLayoutX() > WALL3.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL3.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL3.getLayoutY() + WALL3.getHeight())) {
                                                    Policeman.setLayoutY(WALL3.getLayoutY() - Policeman.getHeight());
                                                } else {
                                                    if (((Policeman.getLayoutX() < WALL4.getLayoutX() + WALL4.getWidth()) && (Policeman.getLayoutX() > WALL4.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL4.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL4.getLayoutY() + WALL4.getHeight())) {
                                                        Policeman.setLayoutY(WALL4.getLayoutY() - Policeman.getHeight());
                                                    } else {
                                                        if (((Policeman.getLayoutX() < WALL5.getLayoutX() + WALL5.getWidth()) && (Policeman.getLayoutX() > WALL5.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL5.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL5.getLayoutY() + WALL5.getHeight())) {
                                                            Policeman.setLayoutY(WALL5.getLayoutY() - Policeman.getHeight());
                                                        } else {
                                                            if (((Policeman.getLayoutX() < WALL6.getLayoutX() + WALL6.getWidth()) && (Policeman.getLayoutX() > WALL6.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL6.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL6.getLayoutY() + WALL6.getHeight())) {
                                                                Policeman.setLayoutY(WALL6.getLayoutY() - Policeman.getHeight());
                                                            } else {
                                                                if (((Policeman.getLayoutX() < WALL7.getLayoutX() + WALL7.getWidth()) && (Policeman.getLayoutX() > WALL7.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL7.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL7.getLayoutY() + WALL7.getHeight())) {
                                                                    Policeman.setLayoutY(WALL7.getLayoutY() - Policeman.getHeight());
                                                                } else {
                                                                    if (((Policeman.getLayoutX() < WALL8.getLayoutX() + WALL8.getWidth()) && (Policeman.getLayoutX() > WALL8.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL8.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL8.getLayoutY() + WALL8.getHeight())) {
                                                                        Policeman.setLayoutY(WALL8.getLayoutY() - Policeman.getHeight());
                                                                    } else {
                                                                        if (((Policeman.getLayoutX() < WALL9.getLayoutX() + WALL9.getWidth()) && (Policeman.getLayoutX() > WALL9.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL9.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL9.getLayoutY() + WALL9.getHeight())) {
                                                                            Policeman.setLayoutY(WALL9.getLayoutY() - Policeman.getHeight());
                                                                        } else {
                                                                            if (((Policeman.getLayoutX() < WALL10.getLayoutX() + WALL10.getWidth()) && (Policeman.getLayoutX() > WALL10.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL10.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL10.getLayoutY() + WALL10.getHeight())) {
                                                                                Policeman.setLayoutY(WALL10.getLayoutY() - Policeman.getHeight());
                                                                            } else {
                                                                                if (((Policeman.getLayoutX() < WALL11.getLayoutX() + WALL11.getWidth()) && (Policeman.getLayoutX() > WALL11.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL11.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL11.getLayoutY() + WALL11.getHeight())) {
                                                                                    Policeman.setLayoutY(WALL11.getLayoutY() - Policeman.getHeight());
                                                                                } else {
                                                                                    if (((Policeman.getLayoutX() < WALL12.getLayoutX() + WALL12.getWidth()) && (Policeman.getLayoutX() > WALL12.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL12.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL12.getLayoutY() + WALL12.getHeight())) {
                                                                                        Policeman.setLayoutY(WALL12.getLayoutY() - Policeman.getHeight());
                                                                                    } else {
                                                                                        if (((Policeman.getLayoutX() < WALL13.getLayoutX() + WALL13.getWidth()) && (Policeman.getLayoutX() > WALL13.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL13.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL13.getLayoutY() + WALL13.getHeight())) {
                                                                                            Policeman.setLayoutY(WALL13.getLayoutY() - Policeman.getHeight());
                                                                                        } else {
                                                                                            if (((Policeman.getLayoutX() < WALL14.getLayoutX() + WALL14.getWidth()) && (Policeman.getLayoutX() > WALL14.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL14.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL14.getLayoutY() + WALL14.getHeight())) {
                                                                                                Policeman.setLayoutY(WALL14.getLayoutY() - Policeman.getHeight());
                                                                                            } else {
                                                                                                if (((Policeman.getLayoutX() < WALL15.getLayoutX() + WALL15.getWidth()) && (Policeman.getLayoutX() > WALL15.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL15.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL15.getLayoutY() + WALL15.getHeight())) {
                                                                                                    Policeman.setLayoutY(WALL15.getLayoutY() - Policeman.getHeight());
                                                                                                } else {
                                                                                                    if (((Policeman.getLayoutX() < WALL16.getLayoutX() + WALL16.getWidth()) && (Policeman.getLayoutX() > WALL16.getLayoutX() - Policeman.getWidth())) && (Policeman.getLayoutY() + Policeman.getHeight() + 2 + Uscor > WALL16.getLayoutY()) && (Policeman.getLayoutY() + 2 + Uscor < WALL16.getLayoutY() + WALL16.getHeight())) {
                                                                                                        Policeman.setLayoutY(WALL16.getLayoutY() - Policeman.getHeight());
                                                                                                    } else {
                                                                                                        Policeman.setLayoutY(Policeman.getLayoutY() + 1.5 + Uscor);
                                                                                                    }
                                                                                                }
                                                                                                ;
                                                                                            }
                                                                                            ;
                                                                                        }
                                                                                        ;
                                                                                    }
                                                                                    ;
                                                                                }
                                                                                ;
                                                                            }
                                                                            ;
                                                                        }
                                                                        ;
                                                                    }
                                                                    ;
                                                                }
                                                                ;
                                                            }
                                                            ;
                                                        }
                                                        ;
                                                    }
                                                    ;
                                                }
                                                ;
                                            }
                                            ;
                                        }
                                        ;
                                    }
                                    ;
                                }
                                ;
                            }
                            ;

                            //Полицейский берёт в руку камень.
                            if (Bros == false) {
                                Stone.setLayoutX(Policeman.getLayoutX() + 13);
                                Stone.setLayoutY(Policeman.getLayoutY() + 13);
                                Stone.setVisible(Ruka);
                            }
                            ;

                            //Ускорение полицейского.
                            if (RUN == true) {
                                if (beg != 250) {
                                    beg++;
                                } else {
                                    beg = 0;
                                    RUN = false;
                                    Uscor = 0;
                                }
                            }
                            Thread.sleep(22);
                        }
                    } catch (InterruptedException e) {
                    }
                    ;
                }
            });
            Game.start();

            //Бросок камня
        Thread Fire = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (Bros == true) {
                            if (StoneDirect == "R") {
                                Stone.setLayoutX(Stone.getLayoutX() + 3);
                            };
                            if (StoneDirect == "L") {
                                Stone.setLayoutX(Stone.getLayoutX() - 3);
                            };
                            if (StoneDirect == "U") {
                                Stone.setLayoutY(Stone.getLayoutY() - 3);
                            };
                            if (StoneDirect == "D") {
                                Stone.setLayoutY(Stone.getLayoutY() + 3);
                            };
                            time++;
                            Ruka = false;

                            //Попадание камня в заключённого
                            if (Stone.getBoundsInParent().intersects(Prisoner.getBoundsInParent())){
                                System.out.println("12");
                                HitPrison = true;
                                time = 100;
                            };

                            //Каменғ попал в стенку
                            if(Stone.getBoundsInParent().intersects(WALL.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL1.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL2.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL3.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL4.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL5.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL6.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL7.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL8.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL9.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL10.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL11.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL12.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL13.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL14.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL15.getBoundsInParent())){
                                time = 100;
                            };
                            if(Stone.getBoundsInParent().intersects(WALL16.getBoundsInParent())){
                                time = 100;
                            };

                            //Время полёта камня
                            if (time == 100){
                                Stone.setVisible(false);
                                time = 0;
                                Bros = false;
                            };
                        };
                        Thread.sleep(6);
                    }
                } catch (InterruptedException e) {
                };
            }
        });
        Fire.start();
    }

    //Остановка полицейского
    public void STOP(KeyEvent keyEvent) {
            if (keyEvent.getCode() == KeyCode.R) {
                if (Enter == false) {
                    Enter = true;
            }
        };
        if ((keyEvent.getCode() == KeyCode.W) || (keyEvent.getCode() == KeyCode.A) || (keyEvent.getCode() == KeyCode.S) || (keyEvent.getCode() == KeyCode.D)){
            Enter = false;
        }
    }


    //Смена направления преступника
    public String ChangeDerection(String DirectionPrison){
        if (DirectionPrison == "L"){

        };
        return DirectionPrison;
    };

    public void OutBottonClick(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Main = new Scene(root);
        stage.setScene(Main);
        stage.setFullScreen(true);
        stage.show();
    }
}
