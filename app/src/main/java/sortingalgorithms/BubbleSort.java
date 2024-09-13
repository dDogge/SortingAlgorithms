package sortingalgorithms;

import java.util.Collections;
import java.util.List;

public class BubbleSort implements SortingAlgorithm{
    List<Integer> list;
    
    public BubbleSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void Sort() {
        int n = list.size();
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < n - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i + 1);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    @Override
    public List<Integer> getList() {
        return list;
    }
}
