package com.ydcun.chinahadoop;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ydcunu809 on 16-4-28.
 * 字符全排列
 */
public class FullArry {
    public void Print(int[] a,int size){
        for(int i=0;i<size;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public boolean isDuplicate(int[] a,int n,int t){
        while(n<t){
            if(a[n]==a[t])
                return false;
            n++;
        }
        return true;
    }
    /**
     * 递归实现全排列，兼容重复字符
     * */
    public void Permutation(int[] a,int size,int n){
        if(n==size-1){
            Print(a,size);
            return;
        }
        int temp;
        for(int i=n;i<size;i++){  //1XXX 2XXX 3XXX 4XXX
            if(!isDuplicate(a,n,i)) //a[i] 是否在[n,i)是否出现过
                continue;
            temp = a[i];
            a[i] = a[n];
            a[n] = temp;
            Permutation(a,size,n+1);
            temp = a[i];
            a[i] = a[n];
            a[n] = temp;
        }
    }
    /**
     * 递归实现全排列，兼容重复字符   用空间换时间方法改进
     * */
    public void Permutation2(int[] a,int size,int n){
        if(n==size-1){
            Print(a,size);
            return;
        }
        Map<String,String> map = new HashMap<String,String>();
        int temp;
        for(int i=n;i<size;i++){//1XXX 2XXX 3XXX 4XXX
            if(map.get(a[i]+"")!=null)
                continue;
            map.put(a[i]+"","ok");

            temp = a[i];
            a[i] = a[n];
            a[n] = temp;
            Permutation2(a,size,n+1);
            temp = a[i];
            a[i] = a[n];
            a[n] = temp;
        }
    }

    public boolean GetNextPermutation(int[] a,int size){
        //后找
        int i=size-2;
        while(i>=0 && a[i]>=a[i+1])
            i--;
        if(i<0)
            return false;
        //小大
        int j=size-1;
        while(a[j] <= a[i])
            j--;
        //交换
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        //翻转
        int p=0;
        while(i+1+p<size-p-1){
            temp = a[i+1+p];
            a[i+p+1] = a[size-p-1];
            a[size-p-1] = temp;
            p++;

        }
        return true;
    }
    public static void main(String[] args){
        int[] a={1,2,3,3,4};

        FullArry fullArry = new FullArry();
//        fullarry.Permutation(a,a.length,0);
//        fullarry.Permutation2(a,a.length,0);
        while(fullArry.GetNextPermutation(a,a.length)){
            fullArry.Print(a,a.length);
        }
    }

}
