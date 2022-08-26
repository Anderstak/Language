package com.onegin.language.gui.components;

import com.onegin.language.dictionary.entities.Definition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class DefinitionListViewItem extends HBox {

    @FXML
    Label wordLabel;

    @FXML
    Label commentLabel;

    public DefinitionListViewItem() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DefinitionListViewItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDefinition(Definition definition) {
        this.wordLabel.setText(definition.getWord());
        int n = definition.getDefinitions().size();
        if (n % 10 == 1) {
            this.commentLabel.setText("Найдена " + n + " статья.");
        } else if ((n % 10 >= 2) && (n % 10 <= 4)) {
            this.commentLabel.setText("Найдено " + n + " статьи.");
        } else {
            this.commentLabel.setText("Найдено " + n + " статей.");
        }
    }


}
