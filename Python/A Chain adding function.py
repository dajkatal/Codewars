class newInt(int):
    def __call__(self, v):
        return newInt(self+v)

def add(current):
    return newInt(current)
