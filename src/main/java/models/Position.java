package models;

public class Position {
	//Generic Positions
	private int rowPosition;
	private int columnPostion;

	public Position() {

	}

	public Position(int rowPosition, int columnPostion) {
		super();
		this.rowPosition = rowPosition;
		this.columnPostion = columnPostion;
	}

	public int getRowPosition() {
		return rowPosition;
	}

	public void setRowPosition(int rowPosition) {
		this.rowPosition = rowPosition;
	}

	public int getColumnPostion() {
		return columnPostion;
	}

	public void setColumnPostion(int columnPostion) {
		this.columnPostion = columnPostion;
	}

}
