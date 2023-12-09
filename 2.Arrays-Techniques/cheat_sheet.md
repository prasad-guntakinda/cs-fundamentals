# Array Techniques Cheat Sheet

### Prefix Sum:

### sub arrays:
        
        - Num of sub arrays in an array = n(n+1)/2
        - num of sub arrays arr[i] is present  = (num of start points)*(num of end points)
                                               = (i+1)*(n-i)
        - 

#### When to use which technique?
- Sum of some random sub arrays ==> use range-sum technique
- Sum of all sub arrays ==> use carry-forward technique
- Sum of all sub arrays sum ==> contribution technique
- Sum of fixed size window ==> sliding window
