package src;

import java.util.Scanner;

public class Main {

    private static final int LOWER = 26;
    private static final int UPPER = 26;
    private static final int DIGIT = 10;
    private static final int SPECIAL = 23;

    public static void main(String[] args) {
        
        String password = null;
        Scanner sc = new Scanner(System.in);

        while(password == null) {
            System.out.print("\nEnter your password : ");
            password = sc.nextLine();
            if(password.contains(" ")) {
                System.out.println("Your password contains blankspace !");
                password = null;
            }
        }

        sc.close();

        int lower = getNumberOfLowercase(password); int upper = getNumberOfUppercase(password); int digit = getNumberOfDigit(password); int special = getNumberOfSpecialChar(password);

        System.out.println("\nPassword data :");
        System.out.println("\t - Number of lower : " + lower);
        System.out.println("\t - Number of upper : " + upper);
        System.out.println("\t - Number of digit : " + digit);
        System.out.println("\t - Number of special : " + special);

        int numberChar = (lower > 0 ? LOWER : 0) + (upper > 0 ? UPPER : 0) + (digit > 0 ? DIGIT : 0) + (special > 0 ? SPECIAL : 0);
        double entropy = Math.log(Math.pow(numberChar, password.length())) / Math.log(2);
        
        System.out.println("\nEntropy : " + entropy);

        if(0 <= entropy && entropy <= 35) {
            System.out.println("-> Very weak");
        } else if (36 <= entropy && entropy <= 59) {
            System.out.println("-> Weak");
        } else if (60 <= entropy && entropy <= 119) {
            System.out.println("-> Strong");
        } else {
            System.out.println("-> Very strong");
        }

        System.out.println("\n");

    }

    private static int getNumberOfUppercase(String password) {
        int res = 0;
        for(char c : password.toCharArray()) {
            if(Character.isUpperCase(c)) {
                res ++;
            }
        }
        return res;
    }

    private static int getNumberOfLowercase(String password) {
        int res = 0;
        for(char c : password.toCharArray()) {
            if(Character.isLowerCase(c)) {
                res ++;
            }
        }
        return res;
    }

    private static int getNumberOfDigit(String password) {
        int res = 0;
        for(char c : password.toCharArray()) {
            if(Character.isDigit(c)) {
                res ++;
            }
        }
        return res;
    }

    private static int getNumberOfSpecialChar(String password) {
        int res = password.replaceAll("[A-Za-z0-9\\s]", "").length();
        return res;
    }
  
}