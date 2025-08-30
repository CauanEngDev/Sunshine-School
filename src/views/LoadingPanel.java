package views;

import javax.swing.*;
import java.awt.*;


public class LoadingPanel extends JPanel{
    private JLabel loadingLabel;
    private Icon loadingIcon;

    public LoadingPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(0, 0, 0, 180));
        setOpaque(true);

        ImageIcon gifIcon = new ImageIcon(getClass().getResource("/resources/GIF_Carregando.gif"));
        loadingLabel = new JLabel(gifIcon);

        add(loadingLabel, BorderLayout.CENTER);
    }
}
