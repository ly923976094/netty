package offer;


import java.util.ArrayList;
import java.util.Stack;

public class Solution1 {

    //HasSubtree主要是判断树root1中是否含有root2节点,判断子结构
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return false;
        if (root1 == null && root2 != null) return false;
        boolean flag = false;
        if (root1.val == root2.val) {
            flag = isSubTree(root1, root2);
        }
        return flag || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1.val == root2.val) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }
        return false;
    }

    /**
     * 判断镜像
     *
     * @param root
     */
    public void Mirror(TreeNode root) {

        if (root != null && (root.left != null || root.right != null)) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            Mirror(root.left);
            Mirror(root.right);
        }
    }


    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1, top = 0, boom = matrix.length - 1;//记录四个角的位置
        ArrayList<Integer> list = new ArrayList<Integer>();

        while ((right > left) && (boom > top)) {
            for (int i = left; i <= right; i++) {//从左到右
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= boom; i++) {//上到下
                list.add(matrix[i][right]);
            }
            for (int i = right - 1; i >= left; i--) {//右到左
                list.add(matrix[boom][i]);
            }
            for (int i = boom - 1; i > top; i--) {//下到上
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            boom--;
        }

        if ((boom == top) && (left < right)) {//单独剩下一行的情况
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
        }
        if ((left == right) && (boom > top)) {//单独剩下一列的情况
            for (int i = top; i <= boom; i++) {
                list.add(matrix[i][left]);
            }
        }
        if ((boom == top) && (right == left)) {//单独剩下一个元素的情况
            list.add(matrix[left][boom]);
        }
        return list;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public void pop() {
        if (!stack1.isEmpty())
            stack1.pop();
    }

    public int top() {
        if (!stack1.isEmpty())
            return stack1.pop();
        return -1;
    }

    public int min() {

        int min = Integer.MIN_VALUE;
        while (!stack1.isEmpty()) {
            int tmp = stack1.pop();
            if (tmp < min) {
                min = tmp;
            }

        }
        return min;

    }


    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length != popA.length)
            return false;
        int size = pushA.length;
        Stack<Integer> stack = new Stack<Integer>();
        // index 表示目前出栈到哪里了
        int index_pop = 0;
        for (int i = 0; i < size; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index_pop]) {
                index_pop++;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer>  arrayList = new ArrayList<Integer>();
        ArrayList<TreeNode>  list = new ArrayList<TreeNode>();
        if (root == null) {
            return arrayList;
        }
        list.add(root);
        while(list.size() >0){
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i).val);
            }
            list = getList(list);
        }
        return arrayList;
    }


    public static ArrayList<TreeNode> getList(ArrayList<TreeNode> list){
        ArrayList<TreeNode> newList = new ArrayList<TreeNode>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).left != null) {
                newList.add(list.get(i).left);
            }
            if (list.get(i).right != null) {
                newList.add(list.get(i).right);
            }
        }
        return newList;
    }
}
