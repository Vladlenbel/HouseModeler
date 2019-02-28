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
        System.out.println("");
        System.out.println("Вы перешли в комнату "+ name);
        System.out.println("Для просмотра информации о комнате нажмите - 1");
        System.out.println("Для добавления мебели нажмите - 2");
        System.out.println("Для добавления осветительного прибора - 3");
        System.out.println("Для выхода  в предыдущее меню нажмите - 0");


        int rommMenyNumb = Integer.parseInt(scaner.nextLine());

        if (rommMenyNumb == 1){
            roomInformation(scaner);
        }
        if (rommMenyNumb == 2){
            addFurnitureToRoom(scaner);
        }
        if (rommMenyNumb == 3){
            addLightBulb(scaner);
            roomMeny(scaner);
        }
        if (rommMenyNumb == 0){
            return;
        }

    }

    private void roomInformation(Scanner scanner){
        System.out.println("");
        System.out.println("Информация о комнате " + name);
        System.out.println("Площадь комнаты: " + square + " m^2");
        System.out.println("Список мебели:");
        if (furnitureList.getFurnitureList().isEmpty()){
            System.out.println("В этой комнате пока нет мебели");
        }
        double occupaedArea = 0;
            for (Furniture furniture: furnitureList.getFurnitureList()){
                System.out.println(furniture.getNameFur()+ " занимаемая площадь: " + furniture.maxSize + " m^2");
                occupaedArea += furniture.maxSize;
            }
        System.out.println("Занято площади: " + occupaedArea * 100/square + "%");
        System.out.println("Список светоисточников:");
        int lightBulbFlow = 0;
        for (LightBulb lightBulb: lightBulbList.getLightBulbList()){
            System.out.println(lightBulb.getName()+" - " + " световой поток: " + lightBulb.getLightFlow());
            lightBulbFlow += lightBulb.getLightFlow();
        }
        System.out.println("Общий световой поток: " + lightBulbFlow);
        System.out.println("Для продолжения нажмите на клавишу enter...");
        scanner.nextLine();
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


        int addfurnitureNumb = Integer.parseInt(scanner.nextLine());

        if (addfurnitureNumb == 0){
            roomInformation(scanner);
        }
        if (addfurnitureNumb == 1){
            System.out.println("Вы перешли в пункт добавления дивана");
            System.out.println("Введите минимально занимаемую площадь:");
            double minSize = Double.parseDouble(scanner.nextLine());
            System.out.println("Введите максимально занимаемую площадь: ");
            double maxSize = Double.parseDouble(scanner.nextLine());
            if (minSize > maxSize){
                System.out.println("Минимальная площадь больше максимальной");
                addFurnitureToRoom(scanner);
            }
            furnitureList.addFurnityreConfirm(new Furniture("Диван", minSize, maxSize), square);
            addFurnitureToRoom(scanner);
        }
        if (addfurnitureNumb == 2){
            System.out.println("Вы перешли в пункт добавления стола");
            System.out.print("Введите  занимаемую площадь: ");
            double maxSize = Double.parseDouble(scanner.nextLine());
            furnitureList.addFurnityreConfirm(new Furniture("Стол", maxSize, maxSize), square);
            addFurnitureToRoom(scanner);
        }
        if (addfurnitureNumb == 3){
            System.out.println("Вы перешли в пункт добавления кресла");
            System.out.print("Введите минимально занимаемую площадь: ");
            double minSize = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите максимально занимаемую площадь: ");
            double maxSize = Double.parseDouble(scanner.nextLine());
            if (minSize > maxSize){
                System.out.println("Минимальная площадь больше максимальной");
                addFurnitureToRoom(scanner);
            }
            furnitureList.addFurnityreConfirm(new Furniture("Кресло", minSize, maxSize), square);
            addFurnitureToRoom(scanner);
        }
        if (addfurnitureNumb == 4){
            System.out.println("Вы перешли в пункт добавления кровати");
            System.out.print("Введите  занимаемую площадь: ");
            double maxSize = Double.parseDouble(scanner.nextLine());
            furnitureList.addFurnityreConfirm(new Furniture("Кровать", maxSize, maxSize), square);
            addFurnitureToRoom(scanner);
        }
        if (addfurnitureNumb == 5){
            System.out.println("Вы перешли в пункт добавления стула");
            System.out.println("Введите  занимаемую площадь:");
            double maxSize = Double.parseDouble(scanner.nextLine());
            furnitureList.addFurnityreConfirm(new Furniture("Стул", maxSize, maxSize), square);
            addFurnitureToRoom(scanner);
        }
    }

    private void addfurnitureNumb(Scanner scanner) {
    }

    public void addLightBulb(Scanner scanner){
        System.out.print("Введите мощность светового потока лампочки: ");
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
