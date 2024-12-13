public class MemoryAllocationBloc {

    private int size;
    private boolean isAllocated;

    public MemoryAllocationBloc(int size) {
        this.size = size;
        this.isAllocated = false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isAllocated() {
        return isAllocated;
    }

    public void setAllocated(boolean allocated) {
        isAllocated = allocated;
    }

    public void allocate(){
        this.isAllocated = true;
    }

    public void deallocate(){
        this.isAllocated = false;
    }


    @Override
    public String toString(){
        String status = isAllocated ? "Allocated" :"Free";
        return  "Block( size =" + size + " , status="+status +")";
    }
}
