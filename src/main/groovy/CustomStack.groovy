import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class CustomStack<E> extends CustomCollection{
    CustomStack() {}

    CustomStack(CustomStack stack) {
        size = stack.size
        elements = stack.elements
    }

    void push(E e) { super.push(e) }

    E pop() { super.pop() }

}
