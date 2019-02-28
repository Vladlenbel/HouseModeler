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
         Room room;
        System.out.print("Введите название комнаты: ");

        String nameRoom = scanner.nextLine();

        while (addRoomWithConfirm(nameRoom) == 1){
            System.out.print("Укаките название комнаты: ");
            nameRoom = scanner.nextLine();
        }
        System.out.print("Введите площадь комнаты: ");
        double square = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите колличество окон: ");
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
            if(windowKol == 0 ){
                int summLightFlow = 0;

                while (summLightFlow < 300){
                    summLightFlow = 0;
                    System.out.print("Введите мощность светового потока лампочки: ");
                    LightBulb lightBulbNew = new LightBulb("Лампочка", Integer.parseInt(scanner.nextLine()));

                    //summLightFlow += windowCol*700;
                    for (LightBulb lightBulb: lightBulbList.getLightBulbList()){
                        summLightFlow += lightBulb.getLightFlow();
                    }
                    if (summLightFlow + lightBulbNew.getLightFlow() > 4000){
                        System.out.println("Дужа ярко");
                    }else {
                        lightBulbList.addLightBulbToList(lightBulbNew);
                        summLightFlow += lightBulbNew.getLightFlow();
                    }
                }
            }
            addRoomToList(room = new Room(nameRoom, square, lightBulbList, new FurnitureList()));
            room.roomMeny(scanner);

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
