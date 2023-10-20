# Week 8 Project 2

# Jar
class Jar:
    # Initializing Class
    def __init__(self, capacity=12):
        self.capacity = capacity
        self.size = 0

    # String
    def __str__(self):
        return "🍪" * self.size

    # Deposit
    def deposit(self, n):
        if self.size + n > self.capacity:
            raise ValueError("Error: Over capacity")
        self.size = self.size + n

    # Withdraw
    def withdraw(self, n):
        if n > self.size:
            raise ValueError("Error: Over withdrawal")
        self.size = self.size - n

    # Capacity Getter
    @property
    def capacity(self):
        return self._capacity

    # Capacity Setter
    @capacity.setter
    def capacity(self, capacity):
        if capacity < 1:
            raise ValueError("Invalid capacity")
        self._capacity = capacity

    # Size Getter
    @property
    def size(self):
        return self._size

    # Size Setter
    @size.setter
    def size(self, size):
        if size > self.capacity:
            raise ValueError("Invalid size")
        self._size = size

# Main
def main():
    jar = Jar()
    print(jar)
    jar.deposit(1)
    print(jar)
    jar.deposit(2)
    print(jar)
    jar.withdraw(3)
    print(jar)


if __name__ == "__main__":
    main()