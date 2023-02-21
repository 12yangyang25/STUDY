N, M = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input())))


def dfs(x, y):
    if x <= -1 or x >= N or y <= -1 or y >= M:
        return False  # 영역을 벗어난 경우 return False

    if graph[x][y] == 0:
        graph[x][y] = 1

        dfs(x-1, y)  # 상
        dfs(x+1, y)  # 하
        dfs(x, y-1)  # 좌
        dfs(x, y+1)  # 우

        return True  # 상하좌우 호출 후 return True

    return False  # 이미 방문한 노드일 경우 return False


cnt = 0

for i in range(N):
    for j in range(M):
        if dfs(i, j) == True:
            cnt += 1

print(cnt)
