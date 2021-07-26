/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Nicholas Viggiani
 */
package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    void getList() {
        //given
        List actual = new List();
        ArrayList<Item> expected = new ArrayList();
        Item item = new Item();
        //when
        actual.addItem(item);
        expected.add(item);
        //then
        assertEquals(expected, actual.getList()) ;
    }

    @Test
    void getSize() {
        //given
        List actual = new List();
        ArrayList<Item> expected = new ArrayList<>();
        Item item1 = new Item();
        Item item2 = new Item();
        //when
        actual.addItem(item1);
        actual.addItem(item2);
        expected.add(item1);
        expected.add(item2);
        //then
        assertEquals(expected.size(), actual.getSize());
    }

    @Test
    void getItem() {
        //given
        List actual = new List();
        ArrayList<Item> expected = new ArrayList<>();
        Item item1 = new Item();
        Item item2 = new Item();
        item1.setName("item1");
        item1.setValue("1");
        item1.setId("1111111111");
        item2.setName("Joe");
        item2.setValue("12");
        item2.setId("JOESUPERIO");
        //when
        actual.addItem(item1);
        actual.addItem(item2);
        expected.add(item1);
        expected.add(item2);
        //then
        assertEquals(expected.get(0), actual.getItem(0));
    }

    @Test
    void getIDs() {
        //given
        List actual = new List();
        ArrayList<String> expected = new ArrayList<>();
        Item item1 = new Item();
        Item item2 = new Item();
        item1.setName("item1");
        item1.setValue("1");
        item1.setId("1111111111");
        item2.setName("Joe");
        item2.setValue("12");
        item2.setId("JOESUPERIO");
        //when
        actual.addItem(item1);
        actual.addItem(item2);
        expected.add("1111111111");
        expected.add("JOESUPERIO");
        //then
        assertEquals(expected, actual.getIDs());
    }
}