import java.util.Scanner;

public class Room {
    private String name = new String();
    private double square = 0;

    private LightBulbList lightBulbList;
    private FurnitureList furnitureList;

    public Room(String name, double square,  LightBulbList lightBulbList, FurnitureList furnitureList){
        this.name = name;
        this.square = square;

        this.lightBulbList = lightBulbList;
        this.furnitureList = furnitureList;
    }

    public String getName(){
        return name;
    }

    public double getSquare() {
        return square;
    }

    public void roomMeny(Scanner scaner){
        System.out.println("Вы перешли в комнату "+ name);
        System.out.println("Для просмотра информации о комнате нажмите - 1");
        System.out.println("Для добавления мебели нажмите - 2");
        System.out.println("Для добавления осветительного прибора - 3");
        System.out.println("Для выхода  в предидущее меню нажмите - 0");
        System.out.println("");
        if (Integer.parseInt(scaner.nextLine()) == 1){
            roomInformation(scaner);
        }
        if (Integer.parseInt(scaner.nextLine()) == 2){


            addFurnitureToRoom(scaner);

        }
        if (Integer.parseInt(scaner.nextLine()) == 3){
            addLightBulb(scaner);
            roomMeny(scaner);
        }

    }

    private void roomInformation(Scanner scanner){
        System.out.println("Информация о комнате " + name);
        System.out.println("Площадь комнаты: " + square);
        System.out.println("Список мебели:");
        double occupaedArea = 0;
            for (Furniture furniture: furnitureList.getFurnitureList()){
                System.out.println(furniture.getNameFur()+ " занимаемая площадь: " + furniture.maxSize + " m^2");
                occupaedArea += furniture.maxSize;
            }
        System.out.println("Занято площади: " + occupaedArea * 100/square + "%");
        System.out.println("Список светоисточников:");
        int lightBulbFlow = 0;
        for (LightBulb lightBulb: lightBulbList.getLightBulbList()){
            System.out.println(lightBulb.getName() + " световой поток: " + lightBulb.getLightFlow());
            lightBulbFlow += lightBulb.getLightFlow();
        }
        System.out.println("Общий световой поток: " + lightBulbFlow);
        System.out.println("");
        roomMeny(scanner);
    }

    private void addFurnitureToRoom(Scanner scanner){
        System.out.println("Добавление мебели:");
        System.out.println("Добавить диван - 1");
        System.out.println("Добавить стол - 2");
        System.out.println("Добавить кресло - 3");
        System.out.println("Добавить кровать - 4");
        System.out.println("Добавить стул - 5");
        System.out.println("Выйти из данного меню - 0");
        System.out.println("");

        if (Integer.parseInt(scanner.nextLine()) == 0){
            roomInformation(scanner);
        }
        if (Integer.parseInt(scanner.nextLine()) == 1){
            System.out.println("Вы перешли в пункт добавления дивана");
            System.out.println("Введите минимально занимаемую площадь:");
            double minSize = Double.parseDouble(scanner.nextLine());
            System.out.println("Введите максимально занимаемую площадь:");
            double maxSize = Double.parseDouble(scanner.nextLine());
            furnitureList.addFurnityreConfirm(new Furniture("Диван", minSize, maxSize), square);
            addFurnitureToRoom(scanner);
        }
        if (Integer.parseInt(scanner.nextLine()) == 2){
            System.out.println("Вы перешли в пункт добавления стола");
            System.out.println("Введите  занимаемую площадь:");
            double maxSize = Double.parseDouble(scanner.nextLine());
            furnitureList.addFurnityreConfirm(new Furniture("Стол", maxSize, maxSize), square);
            addFurnitureToRoom(scanner);
        }
        if (Integer.parseInt(scanner.nextLine()) == 3){
            System.out.println("Вы перешли в пункт добавления кресла");
            System.out.println("Введите минимально занимаемую площадь:");
            double minSize = Double.parseDouble(scanner.nextLine());
            System.out.println("Введите максимально занимаемую площадь:");
            double maxSize = Double.parseDouble(scanner.nextLine());
            furnitureList.addFurnityreConfirm(new Furniture("Кресло", minSize, maxSize), square);
            addFurnitureToRoom(scanner);
        }
        if (Integer.parseInt(scanner.nextLine()) == 4){
            System.out.println("Вы перешли в пункт добавления кровати");
            System.out.println("Введите  занимаемую площадь:");
            double maxSize = Double.parseDouble(scanner.nextLine());
            furnitureList.addFurnityreConfirm(new Furniture("Кровать", maxSize, maxSize), square);
            addFurnitureToRoom(scanner);
        }
        if (Integer.parseInt(scanner.nextLine()) == 5){
            System.out.println("Вы перешли в пункт добавления стула");
            System.out.println("Введите  занимаемую площадь:");
            double maxSize = Double.parseDouble(scanner.nextLine());
            furnitureList.addFurnityreConfirm(new Furniture("Стул", maxSize, maxSize), square);
            addFurnitureToRoom(scanner);
        }
    }

    public void addLightBulb(Scanner scanner){
        System.out.println("Введите мощность светового потока");
        LightBulb lightBulbNew = new LightBulb("Лампочка", Integer.parseInt(scanner.nextLine()));
        int summLightFlow = 0;
        //summLightFlow += windowCol*700;
        for (LightBulb lightBulb: lightBulbList.getLightBulbList()){
            summLightFlow += lightBulb.getLightFlow();
        }
        if (summLightFlow + lightBulbNew.getLightFlow() > 4000){
            System.out.println("Дужа ярко");
        }else {
            lightBulbList.addLightBulbToList(lightBulbNew);
        }
        return;
    }
    public void addFurniture(){

    }
}
