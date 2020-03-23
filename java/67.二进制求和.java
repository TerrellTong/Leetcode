/*
	思想：
		通过ASCII码来将字符转换成‘0’
*/

class Solution {
    public String addBinary(String a, String b) {
        char[] a_str = a.toCharArray();
        char[] b_str = b.toCharArray();
        //用StringBuilder类来保存加后的值，然后再进行逆转
        StringBuilder sb = new StringBuilder();
        //进位标志
        int flag = 0;
        //逆序
        for(int i=a_str.length-1,j=b_str.length-1;i >= 0||j >= 0;i--,j--){
            //将字符与0的ASCII码进行相减，结果就是int型，判断是否大于0
            //判断是否会出现字符串越界，如果出现了就将该值设为0
            int a_num = (i >= 0)? a_str[i]-'0':0;
            int b_num = (j >= 0)? b_str[j]-'0':0;
            int result = a_num+b_num+flag;
            if(result >= 2){
                sb.append(result-2);
                flag = 1;
            }else{
                sb.append(result);
                flag = 0;
            }
        }
        if(flag == 1)
            sb.append(flag);
        return sb.reverse()+"";        
    }
}

