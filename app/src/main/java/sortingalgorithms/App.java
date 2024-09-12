
package sortingalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class App {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 1000; i++) {
           list.add(i + 1);
        }

        Collections.shuffle(list, new Random());
        for (int i : list) {
            System.out.print(i + " ");
        }

        BubbleSort bs = new BubbleSort(list);
        bs.Sort();

        list = bs.getList();
        for (int i : list) {
            System.out.println(i + " ");
        }

    }
}
