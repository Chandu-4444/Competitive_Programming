# Segment Tree

<br>

<img src="https://programming.vip/images/doc/b15e4588c3635c11a0ecebb18cc806a7.jpg">
<br>
<br>

### What are range queries?
    We need to answer the queries in a given range. For example, we need to find the sum of elements from L to R in an array.
    We may need to update or make computation in a given range for a query.
### Segment Tree
    Segment tree is a binary tree. It is a full binary tree (Each node has 0 or 2 child nodes). This cannot be a skewed tree, so it is balanced tree.
    why is this only binary tree, why not N-ary tree?


## Why size of segment tree is atmost 4*N?

### Index of last node in worst case = $2^{h+1}-1$, h = $\lceil{log_{2}{N}}\rceil$
### So, S(N) (Index of Nth node) $\leq$ $2^{\lceil{log_{2}{N}}\rceil+1}-1$
### S(N) $<$ $2^{\lceil{log_{2}{N}}\rceil}$
### S(N) $<$ $2*2^{\lceil{log_{2}{N}}\rceil}$
### S(N) $<$ $2*2*2^{\lceil{log_{2}{N}}\rceil-1}$
### S(N) $\leq$ $4^{\lfloor{log_{2}{N}}\rfloor}$
### S(N) $\leq$ $4*N$


<br>
<br>

## problems
- [How to handle fans?](https://www.spoj.com/problems/AKVQLD03/)

    


