package com.shailesh.easy;
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * @author chandan
 *Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyStock {

	public static void main(String[] args) {
		 int[] prices= {7, 1, 5, 3, 6, 4};
		  maxProfit(prices);

	}

	private static void maxProfit(int[] prices) {
		int min=prices[0];
		int max=0; int diff=0;int buyDay=0; int sellDay=0;
		
		
		for (int i=1 ; i<prices.length;i++)
		{
		//	max = Math.max(max,prices[i]);
			//min=Math.min(min, prices[i]);
			
			if(prices[i]<min)
			{
				min=prices[i];buyDay=i;
			}
			if(prices[i]>max)
			{
				max=prices[i];sellDay=i;
			}
		
			diff=Math.max(diff, max-min);
			
		}
		
		
		System.out.println("For Maximum profit , buy on "+ buyDay + "and sell on "+sellDay+ " total profit :"+diff );
		
	}

}
