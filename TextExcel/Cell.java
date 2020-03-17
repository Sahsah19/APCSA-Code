//*******************************************************
// DO NOT MODIFY THIS FILE!!!
//*******************************************************

public interface Cell {
   public static final int CELLWIDTH = 10;   // class constant for cell width

	public String abbreviatedCellText();  // text for spreadsheet cell display, must be exactly length 10
	public String fullCellText();         // text for individual cell inspection, not truncated or padded
}