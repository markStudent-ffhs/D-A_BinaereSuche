package ch.ffhs.dua.binSearch;


public class BinSearch 
{
	/**
	 * Findet für einen aufsteigend geordneten Array zu einer Zahl value
	 * den kleinsten und den grössten Index.
	 * @param array
	 * @param value
	 * @return Ein Paar mit kleinestem und grösstem Index oder null.
	 */
	public static Pair search(int[] array, int value)
	{
		if(array.length == 0) {
			return null; 
		} else if (array.length == 1) {
			if(array[0] == value) {
				return new Pair(0, 0);
			} else {
				return null;
			}
		}
		
		int left = leftSearch(array, value, 0, array.length-1);
		int right = rightSearch(array, value, 0, array.length-1);

		if(left == -1 || right == -1) {
			return null;
		}
		
		return new Pair(left, right);
	}
	
	private static int leftSearch(int[] array, int value, int min, int max) 
	{
	    if (min == max) {
	    	if(array[min] == value) {
	    		return min;
	    	} else {
	    		return -1;
	    	}
	    }
	    
	   	int mid = (min + max) / 2;

	    if (array[mid] < value) {
	    	return leftSearch(array, value, mid + 1, max);
	    } else {
	    	return leftSearch(array, value, min, mid);
	    }
	}
	
	private static int rightSearch(int[] array, int value, int min, int max) 
	{
	    if (min == max) {
	    	if(array[min] == value) {
	    		return min;
	    	} else {
	    		return -1;
	    	}
	    }
	    
	   	int mid = (min + max + 1) / 2;

	    if (array[mid] > value) {
	    	return rightSearch(array, value, min, mid -1);
	    } else {
	    	return rightSearch(array, value, mid, max);
	    }
	}
}
