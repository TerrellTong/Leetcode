/*
	算法思想：
		labuladong
		1）使用一个HashMap存储key到val的映射，就可以快速计算get(key)。
			HashMap<Integer, Integer> keyToVal;
		2）使用一个HashMap存储key到freq的映射，就可以快速操作key对应的freq。
			HashMap<Integer, Integer> keyToFreq;
		3） freq对key是一对多，freq对应的key是存在时序的（删除最久的），而且能够快速删除key列表中的任何一个key，为了满足这个条件，我们采用了LinkedHashSet
		LinkedHashSet是链表和哈希集合的结合体。链表不能快速访问链表节点，但是插入元素具有时序；哈希集合中的元素无序，但是可以对元素进行快速的访问和删除。
		
		HashMap<Integer, LinkedHashSet<Integer>> freqToKeys; 实现一对多的情况！！
		
*/


class LFUCache {
    //key到val的映射，为了完成O(1)的get
    HashMap<Integer,Integer> keyToVal;
    //key到freq的映射，为了完成快速的获取某个元素的freq
    HashMap<Integer,Integer> keyToFreq;
    //freq到key的映射，为了删除最小的频次对应的key，由于一个freq可以对应多个key，而且当出现相同频次需要删除最旧的，我们的val采用LinkedHashSet
    //LinkedHashSet是链表和哈希集合的结合体。链表不能快速访问链表节点，但是插入元素具有时序，hash可以进行快速的访问和删除
    HashMap<Integer,LinkedHashSet<Integer>> freqToKeys;
    //记录最小的频次
    int minFreq;
    //记录LFU的最大容量
    int cap;
    public LFUCache(int capacity) {
        keyToVal = new HashMap();
        keyToFreq = new HashMap();
        freqToKeys = new HashMap();
        this.cap = capacity;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        //如果不包含这个key，则返回-1
        if(!keyToVal.containsKey(key))
            return -1;
        //增加这个key对应的freq
        increaseFreq(key);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if(this.cap <= 0)
            return;

        //如果key存在，直接修改对应的val
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            //key对应的频次+1
            increaseFreq(key);
            return;
        }

        //key不存在，则要插入
        //插入前先判断容量是否满了，如果满了，则要淘汰
        if(this.cap <= keyToVal.size())
            removeMinFreqKey();

        //插入新节点
        keyToVal.put(key,value);
        keyToFreq.put(key,1);
        //putIfAbsent，如果传入key对应的value已经存在，就返回存在的value，不进行替换。如果不存在，就添加key和value，返回null
        freqToKeys.putIfAbsent(1,new LinkedHashSet());
        freqToKeys.get(1).add(key);
        //插入了新的key后，minFreq一定为1
        this.minFreq = 1;
    }

    public void increaseFreq(int key){
        //从当前的key中获取对应的freq
        int freq = keyToFreq.get(key);
        //更新keyToFreq表
        keyToFreq.put(key,freq+1);
        //更新对应的FreqToKey表
        //从FreqToKey中，删除对应的key
        freqToKeys.get(freq).remove(key);
        //将这个key，放到freq+1对应的映射中
        freqToKeys.putIfAbsent(freq+1,new LinkedHashSet());
        freqToKeys.get(freq+1).add(key);
        //如果freq对应的列表空了，则移除这个freq
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            //如果这个freq 恰好是minFreq，更新minFreq，即minFreq++
            if(freq == this.minFreq)
                this.minFreq++;
        }
    }

    public void removeMinFreqKey(){
        //先获取minFreq对应的key列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        //获取最旧的，即最先插入的,即第一个元素
        int deletedKey = keyList.iterator().next();
        //将这个key从对应的LinkedHashSet删除
        keyList.remove(deletedKey);
        if(keyList.isEmpty()){
            freqToKeys.remove(this.minFreq);
            //删除的时候，不要更新minFreq，因为我们要removeMinFreqKey，则一定进行了put，我们在put的时候，会自动设置minFreq = 1
        }
        //更新keyToVal
        keyToVal.remove(deletedKey);
        //更新keyToFreq
        keyToFreq.remove(deletedKey);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */