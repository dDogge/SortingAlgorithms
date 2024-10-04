package sortingalgorithms;

import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class CocktailSort implements SortingAlgorithm {
    private List<Integer> list;
    private static SortingVisualizer sv;

    public CocktailSort(List<Integer> list, SortingVisualizer sv) {
        this.list = list;
        this.sv = sv;
    }

    @Override
    public void Sort(JPanel visualList) {
        int start = 0;
        int end = list.size() - 1;
        boolean swapped = true;

        do {
            swapped = false;

            for (int i = start; i < end; i++) {
                sv.incrementAmountofComparisons(1);
                sv.incrementAmountOfEntries(2);
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i + 1);
                    sv.incrementAmountOfSwaps(1);
                    sv.incrementAmountOfEntries(2);
                    visualList.repaint();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            end -= 1;
            swapped = false;

            for (int i = (end - 1); i >= start; i--) {
                sv.incrementAmountofComparisons(1);
                sv.incrementAmountOfEntries(2);
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i + 1);
                    sv.incrementAmountOfSwaps(1);
                    sv.incrementAmountOfEntries(2);
                    visualList.repaint();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
