package com.company.View;
import javax.swing.*;
import java.awt.*;


public class GuiView {

    private JFrame frame;

    // Menu bar
    private JMenuBar menuBar;
    private JMenu cmMenu;
    private JMenuItem[] coffeeMachines;

    // Left Panel
    private JLabel waterLabel;
    private JProgressBar waterLvl;
    private JButton addWaterBtn;
    private JButton remWaterBtn;

    private JLabel milkLabel;
    private JProgressBar milkLvl;
    private JButton addMilkBtn;
    private JButton remMilkBtn;

    // Center Panel
    private JLabel cmLabel;
    private JLabel coffeeTypeLabel;
    private JButton prevCoffeeBtn;
    private JButton nextCoffeeBtn;

    private JTextArea logArea;

    // Right Panel
    private JButton changeUnitsBtn;
    private JLabel unitsLabel;
    private JLabel sizeLabel;
    private JToggleButton smallBtn;
    private JToggleButton mediumBtn;
    private JToggleButton largeBtn;

    private JLabel coffeeMilkLabel;
    private JProgressBar coffeeMilkLvl;
    private JButton decreaseCoffeeMilkBtn;
    private JButton resetCoffeeMilkBtn;
    private JButton increaseCoffeeMilkBtn;

    private JButton historyBtn;
    private JButton analyseBtn;

    private final int btnSize = 20;

    public GuiView(){
        setupView();

    }

    private void setupView(){
        // Frame
        frame = new JFrame("Coffee Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Menu bar
        menuBar = new JMenuBar();
        cmMenu = new JMenu("Coffee Machine");
        // ToDo:
        // Get list of coffee machines and set up this menu
        cmMenu.add(new JMenuItem("Item 1"));
        cmMenu.add(new JMenuItem("Item 2"));
        cmMenu.add(new JMenuItem("Item 3"));
        cmMenu.add(new JMenuItem("Item 4"));
        menuBar.add(cmMenu);
        frame.setJMenuBar(menuBar);


        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));

        // ToDo:
        // Get max water & milk lvl
        setupLevelBar(leftPanel, waterLvl, 0, 100, 30, addWaterBtn, remWaterBtn, waterLabel);
        setupLevelBar(leftPanel, milkLvl, 0, 100, 70, addMilkBtn, remMilkBtn, milkLabel);

        frame.add(leftPanel, BorderLayout.WEST);


        frame.setSize(720, 480);
        frame.setVisible(true);
    }

    private void setupLevelBar(JPanel parentPanel, JProgressBar progressBar, int min, int max, int current,
                               JButton addBtn, JButton remBtn, JLabel label){
        JPanel vBarPanel = new JPanel();
        vBarPanel.setLayout(new BoxLayout(vBarPanel, BoxLayout.Y_AXIS));
        progressBar = new JProgressBar(SwingConstants.VERTICAL, min, max);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        progressBar.setValue(current);

        addBtn = new JButton("+");
        addBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        remBtn = new JButton("-");
        remBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        label = new JLabel(String.format("lvl: %s", current));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        vBarPanel.add(addBtn);
        vBarPanel.add(progressBar);
        vBarPanel.add(remBtn);
        vBarPanel.add(label);
        parentPanel.add(vBarPanel);
    }

}
