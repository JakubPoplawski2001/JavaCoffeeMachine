package com.company.Model;
import com.company.Controller.Controller;

import java.util.ArrayList;


public class Model {
    public ArrayList<CoffeeMachine> cms = new ArrayList<CoffeeMachine>();
    public CoffeeMachine selectedCm;


    /**
     * !!! Should be called before view setup !!!
     * */
    public void setupModel(Controller controller){
        cms.add(new CoffeeMachine(controller));
        cms.add(new CoffeeMachine(controller));
        selectedCm = cms.get(0);

    }

}
