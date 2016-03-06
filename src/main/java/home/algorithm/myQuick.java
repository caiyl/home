package home.algorithm;

public class myQuick {
	public static void main(String[] args) {
		int[] array = {4,3,2,1,8,9};
		array = sort(array);
		for (int i : array) {
			  
		}
	}
	private static int[] sort(int [] array){
		return quickSort(array,0,array.length-1);
	}
	private static int[] quickSort(int[] array, int low, int heigh) {
		if (low < heigh) {
			int division = partition(array, low, heigh);
			quickSort(array, low, division - 1);
			quickSort(array, division + 1, heigh);
		}
		return array;
	}
	private static int partition(int[] array, int low, int heigh) {
		int base = array[low];

		while(low < heigh){
			
			while (low < heigh && array[heigh] >= base) {
				heigh--;
			}
			swap(array,low, heigh);
			while (low < heigh && array[low] <= base) {
				low++;
			}
			swap(array,low, heigh);
		}
		
		return heigh;
	}
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}
}
