package org.example.sortedCase.sortStringBuilder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedTktContext {
    public StringBuilder getSortedContextByFC(StringBuilder sbIn) {
        String sIn = sbIn.toString();
        Comparator<String[]> comparator = new TktContextRowComparator();

        List<String[]> listSorted = Arrays.stream(sIn.split("\n"))
                .map(s -> s.split("\t"))
                .sorted(comparator).collect(Collectors.toList());

        StringBuilder result = new StringBuilder();

        listSorted.forEach(sArr -> result
                .append(sArr[0])
                .append("\t")
                .append(sArr[1])
                .append("\n"));

        return result;
    }

}
