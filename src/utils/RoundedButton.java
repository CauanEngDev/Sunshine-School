package utils;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    public RoundedButton(String text, int fontSize) {
        super(text);

        setFont(new Font("Magic School One", Font.BOLD, fontSize));
        setForeground(Color.decode("#B85A00"));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        Graphics2D graphic2d = (Graphics2D) graphic.create();
        graphic2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphic2d.setColor(Color.decode("#87CEFA"));
        graphic2d.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
        graphic2d.setColor(getForeground());
        FontMetrics metrics = graphic2d.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(getText())) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        graphic2d.drawString(getText(), x, y);

        graphic2d.dispose();
    }
}
