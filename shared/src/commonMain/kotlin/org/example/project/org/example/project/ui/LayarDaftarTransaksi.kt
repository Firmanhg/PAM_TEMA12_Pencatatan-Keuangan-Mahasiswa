
package org.example.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.data.PenyimpananTransaksi
import org.example.project.model.JenisTransaksi
import org.example.project.model.KategoriKeuangan

private val Ungu = Color(0xFF6B4EAA)
private val Latar = Color(0xFFF7F3FC)

@Composable
fun LayarDaftarTransaksi(
    onTambahTransaksi: () -> Unit
) {
    val kategori = remember {
        listOf(
            KategoriKeuangan(1, "Kebutuhan Kuliah"),
            KategoriKeuangan(2, "Transportasi"),
            KategoriKeuangan(3, "Hiburan"),
            KategoriKeuangan(4, "Makanan")
        )
    }

    // Mengambil transaksi dari penyimpanan bersama.
    // UI akan diperbarui ketika isi StateFlow berubah.
    val daftarTransaksi by PenyimpananTransaksi.daftar.collectAsState()

    val daftarTerurut = daftarTransaksi.sortedByDescending { it.id }

    val totalPemasukan = daftarTransaksi
        .filter { it.jenis == JenisTransaksi.PEMASUKAN }
        .sumOf { it.nominal }

    val totalPengeluaran = daftarTransaksi
        .filter { it.jenis == JenisTransaksi.PENGELUARAN }
        .sumOf { it.nominal }

    val saldo = totalPemasukan - totalPengeluaran

    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Latar,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = onTambahTransaksi,
                    containerColor = Ungu,
                    contentColor = Color.White
                ) {
                    Text(
                        text = "+",
                        fontSize = 28.sp
                    )
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 12.dp
                    )
            ) {
                Text(
                    text = "Pencatatan Keuangan",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF292336)
                )

                Text(
                    text = "Mahasiswa",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(Modifier.padding(top = 8.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Ungu
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Ringkasan Keuangan",
                            color = Color.White,
                            fontSize = 12.sp
                        )

                        Spacer(Modifier.padding(top = 3.dp))

                        Text(
                            text = "Rp ${saldo.formatRupiah()}",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(Modifier.padding(top = 10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "Pemasukan",
                                    color = Color.White,
                                    fontSize = 12.sp
                                )

                                Text(
                                    text = "Rp ${totalPemasukan.formatRupiah()}",
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.End
                            ) {
                                Text(
                                    text = "Pengeluaran",
                                    color = Color.White,
                                    fontSize = 12.sp
                                )

                                Text(
                                    text = "Rp ${totalPengeluaran.formatRupiah()}",
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }

                Spacer(Modifier.padding(top = 12.dp))

                Text(
                    text = "Daftar Transaksi",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF292336)
                )

                Text(
                    text = "${daftarTerurut.size} transaksi tercatat",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                Spacer(Modifier.padding(top = 8.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 80.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        items = daftarTerurut,
                        key = { it.id }
                    ) { item ->
                        val namaKategori = kategori
                            .find { it.id == item.kategoriId }
                            ?.nama ?: "Lainnya"

                        KartuTransaksi(
                            transaksi = item,
                            namaKategori = namaKategori
                        )
                    }
                }
            }
        }
    }
}

private fun Long.formatRupiah(): String =
    toString()
        .reversed()
        .chunked(3)
        .joinToString(".")
        .reversed()
