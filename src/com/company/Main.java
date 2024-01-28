package com.company;
import com.company.Model.CoffeeMachine;
import com.company.View.GuiView;


public class Main {

    public static void main(String[] args) {
        // W tym miejscu aplikacja startuje

         // ToDo:
         // Stworzenie ekspresow do kawy
         // Uruchomienie aplikacji

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        System.out.println("Water lvl: " + coffeeMachine.getWaterLevel());
        coffeeMachine.addWater(3.0f);
        System.out.println("Water lvl: " + coffeeMachine.getWaterLevel());
        coffeeMachine.addWater(1.0f);
        System.out.println("Water lvl: " + coffeeMachine.getWaterLevel());


        GuiView view = new GuiView();
    }
}
