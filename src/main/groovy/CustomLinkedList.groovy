import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
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

        void reduceIndex() {
            this.index--
        }
    }

    Integer size() { size }

    E get(Integer index) {
        getNode(index).e
    }

    E first() {
        firstNode.e
    }

    E last() {
        lastNode.e
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
        firstNode.setPrevNode(lastNode)
    }

    private Node<E> getNode(Integer index) {
        switch (index) {
            case {it >= size}:
                throw new ArrayIndexOutOfBoundsException()
                break
            case {(it == firstNode.index) || (it == 0)}:
                return firstNode
            case {it == lastNode.index}:
                return lastNode
                break
            default:
                if ((index - firstNode.index) <= (lastNode.index - index)) {
                    Node<E> next = firstNode.nextNode
                    for(int i = 0; i < (index - firstNode.index); i++) {
                        if (index == next.index) return next
                        else next = next.nextNode
                    }
                } else {
                    Node<E> previous = lastNode.prevNode
                    for (int i = lastNode.index; i >= 0; i--) {
                        if (index == previous.index) return previous
                        previous = previous.prevNode
                    }
                }
        }
    }

    void remove(Integer index) {
        if (index >= size) throw new ArrayIndexOutOfBoundsException("index = $index; size = $size")
        Node<E> node = getNode(index)
        Node<E> prevNode = node.prevNode
        Node<E> nextNode = node.nextNode
        if (node == firstNode) firstNode = nextNode
        prevNode.setNextNode(nextNode)
        nextNode.setPrevNode(prevNode)
        for (int i = index + 1; i <= lastNode.index; i++) {
            nextNode.reduceIndex()
            nextNode = nextNode.nextNode
        }
        --size
    }

    Boolean contains(E e) {
        switch (e) {
            case firstNode.e:
                return true
                break
            case lastNode.e:
                return true
                break
            default:
                Node<E> node = firstNode.nextNode
                Boolean out = false
                Integer times = 0
                while ((times <= size) && !out) {
                    times++
                    node = node.nextNode
                    out = (node.e == e)
                }
                return out
        }
    }
}
