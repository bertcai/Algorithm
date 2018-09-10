package SwordToOffer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strings = str.split("-");
            String[] strA = strings[0].split(" ");
            String[] strB = strings[1].split(" ");
            if (findType(strA) != findType(strB) &&
                    findType(strA) != 4 &&
                    findType(strA) != 6 &&
                    findType(strB) != 4 &&
                    findType(strB) != 6) {
                System.out.println("ERROR");
            } else if (findType(strA) == 6) {
                System.out.println(strings[0]);
            } else if (findType(strB) == 6) {
                System.out.println(strings[1]);
            } else if (findType(strA) == 4 &&
                    findType(strB) != 4) {
                System.out.println(strings[0]);
            } else if (findType(strB) == 4 &&
                    findType(strA) != 4) {
                System.out.println(strings[1]);
            } else if (findType(strA) == 4) {
                if (strA[0].equals("2")) {
                    System.out.println("2");
                } else if (strB[0].equals("2")) {
                    System.out.println("2");
                } else if (strA[0].equals("A")) {
                    System.out.println("A");
                } else if (strB[0].equals("A")) {
                    System.out.println("A");
                } else if (strA[0].compareTo(strB[0]) < 0) {
                    System.out.println(strings[1]);
                } else {
                    System.out.println(strings[0]);
                }
            } else if (findType(strA) == 1) {
                if (strA[0].equals("JOKER")) {
                    System.out.println(strings[0]);
                } else if (strB[0].equals("JOKER")) {
                    System.out.println(strings[1]);
                } else if (strA[0].equals("2")) {
                    System.out.println("2");
                } else if (strB[0].equals("2")) {
                    System.out.println("2");
                } else if (strA[0].equals("A")) {
                    System.out.println("A");
                } else if (strB[0].equals("A")) {
                    System.out.println("A");
                } else if (strA[0].compareTo(strB[0]) < 0) {
                    System.out.println(strings[1]);
                } else {
                    System.out.println(strings[0]);
                }
            } else if (findType(strA) == 2) {
                if (strA[0].equals("2")) {
                    System.out.println("2");
                } else if (strB[0].equals("2")) {
                    System.out.println("2");
                } else if (strA[0].equals("A")) {
                    System.out.println("A");
                } else if (strB[0].equals("A")) {
                    System.out.println("A");
                } else if (strA[0].compareTo(strB[0]) < 0) {
                    System.out.println(strings[1]);
                } else {
                    System.out.println(strings[0]);
                }
            } else if (findType(strA) == 3) {
                if (strA[0].equals("2")) {
                    System.out.println("2");
                } else if (strB[0].equals("2")) {
                    System.out.println("2");
                } else if (strA[0].equals("A")) {
                    System.out.println("A");
                } else if (strB[0].equals("A")) {
                    System.out.println("A");
                } else if (strA[0].compareTo(strB[0]) < 0) {
                    System.out.println(strings[1]);
                } else {
                    System.out.println(strings[0]);
                }
            } else if (strA[0].compareTo(strB[0]) < 0) {
                System.out.println(strings[0]);
            } else {
//                System.out.println(strA[0]);
//                System.out.println(strB[0]);
//                System.out.println(strA[0].compareTo(strB[0]));
                System.out.println(strings[1]);
            }
        }
    }


    /**
     * @param strs
     * @return 0 error
     * 1 single
     * 2 double
     * 3 treble
     * 4 boom
     * 5 iterable
     * 6 joker boom
     */
    public static int findType(String[] strs) {
        if (strs.length == 1) {
            return 1;
        }
        if (strs.length == 2) {
            if (strs[0].equals(strs[1])) {
                return 2;
            } else {
                return 6;
            }
        }
        if (strs.length == 3) {
            return 3;
        }
        if (strs.length == 4) {
            return 4;
        }
        if (strs.length == 5) {
            return 5;
        }
        return 0;
    }
}
