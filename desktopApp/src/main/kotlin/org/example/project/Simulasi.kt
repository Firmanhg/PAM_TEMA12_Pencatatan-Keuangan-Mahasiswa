
package org.example.project

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.example.project.data.SumberTransaksiPalsu
import org.example.project.model.label

fun main() = runBlocking {
    println("Simulasi pencatatan keuangan mahasiswa #1")

    SumberTransaksiPalsu()
        .pantauStatus()
        .collect { status ->
            println(status.label())
        }

    println("Simulasi selesai.")
}
