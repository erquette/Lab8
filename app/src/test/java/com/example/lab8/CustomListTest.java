package com.example.lab8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testCountCities() {
        CustomList list = new CustomList(null, cityList);
        assertEquals(0, list.countCities());

        City city = new City("Winnipeg", "MB");
        list.addCity(city);
        assertEquals(1, list.countCities());

        City city2 = new City("Toronto", "ON");
        list.addCity(city2);
        assertEquals(2, list.countCities());

        list.deleteCity(city);
        assertEquals(1, list.countCities());
    }
}
