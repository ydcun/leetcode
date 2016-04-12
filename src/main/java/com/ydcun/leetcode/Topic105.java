package com.ydcun.leetcode;

/**
 * Hello world!
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Topic105 {
    public TreeNode build(int[] preorder,int s1,int e1,int[] inorder,int s2,int e2){
        TreeNode root =null;
        if(s1 > e1)
            return null;
        //else if(s1 == e1)
            //return new TreeNode(preorder[s1]);
        root = new TreeNode(preorder[s1]);
        int i = s2;
        for(; i <= e2; i ++)
        {
            if(inorder[i] == preorder[s1])
                break;
        }
        int leftlen = i-s2;
        root.left = build(preorder, s1+1, s1+leftlen, inorder, s2, s2+leftlen-1);
        root.right = build(preorder, s1+leftlen+1, e1, inorder, s2+leftlen+1, e2);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return  build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public static void main(String[] args){
        TreeNode root = new Topic105().buildTree(new int[]{1, 2, 4, 8,5,9, 3, 6, 7}, new int[]{8,4, 2,9, 5, 1, 6, 3, 7});
        System.out.print("d");
    }
}
