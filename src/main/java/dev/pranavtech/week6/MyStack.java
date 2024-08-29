package dev.pranavtech.week6;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack implements Cloneable {

    private Vector items;

    public MyStack() {
        items = new Vector();
    }

    public Object push(Object item) {
        items.addElement(item);
        return item;
    }

    public Object pop() {
        Object	obj;
        int	len = items.size();
        obj = peek();
        items.removeElementAt(len - 1);
        return obj;
    }

    public Object peek() {
        int	len = items.size();
        if (len == 0)
            throw new EmptyStackException();
        return items.elementAt(len - 1);
    }

    public int size() {
    return items.size();
    }

    public String toString() {
        return items.toString();
    }

    @Override
    public MyStack clone() {
        try {
            MyStack clone = (MyStack) super.clone();
            clone.items = (Vector) items.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        MyStack s1 = new MyStack();
        System.out.println("Instantiate a new stack s1");
        System.out.println("push I and Love to stack s1");
        s1.push("I");
        s1.push("Love");
        System.out.println("clone s1 -> s2");
        MyStack s2 = (MyStack) s1.clone();
        System.out.println("s1: size= " + s1.size() + " " + s1);
        System.out.println("s2: size= " + s2.size() + " " + s2);

        s2.push("Java");
        System.out.println("push Java to s2");
        System.out.println("s1: size= " + s1.size() + " " + s1);
        System.out.println("s2: size= " + s2.size() + " " + s2);

        s1.push("CS214");
        System.out.println("push CS214 to s1");
        System.out.println("s1: size= " + s1.size() + " " + s1);
        System.out.println("s2: size= " + s2.size() + " " + s2);

        s2.push("Bye");
        System.out.println("push Bye to s2");
        System.out.println("s1: size= " + s1.size() + " " + s1);
        System.out.println("s2: size= " + s2.size() + " " + s2);

    }

}
