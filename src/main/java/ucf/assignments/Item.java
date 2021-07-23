/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Nicholas Viggiani
 */
package ucf.assignments;

import java.util.ArrayList;

public class Item {
    //create variables to store attributes of an item
    // String name; String id; BigDecimal value
    private String name;
    private String id;
    private String value;
    private ArrayList<String> idList = new ArrayList<>();

    //getter method for ID
    public String getId() {
        return id;
    }

    //setter method for ID
    public void setId(String id) {
        //use this.id = id to set id value for instance of this item
        //Set ERROR messages is length of string is not 10 OR
        // if the String does not contain exclusively characters and numbers
        if (id.length() == 10) {
            this.id = id;
        } else {
            this.id = "ERROR, Must be formatted XXXXXXXXXX";
        }
        char idCharList[] = id.toCharArray();
        for (int i = 0; i < idCharList.length; i++) {
            if (!Character.isLetterOrDigit(idCharList[i])) {
                this.id = "ERROR, Must only contain Num/Char";
            }
        }
        validateUniqueID(id);
        idList.add(id);

    }

    //getter method for value
    public String getValue() {
        return value;
    }

    //setter method for value
    public void setValue(String value) {
        //use this.value = value to set value for instance of this item
        //convert from String to BigDecimal type
        this.value = value;
        if (value.equals("")){
            this.value = "Blank";
        }
        char valueList[] = value.toCharArray();
        for (int i = 0; i < valueList.length; i++) {
            if (!Character.isDigit(valueList[i])) {
                this.value = "NonNumeric";
            }
        }
    }

    //getter method for name
    public String getName() {
        return name;
    }

    //setter method for name
    public void setName(String name) {
        //use this.name = name to set name value for instance of this item
        //Set ERROR message if name is not between 2 and 256 characters
        if (name.length() >= 2 && name.length() <= 256) {
            this.name = name;
        } else {
            this.name = "ERROR, Length must be between 2-256 inclusive";
        }
    }

    public String validateUniqueID(String id) {
        //use list of IDs to ensure they do not repeat
        //if ID is listed more than once, ERROR
        for (String str : idList) {
            if (!str.equals(id)) {
                this.id = id;
            } else {
                this.id = "ERROR Serial Number must be unique";
            }
        }
        return this.id;
    }

}