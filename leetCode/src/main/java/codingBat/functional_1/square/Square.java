package codingBat.functional_1.square;

import java.util.List;
import java.util.stream.Collectors;

/*
Given a list of integers, return a list where each integer is multiplied with itself.

square([1, 2, 3]) → [1, 4, 9]
square([6, 8, -6, -8, 1]) → [36, 64, 36, 64, 1]
square([]) → []
 */

public class Square {
    public List<Integer> square(List<Integer> nums) {
        return nums.stream().map(x -> x*x).collect(Collectors.toList());
    }

}
