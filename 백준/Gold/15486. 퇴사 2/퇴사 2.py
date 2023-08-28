import sys

input = lambda: sys.stdin.readline().rstrip()
n = input()
n = int(n)
date = {}
# date = []
for i in range(n):
    a, b = map(int, input().split())
    # date.append([a, b])
    date[i] = [a, b]
# print(date)
arr = [0 for j in range(int(n)+2)]

for i in range(n-1, -1, -1):
    # 일단 해당 날짜의 값이 N+1을 넘어가게 되는지 체크
    if date[i][0] + i > n:
        arr[i] = arr[i+1]
    else:
        # print(i, date[i][0])
        arr[i] = max(arr[i+1], arr[date[i][0]+i] + date[i][1])


print(arr[0])
