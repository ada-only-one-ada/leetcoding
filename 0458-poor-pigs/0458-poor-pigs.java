class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 比如buckets = 1000，死亡时间 = 15，测试时间 = 60
        // 那么一只猪可以喝水 60 / 15 = 4次，可以测试 5 个桶，即 60 / 15 + 1 = 5

        int base = minutesToTest / minutesToDie + 1;
        double requiredPigs = Math.log(buckets) / Math.log(base);

        // return (int) Math.ceil(requiredPigs);
        // 在执行125，1，4这个用例的时候由于数据精度问题，125求5的对数会算成3.000000000004，向上取整得到4，导致错误
        return (int) Math.ceil(requiredPigs - 1e-9);
    }
}

