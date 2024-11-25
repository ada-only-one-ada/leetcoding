class ParkingSystem {
    int[] count;

    public ParkingSystem(int big, int medium, int small) {
        count = new int[4];
        count[1] = big;
        count[2] = medium;
        count[3] = small;
    }
    
    public boolean addCar(int carType) {
        if (carType < 0 || carType >= count.length) return false;
        if (count[carType] <= 0) return false;

        count[carType]--;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */