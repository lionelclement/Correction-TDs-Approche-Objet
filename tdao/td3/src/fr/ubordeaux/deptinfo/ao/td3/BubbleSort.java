package fr.ubordeaux.deptinfo.ao.td3;

public class BubbleSort implements Sort {

	private static BubbleSort instance;
	private static final String NAME = "Bubble";

	private BubbleSort() {
		super();
	}

	public static BubbleSort createInstance() {
		if (instance == null)
			instance = new BubbleSort();
		return instance;
	}

	@Override
	public String[] sort(String[] unsorted) {
		String[] sorted = unsorted.clone();
		boolean effect;
		for (int i = sorted.length - 1; i > 0; --i) {
			effect = false;
			for (int j = 0; j < i; ++j)
				if (sorted[j + 1].compareTo(sorted[j]) < 0) {
					String tmp = sorted[j];
					sorted[j] = sorted[j + 1];
					sorted[j + 1] = tmp;
					effect = true;
				}
			if (!effect)
				break;
		}
		return sorted;
	}

	@Override
	public String getName() {
		return NAME;
	}

}
