 /*
	算法思想：
	StringBuilder
 */
class Solution {
    public String compressString(String S) {
        if(S.equals(""))
            return "";
        //存储最后的结果字符串
        StringBuilder sb = new StringBuilder();
        //记录当前字符的数目
        int sum = 1;
        int i=0;
        for(int j=1;j<S.length();){
            if(S.charAt(i) == S.charAt(j)){
                j++;
                sum++;
            }else{
                sb.append(S.charAt(i));
                sb.append(sum);
                //j的指针赋给i
                i=j;
                j++;
                sum=1;
            }
        }
		//最后一个重复的字符添加
        sb.append(S.charAt(i));
        sb.append(sum);
        String result = sb+"";
        if(result.length() < S.length())
            return result;
        return S;
    }
}

