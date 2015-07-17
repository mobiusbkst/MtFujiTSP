/**
 * 各地点の情報 このプログラムで扱うのは日本国内なので東経と北緯ということにする また平面直角座標系については、山梨県と静岡県のみ扱うので8系とする。
 */
public class Point {

    public Point(int id, String name, double latitude, double longitude,
            double x, double y) {
        super();
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.x = x;
        this.y = y;
    }

    /**
     * 場所につけた番号
     */
    private int id;

    /**
     * 構成資産の名前
     */
    private String name;

    /**
     * 北緯（十進法度単位）
     */
    private double latitude;

    /**
     * 東経（十進法度単位）
     */
    private double longitude;

    /**
     * 平面直角座標系において富士山頂からの東西方向の距離
     */
    private double x;

    /**
     * 平面直角座標系において富士山頂からの南北方向の距離
     */
    private double y;

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getLatitude() {
        return latitude;
    }

    void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    double getLongitude() {
        return longitude;
    }

    void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    double getX() {
        return x;
    }

    void setX(double x) {
        this.x = x;
    }

    double getY() {
        return y;
    }

    void setY(double y) {
        this.y = y;
    }
}