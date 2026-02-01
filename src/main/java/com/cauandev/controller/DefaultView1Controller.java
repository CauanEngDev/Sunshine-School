package com.cauandev.controller;

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

    public DefaultView1Controller(String url) {
        ViewFunctions.ViewLoader(url, this);
    }

    public void setTitle(String title) { this.title.setText(title); }

    public void setAvatar(String avatarURL) { this.avatar.setImage(ViewFunctions.loadImage(avatarURL)); }

    public void setCreateButton(String createButton) { this.createButton.setText(createButton); }

    public void setDeleteButton(String deleteButton) { this.deleteButton.setText(deleteButton); }

    public void setUpdateButton(String updateButton) { this.updateButton.setText(updateButton); }

    public void setSearchButton(String searchButton) { this.searchButton.setText(searchButton); }

    @FXML
    public void initialize() {

    }
}
