/*
	算法思想：
		按照题解
				
*/

class Solution {
    public int myAtoi(String str) {
        //空字符串
        if(str.equals(""))
            return 0;
        //修枝多余的“”
        String str_tr = str.trim();
        //用StringBuilder存储备选的字符串
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str_tr.length();i++){
            if((str_tr.length()>=2)&&(str_tr.charAt(0)+str_tr.charAt(1) == 88))
                return 0;
            if((str_tr.charAt(i) == '+')&&i==0)
                continue;
            if((('0'<=str_tr.charAt(i))&&(str_tr.charAt(i)<='9'))||((str_tr.charAt(i) == '-')&& i == 0))
                sb.append(str_tr.charAt(i));
            else
                break;
        }
        //将StringBuilder转成String
        String result = sb + "";
        if(result.equals("") || result.equals("-"))
            return 0;
        //将String转成int
        int res;
        //数大于int处理
        try{
            res = Integer.parseInt(result);
        }catch(Exception e){
            if(result.charAt(0) == '-')
                res = -2147483648;
            else
                res = 2147483647;
        }
   
        return res;
    }
}











