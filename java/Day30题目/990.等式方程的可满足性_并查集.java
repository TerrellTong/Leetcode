/*
	算法思想：
		注意思想的转换！！！
		并查集，按照的labuladong的思想解决了！
		注意要遍历两次！！！，不然["a==b","b!=c","c==a"],不能通过！
		先处理==，使得他们各自联通，然后处理！=，检查不等关系是否破坏了相等关系的连通性（即看是否存在相同的祖先！！）
*/


class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        //初始化，每个字符的祖先都是自己
        for(int i=0;i<26;i++){
            parent[i] = i;
        }
        //如果是==，则表示是连通的，是!=，则表示是不连通的
        for(String s:equations){
            //第二个字符是=，则表示是==，可以进行union
            if(s.charAt(1) == '='){
                union(s.charAt(0)-'a',s.charAt(3)-'a',parent);
            }
        }
        //对于!=，我们也要进行重头到尾的遍历，因为，我们要先将所有的==连通，不能边添加边判是否为！=，不然
        //["a==b","b!=c","c==a"],不能通过！
        for(String s:equations){
            if(s.charAt(1) == '!'){
                int ance_x = find(s.charAt(0)-'a',parent);
                int ance_y = find(s.charAt(3)-'a',parent);
                if(ance_x == ance_y)
                    return false;
            }
        }
        return true;
    }

    //结点联合
    public void union(int x,int y , int[] parent){
        int ance_x = find(x,parent);
        int ance_y = find(y,parent);
        if(ance_x == ance_y)
            return;
        //x的祖先放到y上
        //将ance_y设置为ance_x的祖先
        parent[ance_x] = ance_y; 
    }

    //找到祖先节点
    public int find(int x,int[] parent){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}