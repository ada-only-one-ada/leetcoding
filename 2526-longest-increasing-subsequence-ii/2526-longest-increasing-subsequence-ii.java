class Node {
    Node left, right;
    int val, add;
}

class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int ans = 0;
        int N = (int) 1e5;
        Node root = new Node();
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 查询区间 [nums[i] - k, nums[i] - 1] 的最值
            int cnt = query(root, 0, N, Math.max(0, nums[i] - k), nums[i] - 1) + 1;
            // 更新，注意这里是覆盖更新，对应的模版中覆盖更新不需要累加，已在下方代码中标注
            update(root, 0, N, nums[i], nums[i], cnt);
            ans = Math.max(ans, cnt);
        }

        return ans;
    }
    
    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val = val; // 不需要累加
            node.add = val; // 不需要累加
            return ;
        }

        pushDown(node);

        int mid = start + (end - start) / 2;
        if (l <= mid) {
            update(node.left, start, mid, l, r, val);
        }

        if (r > mid) {
            update(node.right, mid + 1, end, l, r, val);
        }
        
        pushUp(node);
    }

    public int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return node.val;
        }

        pushDown(node);

        int mid = start + (end - start) / 2;
        int ans = 0;
        if (l <= mid) {
            ans = query(node.left, start, mid, l, r);
        }

        if (r > mid) {
            ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
        }

        return ans;
    }

    public void pushUp(Node node) {
        node.val = Math.max(node.left.val, node.right.val);
    }

    public void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node();
        }

        if (node.right == null) {
            node.right = new Node();
        }

        if (node.add == 0) {
            return;
        }

        node.left.val = node.add;  // 不需要累加
        node.right.val = node.add; // 不需要累加
        node.left.add = node.add;  // 不需要累加
        node.right.add = node.add; // 不需要累加
        node.add = 0;
    }
}
