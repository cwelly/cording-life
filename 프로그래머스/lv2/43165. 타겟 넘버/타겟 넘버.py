answer = 0
def powerset(numbers , target , index , cur_val) :
    global answer
    # 만약 전부 돌아봤다면
    if index  == len(numbers) :
        # 타겟값과 같은지 비교
        if cur_val == target :
            answer+=1
        return
    # 현재 보고있는 값을 뺐을때
    powerset(numbers , target , index+1 , cur_val - numbers[index])
    # 현재 보고있는 값을 더할때
    powerset(numbers , target , index+1 , cur_val + numbers[index])
    # answer=1
    return 

def solution(numbers, target):
    global answer
    powerset(numbers , target , 0 , 0)
    return answer