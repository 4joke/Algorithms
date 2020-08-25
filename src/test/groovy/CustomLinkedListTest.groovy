import org.testng.annotations.Test

class CustomLinkedListTest {
    CustomLinkedList<String> list = new CustomLinkedList()

    @Test
    void addTest() {
        list = new CustomLinkedList()
        Integer size = 0
        for (i in 0..99) {
            list.add(i)
            assert ++size == list.size()
            assert i == list.last()
        }
        assert 0 == list.first()
        assert 99 == list.last()
    }

    @Test(dependsOnMethods = 'addTest')
    void getTest() {
        for (i in 0..99) {
            assert list.get(i) == i
        }
    }

    @Test(dependsOnMethods = 'getTest')
    void removeTest() {
        def size = list.size()
        size.times {
            list.remove(0)
            assert --size == list.size()
        }
    }
}
