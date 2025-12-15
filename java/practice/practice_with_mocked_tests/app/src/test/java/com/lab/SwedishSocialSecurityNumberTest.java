package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SwedishSocialSecurityNumberTest {
    
    private SSNHelper helper;
    //private BuggySSNHelperAllowDayUpTo30 helper;
    //private BuggySSNHelperAllowMonth0 helper;
    //private BuggySSNHelperIncorrectFormat helper;
    //private BuggySSNHelperIncorrectFormatFalse helper;
    //private BuggySSNHelperMessyLuhn helper;
    //private BuggySSNHelperWrongLength helper;
    
    @BeforeEach
    public void setUp() {
        helper = new SSNHelper();
        //helper = new BuggySSNHelperAllowDayUpTo30();
        //helper = new BuggySSNHelperAllowMonth0();
        //helper = new BuggySSNHelperIncorrectFormat();
        //helper = new BuggySSNHelperIncorrectFormatFalse();
        //helper = new BuggySSNHelperMessyLuhn();
        //helper = new BuggySSNHelperWrongLength();
    }
    
    @Test
    public void isValidDayShouldReturnTrueFor31() {
        assertTrue(helper.isValidDay("31"));
    }

    @Test
    public void isValidMonthShouldReturnFalseFor0() {
        assertFalse(helper.isValidMonth("0"));
    }

    @Test
    public void isCorrectFormatShouldReturnFalseWhenIncorrect() {
        assertFalse(helper.isCorrectFormat("abc-ed"));
    }

    @Test
    public void isCorrectFormatShouldReturnTrueWhenCorrect() {
        assertTrue(helper.isCorrectFormat("900101-0017"));
    }

    @Test
    public void luhnIsCorrectShouldReturnTrueWhenCorrect() {
        assertTrue(helper.luhnIsCorrect("900101-0017"));
    }

    @Test
    public void isCorrectLengthShouldReturnFalseWhenTooLong() {
        assertFalse(helper.isCorrectLength("900101-00177"));
    }
}