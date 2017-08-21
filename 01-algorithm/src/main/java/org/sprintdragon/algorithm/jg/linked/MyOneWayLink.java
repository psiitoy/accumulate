package org.sprintdragon.algorithm.jg.linked;

import lombok.Data;
import lombok.ToString;

import java.util.Stack;

/**
 * 单链表的创建和遍历
 * Created by wangdi on 17-5-8.
 */
@Data
public class MyOneWayLink<E> {

    private Node<E> first;
    private Node<E> current;

    @Data
    @ToString
    private class Node<E> {
        private Node<E> next;
        private E e;

        public Node(E e) {
            this.e = e;
        }
    }

    //方法：向链表中添加数据
    public void add(E e) {
        if (e == null) {
            throw new RuntimeException("cant add null");
        }
        //判断链表为空的时候
        if (first == null) {
            //如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
            first = new Node(e);
            current = first;
        } else {
            //创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
            current.next = new Node<>(e);
            //把链表的当前索引向后移动一位
            current = current.next;//此步操作完成之后，current结点指向新添加的那个结点
        }
    }

    //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
    public void print() {
        if (first == null) {
            return;
        }
        Node<E> cur = first;
        while (cur != null) {
            System.out.println(cur.e);
            cur = cur.next;
        }
    }

    //2、求单链表中节点的个数：
    public int getLength() {
        int count = 0;
        if (first == null) {
            return count;
        }
        Node<E> cu = first;
        while (cu != null) {
            cu = cu.next;
            count++;
        }
        return count;

    }

    /**
     * 3、查找单链表中的倒数第k个结点：
     * 这里需要声明两个指针：即两个结点型的变量first和second，
     * 首先让first和second都指向第一个结点，然后让second结点往后挪k-1个位置，
     * 此时first和second就间隔了k-1个位置，然后整体向后移动这两个节点，
     * 直到second节点走到最后一个结点的时候，此时first节点所指向的位置就是倒数第k个节点的位置。
     * 时间复杂度为O（n）
     *
     * @param head
     * @param k
     * @return
     */
    public Node findLastNode(Node head, int k) {
        if (k == 0 || head == null) {
            return null;
        }

        Node first = head;
        Node second = head;

//让second结点往后挪k-1个位置
        for (int i = 0; i < k - 1; i++) {
            System.out.println("i的值是" + i);
            second = second.next;
            if (second == null) { //说明k的值已经大于链表的长度了
                //throw new NullPointerException("链表的长度小于" + k); //我们自己抛出异常，给用户以提示
                return null;
            }
        }

        //让first和second结点整体向后移动，直到second走到最后一个结点
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        //当second结点走到最后一个节点的时候，此时first指向的结点就是我们要找的结点
        return first;
    }


    /**
     * 4、查找单链表中的中间结点：
     * 同样，面试官不允许你算出链表的长度，该怎么做呢？
     * 思路：
     * 和上面的第2节一样，也是设置两个指针first和second，只不过这里是，两个指针同时向前走，second指针每次走两步，first指针每次走一步，直到second指针走到最后一个结点时，此时first指针所指的结点就是中间结点。注意链表为空，链表结点个数为1和2的情况。时间复杂度为O（n）。
     * 代码实现：
     *
     * @param head
     * @return
     */
    //方法：查找链表的中间结点
    public Node findMidNode(Node head) {

        if (head == null) {
            return null;
        }

        Node first = head;
        Node second = head;
//每次移动时，让second结点移动两位，first结点移动一位
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

//直到second结点移动到null时，此时first指针指向的位置就是中间结点的位置
        return first;
    }


    //两个参数代表的是两个链表的头结点
    public Node mergeLinkList(Node<Integer> head1, Node<Integer> head2) {

        if (head1 == null && head2 == null) { //如果两个链表都为空
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node head; //新链表的头结点
        Node current; //current结点指向新链表
// 一开始，我们让current结点指向head1和head2中较小的数据，得到head结点
        if (head1.e < head2.e) {
            head = head1;
            current = head1;
            head1 = head1.next;
        } else {
            head = head2;
            current = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1.e < head2.e) {
                current.next = head1; //新链表中，current指针的下一个结点对应较小的那个数据
                current = current.next; //current指针下移
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }

//合并剩余的元素
        if (head1 != null) { //说明链表2遍历完了，是空的
            current.next = head1;
        }

        if (head2 != null) { //说明链表1遍历完了，是空的
            current.next = head2;
        }

        return head;
    }


    /**
     * 6、单链表的反转：【出现频率最高】
     * 例如链表：
     * 　　1->2->3->4
     * 反转之后：
     * 　　4->2->2->1
     * 思路：
     * 　　从头到尾遍历原链表，每遍历一个结点，将其摘下放在新链表的最前端。
     * 注意链表为空和只有一个结点的情况。时间复杂度为O（n）
     *
     * @param head
     * @return
     */
    //方法：链表的反转
    public Node reverseList(Node head) {

//如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node next = null; //定义当前结点的下一个结点
        Node reverseHead = null; //反转后新链表的表头

        while (current != null) {
            next = current.next; //暂时保存住当前结点的下一个结点，因为下一次要用

            current.next = reverseHead; //将current的下一个结点指向新链表的头结点
            reverseHead = current;

            current = next; // 操作结束后，current节点后移
        }

        return reverseHead;
    }

    /**
     * 7、从尾到头打印单链表：
     * 　　对于这种颠倒顺序的问题，我们应该就会想到栈，后进先出。
     * 所以，这一题要么自己使用栈，要么让系统使用栈，也就是递归。注意链表为空的情况。
     * 时间复杂度为O（n）
     * 　　注：不要想着先将单链表反转，然后遍历输出，这样会破坏链表的结构，不建议。
     * 方法1：（自己新建一个栈）
     *
     * @param head
     */
    //方法：从尾到头打印单链表
    public void reversePrint(Node head) {

        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>(); //新建一个栈
        Node current = head;

        //将链表的所有结点压栈
        while (current != null) {
            stack.push(current); //将当前结点压栈
            current = current.next;
        }

        //将栈中的结点打印输出即可
        while (stack.size() > 0) {
            System.out.println(stack.pop().e); //出栈操作
        }
    }

    /**
     * 8、判断单链表是否有环：
     * 　　这里也是用到两个指针，如果一个链表有环，那么用一个指针去遍历，是永远走不到头的。
     * 　　因此，我们用两个指针去遍历：first指针每次走一步，second指针每次走两步，
     * 如果first指针和second指针相遇，说明有环。时间复杂度为O (n)。
     * 方法：
     *
     * @param head
     * @return
     */
    //方法：判断单链表是否有环
    public boolean hasCycle(Node head) {

        if (head == null) {
            return false;
        }

        Node first = head;
        Node second = head;

        while (second != null) {
            first = first.next; //first指针走一步
            second = second.next.next; //second指针走两步

            if (first == second) { //一旦两个指针相遇，说明链表是有环的
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        MyOneWayLink<Integer> al = new MyOneWayLink<>();
        al.add(2);
        al.add(3);
        al.add(55);
        al.add(66);
        al.print();
        System.out.println(al.getLength());
        System.out.println(al.findLastNode(al.first, 2).e);
        System.out.println(al.reverseList(al.first));

    }

}
