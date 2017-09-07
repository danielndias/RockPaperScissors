package com.dndias.rockPaperScissors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public ImageView rockImg;
    @FXML
    public ImageView paperImg;
    @FXML
    public ImageView scissorsImg;
    @FXML
    public ImageView noneImg;
    @FXML
    public Label lblWinner;
    @FXML
    public Label lblPlayerScore;
    @FXML
    public Label lblCompScore;

    @FXML
    private Player humanPlayer = new Player();
    @FXML
    private Player computerPlayer = new Player();


    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }



    @FXML
    public void imgClicked(MouseEvent event) {

        //Setting the images border color back to the default
        rockImg.getParent().getStyleClass().setAll("panelPlayer");
        paperImg.getParent().getStyleClass().setAll("panelPlayer");
        scissorsImg.getParent().getStyleClass().setAll("panelPlayer");
        try {
            if (event.getSource() == rockImg) {
                humanPlayer.makeMove("rock");
                rockImg.getParent().getStyleClass().setAll("panelSelected");
            } else if (event.getSource() == paperImg) {
                paperImg.getParent().getStyleClass().setAll("panelSelected");
                humanPlayer.makeMove("paper");
            } else {
                humanPlayer.makeMove("scissors");
                scissorsImg.getParent().getStyleClass().setAll("panelSelected");
            }
            Rps computerMove = computerPlayer.makeRandomMove();
            if (humanPlayer.move.tie(computerMove)) {
                lblWinner.setText("It's a TIE!");

            } else if (humanPlayer.move.win(computerMove)) {
                lblWinner.setText("You WIN!");
                humanPlayer.incrementScore();

            } else {
                lblWinner.setText("You LOSE!");
                computerPlayer.incrementScore();
            }

            //Changing the image to the corresponding image clicked
            noneImg.setImage(new Image(getClass().getResource("res/" + computerMove.getName() + ".png").toExternalForm()));

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void reset() {

        //Setting the human and computer scores to 0
        humanPlayer.setScore(0);
        computerPlayer.setScore(0);

        //Removing the Winner message
        lblWinner.setText("");

        //Setting the computer image back to the first one
        noneImg.setImage(new Image(getClass().getResource("res/none.png").toExternalForm()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Binding the Player Score Label to the Score Value
        lblPlayerScore.textProperty().bind(humanPlayer.scoreProperty().asString());

        //Binding the Computer Score Label to the Score Value
        lblCompScore.textProperty().bind(computerPlayer.scoreProperty().asString());
    }
}
