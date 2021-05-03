package org.example.sortedCase;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Map<String, Long> nanos = new HashMap<>();
        Long start = 0L;
        Long finish = 0L;
        List<Integer> listInt = new ArrayList<>();
        int bound = 100;

        for (int i = 0; i <= bound; i++) {
            listInt.add(new Random().nextInt(bound));
        }
        System.out.println(listInt.size());

        start = System.currentTimeMillis();
        List<Integer> dummySorted = dummySort(listInt);
        finish = System.currentTimeMillis();
        nanos.put("dummy sort", finish - start);

        System.out.println(dummySorted);
        System.out.println(dummySorted.size());
        System.out.println(nanos);

//        System.out.println(listInt.stream().sorted().collect(Collectors.toList()));
//        Collections.sort(listInt);


    }

    public static List<Integer> dummySort(List<Integer> integers) {
        int baseSize = integers.size();
        List<Integer> sortedList = new ArrayList<>(baseSize);

        for (int j = 0; j < baseSize; j++) {

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
