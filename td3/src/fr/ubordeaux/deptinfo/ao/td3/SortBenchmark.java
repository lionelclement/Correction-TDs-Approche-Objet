package fr.ubordeaux.deptinfo.ao.td3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SortBenchmark {

	private Set<Sort> algorithms;

	public SortBenchmark() {
		super();
		this.algorithms = new HashSet<Sort>();
	}

	public void addAlgorithm(Sort sort) {
		this.algorithms.add(sort);
	}

	public void bench(String[] unsorted) {
		Iterator<Sort> iterator = this.algorithms.iterator();
		while (iterator.hasNext()) {
			Sort sortAlgo = iterator.next();
			long start = System.currentTimeMillis();
			//String[] sorted = ;
			sortAlgo.sort(unsorted);
			long stop = System.currentTimeMillis();
			System.out.println(sortAlgo.getName() + ":" + (stop-start));
			//for (String elt : sorted) {
			//	System.out.print(elt.toString() + ',');
			//}
			//System.out.println("");
		}
		
	}

}
