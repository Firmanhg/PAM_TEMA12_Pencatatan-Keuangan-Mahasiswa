
package org.example.project.model

data class TransaksiKeuangan(
    val id: Int,
    val judul: String,
    val nominal: Long,
    val jenis: JenisTransaksi,
    val kategoriId: Int,
    val catatan: String? = null
)

enum class JenisTransaksi {
    PEMASUKAN,
    PENGELUARAN
}
