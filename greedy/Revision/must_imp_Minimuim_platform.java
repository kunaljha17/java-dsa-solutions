class Solution {
	public int minPlatform(int arr[], int dep[]) {
		int n = arr.length;
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int platformsNeeded = 1;  
		int maxPlatforms = 1;
		int i = 1;  
		int j = 0;  
		
		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				platformsNeeded++;
				i++;
				if (platformsNeeded > maxPlatforms) {
					maxPlatforms = platformsNeeded;
				}
			} else {
				platformsNeeded--;
				j++;
			}
		}
		return maxPlatforms;
		
	}
}
