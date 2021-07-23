/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Nicholas Viggiani
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


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
        //Create a new item and set its attributes
        //add the item to the list of items and validate it's ID
        //Update the TableView and clear existing data
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
        //Remove an existing item from the list if selected
        //If no item is selected ERROR
        //Update the TableView and clear exisitng data
        try {
            itemList.removeItem(tableView.getSelectionModel().getSelectedIndex());

        } catch (IndexOutOfBoundsException e) {
            Item item = new Item();
            item.setName("ERROR, Select item to remove");
            itemList.addItem(item);
        }
        updateColumns();
        clearText();
    }

    public void updateButtonIsClicked(ActionEvent actionEvent) {
        //Update the table after editing values
        itemList.getIDs();
        updateColumns();
    }

    public void searchButtonIsClicked(ActionEvent actionEvent) {
    }

    public void openButtonIsClicked(ActionEvent actionEvent) {
    }

    public void saveButtonIsClicked(ActionEvent actionEvent) {
    }

    public void updateColumns() {
        //Set all column values using CellFactory and set them to be editable
        ObservableList<Item> list = FXCollections.observableArrayList(itemList.getList());
        tableView.setItems(list);
        tableView.setEditable(true);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        update();
    }

    public void update(){
        // Update the selected value with the new value in the text box
        idColumn.setOnEditCommit(t ->
                t.getRowValue().setId(t.getNewValue()));
        priceColumn.setOnEditCommit(t ->
                t.getRowValue().setValue(t.getNewValue()));
        nameColumn.setOnEditCommit(t ->
                t.getRowValue().setName(t.getNewValue()));

    }

    public void clearText() {
        //Set all textFields to blank using clear method
        nameField.clear();
        idField.clear();
        valueField.clear();
    }


}

