package hsejava.algorithms.topics.sixth;

import java.util.*;

class taskCsixth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>(n + 1);
        for (int i = 0; i < n; ++i){
            for (int j = 0;j < n;++j){
                int a = in.nextInt();
                if (a == 1) {
                  g.get(i).add(j);
                }  
            }
        }
        System.out.println(g);
        in.close();
        /*int[][] matrix = new int[n][n];
        ArrayList<Integer> stocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean f = true;
            for (int j = 0; j < n; j++) {
                int a = in.nextInt();
                matrix[i][j] = a;
                if (a == 1) {f = false;}
            }
            if (f) {
                stocks.add(i + 1);
            }
        }
        in.close();
        ArrayList<Integer> istocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean fl = true;
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == 1) {
                    fl = false;
                    break;
                }
                
            }
            if (fl) {
                istocks.add(i + 1);
            }
        }
        System.out.println(istocks.size());
        for (int i = 0; i < istocks.size(); i++) {
            System.out.println(istocks.get(i));
        }
        System.out.println(stocks.size());
        for (int i = 0; i < stocks.size(); i++) {
            System.out.println(stocks.get(i));
        }/* */
    }    
}