import copy

#그냥 powerset 풀스캔

#banned_id 를 하나 부터 for 문으로 전부 확인

# 겹치는 경우는 dict형으로 관리하는 answers 에 값이 있는지로 체크
answer = 0
answers ={}
# 문자열 origin 이 문자열 ban 과 매칭이 되는지 T/F로 리턴하는 메소드
def comId (origin , ban ):
    if len(ban) != len(origin) :
        return False
    for i in range(len(ban)) :
        if ban[i]!='*' and ban[i]!=origin[i] :
            return False
    return True

#  left_id 들의 모든 원소들을 하나씩 빼서 
#   banned_id에 걸리면
#       left_id 에서 빼고 banned_id 를 확인하는 인덱스를 다음값으로 넘어간다
#   banned_id에 안 걸리면
#       넘어간다

#   체크 하다가 , banned_id를 전부 확인하면 
#   제재 아이디를 전부 체크했으므로 left_id를 통해 dict를 확인
#       이미 있으면 넘어가고
#       없으면 answer 값 올리고 , dict에 추가

def powerset (left_id ,  banned_id  , cur) :
    global answer
    global answers
    if cur== len(banned_id) :
        result = ''.join(left_id)
        if result in answers :
            return 
        else :
            answers[result]=0
            answer +=1
            return 
    #남은 아이디들을 순회
    for i in range(len(left_id)) :
        cur_id = left_id[i]
        # 만약 현재 아이디가 banned[cur]에 해당되는 id라면
        if comId(cur_id , banned_id[cur]) :
            tmp = copy.deepcopy(left_id)
            tmp.remove(cur_id)
            # print(cur, tmp,cur_id)
            powerset(tmp , banned_id , cur+1 )
    return 
def solution(user_id, banned_id):
    global answer
    global answers
    powerset(user_id , banned_id , 0)
    # 
    
    return answer