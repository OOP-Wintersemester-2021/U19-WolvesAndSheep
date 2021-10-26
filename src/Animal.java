import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Circle;

public abstract class Animal {

    protected Circle circle;
    protected Vector vector;
    protected boolean isAlive;

    public Animal(float x, float y, float radius, Color color, Vector vector) {
        this.circle = new Circle(x, y, radius, color);
        this.vector = vector;
        isAlive = true;
    }

    public void draw() {
        circle.draw();
    }

    public void update() {
        circle.move(vector.getX(), vector.getY());
        handleCanvasBorderCollision();
    }

    private void handleCanvasBorderCollision() {
        if (circle.getXPos() - circle.getRadius() < 0) {
            circle.setXPos(circle.getRadius());
            vector.setX(vector.getX() * -1);
        } else if (circle.getXPos() + circle.getRadius() > WolfAndSheep.CANVAS_WIDTH ){
            circle.setXPos(WolfAndSheep.CANVAS_WIDTH - circle.getRadius());
            vector.setX(vector.getX() * -1);
        }
        if (circle.getYPos() - circle.getRadius() < 0) {
            circle.setYPos(circle.getRadius());
            vector.setY(vector.getY() * -1);
        } else if (circle.getYPos() + circle.getRadius() > WolfAndSheep.CANVAS_HEIGHT) {
            circle.setYPos(WolfAndSheep.CANVAS_HEIGHT - circle.getRadius());
            vector.setY(vector.getY() * -1);
        }
    }

    public void checkCollision(Animal animal) {
        if (!animal.isAlive || !this.isAlive) return;
        if (circle.hitTest(animal.getX(), animal.getY())) {
            handleCollision(animal);
        }
    }

    public abstract void handleCollision(Animal animal);

    public void die() {
        isAlive = false;
    }

    public float getX() {
        return circle.getXPos();
    }

    public float getY() {
        return circle.getYPos();
    }

    public float getSize() {
        return circle.getRadius();
    }

}
