import java.util.Arrays;

public class sorting {

	public sorting() {

	}
	
//	1. ��ü���� ��� �ϳ��� ���Ҹ� �߽�(Pivot)���� 2���� �κ� �������� ���� �Ѵ�.
//	2. ���ذ�(Pivot) ���� ���� ���Ҵ� ���� �κ���������, ���ذ�(Pivot) ���� ū ���ҵ��� ������ �κ� �������� �����Ѵ�.
//	3. ���ҵ� �κ������� ũ�Ⱑ 0�̳� 1�� �� �� ���� ��ȯ ȣ���� �̿��Ͽ� �ٽ� ���� �Ѵ�.
//	�߰�: �� N���� ��Ƽ���� ������(N) �� �� ������ �� �˻��ϴ� �������� ���� �������� �پ�����Ƿ�(log(N)) �� Nlog(N)���� �ɸ���.

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