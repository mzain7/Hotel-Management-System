package com.example.hotel_transylvania;

import java.util.*;
public class CardValidation {
    public static boolean validation(long credit_number) {
        return (sizecheck(credit_number)>= 13 && sizecheck(credit_number) <= 16 &&
                (sumOfEven(credit_number)+sumOfOdd(credit_number)) % 10 == 0);
    }
    public static int sizecheck(long c_num) {
        String num = c_num+"";
        return num.length();
    }
    public static boolean prefixcheck(long c_num, int d) {
        return getprefix(c_num, sizecheck(d)) == d;
    }
    public static long getprefix(long c_num, int k) {
        if(sizecheck(c_num)>k) {
            String num = c_num + "";
            return Long.parseLong(num.substring(0, k));
        }
        return c_num;
    }
    public static int sumOfOdd(long c_num) {
        int sum = 0;
        String num = c_num + "";
        for(int i = sizecheck(c_num)-1; i >= 0; i -= 2) {
            sum += Integer.parseInt(num.charAt(i)+"");
        }
        return sum;
    }
    public static int sumOfEven(long c_num) {
        int sum = 0;
        String num = c_num + "";
        for(int i = sizecheck(c_num)-1; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(num.charAt(i)+""));
        }
        return sum;
    }
    public static int getDigit(int num) {
        if(num<9)
            return num;
        return num/10 + num%10;
    }}