package sortingalgorithms;

import java.util.List;

import javax.swing.JPanel;

public class InsertionSort implements SortingAlgorithm {
    private List<Integer> list;
    private static SortingVisualizer sv;

    public InsertionSort(List<Integer> list, SortingVisualizer sv) {
        this.list = list;
        this.sv = sv;
    }

    @Override
    public void Sort(JPanel visualList) {
        int n = list.size();
        int key;

        for (int i = 1; i < n; i++) {
            sv.incrementAmountOfEntries(1);
            key = list.get(i);
            int j = i - 1;

            sv.incrementAmountOfEntries(1);
            sv.incrementAmountofComparisons(1);
            while (j >= 0 && list.get(j) > key) {
                sv.incrementAmountOfEntries(1);
                sv.incrementAmountofComparisons(1);
                list.set(j + 1, list.get(j));
                sv.incrementAmountOfSwaps(1);
                sv.incrementAmountOfEntries(1);
                visualList.repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                j = j - 1;
            }

            list.set(j + 1, key);
            sv.incrementAmountOfSwaps(1);
            sv.incrementAmountOfEntries(1);
            visualList.repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Integer> getList() {
        return list;
    }

}
