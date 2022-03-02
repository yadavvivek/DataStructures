 /*  The Strategy Patterns defines a family of algorithms, encapsulates each one and make them interchangeable, 
  *  strategy lets the algorithm vary independently from the clients that use it.  
  */

//client
class Sorting {
	
	ISortingStrategy sortingStrategy;
	
	public Sorting(ISortingStrategy strategy) {
		sortingStrategy = strategy;
	}
	
	public int[] sort(int[] data) {
		return sortingStrategy.sort(data);
	}
}

//Strategy
interface ISortingStrategy {
	int[] sort(int[] data);
}


//BubbleSort Strategy
class BubbleSortStrategy implements ISortingStrategy {

	@Override
	public int[] sort(int[] data) {
		System.out.println("BubbleSortStrategy size: "+data.length);
		for(int i = data.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
		return data;
	}
}

//Selection Sort Strategy

class SelectionSortStrategy implements ISortingStrategy {

	@Override
	public int[] sort(int[] data) {
		System.out.println("SelectionSortStrategy size: "+data.length);
		for(int startingIndex = 0; startingIndex < data.length; startingIndex++) {
			int minItemIndex = startingIndex;
			for(int lookupMinIndex = startingIndex + 1; lookupMinIndex < data.length; lookupMinIndex++) {
				if(data[lookupMinIndex] < data[minItemIndex]) {
					minItemIndex = lookupMinIndex;
				}
			}
			int temp = data[startingIndex];
			data[startingIndex] = data[minItemIndex];
			data[minItemIndex] = temp;
		}
		return data;
	}
}

public class StrategyPatternExample {
	
	public static void main(String args []) {
		int[] data = {1,3,5,2,0};
		sortData(data);
		
		int[] newData = {10, 11, 9, 5, 4, 2, 1, 6, 3, 7, 8, 0};
		sortData(newData);
	}
	
	static void sortData(int[] data) {
		ISortingStrategy sortingStrategy = null;
		Sorting sortingImpl;
		
		//varying of algorithm
		if(data.length <= 5) {
			sortingStrategy = new BubbleSortStrategy();
		} else if (data.length > 5 /* && data.length <= 10 */) {
			sortingStrategy = new SelectionSortStrategy();
		}
		
		sortingImpl = new Sorting(sortingStrategy);
		
		for(int i: sortingImpl.sort(data)) {
			System.out.print(i+", ");
		}
	}
}


