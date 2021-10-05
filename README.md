## List of Problems

- [Modular Multiplication and Prime Factorization (Naive Method): Factors of Factorial Problem.](./src/luna/atcoder/FactorsOfFactorial.java)
    - [Prime Factorization](https://cp-algorithms.com/algebra/factorization.html)
    - [Modular Multiplication](https://www.geeksforgeeks.org/how-to-avoid-overflow-in-modular-multiplication/)
- [Binary Search](https://www.topcoder.com/thrive/articles/Binary%20Search)
    - [Aggressive Cows](./src/luna/spoj/AggressiveCows.java)
    - [Copying Books](./src/luna/spoj/CopyingBooks.java)
    - [Eko Eko](./src/luna/spoj/EKO.java)
    - [Maximum Median](./src/luna/d2/MaximumMedian.java)
- Graphs/Trees
    - [Tours (using all source DFS/BFS)](./src/luna/atcoder/Tour.java)
    - [One-Stroke Path](./src/luna/atcoder/OneStrokePath.java)
    - [Distance Queries](./src/luna/cses/DistanceQueries.java)
    - [Company Queries (Binary Lifting)](./src/luna/cses/CompanyQueriesI.java)
    
 - Miscellaneous
   - [H and V (Nice idea)](./src/luna/atcoder/HandV.java)
   - [Skill Up (Same idea as above)](./src/luna/atcoder/SkippUp.java)
  

 - Number Theory Notes
   - Factors of a number always occur in pairs. [Hackerearth Tutorial](https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-2/tutorial/)
   - Proof: 
    
        $\mathbf{Let}$ $a*b = n$
        $\\$
        $\mathbf{If}$ $b >= \sqrt{n}\\$
        $\mathbf{Then}$ $b = \frac{n}{a} >= \sqrt{n} \implies a <= \sqrt{n}\\$
        So, half of the factors will be less than or equal to $\sqrt{n}$ and the remaining will be greater than $\sqrt{n}$.
     - Factors of 36 = [1, 2, 3, 4, 6, 9, 12, 18, 36].
       The pairs are (1, 36), (2, 18), (3, 12), (4, 9), (6, 6). 
    - [Prime Factorization](https://cp-algorithms.com/algebra/factorization.html)
    - [GCD & LCM](https://cp-algorithms.com/algebra/euclid-algorithm.html)
      - $a*b = gcd(a, b) * lcm(a, b)$
      - $gcd(a, b) = gcd(a, a \pm b)$
      - $gcd(x, 1) = 1, lcm(x, 1) = x$
      - GCD is associative but LCM is not. 
        - $gcd(a,b,c,d) = gcd(a,b,gcd(c,d)) = gcd(a, gcd(b, gcd(c, d)))$
    - Total factors of N = $O(n^{\frac{1}{3}})$
    - Count of all primes from 1 to N = $O(\frac{N}{\ln{N}})$
  - <h2>Modular Arithematic</h2>

    - $(x+y)\mod m = (x\mod m + y\mod m) \mod m$
      - $x \mod m = r1,\\$  $y \mod m = r2\\$ $x = m*a + r1\\$  $y = m*b + r2\\$
       $(x+y)\mod m = (m*a + r1) \mod m + (m*b + r2)\mod m \implies (r1 + r2)\mod m \implies r1 + r2$
    - $(x - y)\mod m = ((x\mod m) - (y\mod m) + m)\mod m$  (Additional m to compensate the negative remainders.)
    - $(x*y)\mod m = ((x\mod m)*(y\mod m))\mod m$
    - Modular Multiplicative Inverse: $(a.b\mod m) = 1$
    - Ferrmat's little theorem
      - If m is prime and a $\in$ [1, m-1], then $a^{m}\mod m = a\mod m$
        - Let $x = a^{-1}\\$
          Multiply this on both sides to get $a^{m-1}\mod m = 1\\$
          So, this gives our MMI for a. 
    - $10^9+7$ is a prime number.
    - [Binary Exponentiation](https://cp-algorithms.com/algebra/binary-exp.html)
  
    - <h2>Sieve of Eratosthenes</h2>
      
      - 

      
        
        