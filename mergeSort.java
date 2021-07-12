package study;
class mergeSort{
    void merge(int arr[],int l,int u,int mid){
        int n1=1+mid - l;
        int n2=u-mid;
        int L[]=new int[n1];
        int R[]=new int[n2];
        for(int i=0;i<n1;i++)
            L[i]=arr[l+i];
        for(int j=0;j<n2;j++)
            R[j]=arr[mid+1+j];
        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }


    void sort(int arr[],int l,int u){
        if(l + 1 < u){
            int mid=l+(u-l)/2;
            sort(arr,l,mid);
            sort(arr,mid+1,u);
            merge(arr,l,u,mid);
        }
    }
    static void printArray(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+"");
        }
        System.out.println();
    }
}
public class mergeSort {

    public static void main(String[] args) {
        int arr[]={12,15,10,7,29,30};
        System.out.println("Given Array");
        mergeSort.printArray(arr);
        mergeSort m = new mergeSort();
        m.sort(arr, 0, arr.length - 1);
        System.out.println("\nSorted array");
        mergeSort.printArray(arr);

    }
}
