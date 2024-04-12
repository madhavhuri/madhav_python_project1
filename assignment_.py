import random

def create_board(rows, cols, num_mines):
    board = [[' ' for _ in range(cols)] for _ in range(rows)]
    mine_positions = set()
    while len(mine_positions) < num_mines:
        row = random.randint(0, rows - 1)
        col = random.randint(0, cols - 1)
        mine_positions.add((row, col))
        board[row][col] = '*'
    return board, mine_positions

def print_board(board):
    for row in board:
        print(' '.join(row))

def count_adjacent_mines(board, row, col):
    count = 0
    for r in range(max(0, row - 1), min(len(board), row + 2)):
        for c in range(max(0, col - 1), min(len(board[0]), col + 2)):
            if (r, c) != (row, col) and board[r][c] == '*':
                count += 1
    return count

def main():
    rows = 5
    cols = 5
    num_mines = 3
    board, mine_positions = create_board(rows, cols, num_mines)
    print("Welcome to Minesweeper!")
    print_board(board)
    while True:
        row = int(input("Enter row: "))
        col = int(input("Enter col: "))
        if (row, col) in mine_positions:
            print("Game Over! You hit a mine.")
            print_board(board)
            break
        else:
            num_adjacent_mines = count_adjacent_mines(board, row, col)
            board[row][col] = str(num_adjacent_mines)
            print_board(board)
            if all(board[i][j] != ' ' for i in range(rows) for j in range(cols)):
                print("Congratulations! You've won!")
                break

if __name__ == "__main__":
    main()