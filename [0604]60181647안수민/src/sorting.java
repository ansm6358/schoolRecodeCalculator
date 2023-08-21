import java.util.Arrays;

public class sorting {

	public sorting() {

	}
	
//	1. 전체원소 가운데 하나의 원소를 중심(Pivot)으로 2개의 부분 집합으로 분할 한다.
//	2. 기준값(Pivot) 보다 작은 원소는 왼쪽 부분집합으로, 기준값(Pivot) 보다 큰 원소들은 오른쪽 부분 집합으로 정렬한다.
//	3. 분할된 부분집합의 크기가 0이나 1이 될 때 까지 순환 호출을 이용하여 다시 분할 한다.
//	추가: 총 N번의 파티션을 나누고(N) 한 번 나눴을 때 검색하는 데이터의 양이 절반으로 줄어들으므로(log(N)) 총 Nlog(N)번이 걸린다.

	public static void main(String[] args) {
		int list[]= {4,6,2,7,10,34,9,0,12,20,};
		quickSort(list, 0, list.length - 1);
		
	}

	private static void quickSort(int num[], int start, int end) {

			if (start >= end) return;

			 int left = start;
			 int right = end;
			 int pivot = num[(left + end) / 2];

			 do {
			while (num[left] < pivot) left++;
			 while (num[right] > pivot) right--;
			 
			 if (left <= right) {
			int temp = num[left];
			 num[left] = num[right];
			 num[right] = temp;
			 left++;
			 right--;
			 }
			 } while (left <= right);
			 
			 if (start < right) quickSort(num, start, right);
			 if (end > left) quickSort(num, left, end);

			}}