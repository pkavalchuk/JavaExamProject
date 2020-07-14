package com.stormnet.figuresfx.controller;

import com.stormnet.figuresfx.drawUtils.Drawer;
import com.stormnet.figuresfx.exceptions.UnknownFigureTypeEx;
import com.stormnet.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MainScreenViewController implements Initializable {
    private List<Figure> figures;
    private Random random;
    private static final Logger logger = Logger.getLogger(String.valueOf(MainScreenViewController.class));

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("App is initialized!");
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    private Figure createFigure(double x, double y) throws UnknownFigureTypeEx {
        Figure figure;
        switch (random.nextInt(4)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, Math.min(random.nextInt(10), 10), Color.MEDIUMPURPLE, random.nextInt(50));
                logger.info("Circle was added.");
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, Math.min(random.nextInt(10), 10), Color.PINK, random.nextInt(45), random.nextInt(70));
                logger.info("Rectangle was added.");
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, Math.min(random.nextInt(10), 10), Color.HOTPINK, random.nextInt(45));
                logger.info("Triangle was added.");
                break;
            case Figure.FIGURE_TYPE_OVAL:
                figure = new Oval(x, y, Math.min(random.nextInt(10), 10), Color.DARKMAGENTA, random.nextInt(50));
                logger.info("Oval was added.");
                break;
            default:
                throw new UnknownFigureTypeEx("Unknown figure type! Do smth to fix it.");
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) throws UnknownFigureTypeEx {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
    }
}