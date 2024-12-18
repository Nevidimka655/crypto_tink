package com.nevidimka655.crypto.tink.data.parsers

import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeysetHandle
import com.google.crypto.tink.TinkProtoKeysetFormat
import com.nevidimka655.crypto.tink.core.encoders.HexService

class ParseKeysetByAeadService(
    private val hexService: HexService
) {

    fun parse(
        serializedKeyset: String,
        aead: Aead,
        associatedData: ByteArray
    ): KeysetHandle {
        val encryptedKeyset = hexService.decode(hex = serializedKeyset)
        return TinkProtoKeysetFormat.parseEncryptedKeyset(
            /* serializedEncryptedKeyset = */ encryptedKeyset,
            /* keysetEncryptionAead = */ aead,
            /* associatedData = */ associatedData
        )
    }

}