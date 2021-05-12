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
    private double x = ARENAX1+ARENAWIDHT/2;


    public void start (Stage stage)
    {

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline t = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
        t.setCycleCount(Timeline.INDEFINITE);

        stage.setTitle("Kulki!");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();

//        gc.setFill(Color.BLACK);
//        gc.fillRect(ARENAX1, ARENAY1, ARENAWIDHT, ARENAHEIGHT);
//        gc.setFill(Color.WHITESMOKE);
//        gc.fillOval(ARENAX1+ARENAWIDHT/2, ARENAY1+ARENAHEIGHT/2,2*R ,2*R);


        t.play();

    }

    private void run(GraphicsContext gc)
    {
        gc.setFill(Color.BLACK);
        gc.fillRect(ARENAX1, ARENAY1, ARENAWIDHT, ARENAHEIGHT);

        gc.setFill(Color.WHITESMOKE);
        gc.fillOval(x += 5, ARENAY1 + ARENAHEIGHT/2,2*R, 2*R);
    }

}
