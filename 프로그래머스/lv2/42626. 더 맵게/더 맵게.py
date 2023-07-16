from queue import PriorityQueue
def solution(scoville, K):
    answer = 0
    que = PriorityQueue()
    # 우선순위 큐에 전부 넣기
    for sco in scoville :
        que.put(sco)
    # 최대 n-1번까지만 시도
    for i in range(len(scoville)-1) :
        min_first = que.get()
        min_second = que.get()
        if min_first>= K :
            answer = i
            if i==0 :
                return 0
            return answer
        temp  = min_first+(min_second*2)
        que.put(temp)
    if que.get()>=K :
        answer= len(scoville)-1
    else :
        answer =-1
    return answer