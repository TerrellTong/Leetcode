 /*
	算法思想：
	广度优先遍历，算法要点，一个队列存储当前结点，用另一个容器存储状态，然后对存在的状态进行遍历
	题目说：

	你允许：

	装满任意一个水壶
	清空任意一个水壶
	从一个水壶向另外一个水壶倒水，直到装满或者倒空
	为了方便说明，我们做如下定义：

	装满任意一个水壶，定义为「操作一」，分为：
	（1）装满 A，包括 A 为空和 A 非空的时候把 A 倒满的情况；
	（2）装满 B，包括 B 为空和 B 非空的时候把 B 倒满的情况。

	清空任意一个水壶，定义为「操作二」，分为
	（1）清空 A；
	（2）清空 B。

	从一个水壶向另外一个水壶倒水，直到装满或者倒空，定义为「操作三」，其实根据描述「装满」或者「倒空」就知道可以分为 4 种情况：

	（1）从 A 到 B，使得 B 满，A 还有剩；
	（2）从 A 到 B，此时 A 的水太少，A 倒尽，B 没有满；
	（3）从 B 到 A，使得 A 满，B 还有剩余；
	（4）从 B 到 A，此时 B 的水太少，B 倒尽，A 没有满。

 */
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        // 特判
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }

        State initState = new State(0, 0);

        // 广度优先遍历使用队列
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        queue.offer(initState);
        visited.add(initState);

        while (!queue.isEmpty()) {
            State head = queue.poll();

            int curX = head.getX();
            int curY = head.getY();

            // curX + curY == z 比较容易忽略
            if (curX == z || curY == z || curX + curY == z) {
                return true;
            }

            // 从当前状态获得所有可能的下一步的状态
            List<State> nextStates = getNextStates(curX, curY, x, y);
            
            // 打开以便于观察，调试代码
            // System.out.println(head + " => " + nextStates);
            
            for (State nextState : nextStates) {
                if (!visited.contains(nextState)) {
                    queue.offer(nextState);
                    // 添加到队列以后，必须马上设置为已经访问，否则会出现死循环
                    visited.add(nextState);
                }
            }
        }
        return false;
    }
    private List<State> getNextStates(int curX, int curY, int x, int y) {
        // 最多 8 个对象，防止动态数组扩容，不过 Java 默认的初始化容量肯定大于 8 个
        List<State> nextStates = new ArrayList<>(8);

        // 按理说应该先判断状态是否存在，再生成「状态」对象，这里为了阅读方便，一次生成 8 个对象

        // 以下两个状态，对应操作 1
        // 外部加水，使得 A 满
        State nextState1 = new State(x, curY);
        // 外部加水，使得 B 满
        State nextState2 = new State(curX, y);

        // 以下两个状态，对应操作 2
        // 把 A 清空
        State nextState3 = new State(0, curY);
        // 把 B 清空
        State nextState4 = new State(curX, 0);

        // 以下四个状态，对应操作 3
        // 从 A 到 B，使得 B 满，A 还有剩
        State nextState5 = new State(curX - (y - curY), y);
        // 从 A 到 B，此时 A 的水太少，A 倒尽，B 没有满
        State nextState6 = new State(0, curX + curY);

        // 从 B 到 A，使得 A 满，B 还有剩余
        State nextState7 = new State(x, curY - (x - curX));
        // 从 B 到 A，此时 B 的水太少，B 倒尽，A 没有满
        State nextState8 = new State(curX + curY, 0);

        // 没有满的时候，才需要加水
        if (curX < x) {
            nextStates.add(nextState1);
        }
        if (curY < y) {
            nextStates.add(nextState2);
        }

        // 有水的时候，才需要倒掉
        if (curX > 0) {
            nextStates.add(nextState3);
        }
        if (curY > 0) {
            nextStates.add(nextState4);
        }

        // 有剩余才倒
        if (curX - (y - curY) > 0) {
            nextStates.add(nextState5);
        }
        if (curY - (x - curX) > 0) {
            nextStates.add(nextState7);
        }

        // 倒过去倒不满才倒
        if (curX + curY < y) {
            nextStates.add(nextState6);
        }
        if (curX + curY < x) {
            nextStates.add(nextState8);
        }
        return nextStates;
    }

    private class State {
        private int x;
        private int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
  
    }
}



     




