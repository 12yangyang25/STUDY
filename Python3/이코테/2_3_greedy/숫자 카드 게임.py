# 6λΆ μμ

M, N = map(int, input().split())

numList = []

for _ in range(M):
    numList.append(min(list(map(int, input().split()))))

print(max(numList))
