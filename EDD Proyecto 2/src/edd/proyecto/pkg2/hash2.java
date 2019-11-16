
package edd.proyecto.pkg2;




public class hash2 {
    
    String [] hasharray;
    int arraySize;
    int size = 0;
    
    public hash2(int no0fSlots){
        if(isPrime(no0fSlots)){
            hasharray = new String[no0fSlots];
            arraySize = no0fSlots;
            }
        else{
            int primeCount = getNextPrime(no0fSlots);
            hasharray = new String[primeCount];
            arraySize = primeCount;
            
            System.out.println("Hash table size given " +no0fSlots + "is not a prime");
            System.out.println("Hash table size changed to " +primeCount);
            
            
        }
    }
    
    private boolean isPrime(int num){
        for(int i=2; i*i <= num;i++){
            if(num% i == 0){
                return false;
            }
        }
        return true;
    }
    
    private int getNextPrime(int minNumber){
        for(int i= minNumber; true; i++){
            if(isPrime(i)){
                return i;
            }
        }
    }
    
    private int hashFunc1(String word){
        int hashVal = word.hashCode();
        hashVal = hashVal % arraySize;
        if(hashVal < 0){
            hashVal += arraySize;
            
        }
        return hashVal;
    }
    
    private int hashFunc2(String word){
        int hashVal = word.hashCode();
        hashVal = hashVal % arraySize;
        
        if(hashVal < 0){
            hashVal = arraySize;
            
        }
        return 3 - hashVal % 3;
    }
    
    public void insert(String word){
        int hashVal = hashFunc1(word);
        int stepSize = hashFunc2(word);
        
        while(hasharray[hashVal] != null){
            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }
        
        hasharray[hashVal] = word;
        System.out.println("insert word: " + word);
        size++;
    }
    
    public String find(String word){
        int hashVal =hashFunc1(word);
        int stepSize = hashFunc2(word);
        
        while(hasharray[hashVal] != null){
            if(hasharray[hashVal].equals(word)){
                return hasharray[hashVal];
            }
            
            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }
        return hasharray[hashVal];
    }
    
    public void displayTable(){
        System.out.println("Table: ");
        for(int i=0; i < arraySize; i++){
            if(hasharray[i] != null){
                System.out.println(hasharray[i] + " ");
                
            }else{
                System.out.println("** ");
            }
            System.out.println("** ");
        }
    }
}


