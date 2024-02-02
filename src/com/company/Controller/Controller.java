package com.company.Controller;
import com.company.Model.CoffeeMachine;
import com.company.View.IView;
import com.company.Model.Model;
import java.util.ArrayList;


public class Controller {
    private Model model;
    private IView view;

    public Controller(Model selectedModel, IView selectedView){
        model = selectedModel;
        view = selectedView;

        // model setup should be called before view setup
        model.setupModel(this);
        view.setupView(this);
    }

    public String[] getCoffeeMachinesList(){
        ArrayList<String> tmp = new ArrayList<String>();

        for (CoffeeMachine cm : model.cms) {
            tmp.add(cm.toString());
        }
        String[] result = tmp.toArray(new String[tmp.size()]);

        return result;
    }

    public String getSelectedCoffeeMachine(){
        return model.selectedCm.toString();
    }

    public void selectCoffeeMachine(String selectedCoffeeMachine){
        // Skip selecting same CoffeeMachine multiple times
        if (model.selectedCm.toString() == selectedCoffeeMachine){
            return;
        }

        for (CoffeeMachine cm : model.cms) {
            if (cm.toString() == selectedCoffeeMachine){
                model.selectedCm = cm;
                return;
            }
        }

        // Error
        logMessage("Error can't find selected CoffeeMachine");
        }

    public int getMaxWaterLvl(){
        // Convert 1L to 1000ml as int
        return (int) (model.selectedCm.maxWaterLevel * 1000);
    }

    public int getWaterLvl(){
        // Convert 1L to 1000ml
        return (int) (model.selectedCm.getWaterLevel() * 1000);
    }

    public int getMaxMilkLvl(){
        return model.selectedCm.maxMilkLevel;
    }

    public int getMilkLvl(){
        return model.selectedCm.getMilkLevel();
    }

    public void addWater(){
//        model.addWater
        System.out.println("Water added");
    }

    public void remWater(){
//        model.remWater
        System.out.println("Water removed");
    }

    public void addMilk(){
        System.out.println("Milk added");
    }

    public void remMilk(){
        System.out.println("Milk removed");
    }

    public String getCoffeeType(){
        return model.selectedCm.getCoffeeType().toString();
    }

    public void previousCoffeeType(){
        model.selectedCm.previousCoffeeType();
    }

    public void nextCoffeeType(){
        model.selectedCm.nextCoffeeType();
    }

    public void makeCoffee(){
        model.selectedCm.makeCoffee();
    }

    public void logMessage(String message){
        view.logMessage(message);
    }

    public void setCoffeeSize(String size){
        if (size == "S"){
            model.selectedCm.setCoffeeSize(CoffeeMachine.CoffeeSize.SMALL);
        }
        else if (size == "M"){
            model.selectedCm.setCoffeeSize(CoffeeMachine.CoffeeSize.MEDIUM);
        }
        else if (size == "L"){
            model.selectedCm.setCoffeeSize(CoffeeMachine.CoffeeSize.LARGE);
        }
        else {
            // Error
            logMessage("Error");
        }
    }

    public int getCoffeeMilk(){
        return model.selectedCm.getMilkAmount();
    }

    public void decreaseCoffeeMilk(){
        model.selectedCm.decreaseMilk();
    }

    public void increaseCoffeeMilk(){
        model.selectedCm.increaseMilk();
    }

    public void history(){
        logMessage(model.selectedCm.getRecentCoffeeHistory());
    }

    public void analyse(){
        logMessage(model.selectedCm.getAnalyse());
    }

    public void chamgeUnitEnabled(){
        // ToDo:
        // Change units on machine
    }

    public void changeUnits(){

    }
}
