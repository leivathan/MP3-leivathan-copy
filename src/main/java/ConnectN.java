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
    public static final int MIN_N = 6;
    /**
     * Public game title. Could be used by toString().
     */
    public String title = "title";
    /**
     *
     */
    private int boardHeight = 0;
    /**
     *
     */
    private int boardWidth = 0;
    /**
     *
     */
    private int nValue = 0;

    /**
     * Create a new ConnectN board with uninitialized height, width, and N value.
     */
    ConnectN() {
    }
    /**
     * Create a new ConnectN board with given height and width and uninitialized N value.
     * @param setWidth The width for the new ConnectN board.
     * @param setHeight The height for the new ConnectN board.
     */
    ConnectN(final int setWidth, final int setHeight) {
        boardWidth = setWidth;
        boardHeight = setHeight;
        if (boardWidth > MAX_WIDTH || boardWidth < MIN_WIDTH) {
            this.boardWidth = 0;
        }
        if (boardHeight > MAX_HEIGHT || boardHeight < MIN_HEIGHT) {
            this.boardHeight = 0;
        }
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
//        if (setWidth > MAX_WIDTH || setWidth < MIN_WIDTH) {
//            this.boardWidth = setWidth;
//        }
//        if (setHeight <= MAX_HEIGHT || setHeight >= MIN_HEIGHT) {
//            this.boardHeight = setHeight;
//        }
        if (setN < MIN_N || setN > Math.max(boardHeight, boardWidth)) {
            nValue = 0;
        } else {
            nValue = setN;
        }
    }
    /**
     * Create a new connectN board with dimensions and N value copied from another board.
     * @param otherBoard the ConnectN board to copy width, height,and N from.
     */
    public ConnectN(final ConnectN otherBoard) {
        this.boardHeight = otherBoard.boardHeight;
        this.boardWidth = otherBoard.boardWidth;
        this.nValue = otherBoard.nValue;
    }
    /**
     *
     * @return the total number of games that have been created.
     */
    public static int getTotalGames() {
      return 0;
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
        if (setWidth <= MAX_WIDTH && setWidth >= MIN_WIDTH) {
            this.boardWidth = setWidth;
            if (nValue < MIN_N || nValue > Math.max(boardHeight, boardWidth)) {
                nValue = 0;
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
        if (setHeight <= MAX_HEIGHT && setHeight >= MIN_HEIGHT) {
            this.boardHeight = setHeight;
            if (nValue < MIN_N || nValue > Math.max(boardHeight, boardWidth)) {
                nValue = 0;
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
        if (newN >= MIN_N && newN < Math.min(boardHeight, boardWidth)) {
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
        return 0;
    }
    /**
     *
     * @param player the player attmepting the move
     * @param setX the X coordinate that they are trying to place a tile at
     * @param setY the Y coordinate that they are trying to place a tile at
     * @return true if the move succeeds, false on error
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {
        return true;
    }
    /**
     *
     * @param player the player attempting the move
     * @param setX the X coordinate for the stack that they are tring to drop a tile in
     * @return true if the move succeeds, false on error
     */
    public boolean setBoardAt(final Player player, final int setX) {
        return true;
    }
    /**
     *
     * @param getX the X coordinate to get the player at
     * @param getY the Y coordinate to get the player at
     * @return the player whose tile is at that position,
     * or null or error if nobody has played at that position
     */
    public Player getBoardAt(final int getX, final int getY) {
        return null;
    }
    /**
     *
     * @return a copy of the current board
     */
    public Player[][] getBoard() {
        return null;
    }
    /**
     * Return the winner of the game, or null if the game has not ended.
     * @return the winner of the game, or null if the game has not ended
     */
    public Player getWinner() {
        return null;
    }
    /**
     *
     * @param width the width of the new ConnectN instance to create
     * @param height the height of the new ConnectN instance to create
     * @param n the n value of the new ConnectN instance to create
     * @return the new ConnectN instance, or null if the parameters are invalid
     */
    public static ConnectN create(final int width, final int height, final int n) {
        return null;
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
        return null;
    }
    /**
     *
     * @param firstBoard the first ConnectN board to compare
     * @param secondBoard the second ConnectN board to compare
     * @return true if the boards are the same, false otherwise
     */
    public static boolean compareBoards(final ConnectN firstBoard, final ConnectN secondBoard) {
        return true;
    }
    /**
     *
     * @param boards the array of ConnectN boards to compare
     * @return true if all passed boards are the same, false otherwise
     */
    public static boolean compareBoards(final ConnectN... boards) {
        return true;
    }
    /**
     *
     * @return an integer
     */
    public final int hashCode() {
        return 0;
    }
    /**
     *
     * @param obj what am I doing
     * @return true or false
     */
    public boolean equals(final Object obj) {
        return true;
    }

}
