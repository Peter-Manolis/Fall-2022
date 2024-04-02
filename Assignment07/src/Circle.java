/*
This is the circle subclass which extends Shape. Circle has one new variable, which is a double called radius and set
to 1.0. Circle has three constructors, one with no variables, one with just String radius, adn another with
String radius, String color, adn boolean filled. Radius has getter and setter methods within. Finally, Circle overrides
getArea, getPerimeter, and toString with its own versions of the methods.
 */
public class Circle extends Shape {
    protected double radius = 1.0;
    public Circle(){
    }
    public Circle(double radius){ //Cant create a circle with a negative radius
        if (radius < 0) {
            throw new IllegalArgumentException("Radius can't be negative.");
        }
        else {
            this.radius = radius;
        }
    }
    public Circle(double radius, String color, boolean filled){ //Cant create a circle with a negative radius
        if (radius < 0) {
            throw new IllegalArgumentException("Radius can't be negative.");
        }
        else {
            this.radius = radius;
        }
        this.color = color;
        this.filled = filled;
    }

    public double getRadius() { //Getter
        return radius;
    }

    public void setRadius(double radius) { //Setter that only allows for positive numbers
        if (radius < 0) {
            throw new IllegalArgumentException("Radius can't be negative.");
        }
        else{
            this.radius = radius;
        }
    }

    @Override
    public double getArea(){ //Overrides
        return Math.PI * this.radius * this.radius;
    }
    @Override
    public double getPerimeter(){ //Overrides
        return 2 * Math.PI * this.radius;
    }
    @Override
    public String toString(){ //Overrides
        return ("Circle[Shape[color=" + this.color + ",filled=" + this.filled + "],radius=" + this.radius + "]");
    }
}
