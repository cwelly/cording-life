
def solution(numbers):
    # 숫자들을 문자열 형태로 변환
    numbers = list(map(str, numbers))
    # 123 형태의 문자열을 1231231231234 의 앞의 4자리만을 사용
    # 4자리인 이유는 numbers의 모든 숫자들이 1000이하이기때문
    # 
    numbers.sort(key=lambda x: (x * 4)[:4], reverse=True)
    # 3. 정렬된 numbers를 이어붙인 뒤 반환
    answer = ''.join(numbers)

    # 0이 여러개일 경우, "000" 대신 "0"을 반환하도록 예외처리
    if answer[0] == '0':
        return '0'
    else:
        return answer