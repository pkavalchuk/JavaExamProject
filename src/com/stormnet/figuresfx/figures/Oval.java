package com.stormnet.figuresfx.figures;

import com.stormnet.figuresfx.drawUtils.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Oval extends Figure implements Drawable {
    private double radius;

    private Oval(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_OVAL, cx, cy, lineWidth, color);
    }

    public Oval(double cx, double cy, double lineWidth, Color color, double radius) {
        this(cx, cy, lineWidth, color);
        this.radius = radius < 40 ? 40 : radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oval oval = (Oval) o;
        return Double.compare(oval.radius, radius) == 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Oval{");
        sb.append("radius=").append(radius);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokeOval(cx - radius * 2, cy - radius, radius * 3, radius * 2);
    }
}