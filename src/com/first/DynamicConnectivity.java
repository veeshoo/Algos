package com.first;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DynamicConnectivity {

	public static void main(String[] args) {
		int d = StdIn.readInt();
		QuickFindUF uf = new QuickFindUF(d);
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(!uf.connected(p, q)) {
				uf.union(p, q);
				StdOut.println(p + "  " + q);
			}
		}
	}

}
