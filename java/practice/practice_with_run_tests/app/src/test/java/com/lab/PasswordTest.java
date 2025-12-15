package com.lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Password implementations.
 * 
 * To test different buggy versions, simply uncomment the corresponding
 * getPassword() method and comment out the others.
 * 
 * Available implementations:
 * - Password: Correct implementation
 * - BugDoesNotTrim: Does not trim whitespace
 * - BugToShortPassword: Allows passwords shorter than 12 characters
 * - BugVeryShort: Allows way to short passwords
 * - BugWrongExceptionMessage: Wrong exception message for short passwords
 * - BugMissingPasswordLengthCheck: Does not throw exception for short passwords
 * - BugMissingNumberCheck: Does not throw exception if password lacks a number
 * - BugIsPasswordSameAlwaysTrue: isPasswordSame always returns true
 * - BugWrongHashingAlgorithm: Wrong hashing algorithm
 */

public class PasswordTest {
    private IPassword getPassword(String s) throws Exception {
        //return (IPassword) new Password(s);
        //return (IPassword) new BugDoesNotTrim(s);
        //return (IPassword) new BugToShortPassword(s);
        //return (IPassword) new BugVeryShort(s);
        //return (IPassword) new BugWrongExceptionMessage(s);
        //return (IPassword) new BugMissingPasswordLengthCheck(s);
        //return (IPassword) new BugMissingNumberCheck(s);
        //return (IPassword) new BugIsPasswordSameAlwaysTrue(s); 
        return (IPassword) new BugWrongHashingAlgorithm(s);
    }

    @Test
    public void shouldAlwaysPass() throws Exception {
        assertTrue(true);
    }

    // Checks if password is trimmed.
    @Test
    public void passwordShouldTrimWhitespacesWhenCreated() throws Exception {
        IPassword password = getPassword("  myPassword123  ");
        IPassword trimmedPassword = getPassword("myPassword123");
        assertEquals(trimmedPassword.getPasswordHash(), password.getPasswordHash());
    }

    // Checks if password is too short is thrown.
    @Test
    public void passwordShouldThrowExceptionForTooShortPassword() throws Exception {
        Exception e = assertThrows(Exception.class, () -> getPassword("Password123"));
        assertEquals("To short password", e.getMessage());
    }

    // Checks if exception is thrown when password is entered without number.
    @Test
    public void exceptionShouldBeThrownForPasswordWithoutNumber() throws Exception {
        assertThrows(Exception.class, () -> getPassword("PasswordNoNumber"));
    }

    // Checks if exception is thrown when passwords are not the same.
    @Test
    public void isPasswordSameShouldReturnFalseForDifferentPasswords() throws Exception {
        IPassword pw1 = getPassword("Password1234");
        IPassword pw2 = getPassword("Password4321");
        assertFalse(pw1.isPasswordSame(pw2));
    }

}
