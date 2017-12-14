package com.safefire;


public class Test111 {

    public static void main(String[] args) {
        String thingName = "Back_A10_Thing";
        int x1 = thingName.indexOf("_");
        int x2 = thingName.lastIndexOf("_");
        String propertName = thingName.substring(x1 + 1, x2);
        System.out.print(propertName);
    }

}