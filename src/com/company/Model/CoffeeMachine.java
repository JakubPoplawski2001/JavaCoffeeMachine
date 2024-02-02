package com.company.Model;
import com.company.Controller.Controller;
import java.util.HashMap;


public class CoffeeMachine {
    public Controller controller;

    protected final String name = "Coffee Machine";

    protected CoffeeType coffeeType;
    private CoffeeSize coffeeSize;

    private float waterLevel;
    public final float maxWaterLevel = 2.0f;

    private int milkLevel;
    public final int maxMilkLevel = 1000;

    private int milkAmount;
    protected HashMap<CoffeeType, Integer> milkInCoffeeMap;


    public CoffeeMachine(Controller controller){
        this.controller = controller;

        // Setup milk in coffee table
        milkInCoffeeMap = new HashMap<CoffeeType, Integer>();
        milkInCoffeeMap.put(CoffeeType.ESPRESSO, 0);
        milkInCoffeeMap.put(CoffeeType.CAPPUCCINO, 125);
        milkInCoffeeMap.put(CoffeeType.LATTE, 150);
        milkInCoffeeMap.put(CoffeeType.AMERICANO, 0);
        milkInCoffeeMap.put(CoffeeType.FLAT_WHITE, 130);

        // Set values to default
        setCoffeeType(CoffeeType.ESPRESSO);
        setCoffeeSize(CoffeeSize.MEDIUM);

        setWaterLevel(0);
        setMilkLevel(0);
    }


    private void setCoffeeType(CoffeeType type) {
        this.coffeeType = type;
    }

    public CoffeeType getCoffeeType() {
        return this.coffeeType;
    }

    public void nextCoffeeType() {
        int index = (coffeeType.ordinal() + 1) % CoffeeType.values().length;
        setCoffeeType(CoffeeType.values()[index]);
    }

    public void previousCoffeeType() {
        int index = (coffeeType.ordinal() + CoffeeType.values().length - 1) % CoffeeType.values().length;
        setCoffeeType(CoffeeType.values()[index]);
    }

    public void setCoffeeSize(CoffeeSize size) {
        this.coffeeSize = size;
    }

    public CoffeeSize getCoffeeSize() {
        return this.coffeeSize;
    }

    public void setWaterLevel(float waterLevel) {
        // ToDo:
        // Message log for errors
        if (waterLevel > maxWaterLevel){
            controller.logMessage("To much water");
            this.waterLevel = maxWaterLevel;
        }
        else if (waterLevel < 0){
            controller.logMessage("Water tank is empty");
            this.waterLevel = 0;
        }

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

    public int getBaseMilkAmount(){
        return milkInCoffeeMap.get(coffeeType);
    }

    public int getMilkAmount() {
        return milkAmount;
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

    public String getAnalyse() {
        // Implement analyse method
        return "";
    }

    @Override
    public String toString(){
        return name;
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
