import copy
answer = []


def dfs(cur_city, cur_idx, ways, visited, traveled, tickets):
    global answer
    if 0 != len(answer):
        return
    if cur_idx == len(tickets):
        answer = copy.deepcopy(traveled)
        return
    # print(cur_city, cur_idx, ways, visited, traveled, tickets)
    if cur_city not in ways:
        return
    for i in range(len(ways[cur_city])):
        temp = ways[cur_city][i]
        if visited[cur_city][i] == False:
            # copied_visit = copy.deepcopy(visited)
            # copied_visit[cur_city][i] = True
            # copied_traveled = copy.deepcopy(traveled)
            # copied_traveled.append(temp)

            # dfs(temp, cur_idx+1, ways, copied_visit, copied_traveled, tickets)
            visited[cur_city][i] = True
            traveled.append(temp)
            # print("go in ", traveled, temp, answer, cur_idx)
            dfs(temp, cur_idx+1, ways, visited, traveled, tickets)
            visited[cur_city][i] = False
            # traveled.remove(tem p)
            del traveled[len(traveled)-1]
            # print("go out ", traveled, temp, answer, cur_idx)

    return


def solution(tickets):
    global answer
    traveled = ["ICN"]
    visited = {}
    ways = {}
    for i in tickets:
        if i[0] not in ways:
            ways[i[0]] = []
            ways[i[0]].append(i[1])
            visited[i[0]] = []
            visited[i[0]].append(False)
        else:
            ways[i[0]].append(i[1])
            visited[i[0]].append(False)

    for (key, val) in ways.items():
        val.sort()

    dfs("ICN", 0, ways, visited, traveled, tickets)
    return answer