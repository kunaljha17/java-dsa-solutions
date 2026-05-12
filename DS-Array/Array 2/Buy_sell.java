public class Buy_sell {

    // public static int profit(int prices[]) {
    // int buyAtMin = Integer.MAX_VALUE;
    // int sellAtMax = Integer.MIN_VALUE;
    // int startDay;
    // for (int i = 0; i < prices.length; i++) {
    // if (buyAtMin > prices[i]) {
    // buyAtMin = prices[i];
    // startDay = i;
    // }
    // }

    // for (int i = startDay; i < prices.length; i++) {
    // if (sellAtMax < prices[i]) {
    // sellAtMax = prices[i];
    // }
    // }

    // int profit = sellAtMax - buyAtMin;
    // return profit;

    // }

    public static int buyAndSellStocks(int prices[]) {
        int buyStock = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buyStock < prices[i]) {
                int profit = prices[i] - buyStock;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyStock = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Maximum profit is:" + buyAndSellStocks(prices));
    }
}
