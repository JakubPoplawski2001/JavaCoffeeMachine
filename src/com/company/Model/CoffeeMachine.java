package com.company.Model;

public class CoffeeMachine {
    // ToDo:
    // Wypisac wszystkie zmienne i metody
    // Implementacja powyzszych

    float waterLevel;
    float maxWaterLevel = 2.0f;

    void setWaterLevel(float newWaterLevel){
        // ToDo:
        // Sprawdzic czy nowy poziom wody miesci sie w zakresie <0, maxWaterLevel>
        waterLevel = newWaterLevel;
    }

    public float getWaterLevel(){
        return waterLevel;
    }

    public void addWater(float waterAmount){
        System.out.println("Dodaj " + waterAmount + " wody.");

        float totalWater = waterLevel + waterAmount;

        // ToDo:
        // Do przemyslenia czy sprawdzamy poprawnosc poziomu wody tutaj czy
        // w metodzie setWaterLevel ?
        if(totalWater <= maxWaterLevel){
            setWaterLevel(totalWater);
        }
        else {
            // WaterOverflow Warning
            System.out.println("Nie mozna dodac tyle wody. Grozi przelaniem zbiornika!");
        }
    }


}
