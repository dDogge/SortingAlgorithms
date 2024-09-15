package sortingalgorithms;

import java.util.Collections;
import java.util.List;

public class SelectionSort implements SortingAlgorithm {
    List<Integer> list;

    public SelectionSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void Sort() {
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
            }
        }
    }

    @Override
    public List<Integer> getList() {
        return list;
    }

}
