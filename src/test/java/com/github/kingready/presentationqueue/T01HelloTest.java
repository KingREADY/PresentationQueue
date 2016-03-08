package com.github.kingready.presentationqueue;

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class T01HelloTest {
    @Before
    public void init() {
        System.out.println("Before each test");
    }

    @Test
    public void hello() {
        String result = "hello";
        assertNotNull(result);
    }
    
    @Test
    public void hello2() {
        String result = "hello";
        assertNull(result);
    }

    @After
    public void destroy() {
        System.out.println("After each test");
    }
}
