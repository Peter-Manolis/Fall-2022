import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void getWidth() { //Tests getWidth
        Rectangle r1 = new Rectangle(3.0, 5.0);
        Rectangle r2 = new Rectangle(1.0,2.0, "blue", false);
        assertEquals(3.0, r1.getWidth());
        assertEquals(1.0, r2.getWidth());
    }

    @Test
    void setWidth() { //Tests setWidth
        Rectangle r1 = new Rectangle(3.0, 5.0);
        Rectangle r2 = new Rectangle(1.0,2.0, "blue", false);
        r1.setWidth(10.0);
        r2.setWidth(1.0);
        assertEquals(10.0, r1.getWidth());
        assertEquals(1.0, r2.getWidth());

    }

    @Test
    void getLength() { //Tests getLength
        Shape s1 = new Rectangle();
        Rectangle r1 = (Rectangle) s1;
        Rectangle r2 = new Rectangle();
        assertEquals(1.0,r1.getLength());
        assertEquals(1.0,r2.getLength());
    }

    @Test
    void setLength() { //Tests setLength
        Shape s1 = new Rectangle();
        Rectangle r1 = (Rectangle) s1;
        Rectangle r2 = new Rectangle();
        r1.setLength(5.0);
        r2.setLength(60);
        assertEquals(5.0,r1.getLength());
        assertEquals(60,r2.getLength());
    }
    @Test
    void testNegativeRectangle() { //Tests that IllegalArgumentException is thrown when a negative length or width is used
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle r1 = new Rectangle(-2.0,3.0);
        });
    }

    @Test
    void getArea() { //Tests getArea
        Shape r1 = new Rectangle(5.0,6.0);
        Rectangle r2 = new Rectangle(3.0,2.0, "blue", false);
        assertEquals(30.0, r1.getArea());
        assertEquals(6.0, r2.getArea());
    }

    @Test
    void getPerimeter() { //Tests getPerimeter
        Shape r1 = new Rectangle(7.0,6.0);
        Rectangle r2 = new Rectangle();
        assertEquals(26.0, r1.getPerimeter());
        assertEquals(4.0,r2.getPerimeter());
    }

    @Test
    void testToString() { //Tests toString
        Shape r1 = new Rectangle();
        assertEquals("Rectangle[Shape[color=red,filled=true],width=1.0,length=1.0]", r1.toString());
    }
}