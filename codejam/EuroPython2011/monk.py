def readNextInput():

  cases = int(raw_input())
  for i in range(cases):
    node = int(raw_input())
    desc = raw_input().strip()
    [nodes, edges] = constructGraph(desc, node)
    print "Case #"+str(i+1)+": "

    for day in range(node):
      print findConnectedNodes(nodes, edges, day)

def constructGraph(desc, node):

  parts = desc.split()
  nodes = map(lambda x: int(x)-1, parts)
  edges = []
  for i in range(node):
    edges.append([int(parts[i])-1, i])

  return [nodes, edges]

def findConnectedNodes(nodes, edges, start):

  curr_set = [start]
  visited = []
  while(len(curr_set) != 0):
    # visit the curr_set
    v = curr_set.pop()
    neighbours = []

    for n in edges:
      if n[0] == v:
        neighbours.append(n[1])

    for n in neighbours:
      if n not in visited and n not in curr_set:
        curr_set.append(n)
    visited.append(v)

  return  len(visited)

if __name__=='__main__':

  readNextInput()
