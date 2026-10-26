
package org.example.project.model

data class TransaksiUiState(
    val judul: String = "",
    val nominal: String = "",
    val jenis: JenisTransaksi = JenisTransaksi.PENGELUARAN,
    val kategoriId: Int = 1,
    val catatan: String = "",
    val sedangMenyimpan: Boolean = false,
    val pesan: String? = null
) {
    val bisaSimpan: Boolean
        get() = judul.isNotBlank() &&
                nominal.toLongOrNull()?.let { it > 0L } == true &&
                !sedangMenyimpan
}
