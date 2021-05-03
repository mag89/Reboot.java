package org.example.sortedCase;

import java.util.List;

public class MyThread extends Thread {
    private List<Integer> inputList;
    private List<Integer> outputList;

    public MyThread(List<Integer> inputList) {
        super();
        this.inputList = inputList;
    }

    @Override
    public void run() {
        try {
            this.outputList = Main.concurrencyQuickSort(inputList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getOutputList() {
        return outputList;
    }
}
