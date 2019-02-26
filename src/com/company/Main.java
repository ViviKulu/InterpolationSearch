package com.company;

public class Main {

//    To find the position to be searched, interpolation search uses following formula.

//    The idea of formula is to return higher value of pos
//    when element to be searched is closer to arr[hi]. And
//    smaller value when closer to arr[lo]
//    pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]
//
//    arr[] ==> Array where elements need to be searched
//    x     ==> Element to be searched
//    lo    ==> Starting index in arr[]
//    hi    ==> Ending index in arr[]

//    Algorithm:

//    Rest of the Interpolation algorithm is same except the above partition logic.
//
//    Step1: In a loop, calculate the value of “pos” using the probe position formula.
//    Step2: If it is a match, return the index of the item, and exit.
//    Step3: If the item is less than arr[pos], calculate the probe position of the
//    left sub-array. Otherwise calculate the same in the right sub-array.
//    Step4: Repeat until a match is found or the sub-array reduces to zero.

    public static void main(String[] args) {
	// write your code here
        int[] a = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23,
                24, 33, 35, 42, 47};
        int x = 55;
        int index = interpolationSearch(a, x);
        if(index != -1){
            System.out.println("Element found at " + index);
        }else{
            System.out.println("Element not found");
        }
    }

    private static int interpolationSearch(int[] a, int x) {
        //Find the indexes of the two corners
        int lo = 0;
        int high = a.length - 1;

        //Array must be sorted to ensure that an element present in array
        //must be in range defined by corners.
        while(lo <= high && x >= a[lo] && x <= a[high]){
            //Probe position
            int pos = lo + (((high - lo) / (a[high] - a[lo])) * (x - a[lo]));
            //Condition of target found
            if(a[pos] == x){
                return pos;
            }
            //If x is larger, x is in upper sub array
            if(a[pos] < x){
                lo = pos + 1;
            }
            //If x is smaller, x is in lower sub array
            else{
                high = pos - 1;
            }
        }
        return -1;
    }

}
