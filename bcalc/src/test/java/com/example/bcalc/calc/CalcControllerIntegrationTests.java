package com.example.bcalc.calc;

import com.example.bcalc.calc.dtos.DoMathRequest;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalcControllerIntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getCalcResponse() throws JSONException{
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        DoMathRequest doMathRequest = new DoMathRequest(2, 2, "+");
        HttpEntity<DoMathRequest> request = new HttpEntity<>(doMathRequest, headers);
        String response = this.restTemplate.postForObject("/doMath", request, String.class);
        JSONAssert.assertEquals("{\"calcResponse\":4.0}", response, false);
    }

}
