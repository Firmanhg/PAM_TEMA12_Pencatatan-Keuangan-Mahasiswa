
package org.example.project.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormTransaksiScreen(
    onKembali: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Tambah Transaksi",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Form transaksi berhasil dibuka."
        )

        Button(
            onClick = onKembali
        ) {
            Text("Kembali")
        }
    }
}
