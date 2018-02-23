

/**
 * <p>A class that implements a Connect4-like game.
 * </p>
 */
public class ConnectN {
    /**
     * Maximum board height is 16.
     */
    public static final int MAX_HEIGHT = 16;
    /**
     * Maximum board width is 16.
     */
    public static final int MAX_WIDTH = 16;
    /**
     * Minimum board height is 6.
     */
    public static final int MIN_HEIGHT = 6;
    /**
     * Minimum board width is 6.
     */
    public static final int MIN_WIDTH = 6;
    /**
     * Minimum board N value is 4.
     */
    public static final int MIN_N = 4;
    /**
     * Public game title. Could be used by toString().
     */
    public String title;
    /**
     * Height of the board.
     */
    private int boardHeight = 0;
    /**
     * Width of the board.
     */
    private int boardWidth = 0;
    /**
     * Number of consecutive tiles that need to be placed in order to win the game.
     */
    private int nValue = 0;
    /**
     * Number of  games played.
     */
    private static int gameCount = 0;
    /**
     * The id of the game.
     */
    private int id = 0;
    /**
     * The board on which to play.
     */
    private Player[][] board;
    /**
     * Has it started?
     */
    private boolean isStart;
    /**
     * Has it ended?
     */
    private boolean isOver;
    /**
     * The winner.
     */
    private Player winner;

    /**
     * Create a new ConnectN board with uninitialized height, width, and N value.
     */
    ConnectN() {
        this.id = gameCount;
        gameCount++;
        isStart = false;
    }
    /**
     * Create a new ConnectN board with given height and width and uninitialized N value.
     * @param setWidth The width for the new ConnectN board.
     * @param setHeight The height for the new ConnectN board.
     */
    ConnectN(final int setWidth, final int setHeight) {
        if (setWidth <= MAX_WIDTH && setWidth >= MIN_WIDTH) {
            this.boardWidth = setWidth;

        } else {
            this.boardWidth = 0;
        }
        if (setHeight <= MAX_HEIGHT && setHeight >= MIN_HEIGHT) {
            this.boardHeight = setHeight;
        } else {
            this.boardHeight = 0;
        }
        board = new Player[this.boardWidth][this.boardHeight];
        this.id = gameCount;
        gameCount++;
        isStart = false;
    }
    /**
     * Creates a new connectN board with a given height, width, and N value.
     *<p> Note that this method should not reject invalid values.
     * Constructors must return a new object, or throw an exception,
     * so there is no way for you to reject bad parameters yet.
     * Instead, attempts to set the width, height,
     * or N value to invalid value should lead to them being uninitialized.</p>
     *<p>For example, new ConnectN(1, 10, 4) should return a ConnectN game with width=0, height=10,
     * and N=0, since 1 is an invalid width (too small) and
     * N cannot be set until the width is defined.</p>
     *<p>Each call to any ConnectN constructor should also track
     * the total number of games that have been created,
     * which can be retrieved by getTotalGames().
     * Each board should also receive a unique ID equal to the number of games minus 1.
     * So the first board gets 0, etc.
     *  This should be returned by getID().</p>
     * @param setWidth The width for the new ConnectN board.
     * @param setHeight The height for the new ConnectN board.
     * @param setN The N value for the new ConnectN board.
     */
    public ConnectN(final int setWidth, final int setHeight, final int setN) {
        this(setWidth, setHeight);
        if (setN < MIN_N || setN >= Math.max(boardHeight, boardWidth)
                || this.boardWidth == 0 || this.boardHeight == 0) {
            nValue = 0;
        } else {
            nValue = setN;
        }
        board = new Player[this.boardWidth][this.boardHeight];
        isStart = false;
    }
    /**
     * Create a new connectN board with dimensions and N value copied from another board.
     * @param otherBoard the ConnectN board to copy width, height,and N from.
     */
    public ConnectN(final ConnectN otherBoard) {
        this.boardHeight = otherBoard.boardHeight;
        this.boardWidth = otherBoard.boardWidth;
        this.nValue = otherBoard.nValue;
        board = new Player[this.boardWidth][this.boardHeight];
        this.id = gameCount;
        gameCount++;
        isStart = false;
    }
    /**
     * Sets the title.
     * @param name the title to be set
     */
    public void setTitle(final String name) {
        this.title = name;
    }

