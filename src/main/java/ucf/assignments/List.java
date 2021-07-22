package ucf.assignments;


import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class List {
    private final ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item){
        //adds item to list of items using add method
        this.items.add(item);
    }

    public void removeItem(Item item){
        //removes item from list of items using remove method
        this.items.remove(item);
    }

}
