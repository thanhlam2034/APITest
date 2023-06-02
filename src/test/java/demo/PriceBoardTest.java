package demo;

import org.testng.annotations.Test;
import service.IPriceBoard;
import service.imlp.PriceBoard;

public class PriceBoardTest {
    @Test
    public void testPriceBoard(){
        IPriceBoard priceBoard = new PriceBoard();
        priceBoard.priceBoard();
    }
}
