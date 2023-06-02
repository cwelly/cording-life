import copy
answer = 0
answers ={}
def comId (origin , ban ):
    if len(ban) != len(origin) :
        return False
    for i in range(len(ban)) :
        if ban[i]!='*' and ban[i]!=origin[i] :
            return False
    return True
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