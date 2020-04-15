package model.salemodel;

import static junit.framework.TestCase.assertNotSame;
import org.junit.Test;

public class saleIdTest {

    /**
     * Test to make sure that each saleId is unique
     */
    @Test
    public void testSaleId(){
        SaleDetail thisSaleDetail = new SaleDetail();
        thisSaleDetail.createDefault();
        String thisSaleId = thisSaleDetail.getSaleId().getValue();

        SaleDetail thatSaleDetail = new SaleDetail();
        thatSaleDetail.createDefault();
        String thatSaleId = thatSaleDetail.getSaleId().getValue();
        String thatPreviousId;

        for(int i = 0; i < 9999999; i++){
            // Make sure thisSaleId does not equal thatSaleId
            assertNotSame(thisSaleId, thatSaleDetail);

            // thatSaleId is set as thatPreviousId
            thatPreviousId = thatSaleId;

            //thatSaleDetail points to a new instance of saleDetail
            thatSaleDetail = new SaleDetail();
            thatSaleDetail.createDefault();
            thatSaleId = thatSaleDetail.getSaleId().getValue();

            //check so thatSaleId is not equal to thatPreviousId
            assertNotSame(thatPreviousId, thatSaleDetail);
        }
    }
}
