package gov.nist.toolkit.simcoresupport.mhd

import javax.xml.bind.DatatypeConverter

class HashTranslator {

    static byte[] toByteArray(String hash) {
        DatatypeConverter.parseHexBinary(hash)
    }

    static String fromByteArray(byte[] bytes) {
        DatatypeConverter.printHexBinary(bytes).toLowerCase()
    }
}