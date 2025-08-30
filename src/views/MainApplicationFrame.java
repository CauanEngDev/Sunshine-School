// src/view/MainApplicationFrame.java
package views;

import javax.swing.*;
import java.awt.*;

public class MainApplicationFrame extends JFrame {
    public MainApplicationFrame() {
        setTitle("Sistema da Sunshine School");
        setSize(1024, 768); // Tamanho da sua tela principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Exemplo simples de conteúdo
        JLabel welcomeText = new JLabel("Bem-vindo ao Sistema da Sunshine School!");
        welcomeText.setFont(new Font("Arial", Font.BOLD, 36));
        welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeText);
    }
}