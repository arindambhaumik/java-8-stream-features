/**
 * Demo class for custom functional interface
 */
public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        String shapeType="Circle";
        int length = 10, width=25;

        AreaOfShape result = (type, l, b) ->{
          if(type.equalsIgnoreCase("Square")){
              return l*l;
          }
          else if(type.equalsIgnoreCase("Rectangle")){
              return l*b;
          } else if (type.equalsIgnoreCase("Circle")) {
              return l*l*3.14;
          } else {
              System.out.println("Only supported shapes are Rectangle, Square and Circle...");
              return 0;
          }
        };

        System.out.println("Area of shape "+ shapeType +" is:" + result.area(shapeType, length,width));
    }
}

/**
 * This is a functional interface which returns area of a shape.
 * this annotation is not mandatory, but once use it can't have more than one abstract method inside interface
 */
@FunctionalInterface
interface AreaOfShape {
    public double area(String type, int len, int width);
}