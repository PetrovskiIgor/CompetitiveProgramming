package SRM397;


import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class State {
	int [] board;
	int numSteps;
	
	public State(int [] _board, int _numSteps) { 
		board = new int[_board.length];
		
		for(int i=0; i<board.length; i++) { 
			board[i] = _board[i];
		}

		numSteps = _numSteps;
	}

	@Override
	public boolean equals(Object o) { 
		State other = (State)o;
		

		if(other.board.length != board.length)
			return false;
		for(int i=0; i<board.length; i++) { 
			if(board[i] != other.board[i])
				return false;
		}

		return true;
	}

	@Override
	public int hashCode() { 

StringBuilder sb = new StringBuilder();

for(int i=0; i<board.length; i++) { 

sb.append(String.valueOf(board[i]) + " ");	
}

return sb.toString().hashCode();
}

}

public class SortingGame { 
	
	HashMap<State, Integer> TABLE;
	

	public boolean isIncreasing(int [] arr) { 

		for(int i=1; i<arr.length; i++) { 
			if(arr[i-1] > arr[i])
				return false;
		}

		return true;
	}

	public int[] swapThem(int [] board, int from, int to) { 

		if(to > board.length) 
			return null;

		int [] newBoard = new int[board.length];

		int fromWhere = -1 + to;
		for(int i=0; i<board.length; i++) { 

			if(i<from || i>=to)
				newBoard[i] = board[i];
			else
				newBoard[i] = board[fromWhere--];
		}

		return newBoard;
		

	}

	public int fewestMoves(int [] board, int k) {
		
		TABLE = new HashMap<State, Integer>();
		

		Queue<State> queue = new LinkedList<State>();
		State origin = new State(board, 0);
		queue.add(origin);
		TABLE.put(origin, 0);

		while(!queue.isEmpty()) { 
			State front = queue.poll();

			if(isIncreasing(front.board))
				return front.numSteps;

			for(int i=0; i<front.board.length; i++) { 
				int [] newBoard = swapThem(front.board, i, i+k);

				if(null == newBoard)
					continue;
				State newState = new State(newBoard, 1 + front.numSteps);
				
				if(TABLE.get(newState) != null)
					continue;

				TABLE.put(newState, 1 + front.numSteps);
				queue.add(newState);
			}
		
			

		}


		return -1;
		
	}
	
	/*public static void main(String [] args)  {
		
		int [] board = {1,2,3}
		;
		int k = 3;

		SortingGame sg = new SortingGame();

		int sol = sg.fewestMoves(board, k);

		System.out.println(sol);
	}*/

}
