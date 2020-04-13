package com.dinakar.mask;

import java.util.Scanner;

public class MaskEmail {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a valid Email address:");
    String str = sc.nextLine();
    if (null != maskString(str)) {
      System.out.println("The masked email is: " + maskString(str));
    } else {
      System.out.println("ENTER VALID EMAIL ADDRESS");
    }

  }

  public static String maskString(String email) {
    String result = null;
    int at = email.indexOf("@");
    if (isValid(email)) {
      StringBuilder sb = new StringBuilder(email);
      for (int i = 1; i < (at - 1); ++i) {
        sb.setCharAt(i, '*');
      }
      result = sb.toString();
    }
    return result;
  }
//check for validating email
  public static boolean isValid(String email) {
    boolean result = false;
    if (email.substring(0, email.indexOf("@")).length() > 2) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
    } else {
      return result;
    }
  }
}
