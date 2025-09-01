package models.panels;

import javax.swing.*;
import java.awt.*;

public abstract class ImagePanel extends JPanel {
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
            int panelWidth = this.getWidth(),  panelHeight = this.getHeight();
            int imageWidth = backgroundImage.getWidth(this), imageHeight = backgroundImage.getHeight(this);

            double panelRatio = (double) panelWidth / panelHeight;
            double imageRatio = (double) imageWidth / imageHeight;

            int newWidth = imageWidth, newHeight = imageHeight;

            if  (imageRatio > panelRatio) {
                newWidth = panelWidth;
                newHeight = (int) (panelHeight + imageRatio);
            } else {
                newHeight = panelHeight;
                newWidth = (int) (panelHeight * imageRatio);
            }

            int x = (panelWidth - newWidth) / 2;
            int y = (panelHeight - newHeight) / 2;

            graphic.drawImage(backgroundImage, x, y, newWidth, newHeight, this);
        }
    }
}