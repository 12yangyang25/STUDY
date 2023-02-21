N = int(input())

num = []
for _ in range(N):
    num.append(int(input()))

num.sort(reverse=True)

for x in num:
    print(x, end=' ')
