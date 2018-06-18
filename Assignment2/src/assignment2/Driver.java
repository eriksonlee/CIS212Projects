
import assignment2.Cone;
import assignment2.Pyramid;
import assignment2.Shape;
import assignment2.ShapeManager;
import assignment2.Torus;
import java.util.List;


public class Driver {

    public static void main(String args[]) {
        Shape shape;
        System.out.println("------ Test Shape Error Handling ------");
        try {
            shape = new Pyramid(-12.5, 6.6, 8.2);
        } catch (Exception ex) {
            System.out.println("1 of 7) " + ex.getMessage());
        }
        try {
            shape = new Pyramid(12.5, -6.6, 8.2);
        } catch (Exception ex) {
            System.out.println("2 of 7) " + ex.getMessage());
        }
        try {
            shape = new Pyramid(12.5, 6.6, -8.2);
        } catch (Exception ex) {
            System.out.println("3 of 7) " + ex.getMessage());
        }
        try {
            shape = new Cone(-7.5, 12.0);
        } catch (Exception ex) {
            System.out.println("4 of 7) " + ex.getMessage());
        }
        try {
            shape = new Cone(7.5, -12.0);
        } catch (Exception ex) {
            System.out.println("5 of 7) " + ex.getMessage());
        }
        try {
            shape = new Torus(-2.2, 9.5);
        } catch (Exception ex) {
            System.out.println("6 of 7) " + ex.getMessage());
        }
        try {
            shape = new Torus(2.2, -9.5);
        } catch (Exception ex) {
            System.out.println("7 of 7) " + ex.getMessage());
        }
        System.out.println("\n------ Create & Add Good Shapes ------");
        try {
            shape = new Pyramid(12.5, 6.6, 8.2);
            System.out.printf("%s%n%n", shape);
            ShapeManager.addShape(shape);
            shape = new Pyramid(25.5, 32.0, 12.0);
            System.out.printf("%s%n%n", shape);
            ShapeManager.addShape(shape);
            shape = new Cone(7.5, 12.0);
            System.out.printf("%s%n%n", shape);
            ShapeManager.addShape(shape);
            shape = new Cone(25.5, 12.0);
            System.out.printf("%s%n%n", shape);
            ShapeManager.addShape(shape);
            shape = new Torus(2.2, 9.5);
            System.out.printf("%s%n%n", shape);
            ShapeManager.addShape(shape);
            shape = new Torus(5.75, 12.0);
            System.out.printf("%s%n%n", shape);
            ShapeManager.addShape(shape);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------ Test ShapeManager Error Handling ------");
        try {
            shape = new Pyramid(12.5, 6.6, 8.2);
            ShapeManager.addShape(shape);
        } catch (Exception ex) {
            System.out.println("1 of 2) " + ex.getMessage());
        }
        try {
            shape = new Torus(1.1, 2.2);
            ShapeManager.removeShape(shape);
        } catch (Exception ex) {
            System.out.println("2 of 2) " + ex.getMessage());
        }
        System.out.println("------ Shapes sorted by shape volume (min to max) ------");
        List<Shape> sorted = ShapeManager.getContents();
        for (Shape s : sorted) {
            System.out.println(s);
        }
    }
}
