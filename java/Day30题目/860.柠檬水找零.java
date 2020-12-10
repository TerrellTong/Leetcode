/*
	算法思想：
		栈的思想，知道，之前好像做过，但是自己实现还是有问题
		1）必须要记住上一次的OP，默认的上一次OP为+
		2）不是遇到了+，-，*，/就立马加，是等某个数字确实走到了头再计算 例如 0-232323！
		3）根据数字，从而计算上一次的OP！
		题型类似  面试题 16.26. 计算器  ，相当于二刷！！
		
*/

class Solution {
    public boolean lemonadeChange(int[] bills) {
        List<Integer> res_5 = new ArrayList();  //可以用five++ 代替
        List<Integer> res_10 = new ArrayList();	//可以用ten++代替
        List<Integer> res_20 = new ArrayList();
        for(int bill:bills){
            if(bill == 5){
                res_5.add(5);
            }
            else if(bill == 10 && !res_5.isEmpty()){
                //移除最后一个5_pos;
                res_5.remove(res_5.size()-1);
                res_10.add(10);
            }else if(bill == 20 && !res_5.isEmpty()){
                if(!res_10.isEmpty()){
                    res_5.remove(res_5.size()-1);
                    res_10.remove(res_10.size()-1);
                }else if(res_5.size() >= 3){
                    res_5.remove(0);
                    res_5.remove(0);
                    res_5.remove(0);
                }else
                    return false;
                res_20.add(20);
            }
            else
                return false;
        }
        return true;
    }
}
