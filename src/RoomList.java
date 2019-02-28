import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RoomList {
    private List<Room> roomLists;

    public RoomList() {

        roomLists = new ArrayList<>();
    }

    public void addRoomToList(Room room) {
        roomLists.add(room);
    }

    public List<Room> getRoomList() {
        return roomLists;
    }

    public void addRoomToListConfirm(Scanner scanner){
        System.out.println("Введите название комнаты:");

        String nameRoom = scanner.nextLine();

        while (addRoomWithConfirm(nameRoom) == 1){
            System.out.println("Укаките название комнаты");
            nameRoom = scanner.nextLine();
        }
        System.out.println("Введите площадь конаты:");
        double square = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите колличество окон:");
        int windowKol = Integer.parseInt(scanner.nextLine());
            if(windowKol>5){
                while (windowKol > 5){
                    System.out.println("Максимальное колличество 5");
                    windowKol = Integer.parseInt(scanner.nextLine());
                }
            }
            LightBulbList lightBulbList = new LightBulbList();
            for (int i = 0; i<windowKol; i++){
                lightBulbList.addLightBulbToList(new LightBulb("Окно", 700));
            }
            addRoomToList(new Room(nameRoom, square, lightBulbList, new FurnitureList()));
            if(windowKol == 0){

            }
        return;
    }

    private int addRoomWithConfirm(String nameRoom){
        for (Room room: getRoomList()){
            if (room.getName().equals(nameRoom)){
                System.out.println("Ошибка при создании(комната с таким же именем создано)");
                return 1 ;
            }
        }
        return 0;
    }

}
