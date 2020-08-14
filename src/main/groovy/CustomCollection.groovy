

class CustomCollection<E> {
    protected Integer size = 0
    protected E[] elements = new Object[10] as E[]

    protected void push(E e) {
        if (size + 1 < elements.length) {
            elements[++size] = e
        } else {
            elements = copy(elements.length, size + 5)
            elements[++size] = e
        }
    }

    protected E[] copy(Integer copySize, Integer newSize) {
        E[] newElements = new Object[newSize] as E[]
        for (int i = 0; i < copySize; i++) {
            newElements[i] = elements[i]
        }
        newElements
    }

    protected E pop() {
        if (size > 0) {
            E out = elements[size - 1]
            size--
            elements = copy(size, size) as E[]
            return out
        } else throw new RuntimeException("There is no item to return!")
    }

    Integer size() {
        size
    }
}
