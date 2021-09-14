class CustomLinkedMap<K, V> {
    private Integer size = 0
    private Node<K, V> lastNode
    private Node<K, V> firstNode

    private static class Node<K, V> {
        private K key
        private V value
        private Node<K, V> prevNode
        private Node<K, V> nextNode

        Node(K key, V value) {
            this.key = key
            this.value = value
        }

        Node<K, V> getPrevNode() {
            return prevNode
        }

        Node<K, V> getNextNode() {
            return nextNode
        }

        void setPrevNode(Node<K, V> prevNode) {
            this.prevNode = prevNode
        }

        void setNextNode(Node<K, V> nextNode) {
            this.nextNode = nextNode
        }

        K getKey() {
            return key
        }
    }

    Integer size() { size }

    void put(K key, V value) {
        Node<K, V> thisNode = new Node<>(key, value)
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

    private Node<K, V> getNodeByKey(K key) {
        Node<K, V> node
        switch (key) {
            case firstNode.key:
                node = firstNode
                break
            case lastNode.key:
                node = lastNode
                break
            default:
                int times = 0
                node = firstNode
                boolean out = false
                while ((times < size) || !out) {
                    node = node.nextNode
                    out = (key == node.key)
                    times++
                }
        }
        node
    }

    private Node<K, V> getNodeByValue(V value) {
        Node<K, V> node
        switch (value) {
            case firstNode.value:
                node = firstNode
                break
            case lastNode.value:
                node = lastNode
                break
            default:
                int times = 0
                node = firstNode
                boolean out = false
                while ((times < size) || !out) {
                    node = node.nextNode
                    out = (value == node.value)
                    times++
                }
        }
        node
    }

    V get(K key) {
        Node<K, V> node = getNodeByKey(key)
        if (node) return node.value
        else throw new NoSuchElementException()
    }

    void remove(K key) {
        Node<K, V> node = getNodeByKey(key)
        Node<K, V> prevNode = node.prevNode
        Node<K, V> nextNode = node.nextNode
        if (size != 1) {
            prevNode = node.prevNode
            nextNode = node.nextNode
        }
        if ((node == firstNode) && (size != 1)) firstNode = nextNode
        if (size != 1) {
            prevNode.setNextNode(nextNode)
            nextNode.setPrevNode(prevNode)
        } else {
            firstNode = null
            lastNode = null
        }
        size--
    }

    Boolean containsValue(V v) {
        if (size > 0) {
            switch (v) {
                case firstNode.value:
                    return true
                    break
                case lastNode.value:
                    return true
                    break
                default:
                    Node<K, V> node = firstNode.nextNode
                    Boolean out = false
                    Integer times = 0
                    while ((times <= size) && !out) {
                        times++
                        node = node.nextNode
                        out = (node.value == v)
                    }
                    return out
            }
        } else return false
    }

    Boolean containsKey(K k) {
        if (size > 0) {
            switch (k) {
                case firstNode.key:
                    return true
                    break
                case lastNode.key:
                    return true
                    break
                default:
                    Node<K, V> node = firstNode.nextNode
                    Boolean out = false
                    Integer times = 0
                    while ((times <= size) && !out) {
                        times++
                        node = node.nextNode
                        out = (node.key == k)
                    }
                    return out
            }
        } else return false
    }

    @Override
    String toString() {
        StringBuilder builder = new StringBuilder()
        builder.append("CustomLinkedMap{\n")
        builder.append("$firstNode.key : $firstNode.value,\n")
        Node<K, V> node = firstNode.nextNode
        (size - 1).times {
            builder.append("$node.key : $node.value,\n")
            node = node.nextNode
        }
        builder.append("}")
        builder.toString()
    }
}
