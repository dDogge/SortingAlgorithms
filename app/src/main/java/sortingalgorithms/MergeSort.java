package sortingalgorithms;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MergeSort implements SortingAlgorithm {
    private List<Integer> list;
    private static SortingVisualizer sv;

    public MergeSort(List<Integer> list, SortingVisualizer sv) {
        this.list = list;
        this.sv = sv;
    }

    @Override
    public void Sort(JPanel visualList) {
        mergeSort(0, list.size() - 1, visualList);
    }

    private void mergeSort(int start, int end, JPanel visualList) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(start, mid, visualList);
        mergeSort(mid + 1, end, visualList);

        merge(start, mid, end, visualList);
    }

    private void merge(int start, int mid, int end, JPanel visualList) {
        List<Integer> left = new ArrayList<>(list.subList(start, mid + 1));
        List<Integer> right = new ArrayList<>(list.subList(mid + 1, end + 1));

        int leftIndex = 0, rightIndex = 0, resultIndex = start;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            sv.incrementAmountOfEntries(2);
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                sv.incrementAmountofComparisons(1);
                list.set(resultIndex++, left.get(leftIndex++));
                sv.incrementAmountOfSwaps(1);
                sv.incrementAmountOfEntries(2);
            } else {
                sv.incrementAmountofComparisons(1);
                list.set(resultIndex++, right.get(rightIndex++));
                sv.incrementAmountOfSwaps(1);
                sv.incrementAmountOfEntries(2);
            }
            updateVisualList(visualList);
        }

        while (leftIndex < left.size()) {
            list.set(resultIndex++, left.get(leftIndex++));
            sv.incrementAmountOfSwaps(1);
            sv.incrementAmountOfEntries(2);
            updateVisualList(visualList);
        }

        while (rightIndex < right.size()) {
            list.set(resultIndex++, right.get(rightIndex++));
            sv.incrementAmountOfSwaps(1);
            sv.incrementAmountOfEntries(2);
            updateVisualList(visualList);
        }
    }

    private void updateVisualList(JPanel visualList) {
        visualList.repaint();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Integer> getList() {
        return list;
    }

}
