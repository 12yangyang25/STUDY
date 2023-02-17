# 20분

position = input()
vertical = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
x = vertical.index(position[0]) + 1
y = int(position[1])
cnt = 0
print(x, y)

moving = [(2, 1), (-2, 1), (2, -1), (-2, -1),
          (1, 2), (-1, 2), (1, -2), (-1, -2)]

for i in range(len(moving)):
    nx = x + moving[i][0]
    ny = y + moving[i][1]

    if nx < 1 or nx > 8 or ny < 1 or ny > 8:
        continue

    cnt += 1

print(cnt)
