

//Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

//The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) 
//for which the stock price was less than or equal to the price of that day.
//For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, 
//then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
//Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, 
//then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.

//Implement the StockSpanner class:
  //StockSpanner() Initializes the object of the class.
  //int next(int price) Returns the span of the stock's price given that today's price is price.
  
class StockSpanner {
    Stack<int[]> s;
    public StockSpanner() {
        s = new Stack<int[]>();
    }
    
    public int next(int price) {
        int ans = 1;
        while(!s.isEmpty()&&price>=s.peek()[0]){
            ans+=s.pop()[1];
        }
       
        s.push(new int[] {price,ans});
        return ans;
    }
}

//Another way but not efficient
class StockSpanner {
    Stack<Integer> s;
    public StockSpanner() {
        s = new Stack<Integer>();
    }
    
    public int next(int price) {
        int ans = 1;
        Stack<Integer> s2 = new Stack<Integer>();
        while(!s.isEmpty()&&price>=s.peek()){
          s2.push(s.pop());  
          ans+=1;
        }
        while(!s2.isEmpty()){
          s.push(s2.pop());  
        }
        s.push(price);
        return ans;
    }
}
