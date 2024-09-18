
package sortingalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Type 1 if you want to sort a list");
        int choice = scan.nextInt();

        while (choice != 1) {
            System.out.println("Please type 1");
            choice = scan.nextInt();
        }

        while (choice == 1) {
            
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                list.add(i + 1);
            }

            Collections.shuffle(list, new Random());
            for (int i : list) {
                System.out.println(i + " ");
            }

            System.out.println("Please select a sorting algorihm");
            System.out.println("Type 1 for bubble sort");
            System.out.println("Type 2 for selection sort");
            System.out.println("Type 3 for cocktail shaker sort");
            System.out.println("Type 4 for insertion sort");

            int selectList = scan.nextInt();
            long time1;
            long time2;

            if (selectList == 1) {
                BubbleSort bs = new BubbleSort(list);
                time1 = System.currentTimeMillis();
                bs.Sort();
                time2 = System.currentTimeMillis() - time1;
                list = bs.getList();
                for (int i : list) {
                    System.out.println(i + " ");
                }
                System.out.println(time2 + "ms");

            } else if (selectList == 2) {
                SelectionSort ss = new SelectionSort(list);
                time1 = System.currentTimeMillis();
                ss.Sort();
                time2 = System.currentTimeMillis() - time1;
                list = ss.getList();
                for (int i : list) {
                    System.out.println(i + " ");
                }
                System.out.println(time2 + "ms");

            } else if (selectList == 3) {
                CocktailSort cs = new CocktailSort(list);
                time1 = System.currentTimeMillis();
                cs.Sort();
                time2 = System.currentTimeMillis() - time1;
                list = cs.getList();
                for (int i : list) {
                    System.out.println(i + " ");
                }
                System.out.println(time2 + "ms");
                
            } else if (selectList == 4) {
                InsertionSort is = new InsertionSort(list);
                time1 = System.currentTimeMillis();
                is.Sort();
                time2 = System.currentTimeMillis() - time1;
                list = is.getList();
                for (int i : list) {
                    System.out.println(i + " ");
                }
                System.out.println(time2 + "ms");
            } else {
                throw new IllegalArgumentException("Please type any of the numbers mentioned");
            }

            Collections.shuffle(list, new Random());
            System.out.println("Do you want to try another sorting algorihm? Type 1");
            System.out.println("Otherwise type anything else");
            choice = scan.nextInt();
            if (choice != 1) {
                scan.close();
                System.exit(0);
            }
        }
    }
}
