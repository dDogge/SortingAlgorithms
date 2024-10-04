package sortingalgorithms;

import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class BogoSort implements SortingAlgorithm {
    private List<Integer> list;
    private static SortingVisualizer sv;

    public BogoSort(List<Integer> list, SortingVisualizer sv) {
        this.list = list;
        this.sv = sv;
    }

    @Override
    public void Sort(JPanel visualList) {
        int n = list.size();
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < n - 1; i++) {
                sv.incrementAmountOfEntries(2);
                sv.incrementAmountofComparisons(1);
                if (list.get(i) > list.get(i + 1)) {
                    isSorted = false;
                    break;
                }
            }

            if (!isSorted) {
                visualList.repaint();
                Collections.shuffle(list);
                try {
                    Thread.sleep(1);
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
