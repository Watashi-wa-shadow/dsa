//121 BEST TIME TO BUY AND SELL STOCKS

public class pblmNo121 {
    public int maxProfit(int[] stockPrice) {
        int i;
        int currPrice,maxProfit=0,minPrice=Integer.MAX_VALUE;
        for(i=0;i<stockPrice.length;i++){
            currPrice=stockPrice[i];
            if(minPrice>currPrice){
                minPrice=currPrice;      //finding minimum price.
            }
            if((currPrice-minPrice)>maxProfit){
                maxProfit=currPrice-minPrice;
            }
        }
        return maxProfit;
    }
}
