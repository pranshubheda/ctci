"""check if there exists a permutation of the 
given string such that it is a palindrome.
"""

def check(s1):
    """For a palindrome with even length we must have an
    even multiple of each character, or for an odd palindrome we
    must have exactly one character with an odd frequency. Our runtime
    complexity is O(n) for the worst case with space O(128).
    """
    chars = [0] * 128
    for c in s1:
        chars[ord(c)]+=1

    counter = 0
    for i in range(len(chars)):
        if chars[i] %2 != 0:
            counter+=1
    
    return counter <= 1

if __name__ == "__main__":
    s1 = "nitin"
    res = check(s1)
    print(res)