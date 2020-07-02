package com.model;

public class Forecast {
private int id;// id（数据库中的id）
private int number;// 开奖期数
private int a;// 第1位
private int b;// 第2位
private int c;// 第3位
private int d;// 第4位
private int e;// 第5位
private int f;// 第6位
private int g;// 第7位
private String forecasttime;// 预测时间
private Long neutron;// 奖金

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public int getNumber() {
    return number;
}

public void setNumber(int number) {
    this.number = number;
}

public int getA() {
    return a;
}

public void setA(int a) {
    this.a = a;
}

public int getB() {
    return b;
}

public void setB(int b) {
    this.b = b;
}

public int getC() {
    return c;
}

public void setC(int c) {
    this.c = c;
}

public int getD() {
    return d;
}

public void setD(int d) {
    this.d = d;
}

public int getE() {
    return e;
}

public void setE(int e) {
    this.e = e;
}

public int getF() {
    return f;
}

public void setF(int f) {
    this.f = f;
}

public int getG() {
    return g;
}

public void setG(int g) {
    this.g = g;
}

public String getForecasttime() {
    return forecasttime;
}

public void setForecasttime(String forecasttime) {
    this.forecasttime = forecasttime;
}

public Long getNeutron() {
    return neutron;
}

public void setNeutron(Long neutron) {
    this.neutron = neutron;
}
}
