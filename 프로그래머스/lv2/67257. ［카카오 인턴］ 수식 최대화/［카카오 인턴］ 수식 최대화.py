# 어차피 - + * 의 조합에서 모든값을 확인해야하므로
# for문을 돌며 계산하면서 넘어감
import copy
def getMinus(int_list ,op_list) :
    ints =[]
    ops = []
    ret = {}
    for i in range(len(op_list)) :
        if op_list[i] == '-' :
            int_list[i+1] = int_list[i]-int_list[i+1]
        else :
            ops.append(op_list[i])
            ints.append(int_list[i])
    ints.append(int_list[-1])
    ret['ops'] = ops
    ret['ints'] = ints
    return ret

def getPlus(int_list ,op_list) :
    ints =[]
    ops = []
    ret = {}
    for i in range(len(op_list)) :
        if op_list[i] == '+' :
            int_list[i+1] = int_list[i]+int_list[i+1]
        else :
            ops.append(op_list[i])
            ints.append(int_list[i])
    ints.append(int_list[-1])
    ret['ops'] = ops
    ret['ints'] = ints
    return ret

def getMulti(int_list ,op_list) :
    ints =[]
    ops = []
    ret = {}
    for i in range(len(op_list)) :
        if op_list[i] == '*' :
            int_list[i+1] = int_list[i]*int_list[i+1]
        else :
            ops.append(op_list[i])
            ints.append(int_list[i])
    ints.append(int_list[-1])
    ret['ops'] = ops
    ret['ints'] = ints
    return ret

def solution(expression):
    answer = 0
    op_list=[]
    int_list = []
    temp=""
    for char in expression :
        if char == '*' or char == '-' or char == '+' :
            op_list.append(char)
            int_list.append(int(temp))
            temp = ""
        else :
            temp= temp+char
    int_list.append(int(temp))

    answer = -1
    # - 먼저
    ret  = getMinus(copy.deepcopy(int_list) ,copy.deepcopy(op_list))
    #   * +
    rret  = getMulti(copy.deepcopy(ret['ints']) , copy.deepcopy(ret['ops']))
    rrret =  getPlus(rret['ints'] , rret['ops'])
    cur_result = abs(rrret['ints'][0])
    answer =  answer if answer>=cur_result else cur_result
    #   + *
    rret  = getPlus(copy.deepcopy(ret['ints']) , copy.deepcopy(ret['ops']))
    rrret =  getMulti(rret['ints'] , rret['ops'])
    cur_result = abs(rrret['ints'][0])
    answer =  answer if answer>=cur_result else cur_result
    # + 먼저
    ret  = getPlus(copy.deepcopy(int_list) ,copy.deepcopy(op_list))
    #   - *
    rret  = getMinus(copy.deepcopy(ret['ints']) , copy.deepcopy(ret['ops']))
    rrret =  getMulti(rret['ints'] , rret['ops'])
    cur_result = abs(rrret['ints'][0])
    answer =  answer if answer>=cur_result else cur_result
    #   * -
    rret  = getMulti(copy.deepcopy(ret['ints']) , copy.deepcopy(ret['ops']))
    rrret =  getMinus(rret['ints'] , rret['ops'])
    cur_result = abs(rrret['ints'][0])
    answer =  answer if answer>=cur_result else cur_result
    
    
    # * 먼저
    ret  = getMulti(copy.deepcopy(int_list) ,copy.deepcopy(op_list))
    #   + -
    rret  = getPlus(copy.deepcopy(ret['ints']) , copy.deepcopy(ret['ops']))
    rrret =  getMinus(rret['ints'] , rret['ops'])
    cur_result = abs(rrret['ints'][0])
    answer =  answer if answer>=cur_result else cur_result
    #   - +
    rret  = getMinus(copy.deepcopy(ret['ints']) , copy.deepcopy(ret['ops']))
    rrret =  getPlus(rret['ints'] , rret['ops'])
    cur_result = abs(rrret['ints'][0])
    answer =  answer if answer>=cur_result else cur_result
    
    return answer