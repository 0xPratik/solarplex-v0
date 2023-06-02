package com.example.kdispatchsdk

import java.nio.charset.StandardCharsets
import java.security.MessageDigest

fun getCreatorId(address : String):String {
    return "tmpdid-" + address + ":0096"
}

fun calculateSHA256(input: String): String {
    val digest = MessageDigest.getInstance("SHA-256")
    val hash = digest.digest(input.toByteArray(StandardCharsets.UTF_8))
    return bytesToHex(hash)
}

fun bytesToHex(hash: ByteArray): String {
    val hexString = StringBuilder(2 * hash.size)
    for (byte in hash) {
        val hex = Integer.toHexString(0xff and byte.toInt())
        if (hex.length == 1) {
            hexString.append('0')
        }
        hexString.append(hex)
    }
    return hexString.toString()
}