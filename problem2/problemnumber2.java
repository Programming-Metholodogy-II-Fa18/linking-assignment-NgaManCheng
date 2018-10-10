
public class problemnumber2 {
	
	static void printArray(int array1[]){

		int m = array1.length;
		for (int i=0; i<m; ++i)
		System.out.print(array1[i] + " ");
		System.out.println();

	}
	
	public static void main(String args[]){

		System.out.println("Presented with array: ");
		int arr[] = {9, 11, 1, 13, 7, 15, 3};
		printArray(arr);
		problemnumber2Merge ob = new problemnumber2Merge();
		ob.sort(arr, 0, arr.length-1);
		System.out.println("\n The sorted array is now: ");
		printArray(arr);

	}

	class problemnumber2Merge{

		void mergesort(int array[], int one, int two, int three){

			int size1 = two - one + 1;
			int size2 = three - two;
//hold arrays
			int arr1[] = new int [size1];
			int arr2[] = new int [size2];
//data in arrays
			for (int i=0; i<size1; ++i)
				arr1[i] = array[one + i];
			for (int j=0; j<size2; ++j)
				arr2[j] = array[two + 1+ j];

			int i = 0, j = 0;
			
			int k = one;

			while (i < size1 && j < size2){

				if (arr1[i] <= arr2[j]){
					array[k] = arr1[i];
					i++;
				}
				else{
					array[k] = arr2[j];
					j++;
				}

				k++;
			}

	/* Copy remaining elements of L[] if any */
			while (i < size1){
				array[k] = arr1[i];
				i++;
				k++;
			}

	/* Copy remaining elements of R[] if any */
			while (j < size2){
				array[k] = arr2[j];
				j++;
				k++;
			}

		}

	void sort(int arr[], int one, int two){

		if (one < two){

		int middlelocate = (one+two)/2;

		sort(arr, one, middlelocate);
		sort(arr , middlelocate+1, two);
	
		mergesort(arr, one, middlelocate, two);
	
		}
	}
}	
}
