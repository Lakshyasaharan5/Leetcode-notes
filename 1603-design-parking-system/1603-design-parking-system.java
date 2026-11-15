class ParkingSystem {
    /**
    
        big    -> 1 : 4
        medium -> 2 : 2
        small  -> 3 : 0
        [0 1 2 3]
     */
    int[] spots;
    public ParkingSystem(int big, int medium, int small) {
        spots = new int[4];
        spots[1] = big;
        spots[2] = medium;
        spots[3] = small;
    }
    
    public boolean addCar(int carType) {
        if (spots[carType] == 0) return false;
        spots[carType]--;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */