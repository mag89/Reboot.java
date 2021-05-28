package codingBat;

import codingBat.frontBack.SolutionFrontBack;
import codingBat.missingChar.SolutionMissingChar;

public class CodingBatMain {
    public static void main(String[] args) {

        SolutionMissingChar instance = new SolutionMissingChar();

        System.out.println(instance.missingChar("kitten", 1));

        SolutionFrontBack instanceFrontBack = new SolutionFrontBack();
        System.out.println(instanceFrontBack.frontBack("code"));


    }
}
