
// My Database For Password Systems
// Oct 08 2022

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Data {
    // creating arrray lists to put numbers from files in array
    private ArrayList<String> hasharray;
    private ArrayList<String> uidarray;
    private ArrayList<String> passarray;

    public Data() {
        readFiles();
    }

    // method to read file
    public void readFiles() {
        try {
            // getting hashes from file
            BufferedReader hashtext = new BufferedReader (
                // these files were downloaded onto my local computer
                new FileReader("C:\\Users\\vivia\\Downloads\\HW2-PartII-supplementary-files\\Hash.txt")
            );
            // getting uids from file
            BufferedReader uidtext = new BufferedReader(
                // these files were downloaded onto my local computer
                new FileReader("C:\\Users\\vivia\\Downloads\\HW2-PartII-supplementary-files\\UID.txt")
            );
            // getting passwords from file
            BufferedReader passtext = new BufferedReader(
                // these files were downloaded onto my local computer
                new FileReader("C:\\Users\\vivia\\Downloads\\HW2-PartII-supplementary-files\\Password.txt")
            );

            // placing hashes into array
            hasharray = new ArrayList<String>();
            String hash = hashtext.readLine();
            while (hasharray != null) {
                hasharray.add(hash);
                hash = hashtext.readLine();
            }
            // placing uids into array
            uidarray = new ArrayList<String>();
            String uid = uidtext.readLine();
            while (uidarray != null) {
                uidarray.add(uid);
                uid = uidtext.readLine();
            }
            // placing passwords into array
            passarray = new ArrayList<String>();
            String pw = passtext.readLine();
            while (passarray != null) {
                passarray.add(pw);
                pw = passtext.readLine();
            }

            // closing files
            hashtext.close();
            uidtext.close();
            passtext.close();
        }
        // catching exceptions
        catch (FileNotFoundException ex) {
            System.out.println();
        }
        catch (IOException ex) {
            System.out.println();
        }
    }

    // methods to set uids, hashes, and passwords
    public String setUID (int i) {
        return uidarray.get(i);
    } 
    public String setHash (int i) {
        return hasharray.get(i);
    }
    public String setPW (int i) {
        return passarray.get(i);
    }

    // methods to get uids, hashes, and passwords
    public String getUID() {
        String toString = "";
        // iterating through every element
        for (int i = 0; i < uidNum(); i++) {
            // placing inside array
            toString += setUID(i) + "\n";
        }
        return toString;
    }
    public String getHash() {
        String toString = "";
        // iterating through every element
        for (int i = 0; i < hashNum(); i++) {
            // placing inside array
            toString += setHash(i) + "\n";
        }
        return toString;
    }
    public String getPass() {
        String toString = "";
        // iterating through every element
        for (int i = 0; i < passNum(); i++) {
            // placing inside array
            toString += setPW(i) + "\n";
        }
        return toString;
    }

    // methods to find array sizes of uids, hashes, and passwords
    public int uidNum() {
        return uidarray.size();
    }
    public int hashNum() {
        return hasharray.size();
    }
    public int passNum() {
        return passarray.size();
    }
}
