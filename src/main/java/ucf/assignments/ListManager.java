/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Nicholas Viggiani
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Locale;


public class ListManager {
    private final List itemList = new List();
    ObservableList<String> choiceBoxValues = FXCollections.observableArrayList("Name", "Serial Number");

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

    @FXML
    private ComboBox comboBox;

    @FXML
    public void initialize() {
        comboBox.setValue("Name");
        comboBox.setItems(choiceBoxValues);
        FilteredList<Item> filteredList =
                new FilteredList<Item>(FXCollections.observableArrayList(itemList.getList()));
    }

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
        updateColumns(itemList.getList());
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
        updateColumns(itemList.getList());
        clearText();
    }

    public void updateButtonIsClicked(ActionEvent actionEvent) {
        //Update the table after editing values
        itemList.getIDs();
        updateColumns(itemList.getList());
    }

    public void openButtonIsClicked(ActionEvent actionEvent) {
        //allows for user input to be loaded from a file
        //Filters the openable files to only .txt files;
        String path = FileManager.promptOpenFile();
        if (!path.equals("")) {
            if (path.contains(".txt")) {
                ArrayList<String> fileList = FileManager.readFromFile(path);
                for (int i = 0; i < fileList.size(); i++) {
                    Item item = new Item();
                    item.TXTfileToItem(fileList, i);
                    itemList.addItem(item);
                }
            }
            else if (path.contains(".html")) {
                ArrayList<String> fileList = FileManager.readFromHTML(path);
                for (int i = 0; i < fileList.size(); i++){
                    Item item = new Item();
                    item.HTMLfileToItem(fileList, i);
                    itemList.addItem(item);
                }
            }
        }
        itemList.getIDs();
        updateColumns(itemList.getList());
    }

    public void saveButtonIsClicked(ActionEvent actionEvent) {
        String path = FileManager.promptSaveFile();
        if (!path.equals("")) {
            FileManager.writeToFile(path, itemList);
        }
    }

    public void updateColumns(ArrayList<Item> items) {
        //Set all column values using CellFactory and set them to be editable
        ObservableList<Item> list = FXCollections.observableArrayList(items);
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

    public void update() {
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

    public void searchButtonIsClicked(ActionEvent actionEvent) {
        String key = searchField.getText().toLowerCase();
        ArrayList<Item> filterList = new ArrayList<>();
        if (comboBox.getValue().equals("Name")) {
            for (int i = 0; i < itemList.getSize(); i++) {
                if (itemList.getItem(i).getName().contains(key)) {
                    filterList.add(itemList.getItem(i));
                }
            }
        } else if (comboBox.getValue().equals("Serial Number")) {
            for (int i = 0; i < itemList.getSize(); i++) {
                if (itemList.getItem(i).getId().contains(key)) {
                    filterList.add(itemList.getItem(i));
                }
            }
        }
        updateColumns(filterList);
        if (key.equals("")){
            updateColumns(itemList.getList());
        }
    }
}

