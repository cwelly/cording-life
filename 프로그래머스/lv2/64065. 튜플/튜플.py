
# 먼저 문자열을 튜플의 리스트로 만들고

# 튜플의 크기로 정렬

# 현재 보고 있는 튜플의 합에서 , 이전 튜플의 합을 빼면

# 지금 추가해야 할 값이 나오므로 이 값을 추가
def solution(s):
    answer =[]
    tu_list =[]
    t_int = ''
    temp =[]
    # 문자열을 튜플로 바꾸는 코드
    for char in s[1:-1]:
        if  char =='{' :
            temp = []
        elif char == '}' :
            temp.append(int(t_int))
            t_int=""
            tt= tuple(temp)
            tu_list.append(tt)
        elif  char == ',':
            if t_int != "" :
                temp.append(int(t_int))
                t_int=""
        else :
            t_int=t_int+char
    # 튜플의 리스트를 해당 튜플의 크기로 정렬
    tu_list.sort(key = lambda x : len(x))      
    tmp = 0
    # 정렬된 튜플의 리스트를 각 차이만큼 계산해 순서대로 추가
    for i in tu_list :
        cur_sum  = sum(i)-tmp
        answer.append(cur_sum)
        tmp = sum(i)
    return answer