/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Nicholas Viggiani
 */
package ucf.assignments;

import java.util.ArrayList;

public class List {
    private final ArrayList<Item> items = new ArrayList<>();

    //getter method for list of items
    public ArrayList<Item> getList(){
        return items;
    }

    //getter method for size of list
    public int getSize(){
        return items.size();
    }

    //getter method for item in list
    public Item getItem(int integer){
        return items.get(integer);
    }

    public void addItem(Item item){
        //adds item to list of items using add method
        this.items.add(item);
    }

    public void removeItem(int index){
        //removes item from list of items using remove method
        this.items.remove(index);
    }

    public ArrayList<String> getIDs(){
        //create a list of IDs of each item
        //if the ID is already in the list of IDs then
        //ERROR, the ID must be unique
        ArrayList<String> idList = new ArrayList<>();
        for (Item item : items){
            if (!idList.contains(item.getId())){
                idList.add(item.getId());
            } else {
                item.setId("ERROR Serial Number must be unique");
            }
        }
        return idList;
    }
}