    /**
     * Returns the title.
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }
    /**
     *
     * @return the total number of games that have been created.
     */
    public static int getTotalGames() {
      return gameCount;
    }

    /**
     * Get the current board width.
     * @return the current board width
     */
    public int getWidth() {
        return this.boardWidth;
    }
    /**
     *
     * @param setWidth the new width to set
     * @return true if the width was set successfully, false on error.
     */
    public boolean setWidth(final int setWidth) {
        if (setWidth <= MAX_WIDTH && setWidth >= MIN_WIDTH && !isStart) {
            this.boardWidth = setWidth;
            if (nValue < MIN_N || nValue >= Math.max(boardHeight, boardWidth)) {
                nValue = 0;
            }
            if (boardHeight >= MIN_HEIGHT && boardHeight <= MAX_HEIGHT) {
                board = new Player[boardWidth][boardHeight];
            }
            return true;
        } else {
            return false;
        }
    }
    /**
     * Get the current board height.
     * @return the current board height
     */
    public int getHeight() {
        return this.boardHeight;
    }
    /**
     * Attempt to set the board height.
     * <p>Fails if the height is invalid, or if the game has already started.</p>
     * @param setHeight the new height to set
     * @return true if the height was set successfully, false on error
     */
    public boolean setHeight(final int setHeight) {
        if (setHeight <= MAX_HEIGHT && setHeight >= MIN_HEIGHT && !isStart) {
            this.boardHeight = setHeight;
            if (nValue < MIN_N || nValue >= Math.max(boardHeight, boardWidth)) {
                nValue = 0;
            }
            if (boardWidth >= MIN_WIDTH && boardWidth <= MAX_WIDTH) {
                board = new Player[boardWidth][boardHeight];
            }
            return true;
        } else {
            return false;
        }
    }
    /**
     * Get the current board N value.
     * @return the current board N value.
     */
    public int getN() {
        return this.nValue;
    }
    /**
     * Attempt to set the current board N value.
     * @param newN the new N
     * @return true, if successful
     */
    public boolean setN(final int newN) {
        if (newN >= MIN_N && newN < Math.max(boardHeight, boardWidth)
                && boardHeight != 0 && boardWidth != 0 && !isStart) {
            nValue = newN;
            return true;
        } else {
            return false;
        }
    }
    /**
     * Get the current board's id.
     * @return the current board's id
     */
    public int getID() {
        return this.id;
    }
    /**
     *
     * @param player the player attempting the move
     * @param setX the X coordinate that they are trying to place a tile at
     * @param setY the Y coordinate that they are trying to place a tile at
     * @return true if the move succeeds, false on error
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {
        int countHorizontal = 1;
        int countVertical = 1;
        if (setY >= this.boardHeight || setY < 0 || setX >= this.boardWidth || setX < 0
                || this.board[setX][setY] != null || player == null) {
            return false;
        }
        if (setY == 0) {
            if (this.board[setX][0] == null) {
                isStart = true;
                this.board[setX][0] = player;
                for (int k = 0; k < this.boardHeight - 1; k++) {
                    if (this.board[setX][k] == null) {
                        countVertical = 1;
                        continue;
                    }
                    if (this.board[setX][k] == this.board[setX][k + 1]) {
                        countVertical++;
                    } else {
                        countVertical = 1;
                    }
                    if (countVertical == nValue) {
                        winner = player;
                        winner.addScore();
                        isOver = true;
                    }
                }
                for (int k = 0; k < this.boardWidth - 1; k++) {
                    if (this.board[k][setY] == null) {
                        countHorizontal = 1;
                        continue;
                    }
                    if (this.board[k][setY] == this.board[k + 1][setY]) {
                        countHorizontal++;
                    } else {
                        countHorizontal = 1;
                    }
                    if (countHorizontal == nValue) {
                        winner = player;
                        winner.addScore();
                        isOver = true;
                    }
                }
                return true;
            }
        }
        if (this.board[setX][setY - 1] == null) {
            return false;
        }
        isStart = true;
        this.board[setX][setY] = player;
        for (int k = 0; k < this.boardHeight - 1; k++) {
            if (this.board[setX][k] == null) {
                countVertical = 1;
                continue;
            }
            if (this.board[setX][k] == this.board[setX][k + 1]) {
                countVertical++;
            } else {
                countVertical = 1;
            }
            if (countVertical == nValue) {
                winner = player;
                winner.addScore();
                isOver = true;
            }
        }
        for (int k = 0; k < this.boardWidth - 1; k++) {
            if (this.board[k][setY] == null) {
                countHorizontal = 1;
                continue;
            }
            if (this.board[k][setY] == this.board[k + 1][setY]) {
                countHorizontal++;
            } else {
                countHorizontal = 1;
            }
            if (countHorizontal == nValue) {
                winner = player;
                winner.addScore();
                isOver = true;
            }
        }
        return true;
    }
    /**
     *
     * @param player the player attempting the move
     * @param setX the X coordinate for the stack that they are tring to drop a tile in
     * @return true if the move succeeds, false on error
     */
    public boolean setBoardAt(final Player player, final int setX) {
        if (this.boardHeight != 0 && this.boardWidth != 0 && this.getWinner() == null
                && setX <= boardWidth && setX >= 0) {
            for (int i = 0; i < this.boardHeight; i++) {
                if (board[setX][i] == null) {
                    board[setX][i] = player;
                    isStart = true;
                    int finalY = i;
                    int countHorizontal = 1;
                    int countVertical = 1;
                    for (int k = 0; k < this.boardHeight - 1; k++) {
                        if (this.board[setX][k] == null) {
                            countVertical = 1;
                            continue;
                        }
                        if (this.board[setX][k] == this.board[setX][k + 1]) {
                            countVertical++;
                        } else {
                            countVertical = 1;
                        }
                        if (countVertical == nValue) {
                            winner = player;
                            winner.addScore();
                            isOver = true;
                        }
                    }
                    for (int k = 0; k < this.boardWidth - 1; k++) {
                        if (this.board[k][finalY] == null) {
                            countHorizontal = 1;
                            continue;
                        }
                        if (this.board[k][finalY] == this.board[k + 1][finalY]) {
                            countHorizontal++;
                        } else {
                            countHorizontal = 1;
                        }
                        if (countHorizontal == nValue) {
                            winner = player;
                            winner.addScore();
                            isOver = true;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
    /**
     *
     * @param getX the X coordinate to get the player at
     * @param getY the Y coordinate to get the player at
     * @return the player whose tile is at that position,
     * or null or error if nobody has played at that position
     */
    public Player getBoardAt(final int getX, final int getY) {
        if (getX >= this.boardWidth || getX < 0 || getY >= this.boardHeight
                || getY < 0 || !isStart || board[getX][getY] == null
                || boardWidth == 0 || boardHeight == 0) {
            return null;
        } else {
            return board[getX][getY];
        }
    }
    /**
     *
     * @return a copy of the current board
     */
    public Player[][] getBoard() {
        if (this.board == null) {
            return null;
        }
        Player[][] copy = new Player[boardWidth][boardHeight];
        if (this.boardWidth == 0 || this.boardHeight == 0
                || this.boardHeight < MIN_HEIGHT || this.boardWidth < MIN_WIDTH) {
            return null;
        } else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == null) {
                        copy[i][j] = null;
                    } else {
                        copy[i][j] = new Player(board[i][j]);
                    }
                }
            }
//            for (int i = 0; i < this.boardWidth; i++) {
//                for (int j = 0; j < this.boardHeight; j++) {
//                    copy[i][j] = this.board[i][j];
//                }
//            }
            return copy;
        }
    }
    /**
     * Return the winner of the game, or null if the game has not ended.
     * @return the winner of the game, or null if the game has not ended
     */
    public Player getWinner() {
//        int countHorizontal = 1;
//        int countVertical = 1;
//        for (int i = 0; i < this.boardWidth; i++) {
//            for (int j = 0; j < this.boardHeight - 1; j++) {
//                if (this.board[i][j] == this.board[i][j + 1]) {
//                    countVertical++;
//                } else {
//                    countVertical = 1;
//                }
//                if (countVertical == nValue) {
//                    return this.board[i][j];
//                }
//            }
//        }
//        for (int j = 0; j < this.boardHeight; j++) {
//            for (int i = 0; i < this.boardWidth - 1; i++) {
//                if (this.board[i][j] == this.board[i + 1][j]) {
//                    countHorizontal++;
//                } else {
//                    countHorizontal = 1;
//                }
//                if (countHorizontal == nValue) {
//                    return this.board[i][j];
//                }
//            }
//        }
//        return null;
        return winner;
    }
    /**
     *
     * @param width the width of the new ConnectN instance to create
     * @param height the height of the new ConnectN instance to create
     * @param n the n value of the new ConnectN instance to create
     * @return the new ConnectN instance, or null if the parameters are invalid
     */
    public static ConnectN create(final int width, final int height, final int n) {
        ConnectN dad;
        if (width > MAX_WIDTH || width < MIN_WIDTH || height > MAX_HEIGHT
                || height < MIN_HEIGHT || n < MIN_N || n >= Math.max(height, width)) {
            return null;
        } else {
            dad = new ConnectN(width, height, n);
        }
        return dad;
    }
    /**
     *
     * @param number the number of new ConnectN instances to create
     * @param width the width of the new ConnectN instance to create
     * @param height the height of the new ConnectN instance to create
     * @param n the n value of the new ConnectN instance to create
     * @return an array of new ConnectN instances, or null if the parameters are invalid
     */
    public static ConnectN[] createMany(final int number, final int width,
                                        final int height, final int n) {
        ConnectN[] arrayArmada = new ConnectN[number];
        if (width > MAX_WIDTH || width < MIN_WIDTH && height > MAX_HEIGHT
                || height < MIN_HEIGHT && n < MIN_N || n >= Math.max(height, width)) {
            return null;
        } else {
            for (int i = 0; i < number; i++) {
                ConnectN mom = new ConnectN(width, height, n);
                arrayArmada[i] = mom;
            }
        }
        return arrayArmada;
    }
    /**
     *
     * @param firstBoard the first ConnectN board to compare
     * @param secondBoard the second ConnectN board to compare
     * @return true if the boards are the same, false otherwise
     */
    public static boolean compareBoards(final ConnectN firstBoard, final ConnectN secondBoard) {
        boolean isSame = false;
        if (firstBoard == null || secondBoard == null
                || firstBoard.getN() != secondBoard.getN()
                || firstBoard.getHeight() != secondBoard.getHeight()
                || firstBoard.getWidth() != secondBoard.getWidth()) {
            return false;
        }
        if (firstBoard.getBoard() == null && secondBoard.getBoard() == null) {
            return true;
        }
        if (firstBoard.boardHeight == secondBoard.boardHeight
                && firstBoard.boardWidth == secondBoard.boardWidth
                && firstBoard.nValue == secondBoard.nValue) {
            for (int i = 0; i < firstBoard.boardWidth; i++) {
                for (int j = 0; j < firstBoard.boardHeight; j++) {
                    if (firstBoard.board[i][j] == secondBoard.board[i][j]) {
                        isSame = true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return isSame;
    }
    /**
     *
     * @param boards the array of ConnectN boards to compare
     * @return true if all passed boards are the same, false otherwise
     */
    public static boolean compareBoards(final ConnectN... boards) {
//        boolean isSame = false;
//        if (boards.length == 0) {
//            return true;
//        }
//        for (int i = 0; i < boards.length - 1; i++) {
//            if (ConnectN.compareBoards(boards[i], boards[i + 1])) {
//                isSame = true;
//            } else {
//                return false;
//            }
//        }
//        return isSame;
        for (int i = 1; i < boards.length; i++) {
            if (boards[i] == null || boards[i - 1] == null
                    || boards[i].getHeight() != boards[i - 1].getHeight()
                    || boards[i].getWidth() != boards[i - 1].getWidth()
                    || boards[i].getN() != boards[i - 1].getN()) {
                return false;
            }
        }
        return true;
    }

//    /**
//     *
//     * @param o object
//     * @return a boolean
//     */
//    @Override
//    public boolean equals(final Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof ConnectN)) {
//            return false;
//        }
//        ConnectN connectN = (ConnectN) o;
//        return !(boardHeight == connectN.boardHeight
//                && boardWidth == connectN.boardWidth
//                && nValue == connectN.nValue
//                && id == connectN.id
//                && Objects.equals(title, connectN.title)
//                && Arrays.equals(getBoard(), connectN.getBoard()));
//    }
//
//    /**
//     *
//     * @return an int
//     */
//    @Override
//    public int hashCode() {
//        return Objects.hash(getHeight(), id, getN(), getWidth(), getTitle());
//    }
}
