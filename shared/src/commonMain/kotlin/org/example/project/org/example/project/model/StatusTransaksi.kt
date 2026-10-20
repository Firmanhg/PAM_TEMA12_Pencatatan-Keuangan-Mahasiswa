
package org.example.project.model

sealed class StatusTransaksi {
    data object Tercatat : StatusTransaksi()

    data class Diproses(
        val keterangan: String
    ) : StatusTransaksi()

    data class Selesai(
        val keterangan: String
    ) : StatusTransaksi()
}

fun StatusTransaksi.label(): String = when (this) {
    is StatusTransaksi.Tercatat ->
        "Transaksi tercatat"

    is StatusTransaksi.Diproses ->
        "Transaksi sedang diproses: $keterangan"

    is StatusTransaksi.Selesai ->
        "Transaksi selesai: $keterangan"
}
