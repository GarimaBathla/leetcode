package algo.easy.romantointeger;

public class Solution {


    private static int romanToInt(String romanNumber) {


        int total = 0;
        int previousValue = 0;
        int index = 0;
        while (index < romanNumber.length()) {
            char currentRomanNumber = romanNumber.charAt(index++);
            char nextRomanNumber = index < romanNumber.length()? romanNumber.charAt(index) : ' ';
            boolean shouldSubtract;
            switch (currentRomanNumber) {
                case 'I':
                    shouldSubtract = subtractCurrentRomanNumber(currentRomanNumber, nextRomanNumber);
                    if (shouldSubtract) {
                        previousValue = 1;
                    } else {
                        total = total + 1;
                    }
                    break;
                case 'V':
                    total = total + 5 - previousValue;
                    previousValue = 0;
                    break;
                case 'X':
                    shouldSubtract = subtractCurrentRomanNumber(currentRomanNumber, nextRomanNumber);
                    if (shouldSubtract) {
                        previousValue = 10;
                    } else {
                        total = total + 10 - previousValue;
                        previousValue = 0;
                    }
                    break;
                case 'L':
                    shouldSubtract = subtractCurrentRomanNumber(currentRomanNumber, nextRomanNumber);
                    if (shouldSubtract) {
                        previousValue = 50;
                    } else {
                        total = total + 50 - previousValue;
                        previousValue = 0;
                    }
                    break;
                case 'C':
                    shouldSubtract = subtractCurrentRomanNumber(currentRomanNumber, nextRomanNumber);
                    if (shouldSubtract) {
                        previousValue = 100;
                    } else {
                        total = total + 100 - previousValue;
                        previousValue = 0;
                    }
                    break;
                case 'D':
                    shouldSubtract = subtractCurrentRomanNumber(currentRomanNumber, nextRomanNumber);
                    if (shouldSubtract) {
                        previousValue = 500;
                    } else {
                        total = total + 500 - previousValue;
                        previousValue = 0;
                    }
                    break;

                case 'M':
                    shouldSubtract = subtractCurrentRomanNumber(currentRomanNumber, nextRomanNumber);
                    if (shouldSubtract) {
                        previousValue = 1000;
                    } else {
                        total = total + 1000 - previousValue;
                        previousValue = 0;
                    }
                    break;
            }

        }
        return total;
    }

    private static boolean subtractCurrentRomanNumber(char currentRomanNumber, char nextRomanNumber) {
        switch (currentRomanNumber) {
            case 'I':
                switch (nextRomanNumber) {
                    case 'V':
                    case 'X':
                        return true;
                    default:
                        return false;
                }
            case 'X':
                switch (nextRomanNumber) {
                    case 'L':
                    case 'C':
                    case 'D':
                    case 'M':
                        return true;
                    default:
                        return false;
                }
            case 'L':
                switch (nextRomanNumber) {
                    case 'C':
                    case 'D':
                    case 'M':
                        return true;
                    default:
                        return false;
                }
            case 'C':
                switch (nextRomanNumber) {
                    case 'D':
                    case 'M':
                        return true;
                    default:
                        return false;
                }
            case 'D':
                switch (nextRomanNumber) {
                    case 'M':
                        return true;
                    default:
                        return false;
                }
            default:
                return false;

        }

    }

    public static void main(String args[]) {
        String romanNumber = "MCMLXXVI";
        int intValue = romanToInt(romanNumber);
        System.out.println(intValue);

    }


}
