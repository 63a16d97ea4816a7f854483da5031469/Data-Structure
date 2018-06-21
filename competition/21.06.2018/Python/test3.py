# nodes = {'A': 1,
#          'B': 2,
#          'C': 2
#          }
#
# paths = {'A': ['B', 'C'],
#          'B': ['C'],
#          'C': []
#          }



nodes = {'A': 1,
         'B': 2,
         'C': 2,
         'D': 6
         }

paths = {
    'A': ['B', 'C','D'],
    'B': ['C'],
    'C': [],
    'D': ['C']
}



max_value = -1

def find_max_path(_nodes, _paths, start_node, path=[], _vv=0):
    _v = _nodes[start_node]
    _p = _paths[start_node]

    path = path + [start_node]
    _vv = _v + _vv
    if len(_p) == 0:
        return [path], _vv
    ps = []
    values = []
    global max_value

    for _t1 in _p:
        if _t1 not in path:
            newpaths, value = find_max_path(_nodes, _paths, _t1, path, _vv)
            values.append(value)
            print newpaths, value
            if not isinstance(value,list) and max_value<value:
                max_value = value
            for newpath in newpaths:
                ps.append(newpath)
    return ps, values


if __name__ == '__main__':
    ps,values= find_max_path(nodes, paths, 'A')
    print max_value;
