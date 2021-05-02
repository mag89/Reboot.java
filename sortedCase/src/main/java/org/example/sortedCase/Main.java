package org.example.sortedCase;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Long> nanos = new HashMap<>();
        Long start = 0L;
        Long finish = 0L;
        List<Integer> listInt = new ArrayList<>();
        int bound = 100_000;

        for (int i = 0; i <= bound; i++) {
            listInt.add(new Random().nextInt(bound));
        }

        start = System.currentTimeMillis();
        dummySort(listInt);
        finish = System.currentTimeMillis();
        nanos.put("dummy sort", finish - start);


        start = System.currentTimeMillis();
        quickSort(listInt);
        finish = System.currentTimeMillis();
        nanos.put("quick sort", (finish - start));

        System.out.println(nanos);

//        System.out.println(listInt.stream().sorted().collect(Collectors.toList()));
//        Collections.sort(listInt);


    }

    public static List<Integer> dummySort(List<Integer> integers) {
        List<Integer> sortedList = new ArrayList<>();

        for (int j = 0; j < integers.size() - 1; j++) {

            int maxInt = 0;
            int maxIntIndex = 0;
            for (int i = 0; i < integers.size(); i++) {
                int thisInt = integers.get(i);
                if (thisInt > maxInt) {
                    maxInt = thisInt;
                    maxIntIndex = i;
                }
            }
            integers.remove(maxIntIndex);
            sortedList.add(maxInt);
        }

        return sortedList;
    }


    public static List<Integer> quickSort(List<Integer> numbers) {
        int sizeOfList = numbers.size();

        if (sizeOfList < 2) {
            return numbers;
        } else {
            int pivotIndex = new Random().nextInt(sizeOfList);
            int pivot = numbers.get(pivotIndex);
            numbers.remove(pivotIndex);
            List<Integer> lessThanPivot = new ArrayList<>();
            List<Integer> greaterThanPivot = new ArrayList<>();
            for (Integer num : numbers) {
                if (num >= pivot) {
                    greaterThanPivot.add(num);
                } else {
                    lessThanPivot.add(num);
                }
            }
            List<Integer> firstSortedHalflist = quickSort(lessThanPivot);
            firstSortedHalflist.add(pivot);
            List<Integer> secondSortedHalflist = quickSort(greaterThanPivot);

            firstSortedHalflist.addAll(secondSortedHalflist);


            return firstSortedHalflist;
        }

    }


}
