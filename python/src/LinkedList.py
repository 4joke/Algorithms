class LinkedList:
    def __init__(self):
        self.size = 0
        self.__first = None
        self.__last = None

    def __iter__(self):
        return LinkedListIterator(self)

    def append(self, value):
        cur_node = Node(value, self.size)
        if self.size == 0:
            cur_node.next = cur_node
            cur_node.previous = cur_node
            self.__first = cur_node
            self.__last = cur_node
            self.size += 1
        else:
            cur_node.previous = self.__last
            cur_node.previous.next = cur_node
            cur_node.next = self.__first
            self.__last = cur_node
            self.size += 1

    def insert(self, index, value):
        new_node = Node(value, index)
        cur_node = self.__node_by_index(index)
        cur_node.previous.next = new_node
        self.__last = new_node
        while cur_node.index != 0:
            self.append(cur_node.value)
            cur_node = cur_node.next

    def __node_by_index(self, index):
        node = self.__first
        if index >= self.size:
            raise ValueError(f"There is no element with index {index}")
        else:
            while node.index != index:
                node = node.next
        return node

    def get(self, index):
        return self.__node_by_index(index).value


class Node:
    def __init__(self, value, index):
        self.value = value
        self.next = None
        self.previous = None
        self.index = index


class LinkedListIterator:
    def __init__(self, linked_list):
        self.entity = linked_list
        self.__index = 0
        pass

    def __next__(self):
        if self.__index < self.entity.size:
            result = self.entity.get(self.__index)
            self.__index += 1
            return result
        raise StopIteration

