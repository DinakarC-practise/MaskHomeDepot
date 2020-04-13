package com.dinakar.mask;

import java.util.Scanner;

public class MaskMobileNumber {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a valid Mobile number:");
    String str = sc.nextLine();
    if (null != maskMobileNumber(str)) {
      System.out.println("The masked number is: " + maskMobileNumber(str));
    } else {
      System.out.println("ENTER VALID NUMBER");
    }
  }

  public static String maskMobileNumber(String mobileNumber) {
    String result = null;
    String intermediate;
    if (null != mobileNumber && !mobileNumber.isEmpty()) {
      intermediate = mobileNumber.replaceAll("[^a-zA-Z0-9\\s+]", "").replace(" ", "");
      int len = intermediate.length();
      StringBuilder sb = new StringBuilder(len);
      for (len = 3; len < 6; len++) {
        sb.append("*");
      }
      if (intermediate.length() == 10) {
        result = "(" + intermediate.substring(0, 3) + ")" + " " + sb + "-" + intermediate
            .substring(6, 10);
      }
    }
    return result;
  }
}