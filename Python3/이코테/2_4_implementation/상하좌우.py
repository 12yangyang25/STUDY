# # 10분

import sys
N = int(input())
X = 1
Y = 1

plans = list(sys.stdin.readline().split())

for plan in plans:  # (O(n))
    if plan == 'U':
        if X > 1:
            X -= 1
    elif plan == 'D':
        if X < N:
            X += 1
    elif plan == 'L':
        if Y > 1:
            Y -= 1
    elif plan == 'R':
        if Y < N:
            Y += 1

print(X, Y)


# 예제코드

# dx = [0, 0, -1, 1]
# dy = [-1, 1, 0, 0]
# moving = ['L', 'R', 'U', 'D']
# for plan in plans:
#     for i in range(4):
#         if plan == moving[i]:
#             nx = X + dx[i]
#             ny = Y + dy[i]

#     if nx < 1 or ny < 1 or nx < n or ny > n:
#         continue

#     X, Y = nx, ny
