package rats;
import java.util.*;
/**
 * This is the abstract class Rat which can be used to move around a Maze
 * 
 *
 */
public abstract class Rat implements Animal {
	protected int mColumn=0;
	protected int mRow=0;
	private int mStartColumn=0;
	private int mStartRow=0;
	protected char mLetter=' ';
	protected String mName=null; 
	protected ArrayList<Move> mMoves=new ArrayList<Move>();
	protected ArrayList<Move> mAllMoves=new ArrayList<Move>();
	protected ArrayList<Move> mPossibleMoves=new ArrayList<Move>();
	/**
	 * Constructor that sets everything to zero and null
	 */
	public Rat(){
		mColumn=0;
		mRow=0;
		mName=null;
		mLetter=' ';
		mMoves.clear();
		mPossibleMoves.clear();
	}
	/**
	 * Method that returns the value of the Rat Column coordinate
	 * @return Rat Column coordinate
	 */
	public int getColumn() {
		return mColumn;
	}
	/**
	 * Method that returns the value of the Rat's identifying letter
	 * @return Rat's identifying Letter
	 */
	public char getLetter() {
		return mLetter;
	}
	/**
	 * Method that returns the Name of the Rat
	 * @return Rat's Name
	 */
	public String getName() {
		return mName;
	}
	/**
	 * Method that reutns the number of moves the Rat has taken.
	 * @return number of moves the rat has taken
	 */
	public int getNumMoves() {
		return mAllMoves.size();
	}
	/**
	 * Method that returns the value of the Rat's Row coordinate.
	 * @return Rat's Row coordinate
	 */
	public int getRow() {
		return mRow;
	}
	/**
	 * Method that returns the value of the Rat's starting column coordinate.
	 * @return Starting Column coordinate value
	 */
	public int getStartColumn() {
		return mStartColumn;
	}
	/**
	 * Method that returns the value of the Rat's starting Row coordinate.
	 * @return Starting Row coordinate value
	 */
	public int getStartRow() {
		return mStartRow;
	}
	/**
	 * This method will be over-written in child classes and will make the Rat move around the Maze
	 * @param maz The Maze the Rat is moving in
	 */
	public abstract void move(Maze maz);
	/**
	 * Restarts the Rat's position and all its memory
	 */
	public void reset() {
		mColumn=mStartColumn;
		mRow=mStartRow;
		mMoves.clear();
		mAllMoves.clear();
		mPossibleMoves.clear();
	}
	/**
	 * Method to set the Starting column coordinate of the Rat
	 * @param col Starting column of the Rat
	 */
	public void setStartColumn(int col) {
		mStartColumn=col;
		
	}
	/**
	 * Method to set the Starting row coordinate of the Rat
	 * @param row Starting row of the Rat
	 */
	public void setStartRow(int row) {
		mStartRow=row;
	}
	/**
	 * Method fills mPossibleMoves with the possible locations the rat can move to
	 * @param maz the Maze the Rat is currently in
	 */
	protected void LookForPossibleMoves(Maze maz){	
		mPossibleMoves.clear();
		try{
			if(maz.getSquare(mRow, mColumn+1) != Maze.WALL){
				mPossibleMoves.add(new Move(new int[]{mRow,mColumn+1}));//right
			}
		}
		catch(IndexOutOfBoundsException e){			
		}
		try{
			if(maz.getSquare(mRow+1, mColumn) != Maze.WALL){
				mPossibleMoves.add(new Move(new int[]{mRow+1,mColumn}));//up
			}
		}
		catch(IndexOutOfBoundsException e){			
		}
		try{			
			if(maz.getSquare(mRow, mColumn-1)!=Maze.WALL){
				mPossibleMoves.add(new Move(new int[]{mRow,mColumn-1}));//left
			}
		}
		catch(IndexOutOfBoundsException e){			
		}
		try{
			if(maz.getSquare(mRow-1, mColumn)!=Maze.WALL)
				mPossibleMoves.add(new Move(new int[]{mRow-1,mColumn}));//down
		}
		catch(IndexOutOfBoundsException e){			
		}
		
				
		try{			
			if(maz.getSquare(mRow, mColumn)==Maze.FINISH){
				mPossibleMoves.clear();// do not let the rat move if it is at the finish
			}
		}
		catch(IndexOutOfBoundsException e){			
		}
	}
	/**
	 * Method that adds new moves to the Rat's memory, as well as moves the rat to its new location
	 * @param m the Move the Rat has determined to take
	 */
	protected void EnactMove(Move m){
		//System.out.println(m);
		if(!mMoves.contains(new Move(new int[]{mRow,mColumn})))
			mMoves.add(new Move(new int[]{mRow,mColumn}));
		mAllMoves.add(new Move(new int[]{mRow,mColumn}));		
		mRow=m.getOrigin()[0];
		mColumn=m.getOrigin()[1];
	}
	/**
	 * This class is a container class for a int[]'s which specify moves taken or moves that are possible to take.
	 * 
	 *
	 */
	protected class Move{
		/**
		 * Main variable
		 */
		private int[] origin;
		/**
		 * default constructor
		 */
		public Move(){};
		/**
		 * Main constructor
		 * @param ori the location of the Rat wishes to move, or the location from which the Rat has moved form
		 */
		public Move(int[] ori){
			origin=new int[]{ori[0],ori[1]};
		}
		/**
		 * Copy constructor
		 * @param m the Move object to copy
		 */
		public Move(Move m){
			this(m.getOrigin());
		}
		/**
		 * Method to return the Location of the origin of this Move
		 * @return This move's location
		 */
		public int[] getOrigin(){
			return origin;
		}
		/**
		 * Overwritten hashCode() from Object
		 * @return unique int for this Move
		 */
		public int hashCode(){
			return origin[0]*100000+origin[1];
		}
		/**
		 * Overwritten equals() method from Object. This is used by contain() to determine if ArrayList contains a given Move
		 * @return boolean of the equality of the passed Move
		 */
		public boolean equals(Object otherMove){
			return this.hashCode()==otherMove.hashCode();
		}
		/**Method to describe the Move in the form of a String.
		 * @return String describing the Move
		 */
		public String toString(){
			return origin[0]+" "+origin[1];
		}
	}
	
}

