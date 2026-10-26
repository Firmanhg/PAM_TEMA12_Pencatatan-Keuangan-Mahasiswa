
package org.example.project.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.data.PenyimpananTransaksi
import org.example.project.model.TransaksiKeuangan
import org.example.project.model.TransaksiUiState

class TransaksiViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TransaksiUiState())
    val uiState = _uiState.asStateFlow()

    fun ubahJudul(teks: String) {
        _uiState.update {
            it.copy(judul = teks.take(40), pesan = null)
        }
    }

    fun ubahNominal(teks: String) {
        if (teks.isEmpty() || teks.all { it.isDigit() }) {
            _uiState.update {
                it.copy(nominal = teks, pesan = null)
            }
        }
    }

    fun ubahJenis(jenis: org.example.project.model.JenisTransaksi) {
        _uiState.update {
            it.copy(jenis = jenis, pesan = null)
        }
    }

    fun ubahKategori(kategoriId: Int) {
        _uiState.update {
            it.copy(kategoriId = kategoriId, pesan = null)
        }
    }

    fun ubahCatatan(teks: String) {
        _uiState.update {
            it.copy(catatan = teks, pesan = null)
        }
    }

    fun simpan(onSelesai: () -> Unit) {
        val state = _uiState.value

        if (!state.bisaSimpan) {
            _uiState.update {
                it.copy(pesan = "Isi judul dan nominal dengan benar.")
            }
            return
        }

        viewModelScope.launch {
            _uiState.update {
                it.copy(sedangMenyimpan = true, pesan = null)
            }

            try {
                delay(300)

                val transaksi = TransaksiKeuangan(
                    id = PenyimpananTransaksi.idBerikutnya(),
                    judul = state.judul.trim(),
                    nominal = state.nominal.toLong(),
                    jenis = state.jenis,
                    kategoriId = state.kategoriId,
                    catatan = state.catatan.trim().ifBlank { null }
                )

                PenyimpananTransaksi.tambah(transaksi)

                _uiState.value = TransaksiUiState(
                    pesan = "Transaksi berhasil disimpan."
                )

                onSelesai()
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        sedangMenyimpan = false,
                        pesan = "Transaksi gagal disimpan."
                    )
                }
            }
        }
    }
}
