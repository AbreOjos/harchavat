package utils.utilitiesForInfra;

import java.util.*;
import java.util.stream.IntStream;

public class CollectionsOperations {

    private CollectionsOperations() { }

    /**
     * Check if set setA is subset of set setB
     *
     * @param setA subset
     * @param setB superset
     * @param <T> generic type
     * @return true if setA is subset of setB, false otherwise
     */
    public static <T> boolean isSubset(Set<T> setA, Set<T> setB) {
        return setB.containsAll(setA);
    }

    public static  <K, V> Map<K, V> zipListsToMap(List<K> firstList, List<V> secondList) {
        // mapping years to options
        return IntStream.range(0, firstList.size()).collect(
                LinkedHashMap::new,
                (m, i) -> m.put(firstList.get(i), secondList.get(i)),
                Map::putAll
        );
    }

    public static  <K, E> List<E> createBigEnoughList(List<K> keys, List<E> options) {
        // create big enough list
        List<E> bigEnoughList = new ArrayList<>();
        for (int i=0; i< keys.size(); i++) {
            bigEnoughList.addAll(options);
        }

        return bigEnoughList;
    }

}
