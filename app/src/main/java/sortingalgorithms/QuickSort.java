package sortingalgorithms;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class QuickSort implements SortingAlgorithm {
    List<Integer> list;

    public QuickSort(List<Integer> list) {
        this.list = list;
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
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if(list.get(j) < pivot) {
                i++;
                Collections.swap(list, i, j);
                visualList.repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Collections.swap(list, i + 1, high);
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
