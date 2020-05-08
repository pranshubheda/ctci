def urlify_naive(s1):
    """O(n(n+1)/2) ~ O(n^2)... since a new string is 
    created in each iteration.
    """
    new_s1 = ''
    for i, c in enumerate(s1):
        if c== ' ':
            new_s1 += '%20'
        else:
            new_s1 += c

def urlify_1(s1):
    """The join function is highly efficient where
    it efficiently uses lists avoiding creating multiple
    interstetial string objects.
    """
    s1 = list(s1)
    for i, c in enumerate(s1):
        if c== ' ':
            s1[i] = '%20'
    
    s1 = ''.join([x for x in s1])
    return s1

def urlify_2(s1):
    """O(n) since we work with arrays and donot
    create unnecessary string concatenations since
    strings are immutable. With inplace replacement hence 
    O(1) space.
    """
    s1 = list(s1)

    space_count = 0
    for i, c in enumerate(s1):
        if c==' ':
            space_count+=1
    
    extra_space_needed = space_count * 2

    new_s1 = s1 + [None]*extra_space_needed
    # new_s1 = [None]*(len(s1)+extra_space_needed)
    
    skip_counter = 0
    for i, c in enumerate(s1):
        if c==' ':
            new_s1[i+skip_counter] = '%'
            new_s1[i+skip_counter+1] = '2'
            new_s1[i+skip_counter+2] = '0'
            skip_counter+=2
        else:
            new_s1[i+skip_counter] = c

    return new_s1

# def urlify_3(s1):
#     s1 = list(s1)

#     space_count = 0
#     for i, c in enumerate(s1):
#         if c==' ':
#             space_count+=1

#     last_index_s1 = len(s1)-1
#     extra_space_needed = space_count * 2
#     s1 = s1 + [None]*extra_space_needed
#     new_last_index_s1 = len(s1) -1

#     skip_counter = 0
#     for i in range(last_index_s1, -1, -1):
#         c = s1[i]
#         if c==' ':
#             s1[new_last_index_s1] = '%'
#             s1[new_last_index_s1-1] = '2'
#             s1[new_last_index_s1-2] = '0'
#             new_last_index_s1 -= 3
#         else:
#             s1[new_last_index_s1] = s1[i]
#             new_last_index_s1 -=1
#         # print(s1)
#         print(i, new_last_index_s1)

#     return s1

if __name__ == "__main__":
    s1 = "http://pranshubheda.com?text='hello world h r u'"
    # s1 = "hello world how are you"
    # s1 = "much ado about nothing"
    res = urlify_2(s1)
    print(res)