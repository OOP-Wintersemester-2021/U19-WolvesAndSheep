import java.util.Random;

public class Vector {

    private float x;
    private float y;

    private static final Random rand = new Random();

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void mirror() {
        x *= -1;
        y *= -1;
    }

    public static Vector getRandom(float min, float max) {
        return new Vector(
                (rand.nextFloat() * (max - min)) + min,
                (rand.nextFloat() * (max - min)) + min
        );
    }
}
