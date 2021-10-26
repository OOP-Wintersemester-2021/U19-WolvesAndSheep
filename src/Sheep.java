import de.ur.mi.oop.colors.Color;

public class Sheep extends Animal {

    private static final Color SHEEP_COLOR = new Color(150, 150, 150);

    public Sheep(float x, float y, float size, Vector movementVector) {
        super(x, y, size, SHEEP_COLOR, movementVector);
    }

    @Override
    public void draw() {
        if (isAlive) {
            super.draw();
        }
    }

    @Override
    public void handleConfrontation(Animal animal) {
        if (animal instanceof Sheep) {
            movementVector.mirror();
        }
    }
}
