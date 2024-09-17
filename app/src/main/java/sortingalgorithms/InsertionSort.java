package sortingalgorithms;

import java.util.List;

public class InsertionSort implements SortingAlgorithm {
    private List<Integer> list;

    public InsertionSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void Sort() {
        int n = list.size();
        int key;

        for (int i = 1; i < n; i++) {
            key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }

            list.set(j + 1, key);
        }
    }

    @Override
    public List<Integer> getList() {
        return list;
    }
    
}
