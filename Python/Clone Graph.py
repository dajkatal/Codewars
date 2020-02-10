class GraphNode:
    def __init__(self, val):
        self.val = val
        self.neighbors = []
    def addNeighbor(self, node):
        self.neighbors.append(node)


def duplicate(newGraph, node):
    for i in range(len(node.neighbors)):
        newNode = GraphNode(node.neighbors[i].val)
        newNode.neighbors.append(newGraph)
        newGraph.neighbors.append(newNode)
        newNode.neighbors
    return newGraph


def clone_graph(node):
    return duplicate(GraphNode(node.val), node)









