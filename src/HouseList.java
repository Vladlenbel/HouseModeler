import java.util.ArrayList;
import java.util.List;

public class HouseList {
    private List<House> houseLists;

    public HouseList() {

        houseLists = new ArrayList<>();
    }

    private void addHouseToList(House house) {
        houseLists.add(house);
    }

    public List<House> getHouseList() {
        return houseLists;
    }
    public House getHouse(String nameHouse){
        House houseRet = null;
        for (House house: getHouseList()){
            if (house.getName().equals(nameHouse)){
                houseRet = house;
            }
        }
        return houseRet;
    }

    public int addHouseWithConfirm(String nameHouse){
        for (House house: getHouseList()){
            if (house.getName().equals(nameHouse)){
                System.out.println("Ошибка при создании(здание с таким же именем создано)");
                return 1 ;
            }
        }
        addHouseToList(new House(nameHouse, new RoomList()));
        return 0;
    }

}
