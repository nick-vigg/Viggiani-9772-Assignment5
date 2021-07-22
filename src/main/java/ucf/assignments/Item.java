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
        this.id = id;
    }

    //getter method for value
    public BigDecimal getValue() {
        return value;
    }

    //setter method for value
    public void setValue(BigDecimal value) {
        //use this.value = value to set value for instance of this item
        this.value = value;
    }

    //getter method for name
    public String getName() {
        return name;
    }

    //setter method for name
    public void setName(String name) {
        //use this.name = name to set name value for instance of this item
        this.name = name;
    }

}
