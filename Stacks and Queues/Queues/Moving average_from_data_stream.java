//Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

//Implement the MovingAverage class:

//MovingAverage(int size) Initializes the object with the size of the window size.
//double next(int val) Returns the moving average of the last size values of the stream.

class MovingAverage {
    int size;
    Deque<Integer> q = new ArrayDeque<Integer>();
    double sum = 0.0;
    int sizeSoFar = 0;
    public MovingAverage(int size) {
        this.size=size;
    }
    
    public double next(int val) {
        if(q.size()==size){
            int x = q.remove();
            sum-=x;
            q.add(val);
            sum+=val;
            return sum/size;
        }else{
            q.add(val);
            sizeSoFar+=1;
            sum+=val;
            return sum/sizeSoFar;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
