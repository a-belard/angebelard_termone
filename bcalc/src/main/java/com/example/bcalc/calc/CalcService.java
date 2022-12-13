package com.example.bcalc.calc;

import com.example.bcalc.calc.dtos.DoMathResponse;
import com.example.bcalc.calc.exceptions.InvalidOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CalcService {
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException {
        if("/".equals(operation) && operand2 == (double) 0){
            throw new InvalidOperationException(("Cannot divide by 0"));
        }

        switch (operation){
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "-":
                return operand1 - operand2;
            case "+":
                return operand1 + operand2;
            case "**":
                return Math.pow(operand1, operand2);
            case "log":
                return operand1 * Math.log10(operand2);
            case "ln":
                return operand1 * Math.log(operand2);
            default:
                throw new InvalidOperationException("Unkown operation");
        }
    }
}
