#include <iostream>
#include <vector>
#include <unordered_map>
#include <stack>

using namespace std;

int main() {
    int n;
    cin >> n;
    unordered_map<int, vector<int>> graph;
    for (int i = 1; i <= n; i++) {
        graph[i] = vector<int>();
    }
    for (int i = 1; i <= n; i++) {
        int chest;
        cin >> chest;
        graph[chest].push_back(i);
    }
    int count = 0;
    vector<int> color(n + 1, 0);
    stack<int> st;
    for (const auto& entry : graph) {
        int vertex = entry.first;
        if (color[vertex] == 0) {
            st.push(vertex);
            while (!st.empty()) {
                int v = st.top();
                if (color[v] == 0) {
                    color[v] = 1;
                    for (int neigh : graph[v]) {
                        if (color[neigh] == 0) {
                            st.push(neigh);
                        } else if (color[neigh] == 1) {
                            count++;
                        }
                    }
                } else if (color[v] == 1) {
                    color[v] = 2;
                    st.pop();
                } else {
                    st.pop();
                }
            }
        }
    }
    cout << count << endl;
    
    return 0;
}
