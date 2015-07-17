import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {

    // データは[m]単位なんだけどそれが枠に収まるように何とかする
    private static int DIMENSION = 150;

    /**
     * @param args
     */
    public static void main(String[] args) {

        // フレーム作成
        JFrame frame = new JFrame();
        frame.setTitle("MainFrame");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        // コンテントペイン作成
        JPanel cp = new JPanel();
        cp.setLayout(null);
        frame.add(cp);
        cp.setBounds(38, 20, 724, 540);

        MtFujiTSP fuji = new MtFujiTSP();
        Point[] p = fuji.initPointData();

        // GraphCanvas作成
        GraphCanvas canvas = new GraphCanvas(724, 540, p);
        cp.add(canvas);
        int[][] distance = fuji.calcDistance(p);
        fuji.calcMinDistance(distance);
        for (int i = 0; i < p.length; i++) {
            canvas.x[i] = p[i].getX() / DIMENSION;
            canvas.y[i] = p[i].getY() / DIMENSION;
        }

        // フレーム可視化
        frame.setVisible(true);
    }
}
