class Cashier {
    int id;
    int n;
    int discount;
    Map<Integer, Integer> map;
    
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.id = 0;    
        this.n = n;
        this.discount = discount;
        this.map = new HashMap<>();

        for (int i = 0; i < products.length; i++){
            map.put(products[i], prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        id++;

        double bill = 0;
        for (int i = 0; i < product.length; i++) {
            bill += map.get(product[i]) * amount[i];
        }

        if (id % n == 0) {
            bill = bill - (bill * discount) / 100; 
        }

        return bill;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */