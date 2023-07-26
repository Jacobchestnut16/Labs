import java.util.Arrays;

public class ArrayData {

    private int[] data;

    private int count = 0;

    public ArrayData(){
        data = new int[0];
    }

    public int numAt(int i){
        return data[i];
    }

    public void add(int l){
        data = Arrays.copyOf(data, data.length+1);
        data[count] = l;
        count++;
    }

    public int count(){
        return count;
    }

    public boolean ERASE(){
        count = 0;
        data = new int[0];
        return true;
    }

    public void remove(){
        count--;
        int[] ret = new int[count];
        for (int i = 0; i < count; i++) {
            ret[i] = data[i];
        }
        data = ret;
    }

    public void remove(int i){
        if (i < 0){
            throw new RuntimeException("Error: "+ i +"\n Expected a positive integer");
        }
        for (int j = i; j < count; j++){
            data[j] = data[j+1];
        }
        remove();
    }


}
