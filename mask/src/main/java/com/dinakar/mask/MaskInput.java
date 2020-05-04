package com.dinakar.mask;

import java.util.Scanner;

public class MaskInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a valid Email or Mobile Number:");
        String str = sc.next();
        if (null != str && !str.isEmpty()) {
            if (isEmailValid(str) && null != maskEmail(str)) {
                System.out.println("Masked email is: " + maskEmail(str));
            } else if (isEmailValid(str) && null != maskMobileNumber(str)) {
                System.out.println("Masked Mobile Number " + maskMobileNumber(str));
            } else {
                System.out.println("Provide valid details");
            }
        } else {
            System.out.println("provide valid details");
        }
    }

    // Masks email ID except for first and last character, works only for more than 2 chars in the ID.
    public static String maskEmail(String email) {
        String result = null;
        if (null != email && isEmailValid(email)) {
            int i = email.indexOf("@");
            String j = email.substring(1, (i - 1));
            if (email.substring(0, i).length() > 2) {
                result = email.charAt(0) + new String(new char[j.length()]).replace("\0", "*") + email.substring(i - 1, email.length());
            }
        }
        return result;
    }

    // Masks only middle three characters in the given mobile number.
    public static String maskMobileNumber(String mobileNumber) {
        String result = null;
        if (null != mobileNumber && isNumberValid(mobileNumber)) {
            result = mobileNumber.replace(mobileNumber.substring(3, 6), "***");
        }
        return result;
    }

    // check for valid email assuming format as "example@domain.com"
    public static boolean isEmailValid(String email) {
        return email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");

    }

    // Check for valid mobile number assuming format as "4044438211"
    public static boolean isNumberValid(String str) {
        return str.matches("\\d{10}") && str.length() == 10;
    }
}
