package com.company;
import com.company.Model.Model;
import com.company.View.GuiView;
import com.company.Controller.Controller;


public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        GuiView view = new GuiView();
        Controller controller = new Controller(model, view);

    }
}
