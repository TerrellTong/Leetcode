/*
	算法思想：
		双指针，当遇到不相等的，j++,相等就i++
		但是由于j比较长，因此要提防alex,aaleelx，这样在输入某个字符后，又重新输入原来的字符了
		
		之前没有思路（想复杂了！），看了下提示！！
		

*/

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        int i=0,j=0;
        while(j<typed.length()){
            if(i < name.length() && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
                //防止alex,aaleelx，这样在输入某个字符后，又重新输入原来的字符了
            }else if(j > 0 && typed.charAt(j) == typed.charAt(j-1))
                j++;
            else
                return false;
        }

        if(i == name.length() )
            return true;
        else
            return false;
    }
}
