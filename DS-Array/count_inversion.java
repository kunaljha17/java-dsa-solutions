//Approach in this i have two approach first one is brute there simple do by doing twio iteration 
// first loop for selecting element then another for comparision by element
// here time complexity is O(n^2) THIS IS not good so we have another approach by 


//Approach 2 is doing with merge sort , why , think like when we have two sorted array then how count inversion perform , like fo same way we divide and do count while merging when left is greater then,
count = (mid-left+1)
// because this when we got one element then after that all element is greater bcz sorted .

// we have just change 2 3 line of code in normal merge sort

  class Solution {
	long count  = 0; //global variable for counting
	public void merge(int[]arr, int si, int mid, int ei) {
		int temp[] = new int[ei - si + 1];
		int i = si; // idx for 1st sorted part
		int j = mid + 1; // idx for 2nd sorted part
		int k = 0; // idx for temp
		
		while (i <= mid && j <= ei) {
			if (arr[i]<=arr[j]) { //here we have to also think for when both number is same then , so we add equal ...
				temp[k] = arr[i];
				i++;
				k++;
			}
			else {
			    count += (mid-i+1); //main counting is here when left is greater as we want pair
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		while (i <= mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		while (j <= ei) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		
		for (k = 0, i = si; k<temp.length; k++, i++) {
			arr[i] = temp[k];
		}
	}
	public void mergeSort(int arr[], int i, int j) {
		if (i >= j)return;
		int mid = i + (j - i)/2;
		mergeSort(arr, i, mid);
		mergeSort(arr, mid + 1, j);
		merge(arr, i, mid, j);
	}
	
	public int inversionCount(int arr[]) {
	    count = 0; // this step is necessary  
		mergeSort(arr,0,arr.length-1);
		return (int)count;
	}
}
