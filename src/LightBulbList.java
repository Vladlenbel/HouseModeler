import java.util.ArrayList;
import java.util.List;

public class LightBulbList {
    private List<LightBulb> lightBulbLists;

    public LightBulbList() {

        lightBulbLists = new ArrayList<>();
    }

    public void addLightBulbToList(LightBulb lightBulb) {
        lightBulbLists.add(lightBulb);
    }

    public List<LightBulb> getLightBulbList() {
        return lightBulbLists;
    }
}
