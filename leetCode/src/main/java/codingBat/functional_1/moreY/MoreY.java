package codingBat.functional_1.moreY;

/*
Given a list of strings, return a list where each string has "y" added at its start and end.

moreY(["a", "b", "c"]) → ["yay", "yby", "ycy"]
moreY(["hello", "there"]) → ["yhelloy", "ytherey"]
moreY(["yay"]) → ["yyayy"]
 */

import java.util.List;
import java.util.stream.Collectors;

public class MoreY {

    public List<String> moreY(List<String> strings) {
        return strings.stream().map(x -> "y" + x + "y").collect(Collectors.toList());
    }

}
