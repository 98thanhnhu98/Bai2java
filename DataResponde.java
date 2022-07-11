package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataResponde {
    private String MSG;
    private float x1;
    private float x2;

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }

    public float getX1() {
        return x1;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getX2() {
        return x2;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    @Override
    public String toString() {
        return "DataResponde{" +
                "MSG='" + MSG + '\'' +
                ", x1=" + x1 +
                ", x2=" + x2 +
                '}';
    }
    @GetMapping("/xy/{a}/{b}/{c}")
    public String method(@PathVariable int a,@PathVariable int b,@PathVariable int c){
        double detal = Math.pow(b, 2) - 4 * a * c;
        if(detal < 0){
            MSG = "Phương trình vô nghiệm";
            return MSG;
        } else if (detal == 0) {
            x1 = -b / (2*a);
            x2 = x1;
            MSG = "0 thì phương trình có nghiệm kép";
            return MSG + " và có nghiệm kép là : "+ x1;
        }else {
            MSG= "0 thì phương trình có 2 nghiệm phân biệt";
            x1 = (float) ((-b + Math.sqrt(detal)) / (2 * a));
            x2 = (float) ((-b - Math.sqrt(detal)) / (2 * a));
            return MSG + " X1 = " + x1 + " X2 = " + x2;
        }
    }

}
