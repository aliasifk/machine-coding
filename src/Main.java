import com.aliasifkhan.core.utils.Application;
import com.aliasifkhan.parkinglot.ParkingLotApplication;

public class Main {
    public static void main(String[] args) {
        Application app = new ParkingLotApplication();
        app.init();
        app.run();
        app.dispose();
    }
}