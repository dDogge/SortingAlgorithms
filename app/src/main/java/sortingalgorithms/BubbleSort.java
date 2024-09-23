package sortingalgorithms;

import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class BubbleSort implements SortingAlgorithm {
    private List<Integer> list;

    public BubbleSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void Sort(JPanel visualList) {
        int n = list.size();
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < n - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i + 1);
                    visualList.repaint();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    @Override
    public List<Integer> getList() {
        return list;
    }
}
