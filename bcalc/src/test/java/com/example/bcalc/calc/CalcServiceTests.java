package com.example.bcalc.calc;

import com.example.bcalc.calc.dtos.DoMathRequest;
import com.example.bcalc.calc.exceptions.InvalidOperationException;
import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class CalcServiceTests {
        CalcService calcService = new CalcService();

        public void testAdd() throws InvalidOperationException {
            double result = calcService.doMath(1, 2, "+");
            Assert.assertEquals(result, 3, "1 + 2 should equal 3");
        }

        public void testSubtract() throws InvalidOperationException {
            double result = calcService.doMath(1, 2, "-");
            Assert.assertEquals(result, -1, "1 - 2 should equal -1");
        }

        public void testMultiply() throws InvalidOperationException {
            double result = calcService.doMath(1, 2, "*");
            Assert.assertEquals(result, 2, "1 * 2 should equal 2");
        }

        public void testDivide() throws InvalidOperationException {
            double result = calcService.doMath(1, 2, "/");
            Assert.assertEquals(result, 0.5, "1 / 2 should equal 0.5");
        }

        public void testPower() throws InvalidOperationException {
            double result = calcService.doMath(2, 3, "**");
            Assert.assertEquals(result, 8, "2 ** 3 should equal 8");
        }

        public void testLog() throws InvalidOperationException {
            double result = calcService.doMath(2, 3, "log");
            Assert.assertEquals(result, 0.3010299956639812, "2 log 3 should equal 0.3010299956639812");
        }

        public void testLn() throws InvalidOperationException {
            double result = calcService.doMath(2, 3, "ln");
            Assert.assertEquals(result, 0.6931471805599453, "2 ln 3 should equal 0.6931471805599453");
        }

        public void testInvalidOperation() {
            try {
                calcService.doMath(1, 2, "invalid");
            } catch (InvalidOperationException e) {
                Assert.assertEquals(e.getMessage(), "Unkown operation");
            }
        }
}
