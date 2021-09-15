package game.ui;

import game.model.Board;
import game.model.Game;
import game.model.Player;
import game.utils.AlertUtil;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import game.Main;


public class StartPane extends FlowPane{

    public StartPane() {
        this.setStyle("-fx-background-color: black;");
        init();
    }

    public void init() {
        Label label = new Label("FINDING MULLER");
        label.setTextFill(Color.WHITE);
        label.setFont(new Font(35));
        label.setStyle("-fx-font-weight: bold");
        label.setTranslateX(50);
        label.setTranslateY(100);


        Label label1 = new Label("It's game time!");
        label1.setTextFill(Color.WHITE);
        label1.setFont(new Font(32));
        label1.setStyle("-fx-font-weight: bold");
        label1.setTranslateX(50);
        label1.setTranslateY(200);
        // Enter player's name
        Label nameLab = new Label("Enter your name:");
        nameLab.setTextFill(Color.WHITE);
        nameLab.setFont(new Font(28));
        nameLab.setTranslateX(50);
        nameLab.setTranslateY(230);


        TextField textField = new TextField();
        textField.setTranslateX(50);
        textField.setTranslateY(260);
        // Start game
        Button button = new Button("Start!");
        button.setTranslateX(70);
        button.setTranslateY(310);
        button.setOnAction((e)->{
            String name = textField.getText().trim();
            if(name == null || name.equals("")) {
                AlertUtil.alertMsg("Warning","Please input your name!");
                return;
            }
            Player player = new Player(name);
            Game.getInstance().setPlayer(player);

            Main.getShowPane().setRight(new GamePane(Game.getInstance()));
            Main.start();
            BoardCanvas boardCanvas = (BoardCanvas) Main.getShowPane().getCenter();
            Board board = boardCanvas.getBoard();
            boardCanvas.clear();
            boardCanvas.startDraw();
        });
        this.getChildren().add(label);
        this.getChildren().add(label1);
        this.getChildren().add(nameLab);
        this.getChildren().add(textField);
        this.getChildren().add(button);
    }
}
