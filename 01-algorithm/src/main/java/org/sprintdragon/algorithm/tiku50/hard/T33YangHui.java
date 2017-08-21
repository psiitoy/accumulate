package org.sprintdragon.algorithm.tiku50.hard;

/**
 *  题目：打印出杨辉三角形（要求打印出10行如下图）
 *  1
 1   1
 1   2   1
 1   3   3   1
 1   4   6   4   1
 1   5   10   10   5   1
 * Created by wangdi on 17-4-25.
 */
public class T33YangHui {

    public static void main(String[] args) {
        int [][] iArray = new int[10][];

        //保证输出10行
        for(int i=0;i<10;i++) {
            //行是从0开始 列数加1 否则出现空指针异常
            iArray[i] = new int[i+1];
            //从第一行开始 依次给每行加不同的空格
            for(int k=9;k>i;k--){
//                System.out.print("  ");
            }
            //控制每行输出的元素
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i) {
                    //两边的值
                    iArray[i][j]=1;
                    System.out.print(iArray[i][j]+"   ");
                }else{
                    //中间的值
                    iArray[i][j]=iArray[i-1][j]+iArray[i-1][j-1];
                    System.out.print(iArray[i][j]+"   ");
                }

            }
            System.out.println();//换行
        }
    }

}
