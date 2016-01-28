package SRM400;

import java.util.HashMap;

class State { 
	int [][] board;
	int R;
	int C;
	
	public State(int [][] _board) { 
		R = _board.length;
		C = _board[0].length;
		
		
		board = new int[R][C];
		
		for(int i=0; i<R; i++) { 
			for(int j=0; j<C; j++) { 
				board[i][j] = _board[i][j];
			}
		}
		
	}
	
	
	@Override
	public boolean equals(Object o) { 
		State other = (State)o;
		
		
		if(R != other.R || C != other.C) 
			return false;
		
		for(int i=0; i<R; i++) { 
			for(int j=0; j<C; j++) { 
				if(board[i][j] != other.board[i][j]) { 
					return false;
				}
			}
		}
		
		return true;
	}
	
	@Override
	public int hashCode() { 
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<R; i++)
			for(int j=0; j<C; j++)
				sb.append((char)(board[i][j] + '0'));
		
		return sb.toString().hashCode();
	}
}

public class LightedPanels { 
	
	
	public static void main(String [] args) { 
		String [] board  = {	"...",
			 					"...",
			 					"..."};
		
		int R = board.length;
		int C = board[0].length();
		
		LightedPanels lp = new LightedPanels();
		
		
	
		
		int sol = lp.minTouch(board);
		
		System.out.println("sol: " + sol);
		
	}

	int IMPOSSIBLE = -1;
	int IN_PROGRESS = -2;
	int R;
	int C;
	
	// for key State -> val Integer how many steps untill the end
	HashMap<State, Integer> TABLE = new HashMap<State,Integer>();

	public int minTouch(String [] arr) { 
		R = arr.length;
		C = arr[0].length();
		
		int [][] beginBoard = new int[R][C];
		int [][] endBoard = new int[R][C];
		
		for(int i=0; i<R; i++) { 
			for(int j=0; j<C; j++) { 
			
				if(arr[i].charAt(j) == '*')
					beginBoard[i][j] = 1;
				else
					beginBoard[i][j] = 0;
				
				endBoard[i][j] = 1;
			}
		}
		
		State beginState = new State(beginBoard);
		State endState = new State(endBoard);
		
		TABLE.put(endState, 0);
		int sol = calculate(beginState);
		return sol;
		
	}
	
	public int calculate(State currState) { 
			System.out.println(TABLE.size());
			/*for(int i=0; i<R; i++) { 
				for(int j=0; j<C; j++) {
					System.out.print(currState.board[i][j]);
				}
				System.out.println();
			}
			System.out.println("----------");*/
		
			Integer val = TABLE.get(currState);
			
			if(null != val) 
				return val;
			
			TABLE.put(currState, IN_PROGRESS);
			
			Integer minSteps  = Integer.MAX_VALUE;
			
			// do the recursion..
			
			State newState;
			int [][] newBoard = new int[R][C];
			
			for(int i=0; i<R; i++) { 
				for(int j=0; j<C; j++) {
					newBoard[i][j] = currState.board[i][j];
				}
			}
			
			newState = new State(newBoard);
			for(int i=0; i<R; i++) {
			
				for(int j=0; j<C; j++) { 
				
					
					changeState(newState, i,j);
					
					val = TABLE.get(newState);
				
					if(val == null) { 
						val = calculate(newState);
					}
					
					
					if(val != IN_PROGRESS && val != IMPOSSIBLE) {
						val++;
						minSteps = Math.min(minSteps, val);		
					}
					
					changeState(newState, i, j);
				}
			}
			
			if(minSteps == Integer.MAX_VALUE) {
				TABLE.put(currState, IMPOSSIBLE);
				return -1;
			}
			
			TABLE.put(currState, minSteps);
			return minSteps;
				
	
	}
	
	public void changeState(State state, int x, int y) { 
	
		for(int dx = -1; dx <= 1; dx++) { 
			for(int dy = -1; dy <= 1; dy++) {
				
				int newX = x + dx;
				int newY = y + dy;
				
				if(newX < 0 || newX >= R || newY < 0 || newY >=C)
					continue;
				
				state.board[newX][newY] = 1 - state.board[newX][newY];
			}
		
		}
	}
}