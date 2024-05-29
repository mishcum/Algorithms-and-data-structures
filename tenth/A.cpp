#include <iostream>
#include <vector>
#include <string>
 
class A {
public:
    static int get_sum(int s, int f, const std::vector<int>& sum_cost) {
        return sum_cost[f] - sum_cost[s - 1];
    }

    static void sum(const std::vector<int>& cost, std::vector<int>& sum_cost, int n) {
        for (int i = 1; i <= n; ++i) {
            sum_cost[i] = sum_cost[i - 1] + cost[i];
        }
    }
};

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int n, q;
    std::cin >> n >> q;

    std::vector<int> cost(n + 1);
    std::vector<int> sum_cost(n + 1);

    for (int i = 1; i <= n; ++i) {
        std::cin >> cost[i];
        sum_cost[i] = cost[i];
    }

    A::sum(cost, sum_cost, n);

    for (int i = 0; i < q; ++i) {
        std::string arg;
        int a, b;
        std::cin >> arg >> a >> b;

        if (arg == "?") {
            std::cout << A::get_sum(a, b, sum_cost) << '\n';
        } else {
            cost[a] = b;
            A::sum(cost, sum_cost, n);
        }
    }

    return 0;
}

