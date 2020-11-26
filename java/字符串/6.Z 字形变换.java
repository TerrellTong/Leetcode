/*
	算法思想：
		按题目意思来就可以了，我自己写的比较麻烦，别人写的简洁！！
		别人对于转换，采用了 flag = -1  当满足顶部/底部，则让 flag = -flag！！！从而可以让索引形成z字型遍历！！

题解：https://leetcode-cn.com/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
*/

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        List<List<Character>> lists = new ArrayList();
        //添加numRows个空list
        for(int i=0;i<numRows;i++)
            lists.add(new ArrayList());
        
        int index = 0;
        int i = 0,j = -2;
        while(index < s.length()){
            for(i=j+2;i<numRows;i++){
                if(index == s.length())
                    break;
                lists.get(i).add(s.charAt(index++));
            }
            for(j=i-2;j>=0;j--){
                if(index == s.length())
                    break;
                lists.get(j).add(s.charAt(index++));
            }
        }

        StringBuilder res = new StringBuilder();
        for(int k=0;k<numRows;k++)
            for(int p=0;p<lists.get(k).size();p++)
                res.append(lists.get(k).get(p));

        return res.toString();
    }
}

//别人的解法
class Solution {
    public String convert(String s, int numRows) {
        if(numRows < 2)
            return s;
        //直接用StringBuilder型的列表
        List<StringBuilder> rows = new ArrayList();
        //添加StringBuilder
        for(int i=0;i<numRows;i++)
            rows.add(new StringBuilder());
        
        int i = 0 , flag = -1;
        for(char c:s.toCharArray()){
            rows.get(i).append(c);
            //实现到达尾部/头部进行反向！！
            if(i == 0 || i == numRows-1) 
                flag = -flag;
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows)
            res.append(row);
        return res.toString();
    }
}