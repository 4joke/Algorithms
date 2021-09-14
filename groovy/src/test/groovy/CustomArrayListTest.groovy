import org.testng.annotations.Test

class CustomArrayListTest {
    CustomArrayList<Integer> arrayList = new CustomArrayList<>()

    @Test
    void addTest() {
        def size = arrayList.size()
        for (i in 1..100) {
            arrayList.add(i)
            assert ++size == arrayList.size()
        }
    }

    @Test(dependsOnMethods = 'addTest')
    void removeTest() {
        def size = arrayList.size()
        arrayList.size().times {
            arrayList.remove(0)
            assert --size == arrayList.size()
        }
    }
}
