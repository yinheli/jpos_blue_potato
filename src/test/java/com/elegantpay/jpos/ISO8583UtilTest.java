package com.elegantpay.jpos;

import org.jpos.iso.ISOMsg;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yinheli
 */
public class ISO8583UtilTest {
    @Test
    public void test_unpack() throws Exception {
        String hexData = "00AB600006000060020000000002007038000008C18000193933323830363032303030313337353031363199000100" +
                "0000000001203012182319123131303030303030303030353931313131353030313132333435363738393131313131350067323" +
                "0333031313632323933353031303830303635343533333520D6D0B9FACDA8C1AAB2E2CAD4C9CCBBA72020202020202020202020" +
                "2020202020202020202020202023313536000000000000";

        ISOMsg result = ISO8583Util.unpack(hexData);
        Assert.assertNotNull(result);

        result.dump(System.out, "");
    }
}
