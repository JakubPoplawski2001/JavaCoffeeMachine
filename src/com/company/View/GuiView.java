package com.company.View;
import com.company.Controller.Controller;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiView implements IView{
    public Controller controller;

    private JFrame frame;

    // Menu Bar
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
    private JButton makeCoffeeBtn;

    private JTextArea logArea;

    // Right Panel
    private JToggleButton smallBtn;
    private JToggleButton mediumBtn;
    private JToggleButton largeBtn;

    private JProgressBar coffeeMilkLvl;
    private JButton decreaseCoffeeMilkBtn;
    private JButton resetCoffeeMilkBtn;
    private JButton increaseCoffeeMilkBtn;

    private JButton historyBtn;
    private JButton analyseBtn;
    private JButton changeUnitsBtn;
    private JLabel unitsLabel;


    public GuiView(){

    }

    @Override
    public void setupView(Controller controller){
        this.controller = controller;

        // Frame
        frame = new JFrame("Coffee Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        setupMenuBar();
        setupLeftPanel();
        setupCenterPanel();
        setupRightPanel();

        frame.setSize(720, 480);
        frame.setVisible(true);
    }

    private void setupMenuBar(){
        menuBar = new JMenuBar();
        cmMenu = new JMenu(controller.getSelectedCoffeeMachine());

        // Add menu items for each coffee machine type
        String[] cms = controller.getCoffeeMachinesList();
        for (final String cm : cms) {
            JMenuItem menuItem = new JMenuItem(cm);

            // Set action on click
            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.selectCoffeeMachine(cm);
                    cmMenu.setText(cm);
                    cmLabel.setText(cm);
                }
            });

            cmMenu.add(menuItem);
        }

        menuBar.add(cmMenu);
        frame.setJMenuBar(menuBar);
    }

    private void setupLeftPanel(){
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));


        // Water lvl bar
        ActionListener addWAL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.addWater();
                waterLvl.setValue(controller.getWaterLvl());
            }
        };
        ActionListener remWAL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.remWater();
                waterLvl.setValue(controller.getWaterLvl());
            }
        };

        JPanel vBarPanel = new JPanel();
        vBarPanel.setLayout(new BoxLayout(vBarPanel, BoxLayout.Y_AXIS));
        waterLvl = new JProgressBar(SwingConstants.VERTICAL, 0, controller.getMaxWaterLvl());
        waterLvl.setAlignmentX(Component.CENTER_ALIGNMENT);
        waterLvl.setValue(controller.getWaterLvl());

        addWaterBtn = new JButton("+");
        addWaterBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        addWaterBtn.addActionListener(addWAL);

        remWaterBtn = new JButton("-");
        remWaterBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        remWaterBtn.addActionListener(remWAL);

        waterLabel = new JLabel(String.format("lvl: %s", controller.getWaterLvl()));
        waterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        vBarPanel.add(addWaterBtn);
        vBarPanel.add(waterLvl);
        vBarPanel.add(remWaterBtn);
        vBarPanel.add(waterLabel);
        leftPanel.add(vBarPanel);


        // Milk lvl bar
        ActionListener addMAL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.addMilk();
                milkLvl.setValue(controller.getMilkLvl());
            }
        };
        ActionListener remMAL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.remMilk();
                milkLvl.setValue(controller.getMilkLvl());
                // ToDo:
                // update labels
                // create method for this
            }
        };

        JPanel vBarPanel2 = new JPanel();
        vBarPanel2.setLayout(new BoxLayout(vBarPanel2, BoxLayout.Y_AXIS));
        milkLvl = new JProgressBar(SwingConstants.VERTICAL, 0, controller.getMaxMilkLvl());
        milkLvl.setAlignmentX(Component.CENTER_ALIGNMENT);
        milkLvl.setValue(controller.getMilkLvl());

        addMilkBtn = new JButton("+");
        addMilkBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        addMilkBtn.addActionListener(addMAL);

        remMilkBtn = new JButton("-");
        remMilkBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        remMilkBtn.addActionListener(remMAL);

        milkLabel = new JLabel(String.format("lvl: %s", controller.getMilkLvl()));
        milkLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        vBarPanel2.add(addMilkBtn);
        vBarPanel2.add(milkLvl);
        vBarPanel2.add(remMilkBtn);
        vBarPanel2.add(milkLabel);
        leftPanel.add(vBarPanel2);


        frame.add(leftPanel, BorderLayout.WEST);
    }

    private void setupCenterPanel(){
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        cmLabel = new JLabel(controller.getSelectedCoffeeMachine());
        cmLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cmLabel.setFont(cmLabel.getFont().deriveFont(20f));

        JPanel coffeeTypePanel = new JPanel();
        coffeeTypePanel.setLayout(new BorderLayout());

        // ToDo:
        // Get CoffeeType
        coffeeTypeLabel = new JLabel(controller.getCoffeeType());
        coffeeTypeLabel.setHorizontalAlignment(JLabel.CENTER);
        coffeeTypeLabel.setFont(coffeeTypeLabel.getFont().deriveFont(16f));
        prevCoffeeBtn = new JButton("<");
        prevCoffeeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.previousCoffeeType();
                coffeeTypeLabel.setText(controller.getCoffeeType());
            }
        });

        nextCoffeeBtn = new JButton(">");
        nextCoffeeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.nextCoffeeType();
                coffeeTypeLabel.setText(controller.getCoffeeType());
            }
        });

        makeCoffeeBtn = new JButton("Make Coffee");
        makeCoffeeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.makeCoffee();
                updateUI();
            }
        });

        coffeeTypePanel.add(coffeeTypeLabel, BorderLayout.CENTER);
        coffeeTypePanel.add(prevCoffeeBtn, BorderLayout.WEST);
        coffeeTypePanel.add(nextCoffeeBtn, BorderLayout.EAST);
        coffeeTypePanel.add(makeCoffeeBtn, BorderLayout.SOUTH);

        logArea = new JTextArea("Hello World!");
        logArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        logArea.setBorder(new TitledBorder("Message Log"));
        logArea.setEditable(false);
        logArea.setLineWrap(true);

        centerPanel.add(cmLabel);
        centerPanel.add(coffeeTypePanel);
        centerPanel.add(logArea);

        frame.add(centerPanel, BorderLayout.CENTER);
    }

    private void setupRightPanel(){
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));


        // Size
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new GridLayout(1, 3, 8, 0));
        sizePanel.setBorder(new TitledBorder("Size"));

        smallBtn = new JToggleButton("S");
        mediumBtn = new JToggleButton("M");
        mediumBtn.setSelected(true);
        largeBtn = new JToggleButton("L");

        smallBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.setCoffeeSize("S");

                smallBtn.setSelected(true);
                mediumBtn.setSelected(false);
                largeBtn.setSelected(false);
            }
        });
        mediumBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.setCoffeeSize("M");

                smallBtn.setSelected(false);
                mediumBtn.setSelected(true);
                largeBtn.setSelected(false);
            }
        });
        largeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.setCoffeeSize("L");

                smallBtn.setSelected(false);
                mediumBtn.setSelected(false);
                largeBtn.setSelected(true);
            }
        });

        sizePanel.add(smallBtn);
        sizePanel.add(mediumBtn);
        sizePanel.add(largeBtn);


        // Milk in coffee control
        JPanel milkPanel = new JPanel();
        milkPanel.setLayout(new BoxLayout(milkPanel, BoxLayout.Y_AXIS));
        milkPanel.setBorder(new TitledBorder("Milk in coffee control"));

        // ToDo:
        // Get current coffee default milk lvl and coffee size
        coffeeMilkLvl = new JProgressBar(0, 2 * controller.getCoffeeMilk());
        coffeeMilkLvl.setValue(controller.getCoffeeMilk());

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 3, 16, 0));

        decreaseCoffeeMilkBtn = new JButton("-");
        decreaseCoffeeMilkBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.decreaseCoffeeMilk();

                coffeeMilkLvl.setValue(controller.getCoffeeMilk());
            }
        });

        increaseCoffeeMilkBtn = new JButton("+");
        increaseCoffeeMilkBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.increaseCoffeeMilk();

                coffeeMilkLvl.setValue(controller.getCoffeeMilk());
            }
        });

        // ToDo:
        // implement reset milk amount methods
        resetCoffeeMilkBtn = new JButton("Reset");
        resetCoffeeMilkBtn.setEnabled(false);

        btnPanel.add(decreaseCoffeeMilkBtn);
        btnPanel.add(resetCoffeeMilkBtn);
        btnPanel.add(increaseCoffeeMilkBtn);

        milkPanel.add(coffeeMilkLvl);
        milkPanel.add(btnPanel);


        // AddOns
        JPanel addonsPanel = new JPanel();
        addonsPanel.setLayout(new BoxLayout(addonsPanel, BoxLayout.Y_AXIS));

        historyBtn = new JButton("History");
        historyBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        historyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.history();
            }
        });

        analyseBtn = new JButton("Analyse");
        analyseBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        analyseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.analyse();
            }
        });

        changeUnitsBtn = new JButton("Change Units");
        changeUnitsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        // ToDo:
        // if (coffeeMachine is ...) btn.setEnable(true); else {
        changeUnitsBtn.setEnabled(false);

        addonsPanel.add(historyBtn);
        addonsPanel.add(analyseBtn);
        addonsPanel.add(changeUnitsBtn);


        rightPanel.add(sizePanel);
        rightPanel.add(milkPanel);
        rightPanel.add(addonsPanel);

        frame.add(rightPanel, BorderLayout.EAST);
    }

    private void updateUI(){
        // ToDo:
        // if any property has change update values of that property


    }

    @Override
    public void logMessage(String message){
        String previousText = logArea.getText();
        logArea.setText(previousText + message);
    }


}
