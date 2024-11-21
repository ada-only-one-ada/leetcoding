class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];

        for (int row = 0; row < img.length; row++) {
            for (int col = 0; col < img[0].length; col++) {
                int center = img[row][col];
                int count = 1;

                int up1 = 0, up2 = 0, up3 = 0, down1 = 0, down2 = 0, down3 = 0, left = 0, right = 0;
                if (row > 0) {
                    if (col > 0) {
                        up1 = img[row-1][col-1];
                        count++;
                    }
                    if (col < img[0].length - 1) {
                        up3 = img[row-1][col+1];
                        count++;
                    }
                    up2 = img[row-1][col];
                    count++;
                }

                if (col > 0) {
                    left = img[row][col-1];
                    count++;
                }

                if (col < img[0].length - 1) {
                    right = img[row][col+1];
                    count++;
                }

                if (row < img.length - 1) {
                    if (col > 0) {
                        down1 = img[row+1][col-1];
                        count++;
                    }

                    if (col < img[0].length - 1) {
                        down3 = img[row+1][col+1];
                        count++;
                    }

                    down2 = img[row+1][col];
                    count++;
                }

                int sum = up1 + up2 + up3 + down1 + down2 + down3 + left + right + center;
                res[row][col] = sum / count;
            }
        }

        return res;
    }
}