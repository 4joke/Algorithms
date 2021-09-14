package stack

class QueueNg<E> extends StackNg<E>{
    private Node first

    @Override
    void push(E e) {
        if (!first) {
            super.push(e)
            first = last
        }
        else super.push(e)
    }

    @Override
    E pop() {
        assert size > 0: 'queue is empty'
        size --
        def out = first
        first = first.next
        out.e
    }
}
