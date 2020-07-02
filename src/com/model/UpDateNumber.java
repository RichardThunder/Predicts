package com.model;

public class UpDateNumber {// 修改开奖期数
private int number;// 要修改的开奖期数
static int n;// 声明静态变量n，存储要修改的开奖期数

public int getNumber() {// 获得要修改的开奖期数
    return number;
}

public void setNumber(int number) {// 为要修改的开奖期数赋值
    this.number = number;
    n = number;// 将要修改的开奖期数赋值给静态变量n
}

public static int getN() {// 获得要修改的开奖期数
    return n;
}
}
