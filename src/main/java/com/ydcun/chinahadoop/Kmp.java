package com.ydcun.chinahadoop;

/**
 * Created by ydcunu809 on 16-4-30.
 * model string in source string first position
 *
 */
public class Kmp {
    /**
     * 暴力破解方式
     * **/
    public int BF(String s,String sub){
        int i,j=0;
        for(i=0;i<s.length()-sub.length() && j<sub.length();i++){
            if(s.charAt(i)==sub.charAt(j)){
                j++;
            }else{
                j=0;
            }
            if(j>=sub.length()){
                return i-sub.length()+2;
            }
        }
        return -1;
    }

    /**
     * KMP next arry init method  once
     * **/
    public void getNext(String s,int[] next){
        next[0] = -1;
        int k=-1;
        int j=0;
        while(j<s.length()-1){
            if(k==-1 || s.charAt(j)==s.charAt(k)){
                ++j;
                ++k;
                next[j]=k;
            }else{
                k = next[k];
            }
        }
    }
    /**
     * KMP netx arry init method second
     * **/
    public void getNext2(String s,int[] next){
        next[0] = -1;
        int k=-1;
        int j=0;
        while(j<s.length()-1){
            if(k==-1 || s.charAt(j)==s.charAt(k)){
                ++j;
                ++k;
                if(s.charAt(j)==s.charAt(k))
                    next[j] = next[k];
                else
                    next[j] = k;
            }else{
                k = next[k];
            }
        }
    }
    public int kmp(String s,String sub){
        int i,j=0;
        int[] next = new int[s.length()];
        getNext(s,next);
        for(i=0;i<s.length();i++){
            if(j==-1 || s.charAt(i)==sub.charAt(j)){
                j++;
            }else{
                j=next[j];
            }
            if(j>=sub.length()){
                return i-sub.length()+2;
            }
        }
        return -1;
    }
    public static void main(String[] arge){
        Kmp kmp = new Kmp();
        String s="abcabcc123ad3e4";
        String sub = "bcc";
        System.out.println("source string："+s);
        System.out.println("model string："+sub);
        System.out.println("first position:"+kmp.BF(s,sub));
        System.out.println("first position:"+kmp.kmp(s,sub));
    }
}
