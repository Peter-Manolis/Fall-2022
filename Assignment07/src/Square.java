/*
This is the Square subclass which extends Rectangle. Square has no new variables Square has three constructors,
one with no variables, one with just Double side, and another with Double side, String color, and boolean filled.
Width and Length have setter methods within. These setter methods call the setSide method. setSide sets both sides
of the Square to be equal to each other. This is distinct difference between Square and Rectangle
Finally, Square overrides getArea, getPerimeter, and toString with its own versions of the methods.
 */
public class Square extends Rectangle{

    public Square(){
    }
    public Square(double side){ //Cant create a Square with negative side
        if (side < 0) {
            throw new IllegalArgumentException("Side can't be negative.");
        }
        else {
            setSide(side);
        }
    }
    public Square(double side , String color, boolean filled){ //Cant create a Square with negative side
        if (side < 0) {
            throw new IllegalArgumentException("Side can't be negative.");
        }
        else {
            setSide(side);
        }
        this.color = color;
        this.filled = filled;
    }
    public double getSide(){
        return width;
    }
    @Override
    public void setWidth(double side){
        setSide(side);
    }
    @Override
    public void setLength(double side){
        setSide(side);
    }
    public void setSide(double side) {
        if (side < 0) {
            throw new IllegalArgumentException("Side can't be negative.");
        }
        else {
            width = side;
            length = side;
        }
    }
    @Override
    public String toString(){
        return ("Square[Rectangle[Shape[color=" + this.color + ",filled=" + this.filled + "],width=" + this.width + ",length=" + this.length + "]]");
    }
}
