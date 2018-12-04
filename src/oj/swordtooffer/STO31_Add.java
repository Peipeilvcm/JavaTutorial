package oj.swordtooffer;

public class STO31_Add {
    public int add(int num1, int num2){
        int tmp = 0;
        while(num1 != 0 && num2 !=0){
            tmp = num1^num2;
            num1 = (num1 & num2)<<1;
            num2 = tmp;
        }
        return num1 == 0 ? num2 : num1;
    }
}
