def solveNextInp():

  cases = int(raw_input())

  for i in range(cases):

    st = raw_input().strip()
    out = solve(st)
    print "Case #"+str(i+1)+": "+out

def syllables(string):

  # should be equal to the number of vovels!

  v = ['a','e','i','o','u']
  count = 0
  for vovel in v:
    count = count + string.count(vovel)
  return count


def solve(inp):

  l = len(inp)

  flg = 0
  for i in range(l):
    for j in range(i, l):
      for k in range(j, l):
        for m in range(k, l):

          if inp[i:j] == inp[k:m+1] and syllables(inp[i:j]) > 1 and syllables(inp[j:k])>0 and i<j and j<k and k<m:
            return "Spell!"

  return "Nothing."


if __name__=='__main__':

  solveNextInp()
