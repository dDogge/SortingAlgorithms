package sortingalgorithms;

import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class SelectionSort implements SortingAlgorithm {
    private List<Integer> list;
    private static SortingVisualizer sv;

    public SelectionSort(List<Integer> list, SortingVisualizer sv) {
        this.list = list;
        this.sv = sv;
    }

    @Override
    public void Sort(JPanel visualList) {
        int n = list.size();

        for (int i = 0; i < (n - 1); i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                sv.incrementAmountofComparisons(1);
                sv.incrementAmountOfEntries(2);
                if (list.get(j) < list.get(min)) {
                    min = j;
                }
            }

            if (min != i) {
                Collections.swap(list, i, min);
                sv.incrementAmountOfSwaps(1);
                sv.incrementAmountOfEntries(2);
                visualList.repaint();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Integer> getList() {
        return list;
    }

}
