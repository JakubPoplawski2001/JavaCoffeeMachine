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
    protected HashMap<CoffeeSize, Float> waterForCoffeeSizeMap;


    public CoffeeMachine(Controller controller){
        this.controller = controller;

        // Setup milk in coffee table
        milkInCoffeeMap = new HashMap<CoffeeType, Integer>();
        milkInCoffeeMap.put(CoffeeType.ESPRESSO, 0);
        milkInCoffeeMap.put(CoffeeType.CAPPUCCINO, 125);
        milkInCoffeeMap.put(CoffeeType.LATTE, 150);
        milkInCoffeeMap.put(CoffeeType.AMERICANO, 0);
        milkInCoffeeMap.put(CoffeeType.FLAT_WHITE, 130);

        waterForCoffeeSizeMap = new HashMap<CoffeeSize, Float>();
        waterForCoffeeSizeMap.put(CoffeeSize.SMALL, 0.12f);
        waterForCoffeeSizeMap.put(CoffeeSize.MEDIUM, 0.3f);
        waterForCoffeeSizeMap.put(CoffeeSize.LARGE, 0.48f);

        // Set values to default
        setCoffeeType(CoffeeType.ESPRESSO);
        setCoffeeSize(CoffeeSize.MEDIUM);

        setWaterLevel(0);
        setMilkLevel(0);
    }


    private void setCoffeeType(CoffeeType type) {
        milkAmount = milkInCoffeeMap.get(type);
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
        if (waterLevel > maxWaterLevel){
            controller.logMessage("To much water");
            this.waterLevel = maxWaterLevel;
            return;
        }
        else if (waterLevel < 0){
            controller.logMessage("Water tank is empty");
            this.waterLevel = 0;
            return;
        }

        this.waterLevel = waterLevel;
    }

    public float getWaterLevel() {
        return this.waterLevel;
    }

    public void addWater(float waterAmount) {
        setWaterLevel(waterLevel+waterAmount);
    }

    public void dispenseWater(float waterAmount) {
        setWaterLevel(waterLevel-waterAmount);
    }

    public void setMilkLevel(int milkLevel) {
        if (milkLevel > maxMilkLevel){
            controller.logMessage("Too much milk");
            this.milkLevel = maxMilkLevel;
            return;
        }
        else if (milkLevel < 0){
            controller.logMessage("Milk container is empty");
            this.milkLevel = 0;
            return;
        }

        this.milkLevel = milkLevel;
    }

    public int getMilkLevel() {
        return this.milkLevel;
    }

    public void addMilk(int milkAmount) {
        setMilkLevel(milkLevel+milkAmount);
    }

    public void dispenseMilk(int milkAmount) {
        setMilkLevel(milkLevel-milkAmount);
    }

    public void increaseMilk() {
        milkAmount += 20;
    }

    public void decreaseMilk() {
        milkAmount -= 20;
        if (milkAmount < 0) {
            milkAmount = 0;
        }
    }

    public int getBaseMilkAmount(){
        return milkInCoffeeMap.get(coffeeType);
    }

    public int getMilkAmount() {
        return milkAmount;
    }

    public void makeCoffee() {
        // Check tank leevels
        if (waterLevel < waterForCoffeeSizeMap.get(coffeeSize)){
            controller.logMessage("Not enought water");
            return;
        }
        if (milkLevel < milkAmount){
            controller.logMessage("Not enought milk");
            return;
        }

        // Dispance resorces
        dispenseWater(waterForCoffeeSizeMap.get(coffeeSize));
        dispenseMilk(milkAmount);

        controller.logMessage("Making your coffee: " + coffeeSize + " " + coffeeType);
        controller.logMessage("Finished. Used: " +
                waterForCoffeeSizeMap.get(coffeeSize) + "L water, " + milkAmount + "ml milk");
    }

    public void showStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coffee Machine: ");
        sb.append(name);
        sb.append('\n');
        sb.append("Coffee Size: ");
        sb.append(coffeeSize);
        sb.append('\n');
        sb.append("Cofee Type: ");
        sb.append(coffeeType);
        sb.append('\n');
        sb.append("Water in coffee: ");
        sb.append(waterForCoffeeSizeMap.get(coffeeSize));
        sb.append('\n');
        sb.append("Milk in coffee: ");
        sb.append(milkAmount);
        sb.append('\n');
        sb.append("Water level in tank: ");
        sb.append(waterLevel);
        sb.append('\n');
        sb.append("Milk level in container: ");
        sb.append(milkLevel);
        sb.append('\n');

        controller.logMessage(sb.toString());
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
