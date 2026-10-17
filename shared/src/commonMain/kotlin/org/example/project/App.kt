
package org.example.project

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val BackgroundPurple = Color(0xFFEBDDFF)
private val ButtonPurple = Color(0xFF6B4EAA)
private val TopBlue = Color(0xFF35B9F5)
private val LeftBlue = Color(0xFF6066F5)
private val RightPurple = Color(0xFF6950FF)

@Composable
fun App() {
    var showMembers by remember { mutableStateOf(false) }

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = BackgroundPurple
        ) {
            if (!showMembers) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeContentPadding()
                        .padding(
                            horizontal = 20.dp,
                            vertical = 24.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(28.dp))

                    Text(
                        text = "Tema 12 - Pencatatan Keuangan Mahasiswa",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF211B2A)
                    )

                    Spacer(modifier = Modifier.height(22.dp))

                    Button(
                        onClick = { showMembers = true },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ButtonPurple
                        ),
                        contentPadding = PaddingValues(
                            horizontal = 24.dp,
                            vertical = 10.dp
                        )
                    ) {
                        Text(
                            text = "Tentang Kelompok",
                            fontSize = 14.sp
                        )
                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeContentPadding()
                        .padding(
                            horizontal = 20.dp,
                            vertical = 24.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Tema 12 - Pencatatan Keuangan Mahasiswa",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF211B2A)
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Button(
                        onClick = { showMembers = false },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ButtonPurple
                        )
                    ) {
                        Text("Kembali")
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth(0.78f)
                            .aspectRatio(1f)
                    ) {
                        drawCubeLogo()
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Berjalan di: Android",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF211B2A)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "=== Daftar Anggota ===",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF211B2A)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Firman H Gultom (123140171)\n" +
                                "Hildyah Maretasya Araffad (123140151)\n" +
                                "Roberto Charlos Sagala (123140113)",
                        fontSize = 14.sp,
                        lineHeight = 22.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF211B2A)
                    )
                }
            }
        }
    }
}

private fun DrawScope.drawCubeLogo() {
    val w = size.width
    val h = size.height

    val top = Offset(w * 0.5f, h * 0.08f)
    val leftTop = Offset(w * 0.08f, h * 0.34f)
    val rightTop = Offset(w * 0.92f, h * 0.34f)
    val centerLeft = Offset(w * 0.32f, h * 0.49f)
    val centerRight = Offset(w * 0.68f, h * 0.49f)
    val centerBottom = Offset(w * 0.5f, h * 0.67f)
    val leftBottom = Offset(w * 0.08f, h * 0.77f)
    val rightBottom = Offset(w * 0.92f, h * 0.77f)
    val bottom = Offset(w * 0.5f, h * 0.94f)

    fun polygon(points: List<Offset>): Path {
        return Path().apply {
            if (points.isEmpty()) return@apply

            moveTo(points[0].x, points[0].y)

            for (i in 1 until points.size) {
                lineTo(points[i].x, points[i].y)
            }

            close()
        }
    }

    drawPath(
        path = polygon(
            listOf(top, leftTop, centerLeft, centerRight, rightTop)
        ),
        color = TopBlue
    )

    drawPath(
        path = polygon(
            listOf(
                leftTop,
                centerLeft,
                Offset(w * 0.32f, h * 0.67f),
                leftBottom,
                Offset(w * 0.08f, h * 0.77f)
            )
        ),
        color = LeftBlue
    )

    drawPath(
        path = polygon(
            listOf(
                centerRight,
                rightTop,
                rightBottom,
                bottom,
                centerBottom
            )
        ),
        color = RightPurple
    )

    drawPath(
        path = polygon(
            listOf(
                Offset(w * 0.5f, h * 0.46f),
                Offset(w * 0.68f, h * 0.57f),
                Offset(w * 0.68f, h * 0.70f),
                Offset(w * 0.5f, h * 0.81f),
                Offset(w * 0.32f, h * 0.70f),
                Offset(w * 0.32f, h * 0.57f)
            )
        ),
        color = Color.Black
    )
}
