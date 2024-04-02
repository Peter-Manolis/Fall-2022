import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void getSide() { //Tests getSide
        Square s1 = new Square(4.0);
        Square s2 = new Square (3.0, "red", false);
        assertEquals(4.0,s1.getSide());
        assertEquals(3.0,s2.getSide());
    }

    @Test
    void setWidth() { //Tests setWidth
        Shape ss1 = new Square();
        Square s1 = (Square) ss1;
        Square s2 = new Square (2.0);
        s1.setWidth(2.0);
        s2.setWidth(5.0);
        assertEquals(2.0,s1.getWidth());
        assertEquals(5.0,s2.getWidth());

    }

    @Test
    void setLength() { //Tests setLength
        Shape ss1 = new Square(5.0);
        Square s1 = (Square) ss1;
        Square s2 = new Square ();
        s1.setLength(1.0);
        s2.setLength(20.0);
        assertEquals(1.0,s1.getLength());
        assertEquals(20.0,s2.getLength());

    }

    @Test
    void setSide() { //Tests setSide
        Square s1 = new Square(4.0);
        Square s2 = new Square (3.0, "red", false);
        s1.setSide(10);
        s2.setSide(50.0);
        assertEquals(10.0,s1.getSide());
        assertEquals(50.0,s2.getSide());
    }
    @Test
    void testNegativeRectangle() { //Tests that IllegalArgumentException is thrown when a negative side is used
        assertThrows(IllegalArgumentException.class, () -> {
            Square s1 = new Square(-2.0);
        });
    }
    @Test
    void getArea(){ //Tests getArea
        Shape s1 = new Square(5.0);
        Square s2 = new Square();
        s2.setLength(5.0);
        s2.setWidth(6.0);
        assertEquals(25,s1.getArea());
        assertEquals(36,s2.getArea());
    }
    @Test
    void getPerimeter(){ //Tests getPerimeter
        Shape s1 = new Square(5.0);
        Square s2 = new Square();
        s2.setLength(5.0);
        s2.setWidth(6.0);
        assertEquals(20,s1.getPerimeter());
        assertEquals(24,s2.getPerimeter());
    }

    @Test
    void testToString() { //Tests toString
        Shape r1 = new Square();
        assertEquals("Square[Rectangle[Shape[color=red,filled=true],width=1.0,length=1.0]]", r1.toString());
    }
}