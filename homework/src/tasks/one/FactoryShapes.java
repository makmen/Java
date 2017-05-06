package tasks.one;

/**
 * Created by AMakas on 20.01.2017.
 */
public class FactoryShapes {
    public Shape factoryMethod(int param) {
        switch (param) {
            case 1:
                return new Circle();
            case 2:
                return new Rectangle();
            case 3:
                return new Square();
            case 4:
                return new Trapeze();
            default:
                return new Triangle();
        }
    }

    public void getShape() {
        int rand = (int)(Math.random()*5);
        ShapeEnum param = ShapeEnum.Rectangle;
        for(ShapeEnum shape : ShapeEnum.values()){

            System.out.println(shape);
        }
    }
}
