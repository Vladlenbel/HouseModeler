import java.util.ArrayList;
import java.util.List;

public class FurnitureList {
    private List<Furniture> furnitureList;

    public FurnitureList() {

        furnitureList = new ArrayList<>();
    }

    private void addFurnitureToList(Furniture furniture) {
        furnitureList.add(furniture);
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void addFurnityreConfirm(Furniture newFurniture, double roomSize){
        double squareBisy = 0;
            for (Furniture furniture: getFurnitureList()){
                squareBisy += furniture.maxSize;
            }
            squareBisy += newFurniture.maxSize;

            if(squareBisy*100/roomSize > 70){
                System.out.println("Не влезет");
            }
            else {
                addFurnitureToList(newFurniture);
            }
    }
}
