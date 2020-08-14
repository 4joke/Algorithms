import groovy.transform.EqualsAndHashCode

import java.util.logging.Logger

@EqualsAndHashCode
class CustomStack<E> extends CustomCollection{
    private static Logger logger = Logger.getLogger('Stack')

    CustomStack() {}

    CustomStack(CustomStack stack) {
        ArrayList
        size = stack.size
        elements = stack.elements
    }

    void push(E e) { super.push(e) }

    E pop() { super.pop() }

}
