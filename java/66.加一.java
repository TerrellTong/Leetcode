/*
	
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for(int i=length-1;i>=0;i--){
            //进位操作
            digits[i]++;
            int flag = digits[i]%10; 
			//如果发现flag == 0 (表明已经进位)，则将此为置为0
            if(flag != 0) 
                return digits;
            else
                digits[i] = 0;
        }
		//为数组开辟新的长度的方法，9,99,999 进一位原数组会溢出
        digits = new int [length+1];
        digits[0] = 1;
        return digits;
    }
}

