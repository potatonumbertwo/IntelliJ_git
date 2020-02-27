package Cs1103Unit2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class InputCanvas extends JPanel implements MouseListener, MouseMotionListener {
    private Point[] points;
    private DisplayCanvas display;
    private int pointDragged = -1;

    public InputCanvas(DisplayCanvas var1) {
        this.display = var1;
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void setPointCount(int var1) {
        this.points = new Point[var1];

        for (int var2 = 0; var2 < var1; ++var2) {
            this.points[var2] = new Point(50 + var2 * 400 / (var1 - 1), 250);
        }

        this.repaint();
        this.display.setPoints(this.points);
    }

    protected void paintComponent(Graphics var1) {
        super.paintComponent(var1);
        if (this.points != null) {
            var1.setColor(Color.BLACK);

            int var2;
            for (var2 = 1; var2 < this.points.length; ++var2) {
                var1.drawLine(this.points[var2 - 1].x, this.points[var2 - 1].y, this.points[var2].x, this.points[var2].y);
            }

            for (var2 = 0; var2 < this.points.length; ++var2) {
                var1.setColor(var2 != 0 && var2 != this.points.length - 1 ? Color.RED : Color.BLUE);
                var1.fillOval(this.points[var2].x - 5, this.points[var2].y - 5, 9, 9);
            }
        }

    }

    public void mousePressed(MouseEvent var1) {
        if (this.pointDragged <= 0) {
            int var2 = var1.getX();
            int var3 = var1.getY();

            for (int var4 = 0; var4 < this.points.length; ++var4) {
                int var5 = this.points[var4].x;
                int var6 = this.points[var4].y;
                int var7 = (var5 - var2) * (var5 - var2) + (var6 - var3) * (var6 - var3);
                if (var7 <= 36) {
                    this.pointDragged = var4;
                    return;
                }
            }

        }
    }

    public void mouseDragged(MouseEvent var1) {
        if (this.pointDragged >= 0) {
            int var2 = var1.getX();
            int var3 = var1.getY();
            var2 = Math.min(500, Math.max(0, var2));
            var3 = Math.min(500, Math.max(0, var3));
            if (var2 != this.points[this.pointDragged].x || var3 != this.points[this.pointDragged].y) {
                this.points[this.pointDragged].setLocation(var2, var3);
                this.display.setPoints(this.points);
                this.repaint();
            }
        }

    }

    public void mouseReleased(MouseEvent var1) {
        this.pointDragged = -1;
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
    }

    public void install(int[] var1) {
        int var2 = var1.length / 2;
        this.points = new Point[var2];

        for (int var3 = 0; var3 < var2; ++var3) {
            this.points[var3] = new Point(var1[2 * var3], var1[2 * var3 + 1]);
        }

        this.repaint();
        this.display.setPoints(this.points);
    }
}
