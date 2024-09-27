package sortingalgorithms;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MergeSort implements SortingAlgorithm {
    List<Integer> list;

    public MergeSort(List<Integer> list) {
        this.list = list;
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
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                list.set(resultIndex++, left.get(leftIndex++));
            } else {
                list.set(resultIndex++, right.get(rightIndex++));
            }
            updateVisualList(visualList);
        }
    
        while (leftIndex < left.size()) {
            list.set(resultIndex++, left.get(leftIndex++));
            updateVisualList(visualList);
        }
    
        while (rightIndex < right.size()) {
            list.set(resultIndex++, right.get(rightIndex++));
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
