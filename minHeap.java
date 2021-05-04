public class HelloWorld{

     public static void main(String []args){
         
         MinHeap minHeap = new MinHeap(5);
         minHeap.insertNode(5);
         minHeap.insertNode(2);
         minHeap.insertNode(1);
         minHeap.extractMin();
         minHeap.insertNode(0);
         minHeap.insertNode(10);
         minHeap.insertNode(1);
         
         
         for(int i= 0; i<minHeap.currSize; i++)
            System.out.print(minHeap.heap[i]+" ");
         
     }
}


class MinHeap{
    
    public int capacity;
    public int currSize;
    public int[] heap;
    
    public MinHeap(int capacity){
        this.capacity = capacity;
        this.heap = new int[capacity];
        for(int i=0; i<capacity; i++)
            heap[i] = Integer.MAX_VALUE;
        this.currSize = 0;
    }
    
    public void insertNode(int value){
        heap[currSize] = value;
        heapify(currSize);
        currSize++;
        // for(int i= 0; i<heap.length; i++)
        //     System.out.println(heap[i]);
    }
    
    public int extractMin(){
        if(currSize<=0)
            return -1;
        int min = heap[0];
        heap[0] = heap[currSize-1];
        heapify(0);
        currSize--;
        return min;
    }
    
    public void heapify(int index){
        if(index<0 || index>currSize)
            return;
        int parent = (index-1)/2;
        int left = 2*index +1;
        int right = 2*index +2;
        
        
        if(heap[index]<heap[parent]){
            swap(index, parent);
            heapify(parent);
        }
        else if(left<heap.length && heap[index]> heap[left]) {
            swap(index,left);
            heapify(left);
        }
        else if(right < heap.length && heap[index]> heap[right]) {
            swap(index,right);
            heapify(right);
        }
        
    }
    
    public void swap(int index1, int index2){
        
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
        
    }
    
    
}
