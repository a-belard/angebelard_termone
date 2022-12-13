package com.example.bcalc.calc.dtos;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoMathRequest {
    private double operand1;
    private double operand2;
    private String operation;

    @Override()
    public String toString() {
        // values to json
        return "{\"operand1\":" + operand1 + ",\"operand2\":" + operand2 + ",\"operation\":\"" + operation + "\"}";
    }
}
