def rotate(data):
    """O(N^2) worst case.
    """
    n =len(data)

    for i in range(n//2):
        #swap top and right
        for j in range(i, n-i-1):
            #swap (0,0) with (0,4)
            temp = data[i][j]
            data[i][j] = data[j][n-i-1]
            data[j][n-i-1] = temp

            #swap (0,0) with (4,4)
            temp = data[n-i-1][n-1-j]
            data[n-i-1][n-1-j] = data[i][j]
            data[i][j] = temp

            #swap (0,0) with (4,0)
            temp = data[i][j]
            data[i][j] = data[n-1-j][i]
            data[n-1-j][i] = temp

    return data

if __name__ == "__main__":
    data = [[1, 2, 3, 4, 5],
            [6, 7, 8, 9, 10],
            [11, 12, 13, 14, 15],
            [16, 17, 18, 19, 20],
            [21, 22, 23, 24, 25]]

    for line in data:
        print(line)

    print()
    res = rotate(data)
    for line in res:
        print(line)