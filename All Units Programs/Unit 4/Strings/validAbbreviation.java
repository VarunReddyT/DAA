import java.util.*;

/*
 * T(n)=O(n)
 */
class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int pw = 0;
        int pa = 0;
        while (pw < word.length() && pa < abbr.length()) {
            if (Character.isLetter(abbr.charAt(pa))) {
                if (word.charAt(pw) != abbr.charAt(pa))
                    return false;
                pw++;
                pa++;
            } else {
                int number = 0;
                while (pa < abbr.length() && Character.isDigit(abbr.charAt(pa))) {
                    number *= 10;
                    number += abbr.charAt(pa++) - '0';
                    System.out.println("number " + number);
                    if (number == 0)
                        return false;
                }
                pw += number;
                System.out.println("pw " + pw + " pa " + pa);
            }
        }
        System.out.println("Final pw " + pw + " pa " + pa);
        return pw == word.length() && pa == abbr.length();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(new ValidWordAbbreviation().validWordAbbreviation(s, t));
        sc.close();
    }
}