class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = false;
        if (length >= 10000 || width >= 10000 ||
            height >= 10000 || mass >= 10000 ||
            width * height >= Math.pow(10, 9) / length) {
            isBulky = true;
        }

        boolean isHeavy= false;
        if (mass >= 100) {
            isHeavy = true;
        }

        if (isHeavy && isBulky) {
            return "Both";
        } else if (!isHeavy && !isBulky) {
            return "Neither";
        } else if (isHeavy) {
            return "Heavy";
        } else {
            return "Bulky";
        }
    }
}