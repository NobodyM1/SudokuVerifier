

public class SudokuVerifier {
	
public int verify(String candidateSolution) {
		
		// All of the codes or rule checkers work independently, only problem is that they are run in this order which is why the tests fail.
		
		String solution = candidateSolution;
		int lenght = solution.length();
		int i;
		
		char number;
		int parsedNumber;
		String rowString;
		
		// Check that rule 1 applies
		for(i=0; i < lenght; i++){
			number = solution.charAt(i);
			if(Character.isDigit(number)== false){
				return -1;
			}
			parsedNumber = Character.getNumericValue(number);
			if(parsedNumber < 0 && parsedNumber > 10){
				return -1;
			}
		}
		
		// Check that rule 2 applies
		int oldStartPoint = 0;
		//int round = 0;
		while(i<3){
			int startPoint = 0;
			int endPoint = 0;
			if(oldStartPoint == 9){
				oldStartPoint = 27;
			}
			if(oldStartPoint == 36){
				oldStartPoint = 54;
			}
			
			for(int j=0; j<3; j++){
				String subGridString = " ";
				startPoint = oldStartPoint;
				for(int k=0; k<3; k++){
					endPoint = startPoint + 3;
					//System.out.println("Start point -> " + startPoint + " End point -> " + endPoint);
					// get subgrid
					String test = solution.substring(startPoint, endPoint);
					subGridString = subGridString + test;
					startPoint = endPoint + 6;
				}
				oldStartPoint = oldStartPoint + 3;
				//round++;
				// check if rule 2 is true
				//System.out.println(subGridString);
				//System.out.println(round);
				//System.out.println("Old start point -> " + oldStartPoint);
				
				for(int k=0; k<9; k++){
					int numberOfTimes = 0;
					number = subGridString.charAt(k);
					for(j=0; j<9; j++){
						Character test = subGridString.charAt(j);
						if(test == number){
							numberOfTimes++;
							if(numberOfTimes == 2){
								return -2;
							}
						}
					}
				}
			}
			i++;
		}
		
		
		// Check that rule 3 applies
		for(i=0; i<9; i++){
			int memoryIndex = 0;
			int cutPoint = memoryIndex + 9;
			rowString = solution.substring(memoryIndex, cutPoint);
			for(int k=0; k<9; k++){
				int numberOfTimes = 0;
				number = rowString.charAt(k);
				for(int j=0; j<9; j++){
					Character test = rowString.charAt(j);
					if(test == number){
						numberOfTimes++;
						if(numberOfTimes == 2){
							return -3;
						}
					}
				}
			}
			memoryIndex = cutPoint;
		}
		
		
		int columnIndex = 0;
		for(int j=0; j<9; j++){
			String columnString = " ";
			for(i=0; i<9; i++){
				columnString = columnString + solution.substring(columnIndex);
				columnIndex = columnIndex + 9;
			}
			
			for(int k=0; k<9; k++){
					int numberOfTimes = 0;
					number = columnString.charAt(k);
					for(int g=0; g<9; g++){
						Character test = columnString.charAt(j);
						if(test == number){
							numberOfTimes++;
							if(numberOfTimes == 2){
								return -4;
							}
						}
					}
				}
		}
		
		
		
		
		
		// returns 0 if the candidate solution is correct
		return 0;
		
		//check
	}
	
}
