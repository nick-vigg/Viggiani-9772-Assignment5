package ucf.assignments;

import java.math.BigDecimal;

public class Item {
    //create variables to store attributes of an item
    // String name; String id; BigDecimal value
    private String name;
    private String id;
    private BigDecimal value;

    //getter method for ID
    public String getId() {
        return id;
    }

    //setter method for ID
    public void setId(String id) {
        //use this.id = id to set id value for instance of this item
        //Set ERROR messages is length of string is not 10 OR
        // if the String does not contain exclusively characters and numbers
        if (id.length() == 10){
            this.id = id;
        } else {
            this.id = "ERROR, Serial Number must be formatted XXXXXXXXXX";
        }
        char idList[] = id.toCharArray();
        for (int i = 0; i < idList.length; i++){
            if (!Character.isLetterOrDigit(idList[i])){
                this.id = "ERROR, Serial Number must only contain Num/Char";
            }
        }
    }

    //getter method for value
    public BigDecimal getValue() {
        return value;
    }

    //setter method for value
    public void setValue(String value) {
        //use this.value = value to set value for instance of this item
        //convert from String to BigDecimal type
        this.value = new BigDecimal(value);
    }

    //getter method for name
    public String getName() {
        return name;
    }

    //setter method for name
    public void setName(String name) {
        //use this.name = name to set name value for instance of this item
        //Set ERROR message if name is not between 2 and 256 characters
        if(name.length() >= 2 && name.length() <= 256){
            this.name = name;
        } else {
            this.name = "ERROR name must be between 2 and 256 characters inclusive";
        }
    }

}
