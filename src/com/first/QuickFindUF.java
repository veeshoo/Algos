package com.first;

public class QuickFindUF {
	
	private int[] network;
	
	public QuickFindUF(int N) {
		network = new int[N];
		int i = 0;
		for(int x : network) {
			x = i++;
		}
	}
	
	public boolean connected(int p, int q) {
		return network[p]==network[q];
	}
	
	public void union(int p, int q) {
		int pVal = network[p];
		int qVal = network[q];
		if(pVal!=qVal) {
			for(int i=0; i<network.length; i++) {
				if(network[i]==pVal) network[i] = qVal;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
