N = int(input())
students = []
for _ in range(N):
    name, score = input().split()
    students.append([name, int(score)])

students.sort(key=lambda x: x[1])

for x in students:
    print(x[0], end=' ')
