package code;

import java.util.ArrayList;
import java.util.List;

import code.SortZeroToTheEnd;

public class main {
    public static void main(String[] args) {
        String text = "Nankai Kansai Airport Station → Nankai Namba Station, Shin-Imamiya Station, Tenkajaya Station Return.";

        if (text.endsWith(".")) {
            System.out.println("The string ends with a period.");
        } else {
            System.out.println("The string does not end with a period.");
        }
    }
}
