package com.nevidimka655.crypto.tink.domain.model.keyset

interface MasterKeyName {

    suspend fun get(
        tag: String,
        associatedData: ByteArray
    ): String

}