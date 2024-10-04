package sortingalgorithms;

import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class QuickSort implements SortingAlgorithm {
    private List<Integer> list;
    private static SortingVisualizer sv;

    public QuickSort(List<Integer> list, SortingVisualizer sv) {
        this.list = list;
        this.sv = sv;
    }

    @Override
    public void Sort(JPanel visualList) {
        quickSort(list, visualList, 0, list.size() - 1);
    }

    private static void quickSort(List<Integer> list, JPanel visualList, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, visualList, low, high);
            quickSort(list, visualList, low, pivotIndex - 1);
            quickSort(list, visualList, pivotIndex + 1, high);
        }
    }

    private static int partition(List<Integer> list, JPanel visualList, int low, int high) {
        int pivot = list.get(high);
        sv.incrementAmountOfEntries(1);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            sv.incrementAmountOfEntries(1);
            sv.incrementAmountofComparisons(1);
            if (list.get(j) < pivot) {
                i++;
                Collections.swap(list, i, j);
                sv.incrementAmountOfSwaps(1);
                sv.incrementAmountOfEntries(2);
                visualList.repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Collections.swap(list, i + 1, high);
        sv.incrementAmountOfSwaps(1);
        sv.incrementAmountOfEntries(2);
        visualList.repaint();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return i + 1;
    }

    @Override
    public List<Integer> getList() {
        return list;
    }

}
