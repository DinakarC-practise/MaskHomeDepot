package com.dinakar.mask;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class MaskEmailTest {

  @Test
  public void maskEmail() {
    String email = "homer@homedepot.com";
    assertNotNull(MaskEmail.maskString(email), "should not be null");
    assertEquals(MaskEmail.maskString(email), "h***r@homedepot.com", "should be equal to");
  }

  @Test
  public void isMaskEmailEmpty() {
    String email = "";
    assertNull(MaskEmail.maskString(email), "should be empty");
  }

  @Test
  public void isMaskEmailNull() {
    String email = null;
    assertNull(MaskEmail.maskString(email), "should be null");
  }

  @Test
  public void isInvalidEmail() {
    String email = "ab@homedepot@.com";
    assertFalse(MaskEmail.isValid(email), "This email address is valid");
  }

  @Test
  public void isValidEmail() {
    String email = "homer@homedepot.com";
    assertTrue(MaskEmail.isValid(email), "This email address is not valid");
  }

  @Test
  public void isEmailLengthVaild() {
    String email = "ab@homedepot.com";
    assertFalse(MaskEmail.isValid(email), "This email address is valid");
  }


}