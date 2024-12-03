//Write a java program to implement a small project to understand the basic concept of OOP’s
abstract class Shape {
     public abstract double area();
}
 class Circle extends Shape {
    private double radius;
     public Circle(double radius) {
        this.radius = radius;
    }
     @Override
    public double area() {
        return Math.PI * radius * radius;
    }}
 class Rectangle extends Shape {
    private double length;
    private double width;
     public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;  }
     @Override
    public double area() {
        return length * width;
    }}
 public class ShapeManagement {
    public static void main(String[] args) {
         Shape circle = new Circle(5.0);          
         Shape rectangle = new Rectangle(4.0, 6.0);   
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rectangle.area());
    }}
