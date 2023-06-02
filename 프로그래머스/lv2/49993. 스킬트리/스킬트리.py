def solution(skill, skill_trees):
    temp = {}
    for i in range(1, len(skill)) :
        temp[skill[i]]=0
    answer = 0
    # print(temp)
    for cur_tree in skill_trees :
        learned_skills = {}
        # print(cur_tree)
        for idx in range(len(cur_tree)) : 
            # print(cur_tree[idx] ,learned_skills )
            # 만약 선행 요소가 있다면
            if cur_tree[idx] in temp :
                #  해당 스킬의 바로 전의 스킬값을 구한다
                sunhang = skill.find(cur_tree[idx])-1
                    
                # 바로 전의 선행스킬을 배웠는지 체크
                if skill[sunhang] in learned_skills:
                    # 배웠다면 배운 스킬에 추가
                    learned_skills[cur_tree[idx]]=0
                else :
                    # 안배웠으면 나중에 추가할 정답값 도루묵
                    answer-=1
                    break
            # 선행 요소가 없는 스킬이면
            else :
                # 배운 스킬에 추가
                learned_skills[cur_tree[idx]]=0
        answer+=1
    return answer