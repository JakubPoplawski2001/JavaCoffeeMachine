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

        setupLevelBar(leftPanel, waterLvl, 0, controller.getMaxWaterlvl(), controller.getWaterLvl(),
                addWaterBtn, remWaterBtn, waterLabel);
        // ToDo:
        // Add ActionLisiners to btns before adding them to panel

//        addWaterBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                controller.addWater();
//                waterLvl.setValue(controller.getWaterLvl());
//            }
//        });
//        remWaterBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                controller.remWater();
//                waterLvl.setValue(controller.getWaterLvl());
//            }
//        });
        setupLevelBar(leftPanel, milkLvl, 0, controller.getMaxMilkLvl(), controller.getMilkLvl(),
                addMilkBtn, remMilkBtn, milkLabel);
//        addMilkBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                controller.addMilk();
//                milkLvl.setValue(controller.getMilkLvl());
//            }
//        });
//        remMilkBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                controller.remMilk();
//                milkLvl.setValue(controller.getMilkLvl());
//                // ToDo:
//                // update labels
//                // create method for this
//            }
//        });

        frame.add(leftPanel, BorderLayout.WEST);
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

    private void setupCenterPanel(){
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // ToDo:
        // Get CoffeeMachine type
        cmLabel = new JLabel("CoffeeMachine");
        cmLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cmLabel.setFont(cmLabel.getFont().deriveFont(20f));

        JPanel coffeeTypePanel = new JPanel();
        coffeeTypePanel.setLayout(new BorderLayout());

        // ToDo:
        // Get CoffeeType
        coffeeTypeLabel = new JLabel("Coffee Type");
        coffeeTypeLabel.setHorizontalAlignment(JLabel.CENTER);
        coffeeTypeLabel.setFont(coffeeTypeLabel.getFont().deriveFont(16f));
        prevCoffeeBtn = new JButton("<");
        nextCoffeeBtn = new JButton(">");

        coffeeTypePanel.add(coffeeTypeLabel, BorderLayout.CENTER);
        coffeeTypePanel.add(prevCoffeeBtn, BorderLayout.WEST);
        coffeeTypePanel.add(nextCoffeeBtn, BorderLayout.EAST);

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

        sizePanel.add(smallBtn);
        sizePanel.add(mediumBtn);
        sizePanel.add(largeBtn);


        // Milk in coffee control
        JPanel milkPanel = new JPanel();
        milkPanel.setLayout(new BoxLayout(milkPanel, BoxLayout.Y_AXIS));
        milkPanel.setBorder(new TitledBorder("Milk in coffee control"));

        // ToDo:
        // Get current coffee default milk lvl and coffee size
        coffeeMilkLvl = new JProgressBar(0, 100);
        coffeeMilkLvl.setValue(50);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 3, 16, 0));

        decreaseCoffeeMilkBtn = new JButton("-");
        increaseCoffeeMilkBtn = new JButton("+");
        resetCoffeeMilkBtn = new JButton("Reset");

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
        analyseBtn = new JButton("Analyse");
        analyseBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
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


}
