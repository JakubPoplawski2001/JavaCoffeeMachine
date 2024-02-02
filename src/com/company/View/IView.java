package com.company.View;
import com.company.Controller.Controller;


public interface IView {

    /**
     * Setup view parameters based on model from controller
     */
    void setupView(Controller controller);

    /**
     * Print message for user
     * */
    void logMessage(String message);
}
