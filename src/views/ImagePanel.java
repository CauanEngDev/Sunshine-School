package views;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String imagePath) {
        try {
            backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem de fundo: " + imagePath);
        }
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);

        if (backgroundImage != null) {
            graphic.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}