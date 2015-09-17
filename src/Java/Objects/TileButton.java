package Java.Objects;

import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * Created by anthonybonitatibus on 9/17/15.
 */
public class TileButton extends Button {

    private int row;
    private int col;
    private Player owner;

    public TileButton() {
        super();
    }

    public int getRow() { return row; }

    public void setRow(int row) { this.row = row; }

    public int getCol() { return col; }

    public void setCol(int col) { this.col = col; }

    public Player getOwner() { return owner; }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isOwned() {
        return owner != null;
    }
}
