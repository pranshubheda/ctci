"""Check if string has all unique characters
"""

def check(s):
    """run time of this method is O(n) in the worst 
    case and amortized time O(1). We can run the program in 
    O(log n) worst case by implementing the hash function
    using a balanced binary search tree.
    """
    unique_chars_set = set()
    for s_i in s:
        if s_i in unique_chars_set:
            return False
        else:
            unique_chars_set.add(s_i)
    return True

if __name__ == "__main__":
    s = "hello"
    res = check(s)
    print(res)