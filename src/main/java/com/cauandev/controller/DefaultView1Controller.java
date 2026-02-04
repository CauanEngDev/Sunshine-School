package com.cauandev.controller;

import com.cauandev.enums.ViewNames;
import com.cauandev.util.ViewFunctions;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class DefaultView1Controller extends AnchorPane {
    @FXML protected ImageView avatar;
    @FXML protected Button title;
    @FXML protected Button createButton;
    @FXML protected Button deleteButton;
    @FXML protected Button updateButton;
    @FXML protected Button searchButton;
    @FXML protected ImageView returnRune;

    public DefaultView1Controller() {
        ViewFunctions.ViewLoader("/view/DefaultOptionsView.fxml", this);
    }

    public void setTitle(String title) { this.title.setText(title); }

    public void setAvatar(String avatarURL) { this.avatar.setImage(ViewFunctions.loadImage(avatarURL)); }

    public void setCreateButton(String createButton) { this.createButton.setText(createButton); }

    public void setDeleteButton(String deleteButton) { this.deleteButton.setText(deleteButton); }

    public void setUpdateButton(String updateButton) { this.updateButton.setText(updateButton); }

    public void setSearchButton(String searchButton) { this.searchButton.setText(searchButton); }

    @FXML
    public void initialize() {
        createButton.setOnAction(event -> createAction());
        deleteButton.setOnAction(event -> deleteAction());
        updateButton.setOnAction(event -> updateAction());
        searchButton.setOnAction(event -> searchAction());
        returnRune.setOnMouseClicked(event -> GeneralController.switchView(ViewNames.OPTION));
    }

    protected abstract void createAction();
    protected abstract void deleteAction();
    protected abstract void updateAction();
    protected abstract void searchAction();
}
