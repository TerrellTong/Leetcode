/*
	算法思想：
		Map<Integer,Set<Integer>>,存储，val和这个val出现的索引集合
	
题解：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/solution/java-ha-xi-biao-listset-by-ppppjqute/
https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/solution/o1-shi-jian-cha-ru-shan-chu-he-huo-qu-sui-ji-yua-5/
*/

class RandomizedCollection {
    int n; //当前集合大小
    HashMap<Integer,Set<Integer>> map; //存取当前值和当前值所在list的索引位置
    ArrayList<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        random = new Random();
        map = new HashMap();
        n = 0;
        list = new ArrayList();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);   
        Set<Integer> set = map.getOrDefault(val,new HashSet());
        //记住添加值的索引值
        set.add(n);
        map.put(val,set);
        n++;
        //如果当前set的size（）不为1，说明添加了重复元素，即添加失败
        return set.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        //得到最后一个索引值和val的索引值
        int lastIndex = n-1;
        Set lastset = map.get(list.get(lastIndex));
        //获取当前val的set集合
        Set set = map.get(val);
        int curIndex = (int)set.iterator().next();//得到当前值索引
        //交换curIndex和lastIndex对应的list的值
        swap(list,curIndex,lastIndex);
        //此时已经删除了所给的val
        list.remove(n-1);
        //删除val对应的索引
        set.remove(curIndex);
        if(set.size()==0)  
            map.remove(val);//在图中删除
            
        //修改最后一个值的索引
        //lastset,存储最后一个元素的所有索引存在的位置，由于索引n-1被删除，现在curIndex，实际上存储的是之前队尾元素的index
        lastset.remove(n-1);
        lastset.add(curIndex);
        n--;

        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(n));
    }

    private void swap(List<Integer> list ,int i,int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */