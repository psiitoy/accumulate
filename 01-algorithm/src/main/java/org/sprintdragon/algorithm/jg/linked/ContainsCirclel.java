package org.sprintdragon.algorithm.jg.linked;//package org.sprintdragon.experimentbase.algorithm.jg.linked;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by wangdi on 17-5-5.
// */
//public class ContainsCirclel {
//
//    /**
//     * 最简单的算法，但需要的空间比较高，一个Set集合
//     *
//     * @param link
//     * @param <T>
//     * @return
//     */
//    public static <T> boolean containsCircle1(LinkList<T> link) {
//        if (link == null) {
//            return false;
//        }
//        T value = link.getValue();
//        Set<T> values = new HashSet<T>();
//        values.add(value);
//        while ((link = link.getNext()) != null) {
//            if (link == null) {
//                return false;
//            }
//            value = link.getValue();
//            if (values.contains(value)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 使用两个指针，一个以速度1前进，另一个以速度2前进，如果存在闭环，则必定会出现交叉碰面
//     *
//     * @param link
//     * @param <T>
//     * @return
//     */
//    public static <T> boolean containsCircle2(LinkList<T> link) {
//        if (link == null || link.getNext() == null) {
//            return false;
//        }
//        LinkList<T> first = link;
//        LinkList<T> second = link.getNext();
//        while (second != null && second.getNext() != null && second.getNext().getNext() != null) {
//            first = first.getNext();
//            second = second.getNext().getNext();
//            if (first.getValue() == second.getValue()) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//}
