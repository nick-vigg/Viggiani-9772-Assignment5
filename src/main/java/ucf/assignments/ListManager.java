package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

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
        updateColumns();
    }

    public void removeButtonIsClicked(ActionEvent actionEvent) {
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

}
