def solution(numbers):
    answer = []
    for cur in numbers :
        
        # 짝수인 경우
        if cur%2==0 :
            answer.append(cur+1)
        # 홀수 인 경우
        # 7(0111) 의 경우 7보단 큰값중에서 , 비트가 하나나 두개만 바뀐 가장 작은값.
        # 7보단 커야하기때문에 함부로 1->0 은 할수 없고,
        # 7바로다음 값인 8  의경우 1000 으로 4개의 비트가 바뀐다.
        # 그렇기 때문에 가장 작은 0위치를 바꾸고 , 그 오른쪽의 1을 같이 바꾼다(2개의 비트를 바꾼다)
        # 이것이 성립하는 이유 1. 하나의 비트를 바꾸는 것으로 홀수에서 조건을 만족하는 값은 못찾는다.
        #                   2. 두개의 비트를 바꾼다할때 ~01* 상태 에서 ~10* 으로 바꾸는 것이 가장 최적
        
        else:
            # print(bin(cur)[2:])
            number_bin = '0' + bin(cur)[2:]
            number_bin = number_bin[:number_bin.rindex('0')] + '10' + number_bin[number_bin.rindex('0') + 2:]
            answer.append(int(number_bin, 2))
            
    return answer