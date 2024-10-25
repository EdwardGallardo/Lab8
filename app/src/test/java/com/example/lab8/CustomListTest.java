package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }


    /**
     * creates a list with two cities initialized in it already
     * and test if both cities are contained in it
     * then adds a new city and tests if it is contained in the list
     * then test if a new city object with identical field values is contained in the list already
     */
    @Test
    public void hasCityTest() {
        // creating a CustomList with two cities in ArrayList argument in the constructor call
        City city_1 = new City("Edmonton", "Alberta");
        City city_2 = new City("Toronto", "Ontario");
        ArrayList<City> cityArrayList = new ArrayList<City>();
        cityArrayList.add(city_1);
        cityArrayList.add(city_2);
        list = new CustomList(null, cityArrayList);
        // testing if both cities are contained in the list
        assertTrue(list.hasCity(city_1));
        assertTrue(list.hasCity(city_2));
        // adding another city and testing if it is contained in the list
        City city_3 = new City("Vancouver", "British Columbia");
        list.addCity(city_3);
        assertTrue(list.hasCity(city_3));
        // creating another city object with identical fields as another city that is already
        // contained in the list and testing if it is contained in the list already
        City city_4 = new City("Edmonton", "Alberta");
        assertTrue(list.hasCity(city_4));
    }

    /**
     * creates a list with two cities initialized in it already
     * then checks if one city is already contained in the list
     * then it deletes the same city and checks if it is not contained in the list anymore
     */
    @Test
    public void deleteCityTest() {
        // creating a CustomList with two cities in ArrayList argument in the constructor call
        City city_1 = new City("Edmonton", "Alberta");
        City city_2 = new City("Toronto", "Ontario");
        ArrayList<City> cityArrayList = new ArrayList<City>();
        cityArrayList.add(city_1);
        cityArrayList.add(city_2);
        list = new CustomList(null, cityArrayList);
        // checking if city is contained in the list
        assertTrue(list.hasCity(city_1));
        // deleting the city
        list.deleteCity(city_1);
        // checking if city is not contained in the list anymore
        assertFalse(list.hasCity(city_1));
    }

    /** creates a list with two cities initialized in it already
     * then checks how many cities are in it
     * then adds a city and checks how many cities are in it
     * then deletes 2 cities and checks how many cities are in it
     */
    @Test
    public void countCitiesTest() {
        // creating a CustomList with two cities in ArrayList argument in the constructor call
        City city_1 = new City("Edmonton", "Alberta");
        City city_2 = new City("Toronto", "Ontario");
        ArrayList<City> cityArrayList = new ArrayList<City>();
        cityArrayList.add(city_1);
        cityArrayList.add(city_2);
        list = new CustomList(null, cityArrayList);
        // checking if countCities() returns 2
        int listSize = list.countCities();
        assertEquals(2, listSize);
        // adding a new city
        City city_3 = new City("Vancouver", "British Columbia"))
        list.addCity(city_3);
        // checking new count
        assertEquals(3, list.countCities());
        // deleting two cities
        list.deleteCity(city_1);
        list.deleteCity(city_3);
        // checking new count
        assertEquals(1, list.countCities());
    }
}
