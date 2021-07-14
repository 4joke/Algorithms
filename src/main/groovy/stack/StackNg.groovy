package stack

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class StackNg<E>{
    protected int size = 0
    protected Node<E> last

    StackNg() {}

    int size() {
        size
    }

    void push(E e) {
        size ++
        def node = new Node(e)
        if (!last) {
            last = node
        } else {
            last.next = node
            node.previous = last
            last = node
        }
    }

    E pop() {
        assert size > 0: 'stack is empty'
        size --
        def out = last
        last = last.previous
        out.e
    }

    boolean isEmpty() {
        size == 0
    }

    E top () {
        assert size > 0: 'stack is empty'
        last.e
    }

    protected static class Node<E> {
        E e
        private Node<E> previous
        private Node<E> next

        Node(E e) {
            this.e = e
        }
    }
}