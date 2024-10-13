BFS решается несколькими способами. 

1. Это запоминть текущую строку (curLayer) и следующую (nextLayer) 

```java
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        if (root == null) {
            return answer;
        }
        List<TreeNode> curLayer = new ArrayList<>();
        curLayer.add(root);

        while (!curLayer.isEmpty()) {
            answer.add(curLayer.get(curLayer.size() - 1).val);

            List<TreeNode> nextLayer = new ArrayList<>();

            for (TreeNode node : curLayer) {
                if (node.left != null) {
                    nextLayer.add(node.left);
                }
                if (node.right != null) {
                    nextLayer.add(node.right);
                }
            }
            curLayer = nextLayer;
        }
        return answer;
    }
```