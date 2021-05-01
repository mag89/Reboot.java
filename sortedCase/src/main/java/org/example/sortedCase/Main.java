package org.example.sortedCase;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        int randInt = new Random().nextInt();
        List<Integer> listInt = new ArrayList<>();

        for (int i = 0; i <= 500_000; i++) {
            listInt.add(new Random().nextInt(7_431));
        }

//        System.out.println(dummySort(listInt));

//        System.out.println(listInt.stream().sorted().collect(Collectors.toList()));
        Collections.sort(listInt);
        System.out.println(listInt);

//        Arrays.sort();

    }

    public static List<Integer> dummySort(List<Integer> integers) {
        List<Integer> sortedList = new ArrayList<>();

        for (int j = 0; j < integers.size() - 1; j++) {

            int maxInt = 0;
            int maxIntIndex = 0;
            for (int i = 0; i < integers.size(); i++) {
                if (integers.get(i) > maxInt) {
                    maxInt = integers.get(i);
                    maxIntIndex = i;
                }
            }
            integers.remove(maxIntIndex);
            sortedList.add(maxInt);
        }

        return sortedList;
    }

    public static void quickSort(List<Integer> list, int begin, int end) {
        Object[] arr = list.toArray();

        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(list, begin, partitionIndex-1);
            quickSort(list, partitionIndex+1, end);
        }


    }

    private static int partition(Object[] arr, int begin, int end) {
        int pivot = (Integer) arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if ((Integer) arr[j] <= pivot) {
                i++;

                int swapTemp = (Integer) arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = (Integer) arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }


}
