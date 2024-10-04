package sortingalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class BucketSort implements SortingAlgorithm {
    private List<Integer> list;
    private static SortingVisualizer sv;

    public BucketSort(List<Integer> list, SortingVisualizer sv) {
        this.list = list;
        this.sv = sv;
    }

    @Override
    public void Sort(JPanel visualList) {
        bucketSort(visualList, list, 20);
    }

    private static void bucketSort(JPanel visualList, List<Integer> list, int nbrOfBuckets) {
        int max = Collections.max(list);
        sv.incrementAmountOfEntries(list.size());
        sv.incrementAmountofComparisons(list.size() - 1);
        List<List<Integer>> buckets = new ArrayList<>(nbrOfBuckets);

        for (int i = 0; i < nbrOfBuckets; i++) {
            buckets.add(new ArrayList<>()); 
        }

        for (int n : list) {
            sv.incrementAmountOfEntries(1);
            int bucketIndex = (n * nbrOfBuckets) / (max + 1);
            buckets.get(bucketIndex).add(n);
            sv.incrementAmountOfEntries(1);
            updateVisual(visualList, buckets, list);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        updateVisual(visualList, buckets, list);

        int startIndex = 0; 
        for (List<Integer> bucket : buckets) {
            sv.incrementAmountOfEntries(1);
            if (!bucket.isEmpty()) {
                List<Integer> bucketSubList = list.subList(startIndex, startIndex + bucket.size());
                
                for (int i = 0; i < bucket.size(); i++) {
                    bucketSubList.set(i, bucket.get(i));
                    sv.incrementAmountOfEntries(2);
                }

                InsertionSort is = new InsertionSort(bucketSubList, sv);
                is.Sort(visualList);

                startIndex += bucket.size();
            }
        }
        visualList.repaint();
    }

    private static void updateVisual(JPanel visualList, List<List<Integer>> buckets, List<Integer> list) {
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                list.set(index++, value);
            }
        }
        visualList.repaint(); 
    }

    @Override
    public List<Integer> getList() {
        return list;
    }
}
