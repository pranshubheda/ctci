"""A program to check if one string is a permutation of the other.
"""

def check(s1, s2):
    """The length of both strings should match and
    every character present in s2 should be present in s1
    with the same frequency. Worst case O(n^2)... amortized 
    O(n) could be improved to worst case O(nlogn) using balanced 
    binary search tree. We could create an array for max siZe number
    of characters too but would cause memory wastage...which could be evaluated
    based on the initial memory allocation for the dict in O(n). We could sort the 
    two strings leading to O(nlogn) worst case.
    """
    if len(s1) != len(s2):
        #must have the same number of chars
        return False

    #char frequency of s1
    s_1_dict = {}
    for s_i in s1:
        if s_i in s_1_dict:
            s_1_dict[s_i] += 1
        else:
            s_1_dict[s_i] = 1

    for s_i in s2:
        if s_i in s_1_dict:
            s_1_dict[s_i] -= 1
        else:
            return False

    #check if any key with non zero value exists 
    for s_i in s_1_dict.keys():
        if s_1_dict[s_i] != 0:
            return False

    return True

if __name__ == "__main__":
    s1, s2 = "hello", "olleh"
    res = check(s1, s2)
    print(res)