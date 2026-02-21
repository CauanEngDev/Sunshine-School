package com.cauandev.util;

import com.cauandev.exception.ResourceNotFoundException;
import com.cauandev.exception.ViewConfigurationException;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * Classe de funções relacionadas às 'views' e imagens.
 */
public class ViewFunctions {
    // Log para mensagens de erro.
    private static final Logger logger = LoggerFactory.getLogger(ViewFunctions.class);

    /**
     * Método que faz o carregamento das telas FXML.
     * @param url caminho da tela.
     * @param root classe que será controlador e raiz da tela (estende 'AnchorPane').
     */
    public static void ViewLoader(String url, AnchorPane root){
        // Função que carrega a tela.
        FXMLLoader loader = new FXMLLoader(ViewFunctions.class.getResource(url));
        loader.setRoot(root); // Seta a raiz da tela.
        loader.setController(root); // Seta o controlador da tela.

        // Tenta Fazer o carregamento da tela ou lança um 'log' caso der erro.
        try {
            loader.load();
        } catch (Exception e) {
            logger.error("Falha crítica na UI: não foi possível carregar {}", url);
            throw new ViewConfigurationException("Erro ao montar a tela: " + url, e);
        }
    }

    /**
     * Método que carrega as imagens.
     * @param url caminho da imagem.
     * @return retorna a imagem pronta para ser usada.
     */
    public static Image loadImage(String url){
        // Carrega a imagem.
        InputStream input = ViewFunctions.class.getResourceAsStream(url);
        // Verifica nulidade e lança exceção.
        if (input == null) {
            logger.error("Caminho vazio");
            throw new ResourceNotFoundException("Imagem não encontrada no caminho: " + url);
        }
        Image image;
        // Tenta criar o 'Image' e lança exceção caso o arquivo esteja corrompido.
        try {
            image = new Image(input);
        } catch (Exception e) {
            logger.error("Não possível carregar imagem");
            throw new ResourceNotFoundException("Arquivo de imagem corrompido em " + url);
        }
        return image;
    }


}
