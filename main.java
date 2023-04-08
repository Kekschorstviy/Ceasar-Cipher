package Ceasar_Cipher;

import java.util.Scanner;

public class Exceptions {
    public static String encryptCeasar(String message, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) ('a' + (ch - 'a' + shift) % 26);
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
    public static String decryptCeasar(String message, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) ('a' + (ch - 'a' - shift + 26) % 26);
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
    public static void getEncrypted(Scanner in) { // don't pass the scanner and call it in switch
        System.out.println("Give me a message: ");
        in.nextLine();
        String message;
        message = in.nextLine();
        System.out.println("Give me shift: ");
        int shift = in.nextInt();
        String encryptedMessage = encryptCeasar(message, shift);
        System.out.println("Encrypted message: " + encryptedMessage);
    }
    public static void getDecrypted(Scanner in) {
        System.out.println("Give me a message: ");
        in.nextLine();
        String message;
        message = in.nextLine();
        System.out.println("Give me shift: ");
        int shift = in.nextInt();
        String decryptCeasar = decryptCeasar(message, shift);
        System.out.println("decrypted message: " + decryptCeasar);

    }
    public static void menu() {
        System.out.println("""
                Hi, I'm a coding bot, choose an option:\s
                1.Encrypt a message\s
                2.Decrypt a message\s
                3.Quit""");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean event = true;
        int choice;

        do {
            menu();
            choice = in.nextInt();

            switch (choice) {
                case 1 -> getEncrypted(in);
                case 2 -> getDecrypted(in);
                case 3 -> event = false;
                default -> System.out.println("Fuckface");
            }

        }while(event);

    }
}
