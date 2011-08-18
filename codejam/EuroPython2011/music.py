import copy
def solveOnInput():

  cases = int(raw_input())

  for i in range(cases):

    strings = int(raw_input())
    inp = []
    for j in range(strings):
      inp.append(raw_input().upper())
    print "Case #"+str(i+1)+":"
    solve(inp)

def len_comp(x, y):
  if len(x) > len(y):
    return 1
  else:
    return -1

def solve(inp):


  inp_len = len(inp)
  parts = []
  if inp_len ==1:
    print "\"\""
    return
  for i in range(inp_len):

    temp = [] # contains the breakup of each string

    str_len = len(inp[i])

    for k in range(str_len+1):
      for j in range(str_len - k):
        temp.append(inp[i][j:j+k+1])

    parts.append(temp)


  for i in range(inp_len):
    probables = []
    for probable in parts[i]:
      flg= 1
      for j in range(inp_len):
        if i==j:
            continue
        else:
          if probable in inp[j]:
            flg = 0
      if flg:
        probables.append(probable)
    if len(probables)==0:
      print ":("
    else:
      probables.sort(len_comp)
      least_len = len(probables[0])
      least = filter(lambda x: len(x) == least_len, probables)
      least.sort()
      print "\""+least[0]+"\""



if __name__=='__main__':

  solveOnInput()




