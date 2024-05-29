package hsejava.algorithms.topics.sorting;

import java.util.Scanner;

class G {
    public static int[] rvrs_srt_bbl(int[] lst) {                 //СОРТИРОВКА ПУЗЫРЬКОМ
        for (int j = 0; j < lst.length - 1; j++) {
            boolean per = false;
            for (int i = 0; i < lst.length - 1 - j; i++) {
                if (lst[i] < lst[i + 1]) {
                    int temp = lst[i];
                    lst[i] = lst[i + 1];
                    lst[i + 1] = temp;
                    per = true;
                }
            }
            if (!per) break;
        }
        return lst;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N_str = in.nextInt(); //строки
        int M_stl = in.nextInt(); //столбцы
        int[][] S_mtr = new int[N_str][M_stl]; //матрица
        for (int i = 0; i < N_str; i++) {
            for (int j = 0; j < M_stl; j++) {
                S_mtr[i][j] = in.nextInt();
            }
        }
        int cnrt_count = in.nextInt();
        int[] cntr = new int[cnrt_count]; 
        for (int i = 0; i < cnrt_count; i++) {
            cntr[i] = in.nextInt();
        }  
        in.close();
        cntr = rvrs_srt_bbl(cntr);
        int count = 0; 
        for (int i = 0; i < cnrt_count; i++) {
            goOut:
            for (int n = 0; n < N_str; n++) {
                for (int m = 0; m < M_stl; m++) {
                    if (cntr[i] <= S_mtr[n][m]) {
                        count += 1;
                        S_mtr[n][m] = 0;
                        break goOut;
                    }
                }
            }
        }
        System.out.println(count);
    }   
}
