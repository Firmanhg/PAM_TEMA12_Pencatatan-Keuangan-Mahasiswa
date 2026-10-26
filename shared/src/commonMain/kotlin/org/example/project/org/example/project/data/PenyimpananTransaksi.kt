
package org.example.project.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.model.JenisTransaksi
import org.example.project.model.TransaksiKeuangan

object PenyimpananTransaksi {

    private val transaksiAwal = listOf(
        TransaksiKeuangan(1, "Alat tulis", 18000L, JenisTransaksi.PENGELUARAN, 1),
        TransaksiKeuangan(2, "Bensin motor", 30000L, JenisTransaksi.PENGELUARAN, 2),
        TransaksiKeuangan(3, "Nonton film", 50000L, JenisTransaksi.PENGELUARAN, 3),
        TransaksiKeuangan(4, "Cetak tugas", 12000L, JenisTransaksi.PENGELUARAN, 1),
        TransaksiKeuangan(5, "Uang saku", 500000L, JenisTransaksi.PEMASUKAN, 4),
        TransaksiKeuangan(6, "Makan siang", 20000L, JenisTransaksi.PENGELUARAN, 4),
        TransaksiKeuangan(7, "Buku kuliah", 75000L, JenisTransaksi.PENGELUARAN, 1),
        TransaksiKeuangan(8, "Transportasi", 15000L, JenisTransaksi.PENGELUARAN, 2),
        TransaksiKeuangan(9, "Beasiswa", 1000000L, JenisTransaksi.PEMASUKAN, 4),
        TransaksiKeuangan(10, "Kopi", 18000L, JenisTransaksi.PENGELUARAN, 4),
        TransaksiKeuangan(11, "Fotokopi", 8000L, JenisTransaksi.PENGELUARAN, 1)
    )

    private val _daftar = MutableStateFlow(transaksiAwal)

    val daftar: StateFlow<List<TransaksiKeuangan>> =
        _daftar.asStateFlow()

    fun tambah(transaksi: TransaksiKeuangan) {
        _daftar.update { daftarLama ->
            daftarLama + transaksi
        }
    }

    fun idBerikutnya(): Int {
        return (_daftar.value.maxOfOrNull { it.id } ?: 0) + 1
    }
}
