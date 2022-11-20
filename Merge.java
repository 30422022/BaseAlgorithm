package BaseSort;
//归并排序算法  1.划分 2.合并(关键点)
public class Merge {

    //合并
     void merge(int[] arr,int[] tmp,int left,int mid,int right){
         //标记左半区第一个未排序的元素
         int l_pos=left;
         //标记右半区第一个未排序的元素
         int r_pos=mid+1;
         //临时数组元素的下标
         int pos=left;
         //合并
         while (l_pos<=mid&&r_pos<=right){  //左右半区有元素就合并
             if(arr[l_pos]<arr[r_pos]){
                 tmp[pos++]=arr[l_pos++];
             }
             else {
                 tmp[pos++]=arr[r_pos++];
             }
         }
         //合并左半区剩余的元素
         while (l_pos<=mid){
             tmp[pos++]=arr[l_pos++];
         }
         //合并右半区剩余的元素
         while (r_pos<=right){
             tmp[pos++]=arr[r_pos++];
         }
         //把临时数组中合并后的元素复制回原来的数组
         while (left<=right){
             arr[left]=tmp[left];
             left++;
         }
    }


    //归并排序
     void mergeSort(int[] arr,int left,int right){
         int[] tmp=new int[arr.length];
        //一个元素无需划分

         if(left<right){
            //找中点
            int mid=left+(right-left)/2;
            //划分左半区
            mergeSort(arr,left, mid);
            //划分右半区
            mergeSort(arr, mid+1, right);
            //合并已经排序的部分
            merge(arr, tmp,left, mid, right);
        }
    }



    //测试
    public static void main(String[] args) {
        int[] a=new int[]{2,4,6,3,7,5};
        new Merge().mergeSort(a,0,a.length-1);
        for(int i:a){
            System.out.print(i+" ");
        }
    }
}
