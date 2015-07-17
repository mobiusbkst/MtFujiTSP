import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GraphCanvas extends Canvas {

    // キャンバスの寸法
    Dimension dimension;

    // グラフ化するデータ
    double[] data;

    // x
    double[] x;

    // y
    double[] y;

    public GraphCanvas(int width, int height, Point[] p) {

        // 領域サイズ設定
        setSize(width, height);

        // 領域のサイズ取得
        dimension = getSize();

        // data[]のインスタンス生成
        data = new double[p.length];

        x = new double[p.length];
        y = new double[p.length];

        // グラフエリアを灰色に設定
        setBackground(Color.lightGray);
    }

    @Override
    public void paint(Graphics g) {

        // 領域のサイズ取得
        dimension = getSize();

        // 軸の色は黒
        g.setColor(Color.black);

        // x軸
        g.drawLine(0, dimension.height / 2, dimension.width - 1,
                dimension.height / 2);

        // y軸
        g.drawLine(dimension.width / 2, 0, dimension.width / 2,
                dimension.height - 1);

        // グラフ線の色は青に設定
        g.setColor(Color.blue);

        for (int i = 0; i < x.length; i++) {
            for (int j = i; j < y.length; j++) {
                g.drawLine((int) x[i] + dimension.width / 2, (int) -y[i]
                        + dimension.height / 2, (int) x[j] + dimension.width
                        / 2, (int) -y[j] + dimension.height / 2);
            }
        }
    }
}
