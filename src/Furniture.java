public class Furniture {

    String nameFur = new String();
    double minSize = 0;
    double maxSize = 0;

    public Furniture(String nameFur, double minSize, double maxSize){
        this.nameFur = nameFur;
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    public String getNameFur() {
        return nameFur;
    }

    public double getMinSize() {
        return minSize;
    }

    public double getMaxSize() {
        return maxSize;
    }
}
