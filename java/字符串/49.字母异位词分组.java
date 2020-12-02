/*
	算法思想：
		暴力通不过！！！
		将每个字符的位置排序，比较后，然后进行hash存储！！！！

题解：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
*/

class Solution {
public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hash = new HashMap();
        for(int i=0;i<strs.length;i++){
            char[] s_arr = strs[i].toCharArray();
            //排序
            Arrays.sort(s_arr);
            //映射到key
            String key = String.valueOf(s_arr);
            if(hash.containsKey(key)){
                hash.get(key).add(strs[i]);
            }else{
                List<String> tmp = new ArrayList();
                tmp.add(strs[i]);
                hash.put(key,tmp);
            }
        }
        return new ArrayList<List<String>>(hash.values());
  	}

}