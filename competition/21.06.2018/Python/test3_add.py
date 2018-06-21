import sys





weights = {'A': 1,
         'B': 2,
         'C': 2,
           'D':6
         }

graph = {
    'A': ['B', 'C','D'],
    'B': ['C'],
    'C': [],
    'D': ['C']
}



def dfs(node, graph, visited, stack):
    visited[node] = True
    stack.append(node)
    print stack
    if node in graph:
        for n in graph[node]:
            if n not in stack:
                if not visited[n]:
                    dfs(n, graph, visited, stack)
            else:
                index = stack.index(n)
                print 'Circle: ',
                for i in stack[index:]:
                    print i,
                print n
    stack.pop(-1)


def main():
    graph = {}
    visited = {}
    stack = []
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


    for node in visited.keys():
        if not visited[node]:
            dfs(node, graph, visited, stack)

if __name__ == "__main__":
    main()