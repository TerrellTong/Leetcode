/*
	算法思想：
		之前做过，二刷，获取每个字符串的字符数组，然后进行按照字典序排序，排序后，判断这个字符串是否在map
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String tmp = new String(arr);
            if(map.get(tmp) == null){
                List<String> list = new ArrayList();
                list.add(str);
                map.put(tmp,list);
            }else{
                map.get(tmp).add(str);
            }
        }
        return new ArrayList(map.values());
    }
}
