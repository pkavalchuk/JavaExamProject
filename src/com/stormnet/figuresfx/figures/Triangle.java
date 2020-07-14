package com.stormnet.figuresfx.figures;

import com.stormnet.figuresfx.drawUtils.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figure implements Drawable {
    private double s1;

    public Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_CIRCLE, cx, cy, lineWidth, color);
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double s1) {
        this(cx, cy, lineWidth, color);
        this.s1 = s1 < 40 ? 40 : s1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(s1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.s1, s1) == 0;
    }

    @Override
    public String toString() {
        String sb = "Triangle{" + "s1=" + s1 +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
        return sb;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{cx, cx + s1 / 2, cx - s1 / 2}, new double[]{cy - s1 / 2, cy + s1 / 2, cy + s1 / 2}, 3);
    }
}