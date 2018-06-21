
import sys









def main():
    graph = {}
    weights = {}
    visited = {}
    stack = []

    nodeNumber = int(sys.stdin.readline())
    for node in range(nodeNumber):
        node, weight = sys.stdin.readline().strip().split(' ')
        if node not in weights:
            weights[node] = int(weight)
    print weights

    num = int(sys.stdin.readline())
    for i in range(num):
        n1, n2 = sys.stdin.readline().strip().split(' ')
        if n1 not in graph:
            graph[n1] = [n2]
        elif n2 not in graph[n1]:
            graph[n1].append(n2)
        if n1 not in visited:
            visited[n1] = False
        if n2 not in visited:
            visited[n2] = False

    print graph

    # for node in visited.keys():
    #     if not visited[node]:
    #         dfs(node, graph, visited, stack)

if __name__ == "__main__":
    main()