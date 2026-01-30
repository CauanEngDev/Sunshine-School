package com.cauandev.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class ViewFunctions {
    private static final Logger logger = LoggerFactory.getLogger(ViewFunctions.class);

    public static void ViewLoader(String url, AnchorPane root){
        FXMLLoader loader = new FXMLLoader(ViewFunctions.class.getResource(url));
        loader.setRoot(root);
        loader.setController(root);

        try {
            loader.load();
        } catch (Exception e) {
            logger.error("Erro ao tentar carregar tela {}", url, e);
        }
    }

    public static Image loadImage(String url){
        InputStream input = ViewFunctions.class.getResourceAsStream(url);
        if (input == null) {
            logger.error("Arquivo não encontrado em {}", url);
            return null;
        }
        Image image;
        try {
            image = new Image(input);
        } catch (Exception e) {
            logger.error("Não possível carregar imagem em {}", url);
            return null;
        }
        return image;
    }


}
