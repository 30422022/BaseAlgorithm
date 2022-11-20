//快速排序 关键：
// 1.定义轴pivot,从待排序数组最左边的值为标准进行划分，存pivot
// 2.检索(找交换值对), 2.1 先从右边j开始检索，找到比pivot小的就停下,
//                  2.2 找到后开始检索左边i，找到比pivot大的就停下
//                  2.3 交换i,j
//     直到最后i==j,找到最终pivot的位置,交换pivot,第一轮交换结束，开始递归。
public class QuickSort {
    //快速排序
     void quicksort(int[] arr,int left,int right){
        if(left>right){
            return ;
        }
        //定义变量，轴pivot(副本)
        int pivot=arr[left];//从最左边的值为标准进行划分，存pivot
        int i=left,j=right;
        //开始检索
        while (i!=j){
            //先从右边j开始检索，找到比pivot小的就停下
            while(arr[j]>=pivot&&i<j){
                j--;
            }
            //找到后开始检索左边i，找到比pivot大的就停下
            while(arr[i]<=pivot&&i<j){
                i++;
            }
            //找到交换的一对数值,交换
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

        }
        //(i==j)找到pivot的最终位置，进行交换
        arr[left]=arr[i];
        arr[i]=pivot;
        //第一轮划分结束,开始递归排剩下的
        quicksort(arr,left,i-1);
        quicksort(arr,i+1,right);
    }

    //测试
    public static void main(String[] args) {
        int[] a=new int[]{2,9,7,3,5,1};
        new QuickSort().quicksort(a,0,a.length-1);
        for (int i:a){
            System.out.print(i+" ");
        }
    }
}
