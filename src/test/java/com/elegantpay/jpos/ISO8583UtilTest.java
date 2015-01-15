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

        hexData = "00 AB 60 00 06 00 00 60 02 00 00 00 00 02007038000008C1 8000193933323830 3630323030303133 3735303136319900 0100000000000120 3012182319123131 3030303030303030 3035393131313135 3030313132333435 3637383931313131 3135006732303330 3131363232393335 3031303830303635 343533333520D6D0 B9FACDA8C1AAB2E2 CAD4C9CCBBA72020 2020202020202020 2020202020202020 2020202020202331 3536000000000000";

        ISOMsg result = ISO8583Util.unpack(hexData);
        Assert.assertNotNull(result);

        result.dump(System.out, "");
    }
}
