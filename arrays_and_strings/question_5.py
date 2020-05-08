import unittest

def check(s1, s2):
    """Worst and best case O(max(len(s1), len(s2)).and Space
    O(128). This will validate for any permutation of s2 i.e with additional
    allowed operation of unlimited swapping. This program can be made
    more constrained by including restriction on number of swappings.
    """
    count = abs(len(s1) - len(s2))
    chars = [0]*128

    if count > 1:
        return False

    for c in s1:
        chars[ord(c)]+=1

    for c in s2:
        chars[ord(c)]-=1

    for i in range(len(chars)):
        if chars[i] != 0:
            count+=1
    
    return count <= 2

def check_no_permutation(s1, s2):
    """Memory efficient O(1) and O(min(len(s1), len(s2)) worst case
    run time.
    """
    m, n = len(s1), len(s2)

    if abs(m-n) > 1:
        return False

    count = 0
    i, j = 0, 0
    while i<m and j<n:
        if count > 1:
            return False
        if s1[i] != s2[j]:
            if m==n:
                i+=1
                j+=1
            elif m<n:
                j+=1
            else:
                i+=1
            count+=1
        else:
            i+=1
            j+=1

    count += abs(i-m)
    count += abs(j-n)
        
    return count <= 1

class Test(unittest.TestCase):
    data = [
        ('pale', 'ple', True),
        ('pales', 'pale', True),
        ('paleabc', 'pleabc', True),
        ('pale', 'ble', False),
        ('a', 'b', True),
        ('', 'd', True),
        ('d', 'de', True),
        ('pale', 'pale', True),
        ('pale', 'ple', True),
        ('ple', 'pale', True),
        ('pale', 'bale', True),
        ('pale', 'bake', False),
        ('pale', 'pse', False),
        ('ples', 'pales', True),
        ('pale', 'pas', False),
        ('pas', 'pale', False),
        ('pale', 'pkle', True),
        ('pkle', 'pable', False),
        ('pal', 'palks', False),
        ('palks', 'pal', False)
    ]    

    def test_one_away(self):
        for [test_s1, test_s2, expected] in self.data:
            actual = check_no_permutation(test_s1, test_s2)
            print('{}, {}'.format(test_s1, test_s2))
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    # s1, s2 = 'pales', 'bales'
    # res = check(s1, s2)
    # print(res)
    unittest.main()