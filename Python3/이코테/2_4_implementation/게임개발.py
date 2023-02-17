# 1:25

N, M = map(int, input().split())
A, B, d = map(int, input().split())

mapInfo = []
isVisited = []
cnt = 0

for i in range(N):
    mapInfo.append(list(map(int, input().split())))
    isVisited.append(list(mapInfo[i]))

movingLeft = [(0, -1), (-1, 0), (0, 1), (1, 0)]
movingBack = [(0, 1), (0, -1), (-1, 0), (0, 1)]
rotateLeft = [3, 0, 1, 2]

while True:
    if isVisited[A][B-1] and isVisited[A-1][B] and isVisited[A][B+1] and isVisited[A+1][B]:
        nA = A + movingBack[d][0]
        nB = B + movingBack[d][1]
        if mapInfo[nA][nB]:
            break
        else:
            cnt += 1
            isVisited[A][B] = 1
            A, B = nA, nB
            continue

    nA = A + movingLeft[d][0]
    nB = B + movingLeft[d][1]
    d = rotateLeft[d]

    if not isVisited[nA][nB]:
        isVisited[A][B] = 1
        A, B = nA, nB
        cnt += 1

print(cnt)
