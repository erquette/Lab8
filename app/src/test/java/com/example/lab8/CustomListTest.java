package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;

public class CustomListTest {
    private ArrayList<City> cityList = new ArrayList<>();

    @Test
    public void testAddCity() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertEquals(1, list.getCount());
    }

    @Test
    public void testHasCity() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Calgary", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city));

        City secondCity = new City("Vancouver", "BC");
        assertFalse(list.hasCity(secondCity));
    }

    @Test
    public void testDeleteCity() {
        CustomList list = new CustomList(null, cityList);
        City newCity = new City("Montreal", "QC");
        list.addCity(newCity);
        assertTrue(list.hasCity(newCity));
        list.deleteCity(newCity);
        assertFalse(list.hasCity(newCity));

        assertThrows(IllegalArgumentException.class, ()-> {
            list.deleteCity(new City("Saskatoon", "SK"));
        });
    }
}
