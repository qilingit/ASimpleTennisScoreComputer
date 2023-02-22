import javax.print.DocFlavor;

public class Player {
    private String name;
    private int point;

    private boolean isAdvantage;

    public Player(String name, int point, boolean isAdvantage) {
        this.name = name;
        this.point = point;
        this.isAdvantage = isAdvantage;
    }

    public String getName() {
        return this.name;
    }

    public int getPoint() {
        return this.point;
    }

    public boolean getIsAdvantage() {
        return this.isAdvantage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setAdvantage(boolean isAdvantage) {
        this.isAdvantage = isAdvantage;
    }

}
