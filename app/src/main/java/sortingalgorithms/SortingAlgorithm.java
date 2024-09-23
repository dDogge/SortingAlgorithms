package sortingalgorithms;

import java.util.List;

import javax.swing.JPanel;

public interface SortingAlgorithm {
    
    void Sort(JPanel visualList);

    List<Integer> getList();
}
