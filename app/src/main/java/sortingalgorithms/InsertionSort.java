package sortingalgorithms;

import java.util.List;

import javax.swing.JPanel;

public class InsertionSort implements SortingAlgorithm {
    private List<Integer> list;

    public InsertionSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void Sort(JPanel visualList) {
        int n = list.size();
        int key;

        for (int i = 1; i < n; i++) {
            key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                visualList.repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                j = j - 1;
            }

            list.set(j + 1, key);
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
