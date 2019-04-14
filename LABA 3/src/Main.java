
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        in_out_put MEM = new in_out_put();
        String A,B,LCS;
        A=MEM.str_input();
        B=MEM.str_input();
        MEM.str_output(A,B);
        int n=A.length();
        int m=B.length();
        int[][] l = new int [n+1][m+1];

        MEM.computeLCS(A, B, n, m, l );
        MEM.showLCS(l,n,m);
        LCS=MEM.assemblyLCS(A, B, n, m, l );
        System.out.print(LCS);

    }
}

class in_out_put {
    public String str1;
    public String str2;
    static public String LCS="";

    public String str_input() {
        String vvod, agree, agree1 = "n";
        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println("Input your string:");
            vvod = scanner.nextLine();
            System.out.println("it's your string? y/n?");
            agree = scanner.nextLine();
        }

        while (agree.equals("n"));
        return vvod;
    }

    public void str_output(String A, String B) {
        System.out.println("Введеные строки");
        System.out.println(A);
        System.out.println(B);
    }

    static void computeLCS(String str1, String str2, int n, int m, int[][] l) {

        for (int i = 0; i < n + 1; i++) {
            l[i][0] = 0;
        }
        for (int i = 0; i < m + 1; i++) {
            l[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                    l[i][j] = l[i - 1][j - 1] + 1;
                } else {

                    if (l[i - 1][j] > l[i][j - 1]) {
                        l[i][j] = l[i - 1][j];
                    } else {
                        l[i][j] = l[i][j - 1];

                    }

                }

            }
        }
    }

    static String assemblyLCS(String str1, String str2, int i, int j, int[][] l) {

        if (l[i][j] != 0) {

            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                LCS = str1.charAt(i - 1) + LCS;
                assemblyLCS(str1, str2, i - 1, j - 1, l);
            } else {

                if (l[i - 1][j] > l[i][j - 1]) {

                    assemblyLCS(str1, str2, i - 1, j, l);

                } else {

                    assemblyLCS(str1, str2, 1, j - 1, l);

                }

            }


        }
        return LCS;
    }

    static void showLCS(int[][] l, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                System.out.print(l[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }


    }
}