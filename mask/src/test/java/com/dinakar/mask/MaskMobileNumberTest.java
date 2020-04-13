package com.dinakar.mask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MaskMobileNumberTest {

  @Test
  public void maskMobileNumber() {
    String mobileNumber = "(404) 443-8211";
    assertNotNull("should not be null", MaskMobileNumber.maskMobileNumber(mobileNumber));
    assertEquals("should be equal", MaskMobileNumber.maskMobileNumber(mobileNumber),
        "(404) ***-8211");
  }

  @Test
  public void maskMobileNumberIsNull() {
    String mobileNumber = null;
    assertNull("should be null", MaskMobileNumber.maskMobileNumber(mobileNumber));
  }

  @Test
  public void maskMobileNumberIsEmpty() {
    String mobileNumber = "";
    assertNull("should be null", MaskMobileNumber.maskMobileNumber(mobileNumber));
  }

  @Test
  public void maskMobileNumberLengthDoesNotMatch() {
    String mobileNumber = "111111";
    assertNull("should be null", MaskMobileNumber.maskMobileNumber(mobileNumber));

  }

}
