package Array;

//You are given an array prices[] where prices[i] is the price of a stock on day i.
//You are allowed to buy once and sell once
//You must buy before you sell
//Return the maximum profit
//If no profit possible → return 0
//
//🧠 Intuition
//Track the minimum price so far
//For each day:
//Assume you sell today
//Profit = price_today - min_price_so_far
//Update maximum profit
//
//✅ Algorithm (Greedy)
//Initialize minPrice = prices[0]
//Initialize maxProfit = 0
//Traverse prices:
//Update minPrice
//Calculate profit
//Update maxProfit

public class BestTimeToBuySellStockI {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (Stock I): " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}

