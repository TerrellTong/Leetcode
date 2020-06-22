/*
	算法思想：
		后序遍历
	
*/
class Solution {
    public boolean patternMatching(String pattern, String value) {
        int a=0,b=0; //统计a和b的个数
        for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i) == 'a')
                a++;
            else 
                b++;
        }
        //如果value为空串，则判断a*b是否为0，只要一个为0，另外一个取“”，即可返回
        if(value.equals("")){
            if(a*b == 0) 
                return true;
            return false;
        }
        if(pattern.equals(""))
            return false;
        //如果只有a/b，则统一按照a进行处理
        if(b == pattern.length())
            a = b;
        if(a == pattern.length()){
            //长度不能被a的次数整除，则返回false
            if(value.length()%a != 0)
                return false;
            //c表示可以value的长度可以被a切成多少份
            int c = value.length()/a;
            String s = value.substring(0,c);//按照平均长度c断开匹配
            for(int i=0;i<a;i++){
                if(!s.equals(value.substring(c*i,c*(i+1))))
                    return false;
            }
            return true;
        }
        List<List<Integer>> r = new ArrayList();//记录所有整数解的a与b的串的长度
        //找到能够把value切分成a,b子串的条件,i的值是a的长度
        for(int i=0;i<=value.length();i++){
            int temp = value.length() - a*i;
            if(temp < 0) break;
            if(temp%b == 0){
                List<Integer> res = new ArrayList();
                res.add(i);
                res.add(temp/b);
                r.add(res);
            }
        }
        //在pattern中，找到a,b的起始索引
        int a_start = pattern.indexOf('a'),b_start=pattern.indexOf('b');
        for(List<Integer> list:r){
            //m表示a代表的长度，n表示b代表的长度
            int m = list.get(0),n=list.get(1),sum=0; //用sum累计下标值
            //a_start*n，表示a之前有代表多少个b的长度
            //s1的结果是:a代表的字符串，s2的结果是:b代表的字符串
            String s1 = value.substring(a_start*n,a_start*n+m),s2=value.substring(b_start*m,b_start*m + n);
            if(s1.equals(s2))
                continue;
            boolean flag =true;
            for(int k=0;k<pattern.length();k++){
                String s = pattern.charAt(k) == 'a'?s1:s2;
                int p = pattern.charAt(k) == 'a'?m:n;
                if(!s.equals(value.substring(sum,sum+p))){
                    flag = false;
                    break;
                }
                sum += p;
            }
            if(flag)
                return true;//只要存在一组解，就为真
        }
        return false;
    }
}




