class Solution {
    public int maximumSum(int[] arr) {
        int maxRes = Integer.MIN_VALUE;

        // 从左向右遍历
        int[] leftDp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && leftDp[i - 1] + arr[i] > arr[i]) {
                leftDp[i] = leftDp[i - 1] + arr[i];
            } else {
                leftDp[i] = arr[i];
            }

            maxRes = Math.max(maxRes, leftDp[i]);
        }

        // 从右向左遍历
        int[] rightDp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i < arr.length - 1 && rightDp[i + 1] + arr[i] > arr[i]) {
                rightDp[i] = rightDp[i + 1] + arr[i];
            } else {
                rightDp[i] = arr[i];
            }

            maxRes = Math.max(maxRes, rightDp[i]);
        }

        // 删掉一个情况：取左右两个区间最大值的和
        for (int i = 1; i < arr.length - 1; i++) {
            int leftRightMax = leftDp[i - 1] + rightDp[i + 1];
            maxRes = Math.max(maxRes, leftRightMax);
        }

        return maxRes;
    }
}