"""mark all element in the row and column as zero 
where zero is present in the matrix. O(MxN)
"""

def replace(data):
    row = [False] * len(data)
    column = [False] * len(data[0])
    for i in range(len(row)):
        for j in range(len(column)):
            if data[i][j] == 0:
                row[i] = True
                column[i] = True
    
    for i in range(len(row)):
        if row[i]:
            data[i] = [0]*len(column)
    
    for j in range(len(column)):
        if column[j]:
            for i in range(len(row)):
                data[i][j] = 0

    return data
if __name__ == "__main__":
    data = [[1, 2, 3, 4, 0],
            [6, 0, 8, 9, 10],
            [11, 12, 13, 14, 15],
            [16, 0, 18, 19, 20],
            [21, 22, 23, 24, 25]]
    
    for d in data:
        print(d)

    print()
    
    data =replace(data)

    for d in data:
        print(d)