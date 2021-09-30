// C++ program to Returns n % p
// using Sieve of Eratosthenes
#include <bits/stdc++.h>
using namespace std;
#define ll long long

// Returns largest power of p that divides n!
ll largestPower(ll n, ll p)
{
    // Initialize result
    ll x = 0;

    // Calculate x = n/p + n/(p^2) + n/(p^3) + ....
    while (n)
    {
        n /= p;
        x += n;
    }
    return x;
}

// Utility function to do modular exponentiation.
// It returns (x^y) % p
ll power(ll x, ll y, ll p)
{
    ll res = 1; // Initialize result
    x = x % p;  // Update x if it is more than or
    // equal to p
    while (y > 0)
    {
        // If y is odd, multiply x with result
        if (y & 1)
            res = (res * x) % p;

        // y must be even now
        y = y >> 1; // y = y/2
        x = (x * x) % p;
    }
    return res;
}

// Returns n! % p
ll modFact(ll n, ll p)
{
    if (n >= p)
        return 0;

    ll res = 1;

    // Use Sieve of Eratosthenes to find all primes
    // smaller than n
    bool isPrime[n + 1];
    memset(isPrime, 1, sizeof(isPrime));
    for (ll i = 2; i * i <= n; i++)
    {
        if (isPrime[i])
        {
            for (ll j = 2 * i; j <= n; j += i)
                isPrime[j] = 0;
        }
    }

    // Consider all primes found by Sieve
    for (ll i = 2; i <= n; i++)
    {
        if (isPrime[i])
        {
            // Find the largest power of prime 'i' that divides n
            ll k = largestPower(n, i);

            // Multiply result with (i^k) % p
            res = (res * power(i, k, p)) % p;
        }
    }
    return res;
}

// Driver method
int main()
{
    ll n, p = 1e9 + 7;
    cin >> n;
    cout << modFact(n * 2, p) % (p) / 2;
    return 0;
}
