
/*
 * 

13 June 2020 at 12:21 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */



public int binarsySearch(int[] arr, int target, int left, int right){

    if(left>right) return -1;

    int mid=left+(right-left)/2;

    if(target==arr[mid]){
        return mid;
    }

    if(target>arr[mid]){
        //go to right side
       return binarySearch(arr, target, mid+1, right);
    }else{
       return binarsySearch(arr, target, left, mid-1);
    }
    
    return -1;
}
    




public int binarySearch(int[] arr, int target){
    int left=0;
    int right=arr.length;

    while(left<=right){
        int mid=left+(right-left)/2;
        if(target==arr[mid]){
            return mid;
        }

        if(target>arr[mid]){
            left=mid+1;
        }else{
            right=mid-1;
        }
    }
    return -1;
}






















