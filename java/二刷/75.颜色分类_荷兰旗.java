/*
	算法思想：
		相当于二刷，还是不会！！
		非一次遍历：用Map存取每个数字出现的次数，然后重新放到nums中
*/

/**
	非一次遍历
*/
class Solution {
    public void sortColors(int[] nums) {
        int redIndex = 0;
        int blueIndex = 0;
        int whiteIndex = 0;

        Map<Integer,Integer> map = new HashMap();
        for(int num:nums){
            int count = map.getOrDefault(num,0);
            count++;
            map.put(num,count);
        }

        int redCount = map.getOrDefault(0,0);
        int whiteCount = map.getOrDefault(1,0);
        int blueCount = map.getOrDefault(2,0);
        int index = 0;
        int i = 0;
        while(i<redCount){
            nums[index++] = 0;
            i++;
        }
        
        i=0;
        while(i<whiteCount){
            nums[index++] = 1;
            i++;
        }

        i=0;
        while(i<blueCount){
            nums[index++] = 2;
            i++;
        }

    }
}


/**
	一次遍历
		两个指针分别指向 下一个0、2应该存放的位置
	遇0则交换 当前元素 和 p0空间的值，并 使得 p0指针 指向 下一个0应该存放的位置，遍历下一个元素
	遇2则交换 当前元素 和 p2空间的值，并 使得 p2指针 指向 下一个2应该存放的位置，继续遍历 交换后的当前元素
*/
class Solution {
    public void sortColors(int[] nums) {
        //p0记录0的最右边界，p2追踪2的最左边界
        //cur记录当前元素的位置
        int p0 = 0,p2 = nums.length-1,cur = 0;
        //交换的中间变量
        int tmp;
        while(cur<=p2){
            //如果当前位置为0，则与p0互换位置
            if(nums[cur] == 0){
                tmp = nums[p0];
                nums[p0] = nums[cur];
                nums[cur] = tmp;
                //此时p0，可以向右移动，且cur也可以继续右移
                p0++;
                cur++;
            }else if(nums[cur] == 2){
                tmp = nums[p2];
                nums[p2] = nums[cur];
                nums[cur] = tmp;
                //此时原p2交换过来的数，程序没有读到
                //例如：交换过来的为0，如果cur++，则0没有成功读取到
                p2--;
            }else 
                cur++;
        }
    }
}