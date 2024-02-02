package com.company.Model;
import java.util.HashMap;


public class CoffeeMachine {

    protected CoffeeType coffeeType;
    private CoffeeSize coffeeSize;

    private float waterLevel;
    public final float maxWaterLevel = 2.0f;

    private int milkLevel;
    public final int maxMilkLevel = 1000;

    protected HashMap<CoffeeType, Integer> milkInCoffeeMap;


    public CoffeeMachine(){

        // Setup milk in coffee table
        milkInCoffeeMap = new HashMap<CoffeeType, Integer>();
        milkInCoffeeMap.put(CoffeeType.ESPRESSO, 0);
        milkInCoffeeMap.put(CoffeeType.CAPPUCCINO, 125);
        milkInCoffeeMap.put(CoffeeType.LATTE, 150);
        milkInCoffeeMap.put(CoffeeType.AMERICANO, 0);
        milkInCoffeeMap.put(CoffeeType.FLAT_WHITE, 130);

        setCoffeeType(CoffeeType.ESPRESSO);
        setCoffeeSize(CoffeeSize.MEDIUM);
    }


    private void setCoffeeType(CoffeeType type) {
        this.coffeeType = type;
    }

    public CoffeeType getCoffeeType() {
        return this.coffeeType;
    }

    public void nextCoffeeType() {
        // Implement nextCoffeeType method
    }

    public void previousCoffeeType() {
        // Implement previousCoffeeType method
    }

    public void setCoffeeSize(CoffeeSize size) {
        this.coffeeSize = size;
    }

    public CoffeeSize getCoffeeSize() {
        return this.coffeeSize;
    }

    public void setWaterLevel(float waterLevel) {
        // ToDo:
        // Sprawdzic czy nowy poziom wody miesci sie w zakresie <0, maxWaterLevel>
        this.waterLevel = waterLevel;
    }

    public float getWaterLevel() {
        return this.waterLevel;
    }

    public void addWater(float waterAmount) {
        // Implement addWater method
    }

    public void dispenseWater(float waterAmount) {
        // Implement dispenseWater method
    }

    public void setMilkLevel(int milkLevel) {
        this.milkLevel = milkLevel;
    }

    public int getMilkLevel() {
        return this.milkLevel;
    }

    public void addMilk(int milkAmount) {
        // Implement addMilk method
    }

    public void dispenseMilk(int milkAmount) {
        // Implement dispenseMilk method
    }

    public void increaseMilk() {
        // Implement increaseMilk method
    }

    public void decreaseMilk() {
        // Implement decreaseMilk method
    }

    public int getMilkAmount() {
        // Implement getMilkAmount method
        return 0;
    }

    public void makeCoffee() {
        // Implement makeCoffee method
    }

    public void showStatus() {
        // Implement showStatus method
    }

    public String getRecentCoffeeHistory() {
        // Implement getRecentCoffeeHistory method
        return "";
    }

    public void analyse() {
        // Implement analyse method
    }

    public enum CoffeeType{
        ESPRESSO,
        CAPPUCCINO,
        LATTE,
        AMERICANO,
        FLAT_WHITE
    }

    public enum CoffeeSize{
        SMALL,
        MEDIUM,
        LARGE
    }

}
