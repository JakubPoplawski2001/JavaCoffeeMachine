package com.company.Controller;
import com.company.View.IView;
import com.company.Model.Model;


public class Controller {
    private Model model;
    private IView view;

    public Controller(Model selectedModel, IView selectedView){
        model = selectedModel;
        view = selectedView;

        view.setupView(this);
    }

    public String[] getCoffeeMachinesList(){
        String[] array = {"CoffeeMachine", "2", "3", "4"};
        return array;
    }

    public String getSelectedCoffeeMachine(){
        return "selectedCoffeeMachine";
    }

    public void selectCoffeeMachine(String selectedCoffeeMachine){
//        model.selectedCM = model.CMsList[selectedCoffeeMachine];
        System.out.println(selectedCoffeeMachine);
    }

    public int getMaxWaterlvl(){
        // Convert 1L to 1000ml as int
        return (int) (1f * 1000);
    }

    public int getWaterLvl(){
        // Convert 1L to 1000ml
        return (int) (0.35f * 1000);
    }

    public int getMaxMilkLvl(){
        return 1000;
    }

    public int getMilkLvl(){
        return 650;
    }

    public void addWater(){
//        model.addWater
    }

    public void remWater(){
//        model.remWater
    }

    public void addMilk(){

    }

    public void remMilk(){

    }
}
