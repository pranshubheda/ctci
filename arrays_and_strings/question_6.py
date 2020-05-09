def compress(s1):
    """Run time complexity is O(n) since 
    we solve this problem using DP. Space complexity
    is O(1).
    """
    counter = [1] * len(s1)
    i = len(s1)-2
    compressed = []
    while i >= 0:
        if s1[i] == s1[i+1]:
            counter[i] = counter[i+1] + 1
        else:
            compressed.insert(0, s1[i+1]+str(counter[i+1]))
        i-=1
    compressed.insert(0, s1[0]+str(counter[0]))
    compressed_string = ''.join([x for x in compressed])
    return compressed_string if len(compressed_string) < len(s1) else s1

if __name__ == "__main__":
    s1 = "aabcccccaaa"
    res = compress(s1)
    print(res)