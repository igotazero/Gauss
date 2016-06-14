package view;

import controller.Engine;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import java.util.List;

public class Window extends Application {
    public static int sizeX = 500;
    public static int sizeY = 590;
    public Group axis;
    public static Group staff = new Group();


    @Override
    public void start(Stage stage) {
        stage.setTitle("Gauss");
        Group root = new Group();
        final Scene scene = new Scene(root, sizeX, sizeY);
        scene.setFill(null);
        //?????? ????
        axis = new Group();
        //??????? ??? OX
        Line ox = new Line();
        ox.setStartX(sizeX - 10);
        ox.setStartY(sizeX / 2);
        ox.setEndX(0d + 10);
        ox.setEndY(sizeX / 2);
        //??????? ??? OY
        Line oy = new Line();
        oy.setStartX(sizeX / 2);
        oy.setStartY(sizeX);
        oy.setEndX(sizeX / 2);
        oy.setEndY(0d + 10);
        //??????? ????
        double px1 = sizeX - 10;
        double py1 = sizeX / 2;
        double px2 = sizeX - 30;
        double py2 = (sizeX / 2) + 4;
        double px3 = px2;
        double py3 = (sizeX / 2) - 4;
        Polygon pointerOne = new Polygon();
        pointerOne.getPoints().addAll(new Double[]{px1, py1, px2, py2, px3, py3});
        double ppx1 = sizeX / 2;
        double ppy1 = 10;
        double ppx2 = (sizeX / 2) + 4;
        double ppy2 = ppy1 + 20;
        double ppx3 = ppx1 - 4;
        double ppy3 = ppy2;
        Polygon pointerTwo = new Polygon();
        pointerTwo.getPoints().addAll(new Double[]{ppx1, ppy1, ppx2, ppy2, ppx3, ppy3});
        //????????? ? ??????
        axis.getChildren().add(ox);
        axis.getChildren().add(oy);
        axis.getChildren().add(pointerOne);
        axis.getChildren().add(pointerTwo);      
        //??????? ????
        //Y
        Label labelY = new Label("Y");
        labelY.setLayoutX(sizeX / 2 + 10);
        labelY.setLayoutY(0);
        //X
        Label labelX = new Label("X");
        labelX.setLayoutX(sizeX - 10);
        labelX.setLayoutY(sizeX / 2 - 20);
        axis.getChildren().add(labelY);
        axis.getChildren().add(labelX);

        //Controllers
        GridPane controllers = new GridPane();
        controllers.setHgap(10);
        controllers.setVgap(10);
        controllers.setLayoutX(0);
        controllers.setLayoutY(sizeX + 10);
        controllers.setLayoutX(10);

        Label functionLabel = new Label();
        functionLabel.setText("Function");
        controllers.add(functionLabel, 0, 0);

        Label pointCountLabel = new Label();
        pointCountLabel.setText("Points count");
        controllers.add(pointCountLabel, 0, 1);

        TextField textAreaFunction = new TextField();
        controllers.add(textAreaFunction, 1, 0);

        TextField textAreaPointsCount = new TextField();
        controllers.add(textAreaPointsCount, 1, 1);
        textAreaPointsCount.setDisable(true);

        Button generateButton = new Button("Generate");
        controllers.add(generateButton, 3, 0);

        Button clearButton = new Button("Clear");
        controllers.add(clearButton, 3, 1);
        clearButton.setDisable(true);

        Button doButton = new Button("Step forward");
        controllers.add(doButton, 4, 0);
        doButton.setDisable(true);

        Button undoButton = new Button("Step back");
        controllers.add(undoButton, 4, 1);
        undoButton.setDisable(true);

        Button select1 = new Button("✔");
        Button select2 = new Button("✔");
        controllers.add(select1, 2, 0);
        controllers.add(select2, 2, 1);
        //Actions for select
        select1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                textAreaFunction.setDisable(false);
                textAreaPointsCount.setDisable(true);
            }
        });
        select2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                textAreaPointsCount.setDisable(false);
                textAreaFunction.setDisable(true);
            }
        });

        //Actions for do's buttons
        generateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!textAreaPointsCount.isDisable()){
                    int pointsCount = Integer.parseInt(textAreaPointsCount.getText());
                    Engine.showPrimaryVector(pointsCount);
                    doButton.setDisable(false);
                    undoButton.setDisable(false);
                    clearButton.setDisable(false);
                }
            }
        });
        clearButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clear();
                doButton.setDisable(true);
                undoButton.setDisable(true);
                clearButton.setDisable(true);
            }
        });
        doButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Engine.stepForward();
            }
        });

        root.getChildren().add(axis);
        root.getChildren().add(controllers);
        root.getChildren().add(staff);
        stage.setScene(scene);
        stage.show();
    }

    public static void showShapes(List<Shape> points){
        staff.getChildren().addAll(points);
    }

    public static void removeAll(List<Shape> points){
        staff.getChildren().removeAll(points);
    }

    public static void clear(){
        staff.getChildren().clear();
    }

    public static void run(String[] args){
        launch(args);
    }
}