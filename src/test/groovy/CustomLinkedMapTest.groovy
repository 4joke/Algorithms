import org.testng.annotations.Test

class CustomLinkedMapTest {
    CustomLinkedMap<Integer, String> map = new CustomLinkedMap<>()

    @Test
    void putTest() {
        def size = 0
        1.upto(100){Integer it ->
            map.put(it, "$it string")
            ++size == map.size()
            String
        }
    }
}
