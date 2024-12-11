class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }

        return a;
    }
}

/*
Initialization:
a = 1 (in binary: 01)
b = 2 (in binary: 10)

1.temp = (a & b) << 1
a & b = 01 & 10 = 00 (bitwise AND), 00 << 1 is 00 (shift left by one, still 00)

2.a = a ^ b
a ^ b is 01 ^ 10 = 11 (bitwise XOR, which gives the sum without carry)

3.b = temp
b becomes 00

Loop Exit Condition: Since b is now 0, the loop exits.
The final value of a is 11 in binary, which is 3 in decimal.
*/