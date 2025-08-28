package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener; // Para o botão

public class WelcomeScreen extends JFrame {
    private JLabel logoLabel; // Imagem da logo
    private JButton startButton; // Botão "Iniciar"

    // Construtor que monta a tela
    public WelcomeScreen() {
        setTitle("Sunshine School - Bem-vindo!");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Define o painel de conteúdo
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 207, 107)); // Cor de fundo laranja-amarelado
        contentPane.setLayout(new BorderLayout()); // Layout para centralizar o conteúdo
        setContentPane(contentPane);

        // --- Logo (Imagem e Texto) ---
        JPanel logoPanel = new JPanel();
        logoPanel.setOpaque(false); // Transparente para ver o fundo do contentPane
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS)); // Para empilhar verticalmente

        // Colocando a imagem
        ImageIcon schoolLogoIcon = new ImageIcon(getClass().getResource("/resources/Emoji_Escola_sombra.png"));
        logoLabel = new JLabel(schoolLogoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza a imagem
        logoPanel.add(logoLabel);
    }
}
