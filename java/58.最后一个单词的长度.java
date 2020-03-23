/*
	
*/

class Solution {
    public int lengthOfLastWord(String s) {
        String[] str_arr = s.split(" ");
        //进行split后的数组  
        int length = str_arr.length;
        //如果数组长度为0(即空字符串)
        if(length == 0)
            return 0;
        int count=0;
        for(;count<str_arr[length-1].length();count++);
        return count;
    }
}

