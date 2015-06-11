package b07;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Patrick on 11.06.2015.
 */
public class NodeTest {

    Node<String> stringNode;
    Node<Integer> integerNode;

    String exampleString;
    Integer exampleInteger;

    @Before
    public void setUp() {
        this.exampleString = "exampleString";
        this.exampleInteger = 123;

        this.stringNode = new Node<>(exampleString);
        this.integerNode = new Node<>(exampleInteger);
    }

    @Test
    public void testGetContent() {
        assertEquals(exampleString, stringNode.getContent());
        assertEquals(exampleInteger, integerNode.getContent());

        assertNotEquals(exampleString, integerNode.getContent());
        assertNotEquals(exampleInteger, stringNode.getContent());

        assertNotEquals(stringNode.getContent(), integerNode.getContent());
    }

    @Test
    public void testSetContent() {
        integerNode.setContent(new Integer(321));
        assertEquals(new Integer(321), integerNode.getContent());
        assertNotEquals(exampleInteger, integerNode.getContent());

        stringNode.setContent("new String");
        assertEquals("new String", stringNode.getContent());
        assertNotEquals(exampleString, stringNode.getContent());
    }

    @Test
    public void testSetAndGetNext() {
        assertEquals(null, stringNode.getNext());

        Node<String> secondStringNode = new Node<>("secondExampleString");
        stringNode.setNext(secondStringNode);

        assertNotNull(stringNode.getNext());
        assertEquals(secondStringNode, stringNode.getNext());

    }


    @Test
    public void testCompareTo() {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");

        assertEquals(0, a.compareTo(a));
        assertEquals(-1, a.compareTo(b));
        assertEquals(1, b.compareTo(a));

        assertEquals(0, one.compareTo(one));
        assertEquals(-1, one.compareTo(two));
        assertEquals(1, two.compareTo(one));

    }

    @Test
    public void testToString() {
        assertEquals("Node [content = exampleString]", stringNode.toString());
        assertEquals("Node [content = 123]", integerNode.toString());

    }

    @Test
    public void testEquals() {
//ToDo equalsTest, sobald equals der Vorgabe entspricht.
    }

    @Test
    public void testHashCode() {
//ToDo testHashCode
    }
}