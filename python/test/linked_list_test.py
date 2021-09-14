import unittest

from src.LinkedList import LinkedList


class LinkedListTest(unittest.TestCase):
    def test_append(self):
        linked_list = LinkedList()
        linked_list.append(1)
        linked_list.append(2)
        linked_list.append(3)
        self.assertTrue(linked_list.size == 3, f"size = {linked_list.size}")

    def test_get(self):
        linked_list = LinkedList()
        linked_list.append(34)
        linked_list.append(55)
        linked_list.append(67)
        self.assertTrue(linked_list.get(1) == 55)

    def test_get_negative(self):
        linked_list = LinkedList()
        linked_list.append(34)
        linked_list.append(55)
        linked_list.append(67)
        with self.assertRaises(Exception):
            linked_list.get(4)

    def test_iterator(self):
        linked_list = LinkedList()
        linked_list.append(34)
        linked_list.append(32342)
        linked_list.append(445)
        for item in linked_list:
            pass

    def test_insert(self):
        linked_list = LinkedList()
        linked_list.append(0)
        linked_list.append(1)
        linked_list.append(3)
        linked_list.insert(2, 2)
        self.assertTrue(linked_list.size == 4)
        self.assertTrue(linked_list.get(2) == 2, f"linked_list.get(2) = {linked_list.get(2)}")


if __name__ == '__main__':
    unittest.main()