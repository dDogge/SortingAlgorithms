package sortingalgorithms;

import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class HeapSort implements SortingAlgorithm {
    private List<Integer> list;
    private static SortingVisualizer sv;

    public HeapSort(List<Integer> list, SortingVisualizer sv) {
        this.list = list;
        this.sv = sv;
    }

    @Override
    public void Sort(JPanel visualList) {
        int n = list.size();

        for (int i = n/2 - 1; i >= 0; i--) {
            heapSort(visualList, list, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            Collections.swap(list, 0, i);
            sv.incrementAmountOfSwaps(1);
            sv.incrementAmountOfEntries(2);
            visualList.repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            heapSort(visualList, list, i, 0);
        }
    }

    private void heapSort(JPanel visualList, List<Integer> list, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        sv.incrementAmountOfEntries(2);
        sv.incrementAmountofComparisons(1);
        if (left < n && list.get(left) > list.get(largest)) {
            largest = left;
        }

        sv.incrementAmountOfEntries(2);
        sv.incrementAmountofComparisons(1);
        if (right < n && list.get(right) > list.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            Collections.swap(list, i, largest);
            sv.incrementAmountOfSwaps(1);
            sv.incrementAmountOfEntries(2);
            visualList.repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            heapSort(visualList, list, n, largest);
        }
    }

    @Override
    public List<Integer> getList() {
        return list;
    }
    
}
