package sortingalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utility {
    private List<Integer> objectList;
    private List<SortingAlgorithm> algorithmList;

    public Utility() {
        this.objectList = new ArrayList<>();
        this.algorithmList = new ArrayList<>();
    }

    public void addObjects(int amount) {
        for (int i = 0; i < amount; i++) {
            objectList.add(i + 1);
        }
        Collections.shuffle(objectList, new Random());
    }

    public void addAlgorithm(SortingAlgorithm algorithm) {
        if (algorithmList.contains(algorithm)) {
            throw new IllegalArgumentException("This algorithm is already in the list!");
        } else {
            algorithmList.add(algorithm);
        }
    }

    public void shuffleList() {
        Collections.shuffle(objectList, new Random());
    }

    public List<Integer> getObjectList() {
        return objectList;
    }

    public List<SortingAlgorithm> geAlgorithmList() {
        return algorithmList;
    }
}
