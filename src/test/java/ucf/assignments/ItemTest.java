package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getId() {
        //given
        Item item = new Item();
        String id = "1234567890";
        //when
        item.setId(id);
        //then
        assertEquals(id, item.getId());
    }

    @Test
    void getValue() {
        //given
        Item item = new Item();
        String value = "12";
        //when
        item.setValue(value);
        //then
        assertEquals(value, item.getValue());
    }

    @Test
    void getName() {
        //given
        Item item = new Item();
        String name = "nothing";
        //when
        item.setName(name);
        //then
        assertEquals(name, item.getName());
    }
}