class Solution {
    public boolean judgeSquareSum(int c) {

long a = 0,b = (long) Math.sqrt(c);

while(a<=b){
    long sum = a*a+b*b;

    if(sum ==c )return true;
    if(sum<c) a++;
    if(sum>c) b--;

}
return false;

 

    }
}

   








        
    
