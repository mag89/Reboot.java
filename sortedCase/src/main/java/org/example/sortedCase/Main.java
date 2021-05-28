package org.example.sortedCase;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Map<String, Long> nanos = new HashMap<>();
        Long start = 0L;
        Long finish = 0L;
        List<Integer> listInt = new ArrayList<>();
        int bound = 1000;

        initList(listInt, bound);
        System.out.println(listInt.size());

        start = System.currentTimeMillis();
        List<Integer> dummySorted = dummySort(listInt);
        finish = System.currentTimeMillis();
        nanos.put("dummy sort", finish - start);

        System.out.println(dummySorted);
        System.out.println(dummySorted.size());
        System.out.println(nanos);

        initList(listInt, bound);
        start = System.currentTimeMillis();
        List<Integer> quickSorted = quickSort(listInt);
        finish = System.currentTimeMillis();
        nanos.put("quick sort", (finish - start));

        System.out.println(quickSorted);
        System.out.println(quickSorted.size());
        System.out.println(nanos);

        initList(listInt, bound);
        start = System.currentTimeMillis();
        List<Integer> concurrentQuickSorted = concurrencyQuickSort(listInt);
        finish = System.currentTimeMillis();
        nanos.put("concurrent quick sort", (finish - start));

        System.out.println(concurrentQuickSorted);
        System.out.println(concurrentQuickSorted.size());
        System.out.println(nanos);


//        System.out.println(listInt.stream().sorted().collect(Collectors.toList()));
//        Collections.sort(listInt);


    }

    public static List<Integer> initList(List<Integer> l, int bound) {
        for (int i = 0; i <= bound; i++) {
            l.add(new Random().nextInt(bound));
        }
        return l;
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


    public static List<Integer> concurrencyQuickSort(List<Integer> numbers) throws InterruptedException {
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

            MyThread firstThread = new MyThread(lessThanPivot);
            MyThread secondThread = new MyThread(greaterThanPivot);
            firstThread.start();
            secondThread.start();
            firstThread.join();
            secondThread.join();

            synchronized (Main.class) {
                List<Integer> firstSortedHalfList = firstThread.getOutputList();
                List<Integer> secondSortedHalfList = secondThread.getOutputList();

                firstSortedHalfList.add(pivot);
                firstSortedHalfList.addAll(secondSortedHalfList);

                return firstSortedHalfList;
            }

        }

    }


}
