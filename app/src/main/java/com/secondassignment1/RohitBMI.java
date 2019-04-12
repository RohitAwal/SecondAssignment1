package com.secondassignment1;

public class RohitBMI {
    private double height,weight;
    public RohitBMI(double height, double weight){
        this.height=height;
        this.weight=weight;
    }
    public double calculate(){
        return weight/(height/100 * height/100);
    }
}
