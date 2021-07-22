package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ListManager {

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

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
        item.setValue(idField.getText());
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

    }

}
