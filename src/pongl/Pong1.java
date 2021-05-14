package pongl;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.jshell.Snippet;

import java.util.Random;


public class Pong1<setCycleCount> extends Application{
    private  static  final double WIDTH = 800;
    private  static  final double HEIGHT = 600;
    private  static  final double MARGIN = 50;
    private  static  final double ARENAWIDHT = WIDTH - 2*MARGIN;
    private  static  final double ARENAHEIGHT = HEIGHT - 2*MARGIN;
    private  static  final double ARENAX1 = MARGIN;
    private  static  final double ARENAY1 = MARGIN;
    private  static  final double ARENAX2 = ARENAX1 + ARENAWIDHT;
    private  static  final double ARENAY2 = ARENAY1 + ARENAHEIGHT;
    private  static  final double R = 10;

    public void start (Stage stage)
    {

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline t = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
        t.setCycleCount(Timeline.INDEFINITE);

        stage.setTitle("Kulki!");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();

        t.play();
    }

//    private double x = ARENAX1+ARENAWIDHT/2;
//    private double y = ARENAY1+ARENAHEIGHT/2;
//
//    private double vx = 5;
//    private double vy = 2;

    private static final int LICZBAKULEK = 10;
    private Kulka[] kulki = new Kulka[LICZBAKULEK];

    private void run(GraphicsContext gc)
    {
        initKula();
        gc.setFill(Color.BLACK);
        gc.fillRect(ARENAX1, ARENAY1, ARENAWIDHT, ARENAHEIGHT);

        for (int i =0; i< LICZBAKULEK; i++) {
            kulki[i].checkBoundaryCollision(ARENAX1, ARENAY1, ARENAX2, ARENAY2);
            kulki[i].update();
            kulki[i].draw(gc);
        }
    }

    private void initKula(){
        Random lott = new Random ();
        for (int i =0; i< LICZBAKULEK; i++) {
            kulki[i] = new Kulka(
                    lott.nextDouble()*ARENAWIDHT+ARENAX1,
                    lott.nextDouble()*ARENAHEIGHT+ARENAY1,
                    5+lott.nextDouble()*20,
                    5+ lott.nextDouble()*20);

        }
    }


}

