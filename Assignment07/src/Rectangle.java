/*
This is the Rectangle subclass which extends Shape. Rectangle has two new variables, which are doubles called
width and length set to 1.0. Rectangle has three constructors, one with no variables,
one with just Double width and length, and another with Double width, Double Length, String color, adn boolean filled.
Width and Length has getter and setter methods within. Finally, Rectangle overrides
getArea, getPerimeter, and toString with its own versions of the methods.
 */
public class Rectangle extends Shape{
    protected double width = 1.0;
    protected double length = 1.0;
    public Rectangle(){
    }
    public Rectangle(double width, double length){ //Cant create a Rectangle with negative width or length
        if (width < 0 || length < 0) {
            throw new IllegalArgumentException("Length or width can't be negative.");
        }
        else{
                this.width = width;
                this.length = length;
            }
    }
    public Rectangle(double width, double length, String color, boolean filled){ //Cant create a Rectangle with negative width or length
        if (width < 0 || length < 0) {
            throw new IllegalArgumentException("Length or width can't be negative.");
        }
        else{
            this.width = width;
            this.length = length;
        }
        this.color=color;
        this.filled=filled;
    }

    public double getWidth() { //Getter
        return width;
    }

    public void setWidth(double width) { //Setter
        if (width < 0) {
            throw new IllegalArgumentException("Width can't be negative.");
        } else {
            this.width = width;
        }
    }

    public double getLength() { //Getter
        return length;
    }

    public void setLength(double length) { //Setter
        if (length < 0) {
            throw new IllegalArgumentException("Length can't be negative.");
        } else {
            this.length = length;
        }
    }
    @Override
    public double getArea(){ //Overrides
        return length*width;
    }
    @Override
    public double getPerimeter(){ //Overrides
        return (length+length+width+width);
    }
    @Override
    public String toString(){ //Overrides
        return ("Rectangle[Shape[color=" + this.color + ",filled=" + this.filled + "],width=" + this.width + ",length=" + this.length + "]");
    }
}
