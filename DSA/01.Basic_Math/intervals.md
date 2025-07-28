# Intevals:

- **Closed Intervals-[a,b] :**  Set of numbers from `a to b` including `a` and `b`
- **Open Intervals - (a,b) :**  Set of numbers from `a to b` excluding both `a` and `b`
- **Left-Opened Right-Closed - (a,b] :** `a` is excluded `b` is included
- **Left-Closed Right-Opened - [a,b) :**  `a` is included `b` is excluded

### How to find num of elements in the intervals?

- [3,8] = {3,4,5,6,7,8} = 6 elements both 3 and 8 is concluded
- (3,8) = {4,5,6,7} = 4 elements both 3 and 8 excluded
- (3,8] = {4,5,6,7,8} = 5 elements 3 is excluded and 8 is included
- [3,8) = {3,4,5,6,7} = 5 elements 3 is included  and 8 is excluded

- [1,100] = 100 elements
- [53,86] = ?

#### Formulae:
- Depends on the interval type formula changes
- Num of elements in closed intervals **[a,b] = b-a+1**
- Num of elements in open intervals **(a,b) = b-a-1**
- Num of elements in other intervals **[a,b) and (a,b] = b-a**

### Where do we use?

- To calculate num of iterations a loop got executed
- **Example:**
```java
for(int i=2;i<n;i++){
    print(i);
}
// here interval [2,n-1]
// how many iterations: b-a+1 = n-1-2+1 = n-2 iterations
// if i starts from k then num of iterations = n-1-k+1 = n-k 
```
