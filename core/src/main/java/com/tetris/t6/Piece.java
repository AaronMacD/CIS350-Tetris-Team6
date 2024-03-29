package com.tetris.t6;

import com.badlogic.gdx.graphics.Color;
import java.awt.Point;
import java.util.Random;

/**
 * Piece Class.
 */
public final class Piece {
    /**
     * Dimensions for Piece(s).
     */
    private Point[][] dimensions;
    /**
     * Random Number Generator.
     */
    private final Random rand = new Random();
    /**
     *  Rotation of Piece; can be 0, 1, 2, or 3
     *  (Numbers are used to know how they are rotated).
     */
    private int rotationNum;
    /**
     * Row of top-left Square of a Piece.
     */
    private int row;
    /**
     * Column of top-left Square of a Piece.
     */
    private int col;
    /**
     * Color of Piece.
     */
    private Color color;

    /**
     * Constructor for Piece.
     */
    public Piece() {
        setRow(1);
        setCol(0);
        setRotationNum(0);
        generatePieceType();
    }

    /**
     * Parameterized constructor for Piece.
     * @param pieceType the type of the piece being created.
     */
    public Piece(final String pieceType) {
        setRow(1);
        setCol(0);
        setRotationNum(0);

        switch (pieceType) {
            case "J": makeJ();
                break;
            case "L": makeL();
                break;
            case "Line": makeLine();
                break;
            case "S": makeS();
                break;
            case "Square": makeSquare();
                break;
            case "T": makeT();
                break;
            default: makeZ();
                break;
        }
    }

    /**
     * Gets row.
     *
     * @return the current row of the piece.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Gets col.
     *
     * @return the current col of the piece.
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Gets color.
     *
     * @return the current color of piece.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Get dimensions point [ ] [ ].
     *
     * @return the dimensions of piece.
     */
    public Point[][] getDimensions() {
        return dimensions.clone();
    }

    /**
     * Gets rotation num.
     *
     * @return the current rotation of the piece.
     */
    public int getRotationNum() {
        return this.rotationNum;
    }

    /**
     * Sets row.
     *
     * @param aRow sets the row of the piece.
     */
    public void setRow(final int aRow) {
        if (aRow < 0 || aRow > PlayerLogic.ROWS - 1) {
            throw new IllegalArgumentException("Row must be >= 0 and <= 21");
        }
        this.row = aRow;
    }

    /**
     * Sets col.
     *
     * @param aCol sets the col of the piece.
     */
    public void setCol(final int aCol) {
        if (aCol < 0 || aCol > PlayerLogic.COLS - 1) {
            throw new IllegalArgumentException("Col must be >= 0 and <= 9");
        }
        this.col = aCol;
    }

    /**
     * Sets rotation num.
     *
     * @param rNum sets the rotationNum of the piece.
     */
    public void setRotationNum(final int rNum) {
        if (!(rNum == 0 || rNum == 1 || rNum == 2 || rNum == 3)) {
            throw new IllegalArgumentException("rotationNum must be "
                + "0, 1, 2, or 3");
        }

        this.rotationNum = rNum;
    }

    /**
     * Moves the piece left.
     */
    public void moveLeft() {
        col--;
    }

    /**
     * Moves the piece right.
     */
    public void moveRight() {
        col++;
    }

    /**
     * Moves the piece down.
     */
    public void moveDown() {
        row++;
    }

    /**
     * rNum  the current rotation number: 0, 1, 2, or 3.
     * direction 1 if clockwise, -1 if counterclockwise
     */
    private void generatePieceType() {
        final int num = rand.nextInt(7);

        //create new piece based on random number
        switch (num) {
            case 0: makeJ();
                break;
            case 1: makeL();
                break;
            case 2: makeLine();
                break;
            case 3: makeS();
                break;
            case 4: makeSquare();
                break;
            case 5: makeT();
                break;
            default: makeZ();
                break;
        }
    }

    /**
     * Makes the J piece. Point values are (rows from top-left square,
     * cols from top-left square)
     */
    private void makeJ() {
        //Point values are row, col for individual square of a piece
        dimensions = new Point[][] {
            //rotation 0
           {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(1, 2)},
            //rotation 1
           {new Point(0, 1), new Point(0, 2), new Point(1, 1), new Point(2, 1)},
            //rotation 2
           {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2)},
            //rotation 3
           {new Point(0, 1), new Point(1, 1), new Point(2, 0), new Point(2, 1)}
        };

        color = new Color(Color.BLUE);

    }
    /**
     * Makes the L piece. Point values are (rows from top-left square,
     * cols from top-left square)
     */
    private void makeL() {
        dimensions = new Point[][] {
            //rotation 0
           {new Point(0, 2), new Point(1, 0), new Point(1, 1), new Point(1, 2)},
            //rotation 1
           {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2)},
            //rotation 2
           {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0)},
            //rotation 3
           {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)}
        };

        color = new Color(Color.ORANGE);
    }
    /**
     * Makes the Line piece. Point values are (rows from top-left square,
     * cols from top-left square)
     */
    private void makeLine() {
        dimensions = new Point[][] {
            //rotation 0
           {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)},
            //rotation 1
           {new Point(0, 2), new Point(1, 2), new Point(2, 2), new Point(3, 2)},
            //rotation 2
           {new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(2, 3)},
            //rotation 3
           {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)}
        };

        color = new Color(Color.CYAN);
    }

    /**
     * Makes the S piece. Point values are (rows from top-left square,
     * cols from top-left square)
     */
    private void makeS() {
        dimensions = new Point[][] {
            //rotation 0
           {new Point(0, 1), new Point(0, 2), new Point(1, 0), new Point(1, 1)},
            //rotation 1
           {new Point(0, 1), new Point(1, 1), new Point(1, 2), new Point(2, 2)},
            //rotation 2
           {new Point(1, 1), new Point(1, 2), new Point(2, 0), new Point(2, 1)},
            //rotation 3
           {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)}
        };

        color = new Color(Color.GREEN);
    }

    /**
     * Makes the Square piece. Point values are (rows from top-left square,
     * cols from top-left square)
     */
    private void makeSquare() {
        //still represented as 4x4 2D array for convenience
        dimensions = new Point[][] {
            //rotation 0
           {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
            //rotation 1
           {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
            //rotation 2
           {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
            //rotation 3
           {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)}
        };

        color = new Color(Color.YELLOW);
    }

    /**
     * Makes the T piece. Point values are (rows from top-left square,
     * cols from top-left square)
     */
    private void makeT() {
        dimensions = new Point[][] {
            //rotation 0
           {new Point(0, 1), new Point(1, 0), new Point(1, 1), new Point(1, 2)},
            //rotation 1
           {new Point(0, 1), new Point(1, 1), new Point(1, 2), new Point(2, 1)},
            //rotation 2
           {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 1)},
            //rotation 3
           {new Point(0, 1), new Point(1, 0), new Point(1, 1), new Point(2, 1)}
        };

        color = new Color(Color.PURPLE);
    }

    /**
     * Makes the Z piece. Point values are (rows from top-left square,
     * cols from top-left square)
     */
    private void makeZ() {
        dimensions = new Point[][] {
            //rotation 0
           {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
            //rotation 1
           {new Point(0, 2), new Point(1, 1), new Point(1, 2), new Point(2, 1)},
            //rotation 2
           {new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(2, 2)},
            //rotation 3
           {new Point(0, 1), new Point(1, 0), new Point(1, 1), new Point(2, 0)}
        };

        color = new Color(Color.RED);
    }
}
