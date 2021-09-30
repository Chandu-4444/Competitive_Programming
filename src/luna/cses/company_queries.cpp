#include <bits/stdc++.h>
using namespace std;

const int LOG = 20;
const int MAXN = 2e5 + 1;
vector<int> tree[MAXN + 1];
int up[MAXN][LOG + 1];
int depth[MAXN];

int main()
{

	int n, q;
	scanf("%d%d", &n, &q);

	up[1][0] = 1;
	tree[0].push_back(1);
	tree[1].push_back(0);
	for (int i = 1; i <= n - 1; i++)
	{
		int x, y;
		cin >> x >> y;
		tree[x].push_back(y);
		tree[y].push_back(x);
	}

	stack<int> stack;
	bool visited[n + 1];
	for (int i = 0; i <= n; i++)
	{
		depth[i] = 0;
		visited[i] = false;
	}
	stack.push(0);
	up[0][0] = 0;
	depth[0] = 0;
	while (stack.size() > 0)
	{
		int curr_node = stack.top();
		stack.pop();
		visited[curr_node] = true;

		for (int i = 1; i <= LOG; i++)
		{
			up[curr_node][i] = up[up[curr_node][i - 1]][i - 1];
		}

		for (int i : tree[curr_node])
		{
			if (!visited[i])
			{
				depth[i] = depth[curr_node] + 1;
				up[i][0] = curr_node;
				stack.push(i);
			}
		}
	}

	while (q--)
	{
		int u, v;
		scanf("%d%d", &u, &v);
		int a = u, b = v;

		if (depth[u] < depth[v])
		{
			swap(u, v);
		}

		int diff = depth[u] - depth[v];

		for (int i = LOG; i >= 0; i--)
		{
			if (diff & (1 << i))
			{
				u = up[u][i];
			}
		}

		if (u == v)
		{
			int ans = depth[a] + depth[b] - 2 * depth[u];
			printf("%d\n", ans);
			continue;
		}

		for (int i = LOG; i >= 0; i--)
		{
			if (up[u][i] != up[v][i])
			{
				u = up[u][i];
				v = up[v][i];
			}
		}

		int ans = depth[a] + depth[b] - 2 * depth[up[u][0]];
		printf("%d\n", ans);
	}

	return 0;
}
