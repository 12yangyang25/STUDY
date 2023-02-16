# 10분

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
