package rats;

import java.util.HashSet;
import java.util.Stack;


/**
 * this class create a rat that have unnatural super power
 * ( like disappearing and jumping from place to another ) 
 * but he doesn't use this super power in the smartest way(but he's smart enough for this assignment) (( hopefully :) )) 
 * @author Joy Korji  
 */
public class SuperRato extends Rat {
	/**hashset will include all the moves we already did */
	HashSet<Move> hash = new HashSet<Move>();
	/**stack will be used to store new moves and pop them after*/
	Stack<Move> stack = new Stack<Move>();
	
	/**
	 * constructor specifies Name and Letter for the super rat :) 
	 * * */
public SuperRato(){
		super();
		mName="Helsinki";
		mLetter='H'; 
	}
	
    /**
     * overriding reset to make sure the hash and stack are empty after each reset. 
     * (since they were not in the Rat (superclass) class).  
     */
	@Override
	public void reset() {
		super.reset();
		hash.clear();
		stack.clear();
	}
	
	
	
	/**
	 * Method will let the rat take a decision for the next move he'll take.
	 * it include an algorithm using stack &amp; hashset, 
	 * to make sure the rat wont visit the same place twice. 
	 * 
	 * @param maz is the current Maze the rat is trying to escape. 
	 */
	 public void move(Maze maz) {
		LookForPossibleMoves(maz);
		for (int i = 0; i < mPossibleMoves.size(); i++) {		// will iterate around the possible moves.
			if(!hash.contains(mPossibleMoves.get(i))) {			// if the move is not inside the hash (the place is not visited before).
				stack.push(mPossibleMoves.get(i));				// send this move to the stack.
				hash.add(mPossibleMoves.get(i));				// add this move to the hash ( to make sure we wont visit this place in the future).
			}
		}
		EnactMove(stack.pop());									// do the last move you send to the stack.
		}


}