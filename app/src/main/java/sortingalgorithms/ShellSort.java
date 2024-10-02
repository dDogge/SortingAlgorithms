package sortingalgorithms;

import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class ShellSort implements SortingAlgorithm {
    List<Integer> list;

    public ShellSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void Sort(JPanel visualList) {
        int n = list.size();
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = list.get(i);
                int j = i;

                while (j >= gap && list.get(j - gap) > temp) {
                    Collections.swap(list, j, j - gap);
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
