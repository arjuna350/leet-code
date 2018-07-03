package com.shailesh.reccurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobilePadPermmitation {
	Map<Integer, List<Character>> refer = new HashMap<>();

	private void printPermmitation(List<Integer> input) {
		List<String> solution = new ArrayList<>();
		this.computePermmitation(input, solution, "", 0);

		for (String str : solution) {
			System.out.println(str);
		}
	}

	private void computePermmitation(List<Integer> input, List<String> solution, String temp, int pos) {

		
		

		// Try all 3 possible characters for current digir in number[]
		// and recur for remaining digits

		for (int i = 0; i < input.size(); i++) {

					temp = "";
					for (int j = pos; j < refer.get(input.get(i)).size(); j++) {
						
						temp = temp + refer.get(input.get(i)).get(j);
						if (temp.length() == input.size()) {
							solution.add(temp);
		
							//return;
						}
					}
		
					computePermmitation(input, solution, temp,pos+1);

		}

	}

	public static void main(String[] args) {
		MobilePadPermmitation mpp = new MobilePadPermmitation();

		mpp.refer.put(1, Arrays.asList('a', 'b', 'c'));
		mpp.refer.put(2, Arrays.asList('d', 'e', 'f'));
		mpp.refer.put(3, Arrays.asList('g', 'h', 'i'));
		mpp.refer.put(4, Arrays.asList('j', 'k', 'l'));
		mpp.refer.put(5, Arrays.asList('m', 'n', 'o'));
		mpp.refer.put(6, Arrays.asList('p', 'q', 'r'));
		mpp.refer.put(7, Arrays.asList('s', 't', 'u'));
		mpp.refer.put(8, Arrays.asList('v', 'w', 'x'));
		mpp.refer.put(9, Arrays.asList('y', 'z'));

		mpp.printPermmitation(Arrays.asList(1, 2));

	}

}
