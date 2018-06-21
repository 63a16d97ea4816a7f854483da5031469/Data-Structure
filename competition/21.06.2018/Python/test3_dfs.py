import sys

max_value = -1
tmp_max_value = 0
is_has_circle = False
weights = {}


def find_path(graph, start, path=[]):
    global tmp_max_value
    global max_value
    global is_has_circle
    global weights

    path = path + [start]
    tmp_max_value = 0

    for t in path:
        tmp_max_value = tmp_max_value + weights[t]
    if tmp_max_value > max_value:
        max_value = tmp_max_value

    # print path
    if not graph.has_key(start):
        return None
    for node in graph[start]:
        if node not in path:
            newpath = find_path(graph, node, path)
            if newpath: return newpath
        else:
            is_has_circle = True
    return None


def main():
    graph = {}
    visited = {}


    nodeNumber = int(sys.stdin.readline())
    for node in range(nodeNumber):
        node, weight = sys.stdin.readline().strip().split(' ')
        if node not in weights:
            weights[node] = int(weight)

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

    input_start_point = sys.stdin.readline().split('\n')[0]

    find_path(graph, input_start_point)

    # print graph;
    # print weights

    if is_has_circle:
        print "has circle"
    else:
        print(max_value)


if __name__ == "__main__":
    main()
