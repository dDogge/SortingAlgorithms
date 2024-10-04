package sortingalgorithms;

import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class ShellSort implements SortingAlgorithm {
    private List<Integer> list;
    private static SortingVisualizer sv;

    public ShellSort(List<Integer> list, SortingVisualizer sv) {
        this.list = list;
        this.sv = sv;
    }

    @Override
    public void Sort(JPanel visualList) {
        int n = list.size();
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = list.get(i);
                sv.incrementAmountOfEntries(1);
                int j = i;

                sv.incrementAmountOfEntries(1);
                sv.incrementAmountofComparisons(1);
                while (j >= gap && list.get(j - gap) > temp) {
                    sv.incrementAmountofComparisons(1);
                    sv.incrementAmountOfEntries(1);
                    Collections.swap(list, j, j - gap);
                    sv.incrementAmountOfSwaps(1);
                    sv.incrementAmountOfEntries(2);
                    j -= gap;
                    visualList.repaint();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            gap /= 2;
        }
    }

    @Override
    public List<Integer> getList() {
        return list;
    }

}
