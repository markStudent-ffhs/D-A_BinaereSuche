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
		
		int index = (array.length / 2);
		
		return search(array, index, array.length -1, value);
	}
	
	/**
	 * rekursive search ohne das erstellen eines hilfs arrays
	 * @param array
	 * @param index
	 * @param offset
	 * @param value
	 * @return
	 */
	private static Pair search(int[] array, int index, int offset, final int value)
	{
		
		//wenn der index 0 oder grösser als offset ist wurde nichts gefunden
		if(index == 0 && array[0] != value || index > offset) {
			return null;
		}

		//Prüfen in welcher hälfte sich die zahl befinden könnte
		// obere hälfte
		if(array[index] < value) {
			//die hälfte der oberen hälfte berechnen
			int incrementer = (offset - index) / 2; 
			if(incrementer == 0) {
				incrementer = 1;
			}
			
			index += incrementer;
			
			return search(array, index, offset, value);
		} 
		//untere hälfte
		else if (array[index] > value) {
			//die hälfte der untern hälfte berechnen
			offset = index - 1;
			index = index / 2;
			return search(array, index, offset, value);
		} 
		//value entspricht der zahl auf dem index
		else {
			int lowerIndex = index;
			int upperIndex = index;
			
			//erstes vorkommen der zahl evaluieren
			while(lowerIndex >= 0) {
				//ist die zahl nicht mehr = value, abbrechen und index wieder um 1 inkrementieren
				if(array[lowerIndex] != value) {
					lowerIndex++;
					break;
				} 
				//ist der index 0, ist das array durchlaufen
				else if(lowerIndex == 0) {
					break;
				} 
				//bei einer übereinstimmung, weiter im array
				else {
					lowerIndex--;
				}
			}
			
			//letzes vorkommen der zahl evaluieren
			while(upperIndex <= array.length) {
				//ist der index gleich der array länge ist das array durchlaufen
				//ist die zahl nicht mehr = value, abbrechen index um 1 dekrimieren
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
