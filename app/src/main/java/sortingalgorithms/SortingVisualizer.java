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

public class SortingVisualizer implements ActionListener{
    private Utility util;
    private JFrame f;
    private JPanel sidePanel;
    private JPanel visualList;
    private JButton shuffleList;
    private JButton exit;
    private JButton selectAlg;
    private JButton sort;
    private JComboBox<String> selection;
    List<Integer> list;
    private String selected;

    public SortingVisualizer() {
        this.f = new JFrame("SORT");
        this.sidePanel = new JPanel();
        this.shuffleList = new JButton("SHUFFLE LIST");
        this.exit = new JButton("EXIT");
        this.selectAlg = new JButton("SELECT");
        this.sort = new JButton("SORT");
        this.util = new Utility();

        String[] options = { "Bubble Sort", "Cocktail Sort" };
        this.selection = new JComboBox<>(options);

        util.addObjects(900);
        this.list = util.getObjectList();

        this.visualList = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawArray(g);
            }
        };

        selection.setBounds(20, 50, 120, 30);
        selectAlg.setBounds(20, 90, 120, 50);
        selectAlg.setBackground(Color.LIGHT_GRAY);
        selectAlg.addActionListener(this);
        sort.setBounds(20, 160, 120, 50);
        sort.setBackground(Color.GREEN);
        sort.addActionListener(this);
        shuffleList.setBounds(20, 230, 120, 50);
        shuffleList.setBackground(Color.LIGHT_GRAY);
        shuffleList.addActionListener(this);
        exit.setBounds(20, 830, 120, 50);
        exit.setBackground(Color.RED);
        exit.addActionListener(this);

        sidePanel.setBackground(Color.DARK_GRAY);
        sidePanel.setBounds(0, 0, 160, 900);
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

        if (e.getSource() == exit) {
            System.exit(0);
        }

        if (e.getSource() == selectAlg) {
            selected = (String)selection.getSelectedItem();
            System.out.println(selected);
        }

        if (e.getSource() == sort) {
            new Thread(() -> {
                if (selected.equals("Bubble Sort")) {
                    BubbleSort bs = new BubbleSort(list);
                    bs.Sort(visualList);
                } else if (selected.equals("Cocktail Sort")) {
                    CocktailSort cs = new CocktailSort(list);
                    cs.Sort(visualList);
                }
            }).start(); // Run sorting on a separate thread
        }
    }
}
