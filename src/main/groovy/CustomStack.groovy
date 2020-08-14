import java.util.logging.Logger

class CustomStack<E> {
    private static Logger logger = Logger.getLogger('Stack')
    private E element
    private E[] elements = new Object[10] as E[]
    private Integer size = 0

    void push(E e) {
        if (size + 1 < elements.length) {
            elements[++size] = e
        } else {
            elements = copy(elements.length, size + 5)
            elements[++size] = e
        }
    }

    E pop() {
        if (size > 0) {
            E out = elements[size - 1]
            size--
            elements = copy(size, size)
            return out
        } else throw new RuntimeException("There is no item to return!")
    }

    private E[] copy(Integer copySize, Integer newSize) {
        E[] newElements = new Object[newSize] as E[]
        for (int i = 0; i < copySize; i++) {
            newElements[i] = elements[i]
        }
        newElements
    }

    Integer size() {
        size
    }
}
