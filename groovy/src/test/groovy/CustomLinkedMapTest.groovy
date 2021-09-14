import org.testng.annotations.Test

class CustomLinkedMapTest {
    CustomLinkedMap<Integer, String> map = new CustomLinkedMap<>()

    @Test
    void putTest() {
        def size = 0
        0.upto(99){Integer it ->
            map.put(it, "$it string")
            ++size == map.size()
            String
        }
    }

    @Test(dependsOnMethods = 'putTest')
    void getTest() {
        0.upto(99) {Integer it ->
            assert map.get(it) == "$it string"
        }
    }

    @Test(dependsOnMethods = 'getTest')
    void containsTest() {
        def random = new Random()
        map.size().times {
            assert map.containsKey(random.nextInt(map.size()))
            assert map.containsValue("${random.nextInt(map.size())} string")
        }
    }

    @Test(dependsOnMethods = 'getTest')
    void removeTest() {
        Integer size = map.size()
        0.upto(99){Integer it ->
            map.remove(it)
            assert --size == map.size()
            assert !map.containsKey(it)
            assert !map.containsValue("$it string")
        }
    }
}
