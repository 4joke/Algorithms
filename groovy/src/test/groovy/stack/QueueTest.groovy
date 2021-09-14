package stack

import org.testng.annotations.Test

class QueueNgTest {
    QueueNg queue = new QueueNg<Integer>()

    @Test
    void pushTest() {
        def size = 0
        for (int i in 1..100){
            queue.push(i)
            assert queue.size() == ++size
        }
    }

    @Test(dependsOnMethods = ['pushTest'])
    void popTest() {
        def first = 1
        queue.size.times {
            assert queue.pop() == first++
        }
    }
}
