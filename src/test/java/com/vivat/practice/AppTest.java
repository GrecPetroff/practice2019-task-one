package com.vivat.practice;

import static org.junit.Assert.assertEquals;

import com.vivat.practice.exception.UnsupportedValue;
import org.junit.Test;

public class AppTest {

    @Test
    public void initialsFoundSuccess() {
        assertEquals("A P", App.getInitials("Alexei Petrov"));
    }

    @Test(expected = UnsupportedValue.class)
    public void initialsBlankInput() {
        App.getInitials("");
    }

}
