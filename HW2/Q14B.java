
// Cracker System
// Oct 08 2022

import java.util.*;
import java.security.*;
import java.io.UnsupportedEncodingException;

public class Q14B {
    // initializing private values
    private static Data data = new Data();

    // main method
    public static void main(String[] args) {
        // user input
        Scanner scan = new Scanner(System.in);
        // user inputs userid, password, and salt with initialized values
        System.out.println("Enter UserID: ");
        String user = scan.nextLine();

        // calling method to find password and salt
        findPW(Integer.parseInt(user));
    }

    // method to find password and salt
    public static void findPW(int user) {
        // initializing new string
        String temp;

        // loops to go through all possible password and salt combinations
        // password range of 0-1000
        for (int i = 0; i <= 1000; i++) {
            // salt range of 0-100
            for (int j = 0; j <= 100; j++) {
                // setting temp with hashes
                temp = getHashes(String.format("%04d", i) + String.format("%03d", j));
                // calling method to compare hashes
                compareHash(data.setHash(user), temp);
                if (data.setHash(user) == temp) {
                    // printing password and salt when uid, pw, and salt matches
                    System.out.println("Password: " + String.format("%04d", i) + "\nSalt: " + String.format("%03d", j));
                }
                else {
                    // printing error message
                    System.out.println("This is an error message.");
                }
            }
        }
    }

    // using the same two methods from Q14A.java
    // methods to get hashes
    public static String getHashes(String scan) {
        // creating hash funtion in utd-8
        byte[] MD5Bytes;
        try {
            // setting to utf-8
            MD5Bytes = scan.getBytes("UTF-8");
            // md5 unction
            MessageDigest md = MessageDigest.getInstance("MD5");
            MD5Bytes = md.digest(MD5Bytes);
        }
        // catching exceptions
        catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return scan;
    }

    // method to compare hashes from data and hashes that was newly created
    public static void compareHash(String dataHash, String newHash) {
        if (dataHash.equals(newHash)) {
            // printing if hashes are the same
            System.out.println("The input password and salt matches the hash value in the database.");
        }
        else {
            // printing if hashes are different
            System.out.println("The input password and salt does not match the hash value in the database.");
        }
    }
}
