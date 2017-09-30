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
		
		int offset = (array.length / 2);
		//System.out.println(middle);
		
		return binS(array, offset, array.length -1, value);
	}
	
	/**
	 * search ohne das erstellen eines hilfs arrays
	 * @param array
	 * @param offset
	 * @param range
	 * @param value
	 * @return
	 */
	private static Pair binS(int[] array, int offset, int range, final int value)
	{
		
		if(offset == 0 && array[0] != value || offset > range) {
			return null;
		}
		
		if(array[offset] < value) {
			int incrementer = (range - offset) / 2; 
			if(incrementer == 0) {
				incrementer = 1;
			}
			
			offset += incrementer;
			
			return binS(array, offset, range, value);
		} else if (array[offset] > value) {
			range = offset - 1;
			offset = offset / 2;
			return binS(array, offset, range, value);
		} else {
			int lowerIndex = offset;
			int upperIndex = offset;
			
			while(lowerIndex >= 0) {
				if(array[lowerIndex] != value) {
					lowerIndex++;
					break;
				} else if(lowerIndex == 0) {
					break;
				} else {
					lowerIndex--;
				}
			}
			
			while(upperIndex <= array.length) {
				if(upperIndex == array.length || array[upperIndex] != value) {
					upperIndex--;
					break;
				} else
					upperIndex++;
			}
						
			return new Pair(lowerIndex, upperIndex);
		}
	}
}
