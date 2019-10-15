package fr.ubordeaux.deptinfo.ao.td3;

public class InsertionSort implements Sort {

	private static InsertionSort instance;
	private static final String NAME = "Insertion";
	
	private InsertionSort() {
		super();
	}

	public static InsertionSort createInstance() {
		if (instance==null)
			instance = new InsertionSort();
		return instance;
	}

	@Override
	public String[] sort(String[] unsorted) {
		String[] sorted = unsorted.clone();
        int n = sorted.length;  
        for (int j = 1; j < n; ++j) {  
            String key = sorted[j];  
            int i = j-1;  
            while ( (i > -1) && ( sorted [i].compareTo(key) > 0 ) ) 
                sorted [i+1] = sorted [i--];  
            sorted[i+1] = key;  
        }  
        return sorted;
    }  
	
	@Override
	public String getName() {
		return NAME;
	}

}
