package com.dinakar.mask;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MaskInputTest {
    @Test
    public void maskEmail() {
        String email = "homer@homedepot.com";
        assertNotNull("should not be null", MaskInput.maskEmail(email));
        assertEquals("should be equal to", MaskInput.maskEmail(email), "h***r@homedepot.com");
    }

    @Test
    public void isMaskEmailEmpty() {
        String email = "";
        assertNull("should be empty", MaskInput.maskEmail(email));
    }

    @Test
    public void isMaskEmailNull() {
        String email = null;
        assertNull("should be null", MaskInput.maskEmail(email));
    }

    @Test
    public void isInvalidEmail() {
        String email = "homer@homedepot@.com";
        assertFalse(MaskInput.isEmailValid(email), "This email address is valid");
    }

    @Test
    public void isValidEmail() {
        String email = "homer@homedepot.com";
        assertTrue(MaskInput.isEmailValid(email), "This email address is not valid");
    }

    @Test
    public void isEmailLengthValid() {
        String email = "ab@homedepot.com";
        assertNull("This email address is valid", MaskInput.maskEmail(email));
    }

    @Test
    public void maskMobileNumber() {
        String mobileNumber = "4044438211";
        assertNotNull("should not be null", MaskInput.maskMobileNumber(mobileNumber));
        assertEquals("should be equal to", MaskInput.maskMobileNumber(mobileNumber), "404***8211");
    }

    @Test
    public void maskMobileNumberIsNull() {
        String mobileNumber = null;
        assertNull("should be null", MaskInput.maskMobileNumber(mobileNumber));
    }

    @Test
    public void maskMobileNumberIsEmpty() {
        String mobileNumber = "";
        assertNull("should be empty", MaskInput.maskMobileNumber(mobileNumber));
    }

    @Test
    public void isInvalidNumber() {
        String mobileNumber = "111111";
        assertNull("should return null", MaskInput.maskMobileNumber(mobileNumber));
    }

    @Test
    public void isValidNumber() {
        String mobileNumber = "4044438211";
        assertTrue(MaskInput.isNumberValid(mobileNumber), "This mobile numberis not valid");
    }

}