package sortingalgorithms;

import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class SelectionSort implements SortingAlgorithm {
    List<Integer> list;

    public SelectionSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void Sort(JPanel visualList) {
        int n = list.size();

        for (int i = 0; i < (n - 1); i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(min)) {
                    min = j;
                }
            }

            if (min != i) {
                Collections.swap(list, i, min);
                visualList.repaint();
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
