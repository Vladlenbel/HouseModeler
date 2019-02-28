public class LightBulb {
    int lightFlow =0;
    String name = new String();


    public LightBulb(String name, int lightFlow){
        this.lightFlow = lightFlow;
        this.name = name;
    }

    public int getLightFlow() {
        return lightFlow;
    }

    public String getName() {
        return name;
    }
}
