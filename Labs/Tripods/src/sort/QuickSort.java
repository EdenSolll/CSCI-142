package sort;

import tripods.Tripod;

import java.util.ArrayList;

/**
 * Perform an "out of place" quick sort on an array list of Tripod's by
 * ascending tripod sum.
 * <pre>
 * quick_sort (not in place):
 * best=O(nlogn)
 * worst=O(n^2)
 * </pre>
 *
 * @author RIT CS
 * @author Eden Grace
 */
public class QuickSort {
    /**
     * Partition the array for values less than the pivot.
     *
     * @param data  the full array of data
     * @param pivot the pivot
     * @return data less than the pivot
     */
    public static ArrayList<Tripod> partitionLess(ArrayList<Tripod> data, Tripod pivot) {
        ArrayList<Tripod> less_tripods = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).sum() < pivot.sum()) {
                less_tripods.add(data.get(i));
            }
        }
        return less_tripods;
    }

    /**
     * Partition the array for values equal to the pivot.
     *
     * @param data  the full array of data
     * @param pivot the pivot
     * @return data equal to the pivot
     */
    public static ArrayList<Tripod> partitionEqual(ArrayList<Tripod> data, Tripod pivot) {
        ArrayList<Tripod> equal_tripods = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).sum() == pivot.sum()) {
                equal_tripods.add(data.get(i));
            }
        }
        return equal_tripods;
    }
    /**
     * Partition the array for values greater than the pivot.
     *
     * @param data  the full array of data
     * @param pivot the pivot
     * @return data greater than the pivot
     */
    public static ArrayList<Tripod> partitionGreater(ArrayList<Tripod> data, Tripod pivot) {
        ArrayList<Tripod> greater_tripods = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).sum() > pivot.sum()) {
                greater_tripods.add(data.get(i));
            }
        }
        return greater_tripods;
    }

    /**
     * Performs a quick sort and returns a newly sorted array.
     *
     * @param data the data to be sorted
     * @return a sorted array
     */
    public static ArrayList<Tripod> quickSort(ArrayList<Tripod> data) {

       ArrayList<Tripod> sorted_array = new ArrayList<>();

        if (data.size() == 0) {
            return data;
        } else {
            Tripod pivot = data.get(0);
            ArrayList<Tripod> less = partitionLess(data, pivot);
            ArrayList<Tripod> equal = partitionEqual(data, pivot);
            ArrayList<Tripod> greater = partitionGreater(data, pivot);

            if (less.size() > 1) {
                less = quickSort(less);
            }
            if (greater.size() > 1) {
                 greater = quickSort(greater);
            }

            sorted_array.addAll(less);
            sorted_array.addAll(equal);
            sorted_array.addAll(greater);
        }
        return sorted_array;
    }
}
