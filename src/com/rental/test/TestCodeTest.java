package com.rental.utility;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCodeTest {
    @Test
    public void sendTestCode() throws Exception {
        TestCode  testCode = new TestCode();
        String s = testCode.createTestCode();
        System.out.println("—È÷§¬Î «:"+s);
        testCode.sendTestCode("13437152430",s);
    }

    @Test
    public void createTestCode() throws Exception {
        TestCode  testCode = new TestCode();
        String s = testCode.createTestCode();
        System.out.println(s);
    }

}