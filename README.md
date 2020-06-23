# IndexSort

<B>Description:</B><BR><BR>
Reference implementation for IndexSort algorithm and compare the runtime with quick sort and the liner time counting sort. <BR><BR>
 QuickSort: https://en.wikipedia.org/wiki/Quicksort<Br>
 CountingSort: https://opendatastructures.org/ods-java/11_2_Counting_Sort_Radix_So.html<BR>

Index sort is an sorting algorithm what works on set of distinct natural numbers and can deliver better runtime performance than QuickSort and CountingSort in many cases. This is not a generic sorting algorithm but works very effectively with positive unique integer values what is used in many business scenario.<BR>
 
<B>How to run reference implementation:</B><BR><BR>
Download the /bin/IndexSorter.jar <BR>
Call: java -jar  IndexSorter.jar param1 param2 param3 param4<BR><BR>
Parameters: <BR>
 param1: number of samples to be generated (like 5) <BR>
 param2: size of the array what will be sorted (like 100)<BR>
 param3: range of the natural numeric numbers (like 1000)<BR>
 param4: print statistic only and skip the array printouts. (like true)<BR>

<B>Algoritm with pseudocode:</B><BR><BR>
array a; // sortable array<BR>
array b; // helper array<BR>
n = length(a) // length of the sortable array<BR>
max = 0  // store the maximum value in the sortable array<BR>
min = infinite  // store the minimum value in the sortable array<BR>
Loop  i = 1 .. n { if a[i] > max then max = a[i]; if a[i] < min then min = a[i]; }   // look for maximum and minimum<BR>
b = new array[max]                                   // helper array creation<BR>
Loop  i = 1 .. n { b[a[i]] = true }                  // set the true by value as index <BR>
pos = 0 <BR>
Loop  i = min .. max {if (b[i]) then a[pos++] = i}     // rewrite the sortable array with position pointer<BR>

<B>Algorithm execution by a sample </B><BR>
 1. Sample to sort [8, 5, 3, 7] <BR>
 2. Create helper boolean array where length of the array is the maximum number in the sample (8): <BR>
 [false, false, false, false, false, false, false, false]<BR>
 3. Use the number from input array as index and set true by this index in the helper array. <BR>
 [false, false, true, false, true, false, true, true]<BR>
 4. Loop over the helper array and write back to the index value to the original array left to right if the helper array contains true in the index position.<BR>
 [3, 5, 7, 8]<BR>
 
 <B>Formal analysis:</B> <BR><BR>
 Sort an array of n distinct elements, quicksort takes O( n log n ) time in best case and O ( n2 ) in worst case.<BR>
 Index sorting needs three loops over the the array.<BR>
 1. Selecting the maximum and minimum element: n step.<BR>
 2. Setting the helper array value: n step.<BR>
 3. Writing back the index values to original: (max - min) step, where max and min are the maximum and minimum values in the array.<BR>
 
 The time is always linear and O ( 2n + (max - min) ) in every case.<BR>
 n = 1000 then QuickSort needs 3000 steps in best case. IndexSort needs 2000 + (maximum - minimum value) steps in every case.<BR>
 CountingSort has O (n + max) what is comparable with IndexSort but IndexSort on random datasets shows better performance.

<B>Statistics:</B> <BR>
 Index sort shows the best execution time in case of big array sizes. There is no big exection time difference in the small arrays. <BR>
<Table>
<TR><TH>Number of Sample</TH><TH>Size of array</TH><TH>Number intervall 1..n</TH><TH>QuickSort Wins</TH><TH>IndexSort Wins</TH><TH>CountingSort Wins</TH></TR>
<TR><TD>100</TD><TD>	10</TD><TD>	100</TD><TD>	81</TD><TD>16</TD><TD> 3</TD></TR>
<TR><TD>100</TD><TD>	10</TD><TD>	100</TD><TD>	92</TD><TD>	6</TD><TD>	2</TD></TR>
<TR><TD>100</TD><TD>	10</TD><TD>	100</TD><TD>	89</TD><TD>	8</TD><TD>	3</TD></TR>
<TR><TD>100</TD><TD>	100</TD><TD>	100</TD><TD>	38</TD><TD>	55</TD><TD>	7</TD></TR>
<TR><TD>100</TD><TD>	100</TD><TD>	100</TD><TD>	50</TD><TD>	45</TD><TD>	5</TD></TR>
<TR><TD>100</TD><TD>	100</TD><TD>	100</TD><TD>	46</TD><TD>	50</TD><TD>	4</TD></TR>
<TR><TD>100</TD><TD>	100</TD><TD>	1000</TD><TD>	51</TD><TD>	43</TD><TD>	6</TD></TR>
<TR><TD>100</TD><TD>	100</TD><TD>	1000</TD><TD>	46</TD><TD>	44</TD><TD>	10</TD></TR>
<TR><TD>100</TD><TD>	100</TD><TD>	1000</TD><TD>	48</TD><TD>	46</TD><TD>	6</TD></TR>
<TR><TD>100</TD><TD>	1000</TD><TD>	1000</TD><TD>	3</TD><TD>	65</TD><TD>	32</TD></TR>
<TR><TD>100</TD><TD>	1000</TD><TD>	1000</TD><TD>	3</TD><TD>	64</TD><TD>	33</TD></TR>
<TR><TD>100</TD><TD>	1000</TD><TD>	1000</TD><TD>	2</TD><TD>	76</TD><TD>	22</TD></TR>
<TR><TD>100</TD><TD>	1000</TD><TD>	10000</TD><TD>	7</TD><TD>	81</TD><TD>	12</TD></TR>
<TR><TD>100</TD><TD>	1000</TD><TD>	10000</TD><TD>	8</TD><TD>	77</TD><TD>	15</TD></TR>
<TR><TD>100</TD><TD>	1000</TD><TD>	10000</TD><TD>	6</TD><TD>	81</TD><TD>	13</TD></TR>
<TR><TD>100</TD><TD>	10000</TD><TD>	10000</TD><TD>	0</TD><TD>	96</TD><TD>	4</TD></TR>
<TR><TD>100</TD><TD>	10000</TD><TD>	10000</TD><TD>	0</TD><TD>	92</TD><TD>	8</TD></TR>
<TR><TD>100</TD><TD>	10000</TD><TD>	10000</TD><TD>	0</TD><TD>	99</TD><TD>	1</TD></TR>
<TR><TD>100</TD><TD>	10000</TD><TD>	100000</TD><TD>	0</TD><TD>	100</TD><TD>	0</TD></TR>
<TR><TD>100</TD><TD>	10000</TD><TD>	100000</TD><TD>	0</TD><TD>	98</TD><TD>	2</TD></TR>
<TR><TD>100</TD><TD>	10000</TD><TD>	100000</TD><TD>	0</TD><TD>	100</TD><TD>	0</TD></TR>
<TR><TD>10</TD><TD>	100000</TD><TD>	1000000</TD><TD>0</TD><TD>	10</TD><TD>	0</TD></TR>
</TABLE>

<BR><B>Disadvantages and improvement oportunities</B> <BR>

 1. It works only with distinct values in the array.<BR>
 2. Runtime depends on the distance between maximum and minimum value in the array.<BR>
 3. It can work with negative numbers with transforming the values to positive by adding the minimum value to each element.<BR>
 4. It can work with real numbers with transforming the values to integer whole number with multiplication by 10s. <BR> 
 5. Better representation of the helper array to avoid big size array (memory usage and loop size). Current represenation is good for natural business numbers becasue the values in the helper array are 1 bits in memory only. 
