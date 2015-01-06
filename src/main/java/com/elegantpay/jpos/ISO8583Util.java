package com.elegantpay.jpos;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

/**
 * @author yinheli
 */
public class ISO8583Util {

    private static GenericPackager packager = null;

    static {
        try {
            packager = new GenericPackager(ISO8583Util.class.getResourceAsStream("/packager.xml"));
        } catch (ISOException e) {
            e.printStackTrace();
        }
    }

    private ISO8583Util() {
    }

    public static ISOMsg unpack(String hex) throws Exception {
        hex = hex.replaceAll("\\s", "").substring(26);
        return unpack(ISOUtil.hex2byte(hex));
    }

    public static ISOMsg unpack(byte[] raw) throws Exception {
        System.out.println(ISOUtil.hexdump(raw));
        ISOMsg msg = new ISOMsg();
        msg.setPackager(packager);
        msg.unpack(raw);
        return msg;
    }

}
