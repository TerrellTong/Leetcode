/*
	算法思想：
		回溯，通过dfs实现，与dfs不同的是dfs结束后，即往回走，需要撤销上一次的选择
		
		这就是回溯，在约束条件下，穷举所有节点，通常用于解决「找出所有可能的组合」类问题。
		
回溯的讲解：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
题目解析：https://leetcode-cn.com/problems/restore-ip-addresses/solution/2020041693medianhui-su-di-gui-fu-yuan-ip-di-zhi-by/
*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList();
        if(s == null || s.length()==0)
            return ans;

        //深度优先搜索（回溯）
        dfs(s,0,new ArrayList<>(),ans);
        return ans;
    }

    //进行深度遍历查询可能的路径
    //pos-当前遍历到s字符串中的位置，cur-当前已经存放好确定的ip端数量
    public void dfs(String s,int pos,List<String> cur,List<String> res){
        if(cur.size() == 4){
            //如果此时pos也刚好遍历完整个s
            if(pos == s.length())
                //将list中间用.连接
                res.add(String.join(".",cur));
            return;
        }

        //ip地址每个字段最多有三个数字
        for(int i=1;i<=3;i++){
            //如果当前位置距离s末尾小于3 就不用再分段了，直接跳出循环
            if(pos+i > s.length())
                break;
            //将s的子串开始分段
            String segment = s.substring(pos,pos+i);
            //剪枝条件:段的起始位置不能为0，段需要拆成int类型的长度不能大于255
            if(segment.startsWith("0") && segment.length()>1 || (i==3&& Integer.parseInt(segment)>255))
                continue;
            //符合条件则加入到cur数组中
            cur.add(segment);
            //继续递归遍历下个位置
            dfs(s,pos+i,cur,res);
            //如果执行到这个位置,说明此时dfs执行完成,我们需要,回退到上一个元素，即回溯！
			//撤销上一次的选择
            cur.remove(cur.size()-1);
        }

    }  
}