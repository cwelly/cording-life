def solution(sequence, k):
    answer = []
    start = 0 
    end = 0
    temp = sequence[start]
    mmax = len(sequence)+1
    tmp = []
    while True :

        if temp == k :
            if end-start <mmax :
                answer =[start , end] 
                mmax = end-start
                end+=1
                if end>=len(sequence) or start>=len(sequence) :
                    break
                temp += sequence[end]
                
            # 아니라면 list 에 등록
            else :
                start+=1
                end +=1
                if end>=len(sequence) or start>=len(sequence) :
                    break
                temp += sequence[end] - sequence[start-1]

        # temp 가 k보다 작다면 오른쪽값을 늘리고
        elif temp<k :
            end+=1
            if end>=len(sequence) or start>=len(sequence) :
                break
            temp +=sequence[end]
        # 작다면 왼쪽값을 줄인다.
        elif temp> k :
            temp-=sequence[start]
            start+=1

    return answer