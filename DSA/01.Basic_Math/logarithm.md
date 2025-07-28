# Logarithm (log)

- In mathematics, a logarithm is the inverse function of exponentiation.
- Example:
  - Exponentiation   x<sup>y</sup> = z
  - Logarithm y = log<sub>x</sub>z
- **log<sub>7</sub>343** is nothing but `how many times you have to multiple base 7 with itself to reach 343` = 7x7x7 = 3 times
- log<sub>7</sub>343 = log<sub>7</sub>7<sup>3</sup> = 3xlog<sub>7</sub>7 = 3x1 = 3
- It is the exponent to which a base must be raised to produce a number. 
- For example, the logarithm base 10 of 1000 is 3, or log₁₀ = 3
- In computer science we consider `log base is always 2`

#### Examples:

1.  other way is how many times you have to devide 1,000 by 10  to reach 1?
```text
1 - 1,000/10 = 100
2 - 100/10 = 10
3 - 10/10 = 1
you have to devide 3 times to reach 1
```
2. How many times we have to multiply 2 with itself to reach 32?
3. How many time we have to devide 32 by 2 to reach 1?
- Both 2 and 3 are same
- if you mutliply 2 with itself (nothing but power-up) to reach 32 = 2*2*2*2*2 = 5 times = 2<sup>5</sup>
- 32/2 = 16/2 = 8/2 = 4/2 = 2/2 = 1, 5 times we have to devide

4. How many times we have to devide 27 by 2 until it reaches to 1?
- log<sub>2</sub>27 = 4.xx ==> 2<sup>4</sup> = 16 and 2<sup>5</sup> = 32, so 27 is in between 2<sup>4</sup> and 2<sup>5</sup>
- integer value of 4.xx = 4

- The base of a logarithm must be greater than 0 and not equal to 1. If the base is not greater than 0, the logarithmic graph would not be continuous.
  John Napier introduced the concept of logarithms in the 17th century. Logarithms are used to make approximations for exact quantities.

### Where to use?
- How many times you have to devide 100 by 2 to reach 1?

log<sub>2</sub>100 times = log<sub>2</sub>2<sup>6.xx</sup> = 6xlog<sub>2</sub>2 = 6 times

- How many times below loop got iterated?
```java
for(int i=n; i>1; i/2){
    print(i);    
}
        n = n, n/2, n/4, n/8, ...1  
iteration=  1,  2,  3,    4, ....k 
assume that k iterations i.e at n/2^k =1 => n=2^k => k = logn base-2

or
for(int i=1; i<=n; i*2){
    print(i);    
}
        n = 1, 2,4,8,16, 32, ....n 
iteration = 1, 2,3,4, ..........k
assume that k iterations i.e at 2^k =n  => k = logn base-2
```



