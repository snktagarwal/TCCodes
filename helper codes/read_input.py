# Defines some of the mundane tasks of reading input

def read_all_stdin():
  inp_lines = []
  while(1):
    try:
      inp_lines.append(raw_input().strip())
    except:
      return inp_lines


if __name__=='__main__':

  print read_all_stdin()
