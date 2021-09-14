package stack

import org.testng.annotations.Test

class StackNgTest {
    StackNg stack = new StackNg<Integer>()

    @Test
    void pushTest() {
        def size = 0
        for (int i in 1..100){
            stack.push(i)
            assert stack.size() == ++size
        }
    }

    @Test(dependsOnMethods = ['pushTest'])
    void topTest() {
        def sizeBefore = stack.size()
        stack.top()
        assert stack.size() == sizeBefore
    }

    @Test(dependsOnMethods = ['topTest'])
    void popTest() {
        def size = stack.size()
        stack.size().times {
            assert stack.pop() == size--
        }
    }

    @Test(dependsOnMethods = 'popTest')
    void isEmptyTest() {
        assert stack.isEmpty()
    }
}