package com.model;

public class UpDateNumber {// �޸Ŀ�������
private int number;// Ҫ�޸ĵĿ�������
static int n;// ������̬����n���洢Ҫ�޸ĵĿ�������

public int getNumber() {// ���Ҫ�޸ĵĿ�������
    return number;
}

public void setNumber(int number) {// ΪҪ�޸ĵĿ���������ֵ
    this.number = number;
    n = number;// ��Ҫ�޸ĵĿ���������ֵ����̬����n
}

public static int getN() {// ���Ҫ�޸ĵĿ�������
    return n;
}
}
