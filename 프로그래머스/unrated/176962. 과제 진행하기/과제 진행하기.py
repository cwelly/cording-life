
#  12:34 형으로 오는 시작시간을 m단위로 바꾸는 함수
#  12:34 -> 720 + 34 = 754
def convert_to_number(time):
    if ':' not in time:
        return int(time)
    
    a,b = time.split(':')
    
    return int(a) * 60 + int(b)

def solution(plans):
    p = []
    # 기본 해결 개념 .
    # 1. 먼저 시작시간들을 기준으로 정렬하고 ,
    # 2. 각 과제를 하나씩 순회하면서 
    #   2-1 마지막 과제가 아니라면 
    #   2-2 마지막 과제라면
    
    
    
    for title,start,time in plans:
        p.append((title, convert_to_number(start), convert_to_number(time)))
    
    p.sort(key=lambda x:x[1])
    ans = []
    stack = []
    for i in range(len(p)): 
        # 만약 마지막 과제라면
        if i == len(p)-1: 
            # 어차피 마지막과제를 먼저 끝낼거니까 과제를 넣고
            ans.append(p[i][0])
            # 어차피 스텍의 순서대로 처리 될게 뻔하니 순서만 확인해서
            for i in range(-1, -len(stack)-1, -1):
                # 정답에 추가
                ans.append(stack[i][0])
            break
        # 다음 과제의 시작시간(i+1)  -  현재 과제가 끝날 시간(i)
        extra = p[i+1][1] - (p[i][1]+p[i][2]) 
        
        # 현재 과제가 끝나도 다음과제가 시작할때까지 시간이 남는경우
        if extra >= 0: 
            # 현재 과제를 해결한것으로 만들고
            ans.append(p[i][0])
            
            # 시작은 했지만 끝내지 못했던 과제를 순서대로 남은 시간만큼 처리
            while stack:
                # 스텍의 가장 위의 값이 남은 시간(extra) 안에 처리 가능하다면
                if stack[-1][1] <= extra: 
                    # 스택에서 빼고
                    k = stack.pop()
                    # 그 값을 정답에 넣고
                    ans.append(k[0]) 
                    # 남은 시간(extra) 갱신
                    extra -= k[1]
                
                # 남은시간에 처리 불가능하다면
                else:
                    # 스택의 값을 extra만큼 최신화
                    stack[-1][1] -= extra
                    break
        # 현재 과제가 끝나기전에 다음과제가 시작된다면
        else: 
            stack.append([p[i][0], -extra])
    
    return ans