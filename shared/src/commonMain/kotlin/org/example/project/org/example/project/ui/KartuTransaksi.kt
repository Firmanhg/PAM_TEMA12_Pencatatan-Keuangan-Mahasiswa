
package org.example.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.model.JenisTransaksi
import org.example.project.model.TransaksiKeuangan

@Composable
fun KartuTransaksi(
    transaksi: TransaksiKeuangan,
    namaKategori: String
) {
    val pemasukan = transaksi.jenis == JenisTransaksi.PEMASUKAN
    val warna = if (pemasukan) Color(0xFF168653) else Color(0xFFE53935)
    val tanda = if (pemasukan) "+" else "−"

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = warna.copy(alpha = 0.12f)
                )
            ) {
                Text(
                    text = tanda,
                    modifier = Modifier.padding(
                        horizontal = 13.dp,
                        vertical = 9.dp
                    ),
                    color = warna,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Text(
                    text = transaksi.judul,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF292336)
                )

                Text(
                    text = namaKategori,
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                Text(
                    text = if (pemasukan) "Pemasukan" else "Pengeluaran",
                    fontSize = 11.sp,
                    color = warna
                )
            }

            Text(
                text = "$tanda Rp ${transaksi.nominal.formatRupiah()}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = warna
            )
        }
    }
}

private fun Long.formatRupiah(): String =
    toString()
        .reversed()
        .chunked(3)
        .joinToString(".")
        .reversed()
