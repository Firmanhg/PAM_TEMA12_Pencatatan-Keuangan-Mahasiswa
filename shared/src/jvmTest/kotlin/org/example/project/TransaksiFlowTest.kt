
package org.example.project

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.example.project.data.SumberTransaksiPalsu
import org.example.project.model.label
import kotlin.test.Test

class TransaksiFlowTest {

    @Test
    fun simulasiStatusTransaksi() = runBlocking {
        println("Simulasi status transaksi #1")

        SumberTransaksiPalsu()
            .pantauStatus()
            .collect { status ->
                println(status.label())
            }

        println("Simulasi selesai.")
    }
}
