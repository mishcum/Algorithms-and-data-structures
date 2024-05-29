#include <iostream>
#include <vector>
#include <array>

using namespace std;

class Main {
public:
    static int leftbsc(vector<vector<int>>& array, int target, int c) {
        int l = -1;
        int r = c;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (array[mid][0] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (array.size() > r && array[r][0] == target) return array[r][1];
        else return 0;
    }
    static void main() {
        int n;
        cin >> n;
        vector<vector<int>> clr(n, vector<int>(2));
        int c = 0;
        for (int i = 0; i < n; i++) {
            int a;
            cin >> a;
            if (i == 0 || clr[c][0] == a) {
                clr[c][0] = a;
                clr[c][1] ++;
            } else {
                c ++;
                clr[c][0] = a;
                clr[c][1] ++;
            }
        }
        int q;
        cin >> q;
        for (int i = 0; i < q; i++) {
            int b;
            cin >> b;
            cout << leftbsc(clr, b , c + 1) << endl;
        }    
    } 
};

int main() {
    Main::main();
    return 0;
}