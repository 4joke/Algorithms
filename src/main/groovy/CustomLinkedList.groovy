class CustomLinkedList<E>{
    private Integer size = 0
    private Node<E> lastNode
    private Node<E> firstNode

    private static class Node<E> {
        private E e
        private Integer index
        private Node<E> prevNode
        private Node<E> nextNode

        Node(E e, Integer index) {
            this.index = index
            this.e = e
        }

        Node(E e) {
            this.e = e
            index ++
        }

        Node<E> getPrevNode() {
            return prevNode
        }

        Node<E> getNextNode() {
            return nextNode
        }

        void setPrevNode(Node<E> prevNode) {
            this.prevNode = prevNode
        }

        void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode
        }

        Integer getIndex() {
            return index
        }
    }

    void add(E e) {
        Node<E> thisNode
        if (size == 0) {
            thisNode = new Node<>(e, 0)
            firstNode = thisNode
            thisNode.setNextNode(thisNode)
            thisNode.setPrevNode(thisNode)
        } else {
            thisNode = new Node<>(e, size)
            lastNode.setNextNode(thisNode)
            thisNode.setPrevNode(lastNode)
            thisNode.setNextNode(firstNode)
        }
        size++
        lastNode = thisNode
    }

    Integer size() { size }

    E get(Integer index) {
        switch (index) {
            case {it >= size}:
                throw new ArrayIndexOutOfBoundsException()
                break
            case {(it == firstNode.index) || (it == 0)}:
                return firstNode.e
            case {it == lastNode.index}:
                return lastNode.e
                break
            default:
                if ((index - firstNode.index) <= (lastNode.index - index)) {
                    Node<E> next = firstNode.nextNode
                    while (index != next.index) {
                        next = next.nextNode
                    }
                    return next.e
                } else {
                    Node<E> previous = lastNode.prevNode
                    while (index != previous.index) {
                        previous = previous.prevNode
                    }
                    return previous.e
                }
        }
    }

    E first() {
        firstNode.e
    }

    E last() {
        lastNode.e
    }
}
