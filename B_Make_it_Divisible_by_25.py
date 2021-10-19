for _ in range(int(input())):
    s = input()
    s = s[::-1]
    ans = []
    for i in range(len(s)):
        if s[i] == '0':
            x = i+1
            c = s[i]
            flag = True
            break
    else:
        flag = False
    if flag:
        for i in range(x, len(s)):
            if s[i] == '0' or s[i] == '5':
                y = i+1
                flag = True
                break
        else:
            flag = False
        if flag:
            ans.append(x-1 + (y-x-1))
    for i in range(len(s)):
        if s[i] == '5':
            x = i+1
            c = s[i]
            flag = True
            break
    else:
        flag = False
    if flag:
        for i in range(x, len(s)):
            if s[i] == '2' or s[i] == '7':
                y = i+1
                flag = True
                break
        else:
            flag = False
        if flag:
            ans.append(x-1 + (y-x-1))
    print(min(ans))
