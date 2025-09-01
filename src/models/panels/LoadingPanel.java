package models.panels;

import javax.swing.*;
import java.awt.*;


public class LoadingPanel extends JPanel{
    public LoadingPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#E0A700"));
        setOpaque(true);

        ImageIcon gifIcon = new ImageIcon(getClass().getResource("/resources/gif_loading.gif"));
        JLabel loadingLabel = new JLabel(gifIcon);
        loadingLabel.setOpaque(false);

        add(loadingLabel, BorderLayout.CENTER);
    }
}
