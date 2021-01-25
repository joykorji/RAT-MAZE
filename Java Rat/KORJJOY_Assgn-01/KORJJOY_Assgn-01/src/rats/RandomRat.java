package rats;
/**
 * Type of Rat that only ever moves randomly ( very dumb )
 * @author DV
 *
 */
public class RandomRat extends Rat{
	/**
	 * Unique constructor that specifies Name and Letter
	 */
	public RandomRat(){
		super();
		mName="Elki";
		mLetter='E';
	}
	/**
	 * Simple Move Method that determines the next move for the Rat. This is chosen completely randomly.
	 * @param maz Maze the Rat is currently exploring
	 */
	public void move(Maze maz) {
		LookForPossibleMoves(maz);
		EnactMove(mPossibleMoves.get((int)(Math.random()*mPossibleMoves.size())));	
		
	}
	

}
