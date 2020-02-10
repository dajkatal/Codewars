def loop_size(node):
    visited = set([])
    visitedList = []
    while True:
        if node in visited:
            return len(visitedList)-visitedList.index(node)
        visited.add(node)
        visitedList.append(node)
        node = node.next