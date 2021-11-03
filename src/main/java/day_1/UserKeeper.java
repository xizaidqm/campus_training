package day_1; /**
 * @author: qiming
 * @date: 2021/11/2 18:34
 * @description: 第二题
 */

import java.util.*;


public class UserKeeper {
    private int timeAlive = 3;
    /**
     * 环形队列，存储对应创建时常的链接
     */
    private Set<Integer>[] connections = new Set[timeAlive];

    /**
     * 记录用户及其对应的会话在环形队列中的位置
     * K：用户。 V:会话所处的位置索引。
     */
    private Map<Integer, Integer> map = new HashMap<>();
    /**
     * 环形列表位置指针
     */
    private Integer currentSlot = 0;
    private Integer previousSlot = timeAlive - 1;

    /**
     * 初始化环形队列
     */
    public void init() {
        for (int i = 0; i < connections.length; i++) {
            connections[i] = new HashSet<>();
        }
    }

    /**
     * 指针前进一步，淘汰该slot中的所有链接，并批量处理1s内获取的所有用户请求
     */
    public void moveForward(Set<Integer> set) {
        Set<Integer> needClear = connections[currentSlot];

        for (Integer i : set) {
            if (map.containsKey(i)) {
                int slotIndex = map.get(i);
                map.remove(i);
                //删除原有链接
                connections[slotIndex].remove(i);
            }

            insertSlot(i);

            //如果存在重复元素，则在needClear中去除
            needClear.remove(i);
        }

        //needClear中剩下的就是需要进行清理的用户，相应地需要清理Map
        for (Integer index : needClear) {
            map.remove(index);
        }

        System.out.println("本次共清理" + needClear.size() + "个用户；" + "剩余的用户总数为：" + map.size());
        needClear.clear();

        //指针前移
        if (currentSlot == connections.length - 1) {
            currentSlot = 0;
            previousSlot++;
        } else if (currentSlot == 0) {
            currentSlot++;
            previousSlot = 0;
        } else {
            currentSlot++;
            previousSlot++;
        }

    }

    /**
     * 插入QPS的用户会话
     *
     * @param val
     */
    public void insertSlot(int val) {
        //在新slot中添加新的链接
        connections[previousSlot].add(val);
        //将新的链接及其对应的slot存储
        map.put(val, previousSlot);

    }

    public static void main(String[] args) throws InterruptedException {
        UserKeeper work = new UserKeeper();
        work.init();

        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            Set<Integer> requests = RequestGenerator.generateReqs();
            System.out.println("当前需要处理" + requests.size() + "个请求");

            work.moveForward(requests);
        }
    }
}

class RequestGenerator {
    private static Random random = new Random();

    /**
     * 随机生成用户请求
     *
     * @return
     */
    public static Set<Integer> generateReqs() {
        //设置本次的请求量
        int totalNum = 2500 + random.nextInt(1000);

        Set<Integer> set = new HashSet<>();

        //随机设置哪些用户发起了请求
        for (int i = 0; i < totalNum; i++) {
            set.add(random.nextInt(100000));
        }
        return set;
    }
}

