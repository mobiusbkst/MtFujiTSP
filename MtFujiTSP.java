import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MtFujiTSP {

    /**
     * 今回の計算で使われる構成資産の数
     */
    private static final int VNUM = 25;

    /**
     * 各構成資産の位置情報をファイルから読み込む
     *
     * @return 各構成資産の位置情報
     */
    Point[] initPointData() {
        Point[] point = new Point[VNUM];
        File file;
        FileReader fr = null;
        BufferedReader br = null;

        file = new File("C:\\temp\\fuji.csv");
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            // 一行目は注釈が入っているので飛ばす
            br.readLine();

            for (int i = 0; i < VNUM; i++) {
                String[] s = br.readLine().split(",");
                point[i] = new Point(Integer.parseInt(s[0]), s[1],
                        Double.parseDouble(s[3]), Double.parseDouble(s[4]),
                        Double.parseDouble(s[7]), Double.parseDouble(s[8]));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return point;

    }

    /**
     * 各構成資産間の距離を計算する。
     *
     * @param p
     * @return
     */
    int[][] calcDistance(Point[] p) {
        int[][] distance = new int[VNUM][VNUM];
        for (int i = 0; i < VNUM; i++) {
            for (int j = i; j < VNUM; j++) {

                double x = p[i].getX() - p[j].getX();
                double y = p[i].getY() - p[j].getY();

                // 1m以下は誤差なので切り捨てて値を格納
                distance[i][j] = distance[j][i] = (int) Math.ceil(Math.sqrt(x
                        * x + y * y));

            }
        }

        // // debug--start
        // for (int i = 0; i < VNUM; i++) {
        // for (int j = 0; j < VNUM; j++) {
        //
        // System.out.print(distance[i][j] + " ");
        //
        // }
        // System.out.println();
        // }
        // // debug--end
        return distance;
    }

    /**
     *
     */
    static int MAX_N = 25;

    //static int dp[][] = new int[1 << MAX_N][MAX_N];
    static int dp[][] = new int[Integer.MAX_VALUE/1000][25];

    void calcMinDistance(int[][] distance) {
        int[][] lookdp = dp;
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        lookdp = dp;
        System.out.println(rec(0, 0, distance));

    }

    // すでに訪れた頂点がS、現在位置がv
    int rec(int S, int v, int[][] distance) {
        if (dp[S][v] >= 0) {
            return dp[S][v];
        }

        if (S == (1 << VNUM) - 1 && v == 0) {
            // すべての頂点を訪れて戻ってきた
            return dp[S][v] = 0;
        }
        int res = Integer.MAX_VALUE;
        for (int u = 0; u < VNUM; u++) {
            if ((S >> u & 1) == 0) {
                // 次にuに移動する
                res = Math.min(res, rec(S | 1 << u, u, distance)
                        + distance[v][u]);
            }
        }
        return dp[S][v] = res;
    }
}