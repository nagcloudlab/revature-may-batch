package com.example;

public class Q {


    static String in = "1234";

    public static void main(String[] args) {
        substrings(0,1);
    }

    static void substrings(int start, int end){
        if(start == in.length() && end == in.length()){
            return;
        }else{
            if(end == in.length()+1){
                substrings(start+1,start+1);
            }else{
                System.out.println(in.substring(start, end));
                substrings(start, end+1);
            }
        }
    }
}
