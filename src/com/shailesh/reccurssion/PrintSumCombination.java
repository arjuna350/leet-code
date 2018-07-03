package com.shailesh.reccurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date 07/06/2018
 * @author shailesh singh 
 *
 * Given an input and total print all combinations with repetitions in this input
 * which sums to given total.
 * e.g
 * input - {2,3,5}
 * total - 10
 *
 * Output
 * [2,2,2,2,2],
 * [2,2,3,3],
 * [2,3,5],
 * [5,5]]
 * Reference
 * https://leetcode.com/problems/combination-sum/
 */
public class PrintSumCombination {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	
    	List<Integer> r = new ArrayList<Integer>();
    	List<List<Integer>> rr = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	this.combinationSumUtil(candidates,10,r,rr,0);
    	
		return rr;
      
    }

    private void combinationSumUtil(int[] candidates, int target, List<Integer> r, List<List<Integer>> rr, int pos) {
    	
    	if(target==0)
    	{
    		List<Integer> temp = new ArrayList<Integer>();
    		temp.addAll(r);
    		rr.add(temp);
    		return;
    	}
    	
    	if(target<0 || pos==candidates.length)
    	{
    		return;
    	}
    	
    	r.add(candidates[pos]);
    	combinationSumUtil(candidates,target-candidates[pos],r,rr,pos);
    	r.remove(r.size()-1);
    	
    	combinationSumUtil(candidates,target,r,rr,pos+1);
    	
    	
           }

    public static void main(String args[]) {
        int input[] = {2,3,5};
        PrintSumCombination psc = new PrintSumCombination();
        List<List<Integer>> result = psc.combinationSum(input, 10);
        result.forEach(r -> {
            r.forEach(r1 -> System.out.print(r1 + " "));
            System.out.println();
        });
    }
}
