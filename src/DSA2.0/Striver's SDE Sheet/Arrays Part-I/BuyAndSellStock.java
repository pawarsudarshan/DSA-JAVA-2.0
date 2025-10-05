public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int profit = 0, maxProfit = 0;
        for (int i=1;i<prices.length;i++) {
            profit += prices[i]-prices[i-1];
            maxProfit = Math.max(maxProfit,profit);
            if(profit<0) profit=0;
        }
        return maxProfit;
    }
}
