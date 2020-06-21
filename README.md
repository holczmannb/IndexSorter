# IndexSorter
 
Reference implementation for IndexSorting algorithm and compare the runtime with quick sort. <BR><BR>

Index sorting is an sorting algorithm what is working on set of distinct natural numbers and can deliver better runtime performance then quicksort in case of the range of the numbers in the set is bellow million.<BR><BR>
 
How to run:<BR>
Download the /bin/IndexSorter.jar <BR>
Call: java -jar  IndexSorter.jar param1 param2 <BR><BR>
Parameters: <BR>
 param1: number of samples to be generated (like 5) <BR>
 param2: size of the array what will be sorted (like 100)<BR>
 param3: range of the natural numeric numbers (like 1000)<BR>
 param4: print statistic only and skip the array printouts. (like true)<BR>

Algorithm execution by a sample <BR>
 1. Sample to sort [8, 5, 3, 7] <BR>
 2. Create helper boolean array where length of the array is the maximum number in the sample (8): <BR>
 [false, false, false, false, false, false, false, false]<BR>
 3. Use the number from input array as index and set true by this index in the helper array. <BR>
 [false, false, true, false, true, false, true, true]<BR>
 4. Loop over the helper array and write back to the index value to the original array left to right if the helper array contains true in the index position<BR>
 [3, 5, 7, 8]<BR>
 
 Formal analysis: <BR>
 Sort an array of n distinct elements, quicksort takes O( n log n ) time in best case and O ( n2 ) in worst case<BR>
 Index sorting needs three loops over the the array<BR>
 1. Selecting the maximum element: n step<BR>
 2. Setting the helper array value: n step<BR>
 3. Writing back the index values to original: n step<BR>
 
 The time is always linear and O ( 3 n ) in every case.<BR>
 n = 1000 then QuickSort and IndexSort both need 3000 steps in best case, but Quicksort is always worse in non best cases.<BR>

 Index sorter show better statistic if the size of the sample is bigger.
