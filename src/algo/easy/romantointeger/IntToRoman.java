package algo.easy.romantointeger;

public class IntToRoman {

    public static String intToRoman(int number) {
        StringBuilder romanValue = new StringBuilder();

        while (number > 0) {
            if (number >= 1000) {
                romanValue = romanValue.append("M");
                number = number - 1000;
            }
            if (1000 > number && number >= 500) {
                romanValue = romanValue.append("D");
                number = number - 500;
            }
            if (500 > number && number >= 100) {
                romanValue = romanValue.append("C");
                number = number - 100;
            }

            if (100 > number && number >= 50) {
                romanValue = romanValue.append("L");
                number = number - 50;
            }

            if (50 > number && number >= 10) {
                romanValue = romanValue.append("X");
                number = number - 10;
            }
            if (10 > number && number > 0) {
                romanValue = romanValue.append(convertDigitToRomanNumber(number));
                number = 0;
            }
        }

        return romanValue.toString();
    }

    private static String convertDigitToRomanNumber(int digit) {
        switch (digit) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
        }
        throw new IllegalArgumentException("Unknown digit found");
    }

    public static void main(String args[]) {
        System.out.println(intToRoman(1976));

    }
}
