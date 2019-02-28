import java.util.Scanner;

public class House {
    private String name = new String();
    private RoomList roomList;
    public House(String name, RoomList roomList){
        this.name = name;
        this.roomList = roomList;
    }

    public String getName(){
        return name;
    }

    public void addRoom(String nameRoom, int windowCol, double square){
        roomList.addRoomToList(new Room(nameRoom, square, new LightBulbList(), new FurnitureList() ));
    }

    public RoomList getRoomList(){
        return roomList;
    }

    public void houseMeny(Scanner scanner){
        System.out.println("");
        System.out.println("Вы перешли в здание "+ name);
        System.out.println("Для создания комнаты нажмите - 1");
        System.out.println("Для выбора комнаты из списка нажмите - 2 ");
        System.out.println("Для просмотра инфорации о всех комнатах здания нажмите - 3 ");
        System.out.println("Для выхода нажмите - 0");


        int houseMenyNum = Integer.parseInt(scanner.nextLine());

            if (houseMenyNum == 0){
                return;
            }
            if(houseMenyNum == 1){

                roomList.addRoomToListConfirm(scanner);
                houseMeny(scanner);
            }
            if (houseMenyNum == 2){
                findRoomInList(scanner);
                houseMeny(scanner);
            }
            if (houseMenyNum == 3){
                for (Room room: roomList.getRoomList()){
                    room.roomInformation(scanner,1);
                }
                houseMeny(scanner);
            }


    }

    private void findRoomInList(Scanner scanner){
        if (roomList.getRoomList().isEmpty() ){
            System.out.println("Список комнат пуст");
            houseMeny(scanner);
        }else {
            System.out.println("Список комнат:");
            for (Room room: roomList.getRoomList()){
                System.out.println(room.getName());
            }
        }
        System.out.println("Укаките название комнаты, которую вы хотите просмотреть: ");
        String nameRoom = scanner.nextLine();

        int notCor = 0;
        for (Room room: roomList.getRoomList()){
            if (room.getName().equals(nameRoom)){
                notCor++;
            }
        }
        if (notCor == 0){
            System.out.println("Вы ввели некорректные данные");
            findRoomInList(scanner);
        }
        for (Room room: roomList.getRoomList()){
            if (room.getName().equals(nameRoom)){
                room.roomMeny(scanner);
            }
        }
    }


}
