package edu.pjatk.s19701.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * Basing on tutorial: https://www.youtube.com/watch?v=FEb2Pt9ymes&ab_channel=RaVen
 */
public class BackButton extends JButton {

    public BackButton() {
        setColor(Color.CYAN);
        colorOver = new Color(179,250,160);
        colorClick = new Color(152, 184,144);
        borderColor = new Color(30, 136,56);
        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
                over = true;
            }

            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(over) {
                    setBackground(colorOver);
                } else {
                    setBackground(color);
                }
            }

            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(colorOver);
            }

            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(color);
            }
        });
    }

    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 0;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(borderColor);
        graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), radius, radius);
        graphics2D.setColor(getBackground());
        graphics2D.fillRoundRect(2, 2, getWidth()-4, getHeight()-4, radius, radius);
        super.paintComponent(g);
    }
}
