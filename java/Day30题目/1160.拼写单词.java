 /*
	算法思想：
	HashMap
 */
class Solution {
    public int countCharacters(String[] words, String chars) {
        //定义一个HashMap存数据
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        //将chars用map进行存放
        for(int i=0;i<chars.length();i++){
            if(map.containsKey(chars.charAt(i))){
                int count = map.get(chars.charAt(i));
                count++;
                map.put(chars.charAt(i),count);
            }else{
                map.put(chars.charAt(i),1);
            }
        }
        int res_length = 0;
        //对words进行判别
        for(int i=0;i<words.length;i++){
    HashMap<Character,Integer> map_temp = (HashMap<Character, Integer>) ((HashMap<Character, Integer>) map).clone();
            for(int j=0;j<words[i].length();j++){
                if(map_temp.containsKey(words[i].charAt(j))){
                    int count = map_temp.get(words[i].charAt(j));
                    if(count == 0)
                        break;
                    count--;
                    map_temp.put(words[i].charAt(j),count);
                }else 
                    break;
                if(j == words[i].length()-1){
                    res_length += words[i].length();
                }
            }
        }
        return res_length;
    }
}

