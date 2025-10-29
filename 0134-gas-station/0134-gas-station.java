class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==1 && gas[0]>=cost[0])return 0;
        int index = 0;
		boolean res = false;
		while(index<gas.length) {
			if(gas[index]>cost[index]) {
				res = isPossible(index, gas, cost);
				if(res)
					break;
			}
			index++;
		}
        return res?index:-1;
    }
    public boolean isPossible(int index, int[] gas, int[] cost) {
		int temp = index;
		int n=gas.length;
		int left = gas[temp]-cost[temp]+gas[(temp+1)%n];
		temp = (temp+1)%n; 
		while(temp!=index) {
			if(left<cost[temp])
				return false;
			left += gas[(temp+1)%n] - cost[temp];
			temp = (temp+1)%n;
			if(left<=0) {				
				return false;
			}
		}		
		return true;
		
	}
}