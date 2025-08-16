class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # Swap along the row from top and bottom moving towards each other
        top, bottom = 0, len(matrix) - 1
        while top < bottom:
            matrix[top], matrix[bottom] = matrix[bottom], matrix[top]
            top += 1
            bottom -= 1

        # Fix diagonal and swap elements on opposite sides with each other
        idx = 1
        while idx < len(matrix):
            i, j = idx, 0
            while i < len(matrix):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
                i += 1
                j += 1
            idx += 1
