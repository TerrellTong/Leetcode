/*
	算法思想：
		map+set即可
*/


class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap();
        //存放已经映射成功的单词
        Set<String> set = new HashSet();
        String[] strArr = s.split(" ");
        //如果数组长度和带拆分的字符串长度不相等，直接返回
        if(strArr.length != pattern.length())
            return false;
        for(int i=0;;i<pattern.length();i++){
            //说明当前map没有存这个模式和str的对应关系
            if(map.getOrDefault(pattern.charAt(i),null) == null){
                if(!set.contains(strArr[i])){
                    map.put(pattern.charAt(i),strArr[i]);
                    set.add(strArr[i]);
                }else
                    return false;
                //字符串的比较
            }else if(map.get(pattern.charAt(i)).equals(strArr[i])){
                continue;
            }else
                return false;
        }
        return true;
    }
}