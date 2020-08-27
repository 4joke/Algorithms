class CustomLinkedMap<E, T> {
    private Integer size = 0
    private Node<E, T> lastNode
    private Node<E, T> firstNode

    private static class Node<E, T> {
        private E key
        private T value
        private Node<E, T> prevNode
        private Node<E, T> nextNode

        Node(E key, T value) {
            this.key = key
            this.value = value
        }

        Node<E, T> getPrevNode() {
            return prevNode
        }

        Node<E, T> getNextNode() {
            return nextNode
        }

        void setPrevNode(Node<E, T> prevNode) {
            this.prevNode = prevNode
        }

        void setNextNode(Node<E, T> nextNode) {
            this.nextNode = nextNode
        }

        E getKey() {
            return key
        }
    }

    Integer size() { size }

    void put(E key, T value) {
        Node<E, T> thisNode = new Node<>(key, value)
        if (size == 0) {
            firstNode = thisNode
            lastNode = thisNode
            thisNode.setNextNode(thisNode)
            thisNode.setPrevNode(thisNode)
        } else {
            thisNode.setPrevNode(lastNode)
            thisNode.setNextNode(firstNode)
            lastNode.setNextNode(thisNode)
            lastNode = thisNode
        }
        ++size
    }

    @Override
    String toString() {
        StringBuilder builder = new StringBuilder()
        builder.append("CustomLinkedMap{\n")
        builder.append("$firstNode.key : $firstNode.value,\n")
        Node<E, T> node = firstNode.nextNode
        (size - 1).times {
            builder.append("$node.key : $node.value,\n")
            node = node.nextNode
        }
        builder.append("}")
        builder.toString()
    }
}
