package com.coach.rockpaperscissors;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by sebastien on 14/11/2016.
 */
public class Reader {
    Scanner in = new Scanner(new BufferedInputStream(System.in));

    public Reader() {
    }

    public Reader(Scanner in) {
        this.in = in;
    }

    public int readInt(String msg, int min, int max) {
        Integer result = null;
        do {
            if (result != null) System.out.println("Invalid choice.");
            System.out.print(msg);
            try {
                result = Integer.parseInt(in.nextLine().trim());
            } catch (Exception e) {
                // ignore
                System.out.println("Invalid choice.");
                result = null;
            }
            //System.out.println("");
        } while (result == null || result < min || result > max);
        return result;
    }
}
