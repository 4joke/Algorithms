
import org.testng.annotations.Test
import org.testng.log4testng.Logger

class CustomStackTest {
    private static Logger logger = Logger.getLogger(CustomStackTest)
    CustomStack stack

    @Test
    void pushTest() {
        stack = new CustomStack<Integer>()
        def size = stack.size()
        for (int i in 1..100){
            stack.push(i)
            assert stack.size() == ++size
        }
    }

    @Test(dependsOnMethods = 'pushTest')
    void popTest() {
        def size = stack.size()
        stack.size().times {
            stack.pop()
            assert stack.size() == --size
        }
    }
}
