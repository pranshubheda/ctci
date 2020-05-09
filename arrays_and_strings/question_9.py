"""Find all occurences of s2 in s1. O(max(len(s1), len(s2)))
run time.
"""

def lps(s2):
    """pre-process the pattern to find the 
    longest substring for each index in pattern
    s2 where prefix equals substring.
    """
    lps_arr = [0]*len(s2)
    for i in range(1, len(s2)):
        if s2[i] == s2[lps_arr[i-1]]:
            lps_arr[i] = lps_arr[i-1] + 1
    return lps_arr

def find(s1, s2):
    """use the lps array to reduce unnecessary
    comparisons.
    """
    lps_arr = lps(s2)
    found = []
    i, j = 0, 0
    while i<len(s1):
        if s1[i] == s2[j]:
            #characters match so increment
            #pattern and string.
            i+=1
            j+=1
        else:
            #no match
            if j>0:
                #degenerate to the lps index of previous character
                #in pattern
                j=lps_arr[j-1]
            else:
                #failure at first character in pattern
                #just move forward to next char in string
                i+=1
        if j == len(s2):
            #reached end of pattern indicating match found
            found.append(i-j)
            #move the pattern back by the lps value of last character
            i-=lps_arr[-1]
            #move the pattern back to first character
            j=0

    return found

if __name__ == "__main__":
    s1 = "abacaaabababababa"
    s2 = "ababa"
    res = find(s1, s2)
    print(res)