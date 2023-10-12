package com.testdemo;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.*;

public class AppTest
{
    Calculator calc ;

    @BeforeClass(alwaysRun = true)
    public void initAll(){
      calc  = new Calculator();
    }

    @Test(groups = "addition")
    public void addPositiveTest(){
        assertEquals(11,calc.add(5,6));
    }

    @Test(groups = "addition")
    public void addNegativeTest(){
        assertEquals(-11,calc.add(-5,-6));
    }

    @Test(groups = "subtraction")
    public void subtractPositiveTest(){
        assertEquals(6,calc.subtract(12,6));
    }

    @Test(groups = "subtraction")
    public void subtractNegativeTest(){
        assertEquals(-6,calc.subtract(-12,-6));
    }

    @Test(groups = "Multiplication")
    public void multiplyPositiveTest(){
        assertEquals((long)(56),calc.multiply(8,7));
    }

    @Test(groups = "Multiplication")
    public void multiplyNegativeTest(){
        assertEquals((56),calc.multiply(-8,-7));
    }

    @Test(dependsOnMethods = "divideByZeroTest", groups="Division")
    public void divideTest(){
        assertEquals(8,calc.divide(16,2),0);
    }

    @Test(groups = "Division")
    public void divideByZeroTest(){
        assertEquals(0,calc.divide(10,0),0);
    }

}
