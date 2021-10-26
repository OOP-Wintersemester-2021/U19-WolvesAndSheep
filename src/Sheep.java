import de.ur.mi.oop.colors.Color;

public class Sheep extends Animal {

    private static final Color SHEEP_COLOR = new Color(150, 150, 150);

    public Sheep(float x, float y, float radius, Vector vector) {
        super(x, y, radius, SHEEP_COLOR, vector);
    }

    @Override
    public void draw() {
        if (isAlive) {
            super.draw();
        }
    }

    @Override
    public void handleCollision(Animal animal) {
        if (animal instanceof Sheep) {
            vector.mirror();
        }
    }
}
