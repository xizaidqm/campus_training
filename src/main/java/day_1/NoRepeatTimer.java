package day_1; /**
 * @author: qiming
 * @date: 2021/11/2 17:32
 * @description: 第一题：不重复定时器
 */

import java.text.SimpleDateFormat;
import java.util.*;

class MetaData {
    int val;
    Long dateTime;

    public MetaData(int val, Long dateTime) {
        this.val = val;
        this.dateTime = dateTime;
    }

}

public class NoRepeatTimer {

    /**
     * 存活时间
     */
    private int aliveTime = 30;

    /**
     * 存放存活的数据，越靠近头部的进入时间越久
     */
    private LinkedList<MetaData> list = new LinkedList<>();
    /**
     * 保证数据不重复
     */
    private Set<Integer> set = new HashSet<>();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-yy HH:mm:ss");

    /**
     * 打印存活的数据，从尾向前打印
     */
    public void printList(List<MetaData> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).val < 0) {
                continue;
            }
            System.out.print(list.get(i).val + "的创建时间为：" + sdf.format(list.get(i).dateTime) + ";  ");
        }
        System.out.println();
    }

    public void reOrder(LinkedList<MetaData> list, MetaData meta) {
        if (!set.contains(meta.val)) {
            set.add(meta.val);
            list.addLast(meta);

        } else {
            //获取重复数值所在位置
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).val == meta.val) {
                    index = i;
                }
            }
            if (index != -1) {
                //设置占位符
                list.add(index, new MetaData(-100, System.currentTimeMillis()));
                //去除重复元素
                list.remove(index + 1);
            }
            list.addLast(meta);

        }
        if (list.size() > aliveTime) {
            list.removeFirst();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        NoRepeatTimer timer = new NoRepeatTimer();
        LinkedList<MetaData> list = timer.list;

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                timer.reOrder(list, new MetaData(random.nextInt(100), System.currentTimeMillis()));
                timer.printList(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

