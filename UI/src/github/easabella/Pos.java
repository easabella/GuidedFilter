package github.easabella;

/**
 * Created by Easabella.
 */
public class Pos{

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int x;
    public int y;

    public void mul(int amplificationFactor) {
        x *= amplificationFactor;
        y *= amplificationFactor;
    }
}

