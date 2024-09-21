package sortingalgorithms;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SortingVisualizer {
    private JFrame f;
    private JPanel sidePanel;
    private JPanel visualList;
    private JButton shuffleList;
    private JButton exit;
    private JButton selectAlg;
    private JButton sort;
    private JComboBox<String> selection;

    public SortingVisualizer() {
        this.f = new JFrame("SORT");
        this.sidePanel = new JPanel();
        this.visualList = new JPanel();
        this.shuffleList = new JButton("SHUFFLE LIST");
        this.exit = new JButton("EXIT");
        this.selectAlg = new JButton("SELECT");
        this.sort = new JButton("SORT");

        String[] options = { "Bubble Sort", "Cocktail Sort" };
        this.selection = new JComboBox<>(options);

        selection.setBounds(20, 50, 120, 30);
        selectAlg.setBounds(20, 90, 120, 50);
        selectAlg.setBackground(Color.LIGHT_GRAY);
        sort.setBounds(20, 160, 120, 50);
        sort.setBackground(Color.GREEN);
        shuffleList.setBounds(20, 230, 120, 50);
        shuffleList.setBackground(Color.LIGHT_GRAY);
        exit.setBounds(20, 940, 120, 50);
        exit.setBackground(Color.RED);

        sidePanel.setBackground(Color.DARK_GRAY);
        sidePanel.setBounds(0, 0, 160, 1080);
        sidePanel.add(selection);
        sidePanel.add(selectAlg);
        sidePanel.add(shuffleList);
        sidePanel.add(exit);
        sidePanel.add(sort);
        sidePanel.setLayout(null);

        visualList.setBackground(Color.BLACK);
        visualList.setBounds(160, 0, 1140, 1080);

        f.add(visualList);
        f.add(sidePanel);
        f.setLayout(null);
        f.setSize(1300, 1080);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
