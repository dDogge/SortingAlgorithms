package sortingalgorithms;

import java.util.Collections;
import java.util.List;

public class CocktailSort implements SortingAlgorithm {
    private List<Integer> list;

    public CocktailSort(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void Sort() {
        int start = 0;
        int end = list.size() - 1;
        boolean swapped = true;

        do {
            swapped = false;

            for (int i = start; i < end; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            end -= 1;
            swapped = false;

            for (int i = (end - 1); i >= start; i--) {
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i + 1);
                    swapped = true;
                }
            }
            
            start += 1;

        } while (swapped);
    }

    @Override
    public List<Integer> getList() {
        return list;
    }
    
}
