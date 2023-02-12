####숫자 자료형

```python
print(1) # int
print(1.1) # float
```

```python
import math # math 모듈 임포트
print(math.sqrt(4)) # 제곱근, 2.0
print(math.pow(4, 2)) # 제곱, 16.0
```

####문자 자료형

```python
'Hello world' # string 표현
# 작은 따옴표, 큰 따옴표 상관 없음
# 줄바꿈, 따옴표 3개 + 줄바꿈 + 따옴표 3개
print('''hello
world
''')
```

```python
print('1' + '1') # 11, 문자열 + 연산

print('hello world'.replace('world', 'universe')) # hello universe
```

####리스트 자료형

```python
students = ["ddiong", "moomin", "gomdol"]
grades = [2, 1, 4]
```

```python
print(students[1]) # moomin
print(len(students)) # 3, 리스트의 길이
print(min(grades)) # 1, 최솟값
print(max(grades)) # 1, 최댓값
print(sum(grades)) # 7, 합계

```

```python
import statistics
print(statistics.mean(grades)) # 2.33333...
```

```python
import random
print(random.choice(students)) #리스트의 요소 중 하나를 랜덤하게 뽑아줌
```

####디버깅

```python
print()
# 혹은
# vscode 실행 - 디버깅 시작
```

####입력과 출력

```python
name = input('name: ') # name: ...
```

####pypi

파이썬 표준 라이브러리(math, random 등)가 아닌, 파이썬 엔지니어들이 개발한 패키지
pypi.org

```git
pip install ...
```
