package sortingalgorithms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SortingVisualizer implements ActionListener {
    private Utility util;
    private JFrame f;
    private JPanel sidePanel;
    private JPanel visualList;
    private JButton shuffleList;
    private JButton exit;
    private JButton selectAlg;
    private JButton selectAmount;
    private JButton sort;
    private JComboBox<String> selection;
    private JComboBox<String> amount;
    List<Integer> list;
    private String selected;
    private int amountOfSwaps, amountOfEntries, amountOfComparisons;

    public SortingVisualizer() {
        amountOfSwaps = amountOfEntries = amountOfComparisons = 0;
        this.f = new JFrame("SORT");
        this.sidePanel = new JPanel();
        this.shuffleList = new JButton("SHUFFLE LIST");
        this.exit = new JButton("EXIT");
        this.selectAlg = new JButton("SELECT");
        this.sort = new JButton("SORT");
        this.selectAmount = new JButton("SELECT");
        this.util = new Utility();

        String[] placeHolders = {
                "10", "100", "150", "200", "250", "300",
                "350", "400", "450", "500", "550",
                "600", "650", "700", "750", "800",
                "850", "900"
        };
        this.amount = new JComboBox<>(placeHolders);
        String[] options = {
                "Bubble Sort", "Cocktail Sort", "Selection Sort",
                "Insertion Sort", "Merge Sort", "Bucket Sort",
                "Quick Sort", "Shell Sort", "Bogo Sort",
        };
        this.selection = new JComboBox<>(options);

        util.addObjects(300);
        this.list = util.getObjectList();

        this.visualList = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawArray(g);
            }
        };

        selection.setBounds(20, 20, 120, 30);
        selectAlg.setBounds(20, 50, 120, 50);
        selectAlg.setBackground(Color.LIGHT_GRAY);
        selectAlg.addActionListener(this);
        amount.setBounds(20, 120, 120, 30);
        selectAmount.setBounds(20, 150, 120, 50);
        selectAmount.setBackground(Color.LIGHT_GRAY);
        selectAmount.addActionListener(this);
        sort.setBounds(20, 220, 120, 50);
        sort.setBackground(Color.GREEN);
        sort.addActionListener(this);
        shuffleList.setBounds(20, 290, 120, 50);
        shuffleList.setBackground(Color.LIGHT_GRAY);
        shuffleList.addActionListener(this);
        exit.setBounds(20, 830, 120, 50);
        exit.setBackground(Color.RED);
        exit.addActionListener(this);

        sidePanel.setBackground(Color.DARK_GRAY);
        sidePanel.setBounds(0, 0, 160, 900);
        sidePanel.add(amount);
        sidePanel.add(selectAmount);
        sidePanel.add(selection);
        sidePanel.add(selectAlg);
        sidePanel.add(shuffleList);
        sidePanel.add(exit);
        sidePanel.add(sort);
        sidePanel.setLayout(null);

        visualList.setBackground(Color.BLACK);
        visualList.setBounds(160, 0, 901, 900);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(visualList);
        f.add(sidePanel);
        f.setLayout(null);
        f.setSize(1061, 900);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void drawArray(Graphics g) {
        int startX = 1;
        int width = 1;
        int height = visualList.getHeight();

        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            int barHeight = value;
            int x = startX + i;
            int y = height - barHeight;

            g.setColor(Color.GREEN);
            g.fillRect(x, y, width, barHeight);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shuffleList) {
            util.shuffleList();
            list = util.getObjectList();
            visualList.repaint();
        }

        if (e.getSource() == selectAmount) {
            int size = Integer.parseInt((String) amount.getSelectedItem());
            util.emptyList();
            util.addObjects(size);
            list = util.getObjectList();
            visualList.repaint();
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }

        if (e.getSource() == selectAlg) {
            selected = (String) selection.getSelectedItem();
            System.out.println(selected);
        }

        if (e.getSource() == sort) {
            new Thread(() -> {
                shuffleList.setEnabled(false);
                selectAmount.setEnabled(false);
                selectAlg.setEnabled(false);
                if (selected.equals("Bubble Sort")) {
                    BubbleSort bs = new BubbleSort(list);
                    bs.Sort(visualList);

                } else if (selected.equals("Cocktail Sort")) {
                    CocktailSort cs = new CocktailSort(list);
                    cs.Sort(visualList);

                } else if (selected.equals("Selection Sort")) {
                    SelectionSort ss = new SelectionSort(list);
                    ss.Sort(visualList);

                } else if (selected.equals("Insertion Sort")) {
                    InsertionSort is = new InsertionSort(list);
                    is.Sort(visualList);

                } else if (selected.equals("Bogo Sort")) {
                    BogoSort bs = new BogoSort(list);
                    bs.Sort(visualList);

                } else if (selected.equals("Merge Sort")) {
                    MergeSort ms = new MergeSort(list);
                    ms.Sort(visualList);

                } else if (selected.equals("Quick Sort")) {
                    QuickSort qs = new QuickSort(list);
                    qs.Sort(visualList);

                } else if (selected.equals("Bucket Sort")) {
                    BucketSort bs = new BucketSort(list);
                    bs.Sort(visualList);

                } else if (selected.equals("Shell Sort")) {
                    ShellSort ss = new ShellSort(list);
                    ss.Sort(visualList);
                }
                shuffleList.setEnabled(true);
                selectAmount.setEnabled(true);
                selectAlg.setEnabled(true);
            }).start(); // Run sorting on a separate thread
        }
    }

    public void incrementAmountOfSwaps() {

    }

    public void incrementAmountOfEntries() {

    }

    public void incrementAmountofComparisons() {
        
    }

}
