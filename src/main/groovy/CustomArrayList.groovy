

class CustomArrayList<E> extends CustomCollection{

    void add(E e) {
        super.push(e)
    }

    void remove(Integer index) {
        switch (index) {
            case {it > size() || it < 0}:
                throw new ArrayIndexOutOfBoundsException()
                break
            case {it == size - 1}:
                pop()
                break
            default:
                elements[index] = null
                size--
                elements = copy(size, size)
                break
        }
    }

    E pop() {
        super.pop()
    }
}
