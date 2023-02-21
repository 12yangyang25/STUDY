from collections import deque

N, M = map(int, input().split())
graph = []

for _ in range(N):
    graph.append(list(map(int, input())))


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()

        for i in range(4):  # 상하좌우 노드 탐색
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:  # 영역을 벗어날 경우 반복분 빠져 나감
                continue

            if graph[nx][ny] == 0:  # 괴물이 있을 경우 반복문 빠져 나감
                continue

            if graph[nx][ny] == 1:  # 처음 이동하는 노드일 경우
                graph[nx][ny] = graph[x][y] + 1  # 최단 거리를 합쳐줌
                queue.append((nx, ny))  # 큐에 삽입

    return graph[N-1][M-1]


print(bfs(0, 0))
