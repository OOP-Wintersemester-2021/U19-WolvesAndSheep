import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

public class Wolf extends Animal {

    private static final Color WOLF_COLOR = new Color(100, 70, 36);
    private static final float STARVATION_SIZE = 10;
    private static final float SIZE_DECAY = 3;
    public static final float MIN_SIZE_DECAY_PERCENTAGE = 0.1f;
    private static final int HUNGER_TIMER = 90;

    private int timeSinceLastEaten;

    public Wolf(float x, float y, float size, Vector movementVector) {
        super(x, y, size, WOLF_COLOR, movementVector);
        timeSinceLastEaten = 0;
    }

    @Override
    public void update() {
        if (isAlive) {
            super.update();
            timeSinceLastEaten++;
            if (timeSinceLastEaten >= HUNGER_TIMER) {
                sleepHungry();
            }
        }
    }

    private void sleepHungry() {
        float shrinkage = Math.max(SIZE_DECAY, body.getRadius() * MIN_SIZE_DECAY_PERCENTAGE);
        body.setRadius(body.getRadius() - shrinkage);
        timeSinceLastEaten = 0;
        if (body.getRadius() <= STARVATION_SIZE) {
            die();
        }
    }

    private void devour(Sheep prey) {
        body.setRadius(body.getRadius() + prey.getSize() / 2);
        timeSinceLastEaten = 0;
        prey.die();
    }

    @Override
    public void die() {
        super.die();
        body.setColor(Colors.WHITE);
        body.setBorder(Colors.RED, 1);
    }

    @Override
    public void handleConfrontation(Animal animal) {
        if (animal instanceof Sheep) {
            devour((Sheep) animal);
        } else if (animal instanceof  Wolf) {
            if (this.getSize() > animal.getSize()) {
                animal.die();
            } else if (animal.getSize() > this.getSize()) {
                this.die();
            } else {
                movementVector.mirror();
            }
        }
    }
}
