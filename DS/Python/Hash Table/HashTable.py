class HashTable:

    def __init__(self, size):
        self.hash_array = [[None], ] * size
        self.capacity = size
        self.currSize = 0

    def hash(self, key):
        if type(key) == str:
            hash_value = 0
            for i in key:
                hash_value = hash_value + ord(i)
            return hash_value % self.capacity
        else:
            return key % self.capacity

    def insert(self, key, value):
        if self.currSize >= self.capacity:
            raise IndexError("Hash table is full!")
        index = self.hash(key)
        # Linear Probing method
        while self.hash_array[index][0] is not None:
            # Replace value if key is present
            if self.hash_array[index][0] == key:
                self.currSize -= 1
                break
            index = (index + 1) % self.capacity

        self.hash_array[index] = [key, value]
        self.currSize += 1

    def getValue(self, key):
        index = self.hash(key)
        counter = 0
        while self.hash_array[index] is not None:
            # Exit condition to prevent infinite loop
            if counter > self.capacity:
                return
            if self.hash_array[index][0] == key:
                return self.hash_array[index][1]
            index = (index + 1) % self.capacity
            counter += 1

    def remove(self, key):
        index = self.hash(key)
        counter = 0
        while self.hash_array[index] is not None:
            if counter > self.capacity:
                return
            if self.hash_array[index][0] == key:
                pair = self.hash_array[index]
                self.hash_array[index] = [None]
                self.currSize -= 1
                return pair
            counter += 1
            index = (index + 1) % self.capacity


ht = HashTable(10)
ht.insert("A", 1)
ht.insert("B", 1)
ht.insert("C", 1)
ht.insert("D", 1)
ht.remove("D")

print(ht.currSize)
print(ht.hash_array)
