//
// Created by dev on 2022/6/13.
//


#include <stdio.h>

int sumNums(int n) {
    int res;
    __asm(
    "movl %%edi, %%eax\n"
    "incl %%edi\n"
    "imull %%edi\n"
    "shrl $1, %%eax\n"
    :"=a"(res)
    );
    return res;
}


int main() {
    int a = 10;
    int b = 0;
    int c;

    static int d = 11;
    static int e = 0;
    static int f;
    int val = sumNums(5);
    printf("val %d", val);

    return 0;

}


