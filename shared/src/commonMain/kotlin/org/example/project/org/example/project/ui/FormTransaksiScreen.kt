
package org.example.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.model.JenisTransaksi

private val UnguForm = Color(0xFF6B4EAA)
private val LatarForm = Color(0xFFF7F3FC)

@Composable
fun FormTransaksiScreen(
    onKembali: () -> Unit
) {
    val vm: TransaksiViewModel = viewModel {
        TransaksiViewModel()
    }
    val state by vm.uiState.collectAsStateWithLifecycle()

    val kategori = listOf(
        1 to "Kebutuhan Kuliah",
        2 to "Transportasi",
        3 to "Hiburan",
        4 to "Makanan"
    )

    Scaffold(
        containerColor = LatarForm
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextButton(
                onClick = onKembali
            ) {
                Text("← Kembali ke daftar")
            }

            Text(
                text = "Tambah Transaksi",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFF292336)
            )

            Text(
                text = "Catat pemasukan atau pengeluaran keuanganmu.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )

            // Input judul menggunakan KolomTeks
            KolomTeks(
                label = "Judul transaksi",
                value = state.judul,
                onValueChange = vm::ubahJudul,
                placeholder = "Contoh: Beli buku kuliah"
            )

            // Input nominal menggunakan KolomTeks
            KolomTeks(
                label = "Nominal (Rp)",
                value = state.nominal,
                onValueChange = vm::ubahNominal,
                placeholder = "Contoh: 50000"
            )

            Text(
                text = "Masukkan angka tanpa titik atau simbol.",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            Text(
                text = "Jenis transaksi",
                style = MaterialTheme.typography.titleMedium
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = state.jenis ==
                                    JenisTransaksi.PENGELUARAN,
                            onClick = {
                                vm.ubahJenis(
                                    JenisTransaksi.PENGELUARAN
                                )
                            }
                        )
                        Text("Pengeluaran")
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = state.jenis ==
                                    JenisTransaksi.PEMASUKAN,
                            onClick = {
                                vm.ubahJenis(
                                    JenisTransaksi.PEMASUKAN
                                )
                            }
                        )
                        Text("Pemasukan")
                    }
                }
            }

            Text(
                text = "Kategori",
                style = MaterialTheme.typography.titleMedium
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                kategori.forEach { (id, nama) ->
                    val terpilih = state.kategoriId == id

                    OutlinedButton(
                        onClick = {
                            vm.ubahKategori(id)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = if (terpilih) {
                                "✓ $nama"
                            } else {
                                nama
                            }
                        )
                    }
                }
            }

            // Input catatan menggunakan KolomTeks
            KolomTeks(
                label = "Catatan (opsional)",
                value = state.catatan,
                onValueChange = vm::ubahCatatan,
                placeholder = "Tambahkan keterangan"
            )

            if (state.pesan != null) {
                Text(
                    text = state.pesan.orEmpty(),
                    color = if (
                        state.pesan ==
                        "Transaksi berhasil disimpan."
                    ) {
                        Color(0xFF24834A)
                    } else {
                        MaterialTheme.colorScheme.error
                    },
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(
                Modifier.height(4.dp)
            )

            Button(
                onClick = {
                    vm.simpan(onSelesai = onKembali)
                },
                enabled = state.bisaSimpan,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = if (state.sedangMenyimpan) {
                        "Menyimpan..."
                    } else {
                        "Simpan Transaksi"
                    }
                )
            }

            Text(
                text = "Judul wajib diisi dan nominal harus lebih dari Rp0.",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}
