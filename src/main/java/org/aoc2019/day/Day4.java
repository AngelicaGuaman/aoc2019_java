package org.aoc2019.day;

public class Day4 {
    private static final int START = 246515;
    private static final int END = 739105;

    public int getPasswordPart1() {
        int numberOfPasswords = 0;
        for (int password = START; password <= END; password++) {
            char[] passwords = String.valueOf(password).toCharArray();
            if(isAdjacent(passwords) && neverDecrease(passwords)){
                numberOfPasswords++;
            }
        }
        return numberOfPasswords;
    }

    public int getPasswordPart2() {
        int numberOfPasswords = 0;
        for (int password = START; password <= END; password++) {
            char[] passwords = String.valueOf(password).toCharArray();
            if(containsOnlyTwoAdjacent(passwords) && neverDecrease(passwords)){
                numberOfPasswords++;
            }
        }
        return numberOfPasswords;
    }

    private boolean containsOnlyTwoAdjacent(char[] password) {
        for (int i = 0; i < password.length - 1; i++) {
            if (password[i] == password[i + 1]) {
                boolean matchBefore = false, matchAfter = false;
                if(i - 1 >= 0 && password[i] == password[i -1]){
                    matchBefore = true;
                }
                if(i + 2 < password.length && password[i] == password[i + 2]){
                    matchAfter = true;
                }
                if(!matchAfter && !matchBefore){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdjacent(char[] password) {
        for (int i = 0; i < password.length - 1; i++) {
            if (password[i] == password[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private boolean neverDecrease(char[] passwords){
        for(int i = 0; i < passwords.length - 1; i++){
            if(passwords[i] > passwords[i+1]){
                return false;
            }
        }
        return true;
    }
}
