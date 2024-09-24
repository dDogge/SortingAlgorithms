package sortingalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utility {
    private List<Integer> objectList;

    public Utility() {
        this.objectList = new ArrayList<>();
    }

    public void addObjects(int amount) {
        for (int i = 0; i < amount; i++) {
            objectList.add(i + 1);
        }
        Collections.shuffle(objectList, new Random());
    }

    public void shuffleList() {
        Collections.shuffle(objectList, new Random());
    }

    public List<Integer> getObjectList() {
        return objectList;
    }

    public void emptyList() {
        objectList.clear();
    }
}
