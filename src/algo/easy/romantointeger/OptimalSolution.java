package algo.easy.romantointeger;

public class OptimalSolution {

    public int romanToInt(String s) {

        int ans = 0;
        char previousRomanChar = ' ';
        for (int i = 0; i < s.length(); i++) {
            char currentRomanChar = s.charAt(i);
            if(romanToInteger(previousRomanChar) >= romanToInteger(currentRomanChar)){
               ans += romanToInteger(previousRomanChar);
               System.out.println("Inside if block:" + ans);
           }
           else {
               ans -= romanToInteger(previousRomanChar);
               System.out.println("Inside else block:" + ans);
            }
           previousRomanChar = currentRomanChar;
        }
        return ans + romanToInteger(previousRomanChar);
    }

    private static int romanToInteger(char c) {
        if (c == 'I') return 1;
        else if (c == 'V') return 5;
        else if (c == 'X') return 10;
        else if (c == 'L') return 50;
        else if (c == 'C') return 100;
        else if (c == 'D') return 500;
        else if (c == 'M') return 1000;
        else return 0;
    }


    public static void main(String args[]) {
        OptimalSolution optimalSoultion = new OptimalSolution();
        System.out.println(optimalSoultion.romanToInt("IV"));

    }
}
