package ucf.assignments;


import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

public class List {
    private final ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> getList(){
        return items;
    }

    public void addItem(Item item){
        //adds item to list of items using add method
        this.items.add(item);
    }

    public void removeItem(Item item){
        //removes item from list of items using remove method
        this.items.remove(item);
    }

    public ArrayList<String> getNames(){
        ArrayList<String> nameList = new ArrayList<>();
        for (Item item : items) {
            nameList.add(item.getName());
        }
        return nameList;
    }

    public ArrayList<String> getIDs(){
        ArrayList<String> idList = new ArrayList<>();
        for (Item item : items){
            if (!idList.contains(item)){
                idList.add(item.getId());
            } else {
                item.setId("ERROR Serial Number must be unique");
                idList.add(item.getId());
            }
        }
        return idList;
    }

    public ArrayList<String> getValues(){
        ArrayList<String> valueList = new ArrayList<>();
        for (Item item : items){
            valueList.add(item.getValue());
        }
        return valueList;
    }

}
