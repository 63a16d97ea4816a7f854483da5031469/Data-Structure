weights = {'A': 1,
           'B': 2,
           'C': 2
           }

graph = {
    'A': ['B', 'C'],
    'B': ['C'],
    'C': []
}

visited = []
max_value = -1
tmp_max_value = 0
is_has_circle = False


def find_path(graph, start, path=[]):
    global tmp_max_value
    global max_value
    global is_has_circle

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

print weights
print graph

find_path(graph, 'A')

if is_has_circle:
    print "has circle"
else:
    print(max_value)
