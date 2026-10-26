
package org.example.project.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun LayarUtama() {
    var tampilkanForm by rememberSaveable {
        mutableStateOf(false)
    }

    if (tampilkanForm) {
        FormTransaksiScreen(
            onKembali = {
                tampilkanForm = false
            }
        )
    } else {
        LayarDaftarTransaksi(
            onTambahTransaksi = {
                tampilkanForm = true
            }
        )
    }
}
