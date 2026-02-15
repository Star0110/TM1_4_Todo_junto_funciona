package com.example.tm1_4_todo_junto_funciona


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.tm1_4_todo_junto_funciona.Pantalla_principal
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity_botones2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_botones2)

        // 1. Botón Estándar
        findViewById<Button>(R.id.btnNormal).setOnClickListener {
            mostrarMensaje("Clic en Botón Estándar")
        }

        // 2. Botón Delineado (Outlined)
        findViewById<Button>(R.id.btnOutlined).setOnClickListener {
            mostrarMensaje("Clic en Botón Delineado")
        }

        // 3. Botón de Texto
        findViewById<Button>(R.id.btnText).setOnClickListener {
            mostrarMensaje("Clic en Botón de Texto")
        }

        // 4. Image Button
        findViewById<ImageButton>(R.id.btnImagen).setOnClickListener {
            mostrarMensaje("¡Foto tomada!")
        }

        // 5. Toggle Button
        val toggle = findViewById<ToggleButton>(R.id.btnToggle)
        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) mostrarMensaje("Sistema: ENCENDIDO")
            else mostrarMensaje("Sistema: APAGADO")
        }

        // 6. Switch
        val switchWifi = findViewById<SwitchMaterial>(R.id.btnSwitch)
        switchWifi.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) mostrarMensaje("Wifi Activado")
            else mostrarMensaje("Wifi Desactivado")
        }

        // 7. Checkbox
        val checkBox = findViewById<CheckBox>(R.id.btnCheck)
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) mostrarMensaje("Términos aceptados")
            else mostrarMensaje("Debes aceptar los términos")
        }

        // 8. Radio Group (Detectar cuál se seleccionó)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioSeleccionado = findViewById<RadioButton>(checkedId)
            mostrarMensaje("Elegiste: ${radioSeleccionado.text}")
        }

        // 9. Chips
        findViewById<Chip>(R.id.chipAction).setOnClickListener {
            mostrarMensaje("Acción de Chip ejecutada")
        }

        findViewById<Chip>(R.id.chipFilter).setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) mostrarMensaje("Filtro aplicado")
            else mostrarMensaje("Filtro removido")
        }

        // 10. Floating Action Button (FAB)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            mostrarMensaje("Abriendo correo...")
        }

        // 11. Boton de salir
        findViewById<Button>(R.id.btnSalir2).setOnClickListener {
            intent = Intent(this, Pantalla_principal::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }

    // Función auxiliar para no escribir Toast a cada rato
    private fun mostrarMensaje(texto: String) {
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
    }
}