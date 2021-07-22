/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Nicholas Viggiani
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class ListManager {
    private final List itemList = new List();

    @FXML
    private TableView<Item> tableView;

    @FXML
    private TableColumn<Item, String> priceColumn;

    @FXML
    private TableColumn<Item, String> idColumn;

    @FXML
    private TableColumn<Item, String> nameColumn;

    @FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField valueField;

    @FXML
    private TextField searchField;

    public void addButtonIsClicked(ActionEvent actionEvent) {
        Item item = new Item();
        item.setName(nameField.getText());
        item.setId(idField.getText());
        item.setValue(valueField.getText());
        itemList.addItem(item);
        itemList.getIDs();
        updateColumns();
        clearText();
    }

    public void removeButtonIsClicked(ActionEvent actionEvent) {
        try {
            if (tableView.getSelectionModel().isEmpty()) {
                itemList.removeItem(tableView.getSelectionModel().getSelectedIndex());

            } else {
                itemList.removeItem(tableView.getSelectionModel().getSelectedIndex());
            }

        } catch (IndexOutOfBoundsException e) {
            Item item = new Item();
            item.setName("ERROR, Select item to remove");
            item.setId("ERROR, Select item to remove");
            item.setValue("ERROR");
            itemList.addItem(item);
        }
        updateColumns();
        clearText();
    }

    public void searchButtonIsClicked(ActionEvent actionEvent) {
    }

    public void openButtonIsClicked(ActionEvent actionEvent) {
    }

    public void saveButtonIsClicked(ActionEvent actionEvent) {
    }

    public void updateColumns(){
        ObservableList<Item> list = FXCollections.observableArrayList(itemList.getList());
        tableView.setItems(list);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
    }

    public void clearText(){
        nameField.clear();
        idField.clear();
        valueField.clear();
    }

}
