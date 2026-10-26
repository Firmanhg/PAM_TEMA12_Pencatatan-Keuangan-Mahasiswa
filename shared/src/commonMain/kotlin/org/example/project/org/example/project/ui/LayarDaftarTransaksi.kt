
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.model.JenisTransaksi
import org.example.project.model.KategoriKeuangan
import org.example.project.model.TransaksiKeuangan

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

    val transaksi = remember {
        listOf(
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
    }

    val daftarTerurut = transaksi.sortedByDescending { it.id }

    val totalPemasukan = transaksi
        .filter { it.jenis == JenisTransaksi.PEMASUKAN }
        .sumOf { it.nominal }

    val totalPengeluaran = transaksi
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
                    Text("+", fontSize = 28.sp)
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
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
                    Column(Modifier.padding(16.dp)) {
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
                                    "Pemasukan",
                                    color = Color.White,
                                    fontSize = 12.sp
                                )
                                Text(
                                    "Rp ${totalPemasukan.formatRupiah()}",
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp
                                )
                            }

                            Column(horizontalAlignment = Alignment.End) {
                                Text(
                                    "Pengeluaran",
                                    color = Color.White,
                                    fontSize = 12.sp
                                )
                                Text(
                                    "Rp ${totalPengeluaran.formatRupiah()}",
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
