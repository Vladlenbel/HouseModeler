import java.util.Scanner;

public class MainMeny {

    Scanner mainScan = new Scanner(System.in);
    HouseList houseList = new HouseList();

    public void mainMeny(){

        while (true){
            System.out.println("Главное меню");
            System.out.println("Для построения здания нажмите - 1");
            System.out.println("Для выбора здания из списка нажмите - 2");

            int menyNum = Integer.parseInt(mainScan.nextLine());

            if (menyNum == 1){
                houseBuilder();
            }if (menyNum == 2){
                listBuilder();
            }else {
                System.out.println("Введено некорректное значение");
            }
        }
    }

    public void houseBuilder(){
        System.out.println("Вы перешли в пункт построение здания");
        System.out.println("Укаките название здание");
        String houseName = mainScan.nextLine();
            while (houseList.addHouseWithConfirm(houseName) == 1){
                System.out.println("Укаките название здание");
                houseName = mainScan.nextLine();
            }
            mainMeny();


    }

    public void listBuilder() {
        System.out.println("Вы перешли в пункт  выбора здания из списка");
        listBuilderConf();
    }
    public void listBuilderConf(){

        //System.out.println("Для выхода нажмите - 0");

        System.out.println("Список зданий:");

        if (houseList.getHouseList().isEmpty() ){
            System.out.println("Список зданий пуст");
            System.out.println("");
            mainMeny();
        }else {
            for (House house : houseList.getHouseList()) {
                System.out.println(house.getName());
            }
        }
        System.out.println("Укаките название здания, которое вы хотите просмотреть");
        String houseName = mainScan.nextLine();

       /* if (Integer.parseInt(houseName) == 0){
            mainMeny();
        }*/
       int notCor = 0;
        for (House house: houseList.getHouseList()){
            if (house.getName().equals(houseName)){
                notCor++;
            }
        }
        if (notCor == 0){
            System.out.println("Вы ввели некорректные данные");
            System.out.println("");
            listBuilderConf();
        }
            for (House house: houseList.getHouseList()){
                if (house.getName().equals(houseName)){
                    house.houseMeny(mainScan);
                    mainMeny();
                }
            }

    }
}
