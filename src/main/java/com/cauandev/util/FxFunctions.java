package com.cauandev.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FxFunctions {
    Logger logger = Logger.getLogger(FxFunctions.class.getName());

    public Parent ViewLoader(String url) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            return loader.load();
        } catch (Exception e) {
            logger.log(Level.INFO, "Erro ao carregar tela no arquivo " + url);
        }
        return null;
    }
}
