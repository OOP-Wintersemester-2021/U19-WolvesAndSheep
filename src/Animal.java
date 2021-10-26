import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Circle;

public abstract class Animal {

    protected Circle body;
    protected Vector movementVector;
    protected boolean isAlive;

    public Animal(float x, float y, float size, Color color, Vector movementVector) {
        this.body = new Circle(x, y, size, color);
        this.movementVector = movementVector;
        isAlive = true;
    }

    public void draw() {
        body.draw();
    }

    public void update() {
        body.move(movementVector.getX(), movementVector.getY());
        handleCanvasBorderCollision();
    }

    private void handleCanvasBorderCollision() {
        if (body.getXPos() - body.getRadius() < 0) {
            body.setXPos(body.getRadius());
            movementVector.setX(movementVector.getX() * -1);
        } else if (body.getXPos() + body.getRadius() > WolvesAndSheep.CANVAS_WIDTH ){
            body.setXPos(WolvesAndSheep.CANVAS_WIDTH - body.getRadius());
            movementVector.setX(movementVector.getX() * -1);
        }
        if (body.getYPos() - body.getRadius() < 0) {
            body.setYPos(body.getRadius());
            movementVector.setY(movementVector.getY() * -1);
        } else if (body.getYPos() + body.getRadius() > WolvesAndSheep.CANVAS_HEIGHT) {
            body.setYPos(WolvesAndSheep.CANVAS_HEIGHT - body.getRadius());
            movementVector.setY(movementVector.getY() * -1);
        }
    }

    public void checkCollision(Animal animal) {
        if (!animal.isAlive || !this.isAlive) return;
        if (body.hitTest(animal.getX(), animal.getY())) {
            handleConfrontation(animal);
        }
    }

    public abstract void handleConfrontation(Animal animal);

    public void die() {
        isAlive = false;
    }

    public float getX() {
        return body.getXPos();
    }

    public float getY() {
        return body.getYPos();
    }

    public float getSize() {
        return body.getRadius();
    }

}
