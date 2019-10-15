package fr.ubordeaux.deptinfo.ao.td3;

public class MergeSort implements Sort {

	private static MergeSort instance;
	private static final String NAME = "Merge";

	private MergeSort() {
		super();
	}

	public static MergeSort createInstance() {
		if (instance == null)
			instance = new MergeSort();
		return instance;
	}

	private void mergeSort(String[] sorted, String[] unsorted, int l, int r) {
		if (l+1 < r) {
			int m = l + (r - l) / 2;
			mergeSort(sorted, unsorted, l, m);
			mergeSort(sorted, unsorted, m, r);
			merge(sorted, unsorted, l, m, r);
		}
	}

	private void merge(String[] sorted, String[] buffer, int l, int m, int r) {
		int i, j, k;
		i = l;
		j = m;
		k = l;
		while (i < m  && j < r) {
			if (sorted[i].compareTo(sorted[j]) < 0)
				buffer[k++] = sorted[i++];
			else
				buffer[k++] = sorted[j++];
		}
		while (i < m) 
				buffer[k++] = sorted[i++];
		while (j < r) 
				buffer[k++] = sorted[j++];
		for (i = l; i < r; ++i)
			sorted[i] = buffer[i];
	}

	@Override
	public String[] sort(String[] unsorted) {
		String[] sorted = unsorted.clone();
		String[] buffer = unsorted.clone();
		mergeSort(sorted, buffer, 0, sorted.length);
		return sorted;
	}

	@Override
	public String getName() {
		return NAME;
	}

}
