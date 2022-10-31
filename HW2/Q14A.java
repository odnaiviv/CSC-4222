
// Password Salt System
// Oct 08 2022

import java.util.*;
import java.security.*;
import java.io.UnsupportedEncodingException;

public class Q14A {
    // initializing private values
    private static Data data = new Data();

    // main method
    public static void main(String[] args) {
        // user input
        Scanner scan = new Scanner(System.in);
        // user inputs userid, password, and salt with initialized values
        System.out.println("Enter UserID: ");
        String user = scan.nextLine();

        System.out.println("Enter Password: ");
        String pw = scan.nextLine();

        System.out.println("Enter Salt: ");
        String salt = scan.nextLine();

        // create new hash from password and salt
        String newHash = getHashes(pw + salt);
        // compare the two
        compareHash(data.setHash(Integer.parseInt(user) - 1), newHash);
    }

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
