package hsejava.algorithms.topics.third;

import java.util.Scanner;

class taskGthird {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int n = Scanner.nextInt();
        Scanner.nextLine();
        String[] arr = new String[n];        
        for (int i = 0; i < n; i++) {
            arr[i] = Scanner.nextLine();
        }
        Scanner.close();
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < n - 1 - j; i++) {
                int k = 0;
                boolean per = false;
                while (k < Math.min(arr[i].length(), arr[i + 1].length())) {
                    if ((int) arr[i].charAt(k) < (int) arr[i + 1].charAt(k)) {
                        String temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        per = true;
                        break;
                    } else if ((int) arr[i].charAt(k) > (int) arr[i + 1].charAt(k)) {
                        per = true;
                        break;
                    }
                    k++;
                }
                if (!per) {
                    //System.out.println(Arrays.toString(arr));
                    String s1 = arr[i] + arr[i + 1];
                    String s2 = arr[i + 1] + arr[i];
                    for (int l = 0; l < s1.length(); l++) {
                        if ((int) s2.charAt(l) > (int) s1.charAt(l)) {
                            String temp1 = arr[i];
                            arr[i] = arr[i + 1];
                            arr[i + 1] = temp1;
                            //System.out.println("::::::");
                            break;
                        } else if ( (int) s2.charAt(l) < (int) s1.charAt(l)) {
                            //System.out.println("!!!!!!!!");
                            break;
                        }
                    }
                }
            }
        }
    
        String res = "" ;
        for (int i = 0; i < n; i++) res += arr[i];
        //System.out.println(Arrays.toString(arr).replace("[", "").replace(" ", "").replace(",", "").replace("]", ""));
        System.out.println(res);
    }    
}
