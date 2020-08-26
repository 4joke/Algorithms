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

    @Test(dependsOnMethods = 'addTest')
    void containsTest() {
        def random = new Random()
        list.size().times {
            assert list.contains(random.nextInt(list.size()))
        }
    }

    @Test(dependsOnMethods = 'addTest')
    void negativeContainsTest() {
        for (int i = 100; i < 200; i++) {
            assert !list.contains(i)
        }
    }

    @Test(dependsOnMethods = 'containsTest')
    void removeTest() {
        def size = list.size()
        size.times {
            list.remove(0)
            assert --size == list.size()
        }
    }
}
