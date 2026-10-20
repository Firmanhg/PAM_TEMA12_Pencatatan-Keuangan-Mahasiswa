
package org.example.project.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.project.model.StatusTransaksi

class SumberTransaksiPalsu {

    fun pantauStatus(): Flow<StatusTransaksi> = flow {
        emit(StatusTransaksi.Tercatat)

        delay(1000)

        emit(
            StatusTransaksi.Diproses(
                "Memeriksa transaksi"
            )
        )

        delay(1500)

        emit(
            StatusTransaksi.Selesai(
                "Pengeluaran berhasil dicatat"
            )
        )
    }
}
