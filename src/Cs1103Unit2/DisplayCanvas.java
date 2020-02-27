package Cs1103Unit2;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class DisplayCanvas extends JPanel {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private double[] s;
    private double[] t;
    private int recursionLevel;

    public DisplayCanvas() {
        this.setBackground(Color.WHITE);
    }

    public void setPoints(Point[] var1) {
        this.x1 = var1[0].x;
        this.y1 = var1[0].y;
        this.x2 = var1[var1.length - 1].x;
        this.y2 = var1[var1.length - 1].y;
        this.s = new double[var1.length];
        this.t = new double[var1.length];
        this.s[0] = this.t[0] = 0.0D;
        double var2 = (double) ((this.x2 - this.x1) * (this.x2 - this.x1) + (this.y2 - this.y1) * (this.y2 - this.y1));

        for (int var4 = 1; var4 < var1.length; ++var4) {
            this.s[var4] = (double) ((this.x2 - this.x1) * (var1[var4].x - this.x1) + (this.y2 - this.y1) * (var1[var4].y - this.y1)) / var2;
            this.t[var4] = (double) ((this.x2 - this.x1) * (var1[var4].y - this.y1) - (this.y2 - this.y1) * (var1[var4].x - this.x1)) / var2;
        }

        this.repaint();
    }

    public void setRecursionLevel(int var1) {
        if (var1 != this.recursionLevel) {
            this.recursionLevel = var1;
            this.repaint();
        }

    }

    protected void paintComponent(Graphics var1) {
        super.paintComponent(var1);
        if (this.s != null) {
            var1.setColor(Color.BLACK);
            var1.fillOval(this.x1 - 4, this.y1 - 4, 7, 7);
            var1.fillOval(this.x2 - 4, this.y2 - 4, 7, 7);
            this.drawLines(var1, this.recursionLevel, (double) this.x1, (double) this.y1, (double) this.x2, (double) this.y2);
        }

    }

    private void drawLines(Graphics var1, int var2, double var3, double var5, double var7, double var9) {
        if (var2 <= 0) {
            var1.drawLine((int) var3, (int) var5, (int) var7, (int) var9);
        } else {
            double var11 = var3;
            double var13 = var5;

            for (int var15 = 1; var15 < this.s.length; ++var15) {
                double var16 = var3 + this.s[var15] * (var7 - var3) - this.t[var15] * (var9 - var5);
                double var18 = var5 + this.t[var15] * (var7 - var3) + this.s[var15] * (var9 - var5);
                this.drawLines(var1, var2 - 1, var11, var13, var16, var18);
                var11 = var16;
                var13 = var18;
            }
        }

    }
}
