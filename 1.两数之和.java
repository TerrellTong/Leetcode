1)暴力法
Class Solution{
	public int[] addSum（int [] nums,int target）{
	for (int i = 0; i < nums.length; i++) {
           	 for (int j = i + 1; j < nums.length; j++) {
               	    if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
	}
	throw new IllegalArgumentException("No two sum solution");
}

2）两次Hash
Class Solution{
	public int[] addSum（int [] nums,int target）{
	Map<Integer,Integer> map = new HashMap<Integer,Integer>;
	for(int i=0;i<nums.length;i++){
		map.put(nums[i],i);
	}
	for(int i=0;i<num.length;i++){
		int complement = target-nums[i];
		if(map.containKey(complement)&&map.get(complement)!=i){
		int j = map.getKey(complement)
		return new int[] {i,j};
		}
	}
	throw new IllegalArgumentException("No two sum solution");
}

3)一次Hash
Class Solution{
	public int[] addSum（int [] nums,int target）{
	Map<Integer,Integer> map = new HashMap<Integer,Integer>;
	for(int i=0;i<num.length;i++){
		int complement = target-nums[i];
		if(map.containKey(complement)){
		int j = map.getKey(complement)
		return new int[] {i,j};
		}
		map.put(nums[i],i);
	}
	throw new IllegalArgumentException("No two sum solution");
}