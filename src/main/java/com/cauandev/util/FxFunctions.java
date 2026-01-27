package com.cauandev.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class FxFunctions {
    private static final Logger logger = LoggerFactory.getLogger(FxFunctions.class);

    public static Parent ViewLoader(String url){
        try {
            FXMLLoader loader = new FXMLLoader(FxFunctions.class.getResource(url));
            return loader.load();
        } catch (Exception e) {
            logger.warn("Erro ao carregar tela no arquivo {}", url, e);
        }
        return null;
    }

    public static Image loadImage(String url){
        InputStream input = FxFunctions.class.getResourceAsStream(url);
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
