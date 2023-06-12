answer = 0
def powerset(numbers , target , index , cur_val) :
    global answer
    if index  == len(numbers) :
        if cur_val == target :
            answer+=1
        return
    powerset(numbers , target , index+1 , cur_val - numbers[index])
    powerset(numbers , target , index+1 , cur_val + numbers[index])
    # answer=1
    return 

def solution(numbers, target):
    global answer
    powerset(numbers , target , 0 , 0)
    return answer