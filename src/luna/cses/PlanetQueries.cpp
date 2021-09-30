#include <bits/stdc++.h>
using namespace std;

const int LOG = 31;
const int MAXN = 2e5 + 1;
int up[MAXN][LOG];

int main()
{
    int n, q;
    scanf("%d%d", &n, &q);

    for (int i = 1; i <= n; i++)
    {
        int x;
        scanf("%d", &x);
        up[i][0] = x;
    }

    for (int j = 1; j < LOG; j++)
    {
        for (int i = 1; i <= n; i++)
        {
            up[i][j] = up[up[i][j - 1]][j - 1];
        }
    }

    while (q--)
    {
        int u, k;
        scanf("%d%d", &u, &k);

        for (int i = LOG - 1; i >= 0; i--)
        {
            if (k & (1 << i))
            {
                u = up[u][i];
            }
        }
        cout << u << endl;
    }
}