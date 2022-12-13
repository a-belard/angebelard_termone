package com.example.bcalc.calc;

import com.example.bcalc.calc.dtos.DoMathRequest;
import com.example.bcalc.calc.dtos.DoMathResponse;
import com.example.bcalc.calc.exceptions.InvalidOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    @Autowired
    CalcService calcService;

    @PostMapping("/doMath")
    @ResponseStatus(HttpStatus.OK)
    public DoMathResponse doMath(@RequestBody DoMathRequest doMathReq) throws InvalidOperationException {
        return new DoMathResponse(calcService.doMath(doMathReq.getOperand1(), doMathReq.getOperand2(), doMathReq.getOperation()));
    }
}
