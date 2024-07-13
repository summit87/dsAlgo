package bitwise;

public class Bitwise1 {

    public static void main(String[] args) {
        //  leftShift();
        //  rightShift();
        //System.out.println(isNumberPowerOf2(16));
        //System.out.println(checkIfIthBitSetOrNot(7,3));
        //System.out.println(extractLastBit(0));
       // bitwise1(5);
       System.out.println(onesComplement(8));
    }

    public static void leftShift() {
        /**
         * Left shift operator : Left shift operator is nothing but multiplying
         * the number with 2^k , where k is number of bit which we wanted to
         * shift to left e.g : if we wanted to shift 2 bit of the number 5 , i.e
         * we are multiplaying 5 with 2^2 , where k = 2 5*4 : 20 , for
         * representation purpose , if we wanted to do k shift for give number
         * n, n << k
         */
        int k = 3;
        int num = 2;
        System.out.println(num << k);
    }

    public static void rightShift() {
        /**
         * Similarly , for the right shift , we will be divind the number with
         * 2^k K : which represent number bit we are shifting to the right for
         * give number
         *
         * e.g we are shifting 2 bit of the right of number 5 5 / 2^2 : 1
         * representation purpose , if we wanted to do k shift for give number n
         * to the right n, n >> k
         */

        System.out.println((6 >> 2));
    }

    /**
     * How to get the number - 1 , i.e if number is n = 4, then how we will get
     * 4-1 => 3 using bitwise bitwise representational of number 4 => 0100 Lets
     * do the reverse all the bit of the rightmost once steps : 1. 4 => 0100 2.
     * rerse all the bit of the rightmost one's including the rightmost once ,
     * i.e 0100 => 0011 , 3. 0011 => 3
     *
     */
    public static boolean isNumberPowerOf2(int num) {

        /**
         * *********************************************************************************
         * TO FIND WHEATHER AS NUMBER IS POWER OF TWO OR NOT * WE NEED TO DO DO
         * BELOW STEP. LET SAY GIVEN NUMBER IS N * 1. THEN GET THE GIVE NUMBER
         * AND DO , X = N-1 * 2. THEN DO THE (N & X) , * IF ANY NUMBER IS POWER
         * OF TWO THEN ONLY ONE BIT WILL BE SET * IF NUMBER HAVING MORE THAN ONE
         * BIT SET , THEN THAT NUMBER IS NOT A POWER OF TWO *
 **********************************************************************************
         */
        int x = num - 1;
        return num > 0 && (num & x) == 0;
    }

    public static boolean checkIfIthBitSetOrNot(int num, int ith) {
        /**
         * To check if ith bit for any given number is set , we need to peform
         * below steps , let say number is N
         *
         * 1. Find another Number with expression 2^i , i.e 1 << i, let say that
         * number id M 2. Then do X = M & N , the result number will have only
         * ith bit set and rest is un-set 3. if all the bit are unset then the
         * number does't have any bit set
         */

        int x = 1 << ith;
        System.out.println(x + " : " + (num & x));
        return (num & x) > 0;
    }

    /**
     * Extract last bit from number 1. calculate the binary represenatational 2.
     * flip all the bit from number 3. add one to last bit in result
     *
     * @param x
     * @return
     */
    public static int extractLastBit(int x) {
        return (x + (x & -x));
    }

    /**
     * There are three approach to calculate the binary representational for
     * number 1. Check if the ith bit is set or not if ith bit is set print 1
     * else 0
     * Other approach , recursivley we will devide the number by 2 if num > 0
     * @param num
     */
    public static void bitwise(int num) {

        /**
         * In for loop , we are starting from 2^i , i will be 8bit or 32bit or 64bit operation
         * every divisible by 2 of the i will move every single bit ,
         * e.g i = 2^8 => 256, divide i by 2 => 128 => 2^7....
         */
        for (int i = 1 << 8; i > 0; i = i >> 1) {
            /**
             * i = 2^8 ,
             * then doing n&i , so here we don't have to Math.pow(2^i) , beause we already moving i by 2^i , where i = i/2
             */
            int x = num & i;
            if (x >= 1) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
    }

    public static void bitwise1(int num){
        if(num > 0){
            bitwise1(num >> 1);
        }
        System.out.print(num % 2);
    }




    /**
     * 1's complement of number we can calculate by below approach
     * 1. calculate number set bit , lat say  => n
     * 2. calculate two to the power of number of bit , i.e 2^n
     * 3. then subtract original number with that number
     */

     public static int onesComplement(int num){
        int count = 0;
        int x = num;
        while (num > 0) {
            if(num%2 >= 1){
                count++;
            }
            num = num / 2; 
        }
        System.out.println(count);
        int num1 = ((int)Math.pow(2, count)) - 1;
        return x - num1;
     }



}
