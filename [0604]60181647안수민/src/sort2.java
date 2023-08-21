import java.util.Vector;

import gangjwa.Gangjwa.Score;

public class sort2 {
	private void quickSort(Vector<Score> scoreVector, int start, int end) {
		
		if (start >= end) return;

		 int left = start;
		 int right = end;
		 Score pivot = this.scoreVector.get((left + end) / 2);


		while (this.scoreVector.get(left).kimal > pivot.kimal) { 
			System.out.println("¿Þ: "+this.scoreVector.get(left).kimal);
			left = left +1;
			}
		 while (this.scoreVector.get(right).kimal < pivot.kimal) {
			 System.out.println("¿À: "+this.scoreVector.get(right).kimal);
			 right = right -1;
		 }
			System.out.println("¿Þ: "+this.scoreVector.get(left).kimal);
			 System.out.println("¿À: "+this.scoreVector.get(right).kimal);
		 if (this.scoreVector.get(left).kimal <= this.scoreVector.get(right).kimal){
			 scoreVector.add(left, this.scoreVector.get(right));
			 scoreVector.add(right+1, this.scoreVector.get(left+1));
			 scoreVector.remove(left+1);
			 scoreVector.remove(right+1);
			 left = left +1;
			 right = right -1;
		 }
		 
		 
		 if (this.scoreVector.get(start).kimal < this.scoreVector.get(right).kimal) quickSort(scoreVector, start, right);
		 if (this.scoreVector.get(end).kimal > this.scoreVector.get(left).kimal) quickSort(scoreVector, left, end);

	}
}
