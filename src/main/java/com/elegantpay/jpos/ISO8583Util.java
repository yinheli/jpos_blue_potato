package com.elegantpay.jpos;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

import java.util.Arrays;

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

    private static ISOMsg doUpack(byte[] raw) throws Exception {
        byte[] header = Arrays.copyOfRange(raw, 2, 13);
        ISOMsg msg = new ISOMsg();
        msg.setPackager(packager);
        msg.unpack(Arrays.copyOfRange(raw, 13, raw.length));
        msg.setHeader(header);
        return msg;
    }


    /**
     * 从原始报文(hex)解析为 ISOMsg 对象
     *
     * @param hex 16进制数据 包含长度(2字节)+11字节的标准 header
     * @return
     * @throws Exception
     */
    public static ISOMsg unpack(String hex) throws Exception {
        hex = hex.replaceAll("\\s", "");
        return unpack(ISOUtil.hex2byte(hex));
    }

    /**
     * 从原始报文(byte[])解析为 ISOMsg 对象
     *
     * @param raw 原始报文, 包含长度(2字节)+11字节的标准 header
     * @return
     * @throws Exception
     */
    public static ISOMsg unpack(byte[] raw) throws Exception {
        return doUpack(raw);
    }

}
