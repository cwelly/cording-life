
# 구해야 할 값은 가로 미사일을 요격하는데 필요한
# 최소 세로 미사일 갯수만을 세면 된다.

# 가장 왼쪽의 미사일부터( e값이 가장 작은 경우) 보는데 , 
# 그다음 오른쪽 미사일(e 값 기준 다음으로 작은 경우) 의 s값을 확인한다 ( 현재 미사일범위 안에 있는지 확인)
#   만약 포함되면
#       다음값으로 넘어간다
#   만약 포함되지 않으면
#       지금까지의 미사일들과 같은 요격미사일을 사용할 수 없으므로 
#       요격 미사일의 수를 늘리고 , e값을 현재 미사일의 값으로 수정

def solution(targets):
    answer = 1
    # 미사일들을 오른쪽 값으로 오름차순 정렬
    targets.sort(key = lambda x: [x[1], x[0]])
    # 가장 왼쪽의 오른쪽값으로 초기화
    cur_end = targets[0][1]
    # missile 순회
    for missile in targets :
        # s값이 현재 cur_end 즉 , 지금의 요격미사일의 범위에 닿지 않으면
        if missile[0]>=cur_end :
            answer+=1
            cur_end=missile[1]
    return answer