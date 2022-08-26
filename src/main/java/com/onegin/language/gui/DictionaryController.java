package com.onegin.language.gui;

import com.onegin.language.Application;
import com.onegin.language.dictionary.DictionaryService;
import com.onegin.language.dictionary.entities.Definition;
import com.onegin.language.gui.components.DefinitionListViewItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DictionaryController implements Initializable {

    DictionaryService dictionaryService = Application.dictionaryService;
    final ObservableList<Definition> definitions = FXCollections.observableArrayList();

    public ListView definitionListView;
    public AnchorPane definitionSceneRoot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.definitionListView.setItems(definitions);
        this.definitions.addAll(this.dictionaryService.getAllDefinitions().values());

        this.definitionListView.setCellFactory(lv -> {
            ListCell<Definition> cell = new ListCell<Definition>() {
                @Override
                protected void updateItem(Definition item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        return;
                    }
                    DefinitionListViewItem c = new DefinitionListViewItem();
                    c.setDefinition(item);
                    setGraphic(c);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    try {
                        Definition d = (Definition) definitionListView.getSelectionModel().getSelectedItem();
                        this.definitionSelected(e, d);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    e.consume();
                }
            });
            return cell;
        });
    }

    public void definitionSelected(MouseEvent mouseEvent, Definition selectedItem) throws IOException {
        DefinitionScene card = new DefinitionScene();
        card.setDefinition(selectedItem);
        this.definitionSceneRoot.getChildren().clear();
        this.definitionSceneRoot.getChildren().add(card);
    }


}