import java.util.ArrayList;
import java.util.List;

public class Allocator {
    private List<MemoryAllocationBloc> memoryBlocks;

    public Allocator(List<Integer> memorySizes){
        memoryBlocks = new ArrayList<>();
        for (int size : memorySizes) {
            memoryBlocks.add(new MemoryAllocationBloc(size));
        }
    }

  public int   allocate(int processSize) {
        int bestFitIndex = -1;
        int minSizeDiff = Integer.MAX_VALUE;

        for(int i = 0 ; i < memoryBlocks.size(); i++){
            MemoryAllocationBloc block = memoryBlocks.get(i);
            if(!block.isAllocated() && block.getSize() >= processSize){
                int sizeDiff = block.getSize() - processSize;
                if(sizeDiff < minSizeDiff){
                    minSizeDiff = sizeDiff;
                    bestFitIndex = i;
                }

            }
        }

        if(bestFitIndex != -1){
            memoryBlocks.get(bestFitIndex).allocate();
        }
        return bestFitIndex;
  }


  public void dealocate(int blockIndex) {
        if(blockIndex >= 0  && blockIndex < memoryBlocks.size()){
            memoryBlocks.get(blockIndex).deallocate();
        }
  }

  public void displayMemory(){
        for(int i = 0; i < memoryBlocks.size(); i++){
            System.out.println("Block " + i + ": " + memoryBlocks.get(i));
        }
  }
}
