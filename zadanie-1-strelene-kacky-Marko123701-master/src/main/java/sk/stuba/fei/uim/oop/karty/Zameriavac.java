package sk.stuba.fei.uim.oop.karty;

public class Zameriavac extends Policko {
    private boolean zamerane=false;

    public void setZamerane(boolean zamerane) {
        this.zamerane = zamerane;
    }

    public boolean isZamerane() {
        return this.zamerane;
    }

    @Override
    public String vykresli() {
        if (this.zamerane){
            return "Zamierene";
        }
        else{
            return "Nezamierene";
        }
    }
}
