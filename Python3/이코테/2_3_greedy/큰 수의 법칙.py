N, M, K = map(int, input().split())

numList = list(map(int, input().split()))

numList.sort(reverse=True)
sum = 0

# 조건문 처리가 불필요함 => 어차피 같은 수가 더해지기 때문에

# if numList[0] == numList[1]:
#     while M > K:
#         sum += numList[0] * K
#         M -= K
#     sum += numList[0] * M

# else:
while M > K:
    sum += numList[0] * K
    sum += numList[1]
    M -= K + 1
sum += numList[0] * M

print(sum)
