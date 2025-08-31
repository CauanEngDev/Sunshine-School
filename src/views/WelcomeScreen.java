package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Image;
import utils.RoundedButton;

public class WelcomeScreen extends JFrame {
    private JButton startButton;

    public WelcomeScreen() {
        setTitle("Sunshine School - Bem-vindo!");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Define o painel de conteúdo
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.decode("#E0A700"));
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setContentPane(contentPane);

        // --- Logo (Imagem e Texto) ---
        JPanel logoPanel = new JPanel();
        logoPanel.setOpaque(false);
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));

        // Colocando a imagem
        int logoWidth = 300;
        int logoHeight = 300;

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/resources/Emoji_Escola_sombra.png"));
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
        ImageIcon finalLogo = new ImageIcon(resizedImage);

        JLabel logoLabel = new JLabel(finalLogo);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Texto da Logo com fonte personalizada
        JLabel titleLabel = new JLabel("Sunshine School");
        titleLabel.setForeground(Color.decode("#B85A00"));
        titleLabel.setFont(new Font("Magic School Two", Font.PLAIN, 90));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        logoPanel.add(logoLabel);
        logoLabel.add(Box.createRigidArea(new Dimension(0, 10)));
        logoPanel.add(titleLabel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        contentPane.add(logoPanel, gbc);

        // --- Botão Iniciar ---
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        startButton = new RoundedButton("Iniciar", 40);
        buttonPanel.add(startButton);

        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets =  new Insets(20, 0, 0, 0);
        contentPane.add(buttonPanel, gbc);

        // Torna a janela visível
        setVisible(true);
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }
}