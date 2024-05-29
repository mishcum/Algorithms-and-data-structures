def horse(n, m, board, i, j):
    if 0 <= i < n and 0 <= j < m:
        if board[i][j] == -1:
            board[i][j] = (
                horse(n, m, board, i - 2, j + 1)
                + horse(n, m, board, i + 1, j - 2)
                + horse(n, m, board, i - 1, j - 2)
                + horse(n, m, board, i - 2, j - 1)
            )
    else:
        return 0
    return board[i][j]


def main():
    n, m = map(int, input().split())
    board = [[-1] * m for _ in range(n)]
    board[0][0] = 1
    print(horse(n, m, board, n - 1, m - 1))


if __name__ == "__main__":
    main()
