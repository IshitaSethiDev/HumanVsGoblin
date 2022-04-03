package models;

public class Human {
	//Default Human Position
	private int rowPosition;
	private int columnPosition;
	private int health;

	public Human() {

	}

	public Human(int rowPosition, int columnPosition, int health) {
		super();
		this.rowPosition = rowPosition;
		this.columnPosition = columnPosition;
		this.health = health;
	}

	public int getRowPosition() {
		return rowPosition;
	}

	public void setRowPosition(int rowPosition) {
		this.rowPosition = rowPosition;
	}

	public int getColumnPosition() {
		return columnPosition;
	}

	public void setColumnPosition(int columnPosition) {
		this.columnPosition = columnPosition;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
