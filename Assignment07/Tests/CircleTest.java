import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void getRadius() { //Tests getRadius
        Circle c1 = new Circle();
        Circle c2 = new Circle(5, "Red", false);
        assertEquals(1.0, c1.getRadius());
        assertEquals(5.0, c2.getRadius());
    }

    @Test
    void setRadius() { //Tests setRadius
        Shape s1 = new Circle();
        Circle c1 = (Circle) s1;
        Circle c2 = new Circle(10, "Red", false);
        c1.setRadius(7.0);
        c2.setRadius(1.0);
        assertEquals(7.0, c1.getRadius());
        assertEquals(1.0, c2.getRadius());
    }
    @Test
    void testNegativeCircle() { //Tests that IllegalArgumentException is thrown when a negative radius is used
        assertThrows(IllegalArgumentException.class, () -> {
            Circle c1 = new Circle(-2);
        });
    }
    @Test
    void getColor() { //Tests getColor
        Circle c1 = new Circle();
        Circle c2 = new Circle(5, "purple", false);
        assertEquals("red", c1.getColor());
        assertEquals("purple", c2.getColor());
    }

    @Test
    void setColor() { //Tests setColor
        Shape s1 = new Circle();
        Circle c1 = (Circle) s1;
        Circle c2 = new Circle(10, "Red", false);
        c1.setColor("blue");
        c2.setColor("red");
        assertEquals("blue", c1.getColor());
        assertEquals("red", c2.getColor());
    }
    @Test
    void isFilled() { //Tests the getter method for the filled instance variable
        Circle c1 = new Circle();
        Circle c2 = new Circle(5, "Red", false);
        assertTrue(c1.isFilled());
        assertFalse(c2.isFilled());
    }

    @Test
    void setFilled() { //Tests setFilled
        Shape s1 = new Circle();
        Circle c1 = (Circle) s1;
        Circle c2 = new Circle(10, "Red", false);
        c1.setFilled(false);
        c2.setFilled(true);
        assertFalse(c1.isFilled());
        assertTrue(c2.isFilled());

    }


    @Test
    void getArea() { //Tests getArea
        Shape c1 = new Circle(3.0);
        Circle c2 = new Circle(5.0);
        double area1 = Math.PI * 9;
        double area2 = Math.PI * 25;
        assertEquals(area1, c1.getArea());
        assertEquals(area2, c2.getArea());
    }

    @Test
    void getPerimeter() { //Tests getPerimeter
        Circle c1 = new Circle(3.0);
        Circle c2 = new Circle();
        double perimeter1 = Math.PI * 2 * 3;
        double perimeter2 = Math.PI * 2 * 1;
        assertEquals(perimeter1, c1.getPerimeter());
        assertEquals(perimeter2, c2.getPerimeter());
    }

    @Test
    void testToString() { //Tests toString
        Circle c1 = new Circle(2.0, "blue", false);
        assertEquals("Circle[Shape[color=blue,filled=false],radius=2.0]", c1.toString());
    }

}