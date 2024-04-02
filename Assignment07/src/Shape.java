public abstract class Shape {
    /*
    This is the parent Shape class. This is abstract class. The class has two protected variables, String color set
    to "red", and boolean filled set to true. The Shape class contains 2 constructors, one which has no
    instance variables, and another which takes twp instance variables of String Color and Boolean Filled. Both of these
    variables have getter and setter methods. The next two methods are abstract, meaning all child classes are forced to
    create their own versions of these methods. These two abstract methods are getArea and getPerimeter. Lastly,
    the Shape class overrides the toString method.
     */
    protected String color = "red";

    protected boolean filled = true;

    public Shape(){
    }
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor() { //Getter
        return color;
    }

    public void setColor(String color) { //Setter
        this.color = color;
    }

    public boolean isFilled() { //Getter
        return filled;
    }

    public void setFilled(boolean filled) { //Setter
        this.filled = filled;
    }

    public abstract double getArea(); //Abstract getArea method

    public abstract double getPerimeter(); //Abstract getPerimeter method
    @Override
    public String toString(){
        return ("Shape[color= " + this.color + ",filled=" + this.filled + "]");
    }
}
