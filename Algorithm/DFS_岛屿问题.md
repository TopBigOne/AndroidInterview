* DFS 遍历最简单的套路

```java
 class dfs {
    void traverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
```
