package com.example.tm1_4_todo_junto_funciona;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity_Botones extends AppCompatActivity {

    private boolean isRed = true;
    private int counter = 0;
    private String selectedDifficulty = "No seleccionado";
    private boolean isLiked = false;
    private int fabClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_botones);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter", 0);
            isRed = savedInstanceState.getBoolean("isRed", true);
            selectedDifficulty = savedInstanceState.getString("selectedDifficulty", "No seleccionado");
            isLiked = savedInstanceState.getBoolean("isLiked", false);
            fabClicks = savedInstanceState.getInt("fabClicks", 0);
        } else {
            SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            counter = prefs.getInt("counter", 0);
        }

        initializeComponents();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        outState.putBoolean("isRed", isRed);
        outState.putString("selectedDifficulty", selectedDifficulty);
        outState.putBoolean("isLiked", isLiked);
        outState.putInt("fabClicks", fabClicks);
    }

    private void initializeComponents() {
        setupStandardButton();
        setupMaterialButton();
        setupImageButton();
        setupFloatingActionButton();
        setupMiniFab();
        setupToggleButton();
        setupExtraToggles();
        setupRadioButton();
        setupColorChangeButton();
        setupCounterButton();
        setupNavigationButton();
        setupFormValidation();
        setupExitButton();
        setupExtraImageButtons();
        setupThemeRadioGroup();

    }

    // BOTÓN NORMAL
    private void setupStandardButton() {
        Button btnStandard = findViewById(R.id.btnStandard);
        if (btnStandard != null) {
            btnStandard.setOnClickListener(v ->
                    Toast.makeText(this, "¡Botón presionado con éxito!", Toast.LENGTH_SHORT).show()
            );
        }
    }

    // MATERIAL BUTTONS
    private void setupMaterialButton() {
        int[] ids = {
                R.id.btnMaterialFilled,
                R.id.btnMaterialOutlined,
                R.id.btnMaterialText,
                R.id.btnMaterialIcon
        };

        for (int id : ids) {
            MaterialButton btn = findViewById(id);
            if (btn != null) {
                btn.setOnClickListener(v ->
                        Snackbar.make(v, btn.getText(), Snackbar.LENGTH_SHORT).show()
                );
            }
        }
    }

    // IMAGE BUTTON HEART
    private void setupImageButton() {
        ImageButton heart = findViewById(R.id.imgBtnHeart);
        TextView status = findViewById(R.id.txtImageButtonStatus);

        if (heart != null && status != null) {
            updateHeartUI(heart, status);

            heart.setOnClickListener(v -> {
                isLiked = !isLiked;
                updateHeartUI(heart, status);

                heart.animate().scaleX(1.3f).scaleY(1.3f).setDuration(150)
                        .withEndAction(() ->
                                heart.animate().scaleX(1f).scaleY(1f).setDuration(150)
                        ).start();
            });
        }
    }

    private void updateHeartUI(ImageButton heart, TextView status) {
        if (isLiked) {
            heart.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            status.setText("¡Te gusta!");
        } else {
            heart.setColorFilter(ContextCompat.getColor(this, android.R.color.darker_gray));
            status.setText("Ya no te gusta");
        }
    }

    // FAB PRINCIPAL
    private void setupFloatingActionButton() {
        FloatingActionButton fab = findViewById(R.id.fab);
        TextView txt = findViewById(R.id.txtFabStatus);

        if (fab != null && txt != null) {
            txt.setText("FAB presionado " + fabClicks + " veces");

            fab.setOnClickListener(v -> {
                fabClicks++;
                txt.setText("FAB presionado " + fabClicks + " veces");

                Snackbar.make(v, "FAB presionado", Snackbar.LENGTH_SHORT)
                        .setAction("DESHACER", a -> {
                            fabClicks--;
                            txt.setText("FAB presionado " + fabClicks + " veces");
                        }).show();

                fab.animate().rotationBy(360f).setDuration(500).start();
            });
        }
    }

    // FAB MINI
    private void setupMiniFab() {
        FloatingActionButton fabMini = findViewById(R.id.fabMini);
        if (fabMini != null) {
            fabMini.setOnClickListener(v ->
                    Snackbar.make(v, "FAB mini presionado", Snackbar.LENGTH_SHORT).show()
            );
        }
    }

    // TOGGLE PRINCIPAL
    private void setupToggleButton() {
        ToggleButton toggle = findViewById(R.id.toggleBtn);
        TextView txt = findViewById(R.id.txtToggleStatus);

        if (toggle != null && txt != null) {
            toggle.setOnCheckedChangeListener((b, checked) -> {
                txt.setText(checked ? "Notificaciones ACTIVADAS" : "Notificaciones DESACTIVADAS");
                txt.setTextColor(ContextCompat.getColor(this,
                        checked ? android.R.color.holo_green_dark : android.R.color.holo_red_dark));
            });
        }
    }

    // TOGGLES EXTRA
    private void setupExtraToggles() {
        ToggleButton wifi = findViewById(R.id.toggleBtnWifi);
        ToggleButton bt = findViewById(R.id.toggleBtnBluetooth);

        if (wifi != null) {
            wifi.setOnCheckedChangeListener((b, c) ->
                    Toast.makeText(this, c ? "WiFi ON" : "WiFi OFF", Toast.LENGTH_SHORT).show()
            );
        }

        if (bt != null) {
            bt.setOnCheckedChangeListener((b, c) ->
                    Toast.makeText(this, c ? "Bluetooth ON" : "Bluetooth OFF", Toast.LENGTH_SHORT).show()
            );
        }
    }

    // RADIO BUTTONS
    private void setupRadioButton() {
        RadioGroup group = findViewById(R.id.radioGroupDifficulty);
        TextView txt = findViewById(R.id.txtRadioStatus);
        Button btn = findViewById(R.id.btnConfirmSelection);

        if (group != null && txt != null && btn != null) {
            group.setOnCheckedChangeListener((g, id) -> {
                if (id == R.id.radioBtnEasy) selectedDifficulty = "Fácil";
                else if (id == R.id.radioBtnMedium) selectedDifficulty = "Medio";
                else if (id == R.id.radioBtnHard) selectedDifficulty = "Difícil";
                else if (id == R.id.radioBtnExpert) selectedDifficulty = "Experto";

                txt.setText("Dificultad seleccionada: " + selectedDifficulty);
                btn.setEnabled(true);
            });

            btn.setOnClickListener(v ->
                    Snackbar.make(v, "Confirmado: " + selectedDifficulty, Snackbar.LENGTH_LONG).show()
            );
        }
    }

    // CAMBIO DE COLOR
    private void setupColorChangeButton() {
        Button btn = findViewById(R.id.btnColor);
        if (btn != null) {
            btn.setOnClickListener(v -> {
                btn.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        isRed ? android.R.color.holo_blue_dark : android.R.color.holo_red_dark
                ));
                btn.setText(isRed ? "Modo Azul Activado" : "Modo Rojo Activado");
                isRed = !isRed;
            });
        }
    }

    // CONTADOR
    private void setupCounterButton() {
        Button btn = findViewById(R.id.btnCounter);
        TextView txt = findViewById(R.id.txtCounter);
        Button reset = findViewById(R.id.btnReset);

        if (btn != null && txt != null && reset != null) {
            updateCounter(btn, txt);

            btn.setOnClickListener(v -> {
                counter++;
                updateCounter(btn, txt);
                saveCounter();
            });

            reset.setOnClickListener(v -> {
                counter = 0;
                updateCounter(btn, txt);
                saveCounter();
            });
        }
    }

    private void updateCounter(Button btn, TextView txt) {
        btn.setText("Presionas: " + counter + " veces");
        txt.setText("Total de clicks: " + counter);
    }

    private void saveCounter() {
        getSharedPreferences("MyPrefs", MODE_PRIVATE)
                .edit().putInt("counter", counter).apply();
    }

    // NAVEGACIÓN
    private void setupNavigationButton() {
        Button btn = findViewById(R.id.btnNavigate);
        EditText user = findViewById(R.id.editUsername);

        if (btn != null && user != null) {
            btn.setOnClickListener(v -> {
                String username = user.getText().toString().trim();
                if (!username.isEmpty()) {
                    Intent i = new Intent(this, SecondActivity_Botones.class);
                    i.putExtra("USERNAME", username);
                    i.putExtra("COUNTER", counter);
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Ingrese un nombre", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // FORMULARIO
    private void setupFormValidation() {
        EditText email = findViewById(R.id.editEmail);
        EditText pass = findViewById(R.id.editPassword);
        Button submit = findViewById(R.id.btnSubmit);
        TextView txtValidation = findViewById(R.id.txtValidation);

        if (email != null && pass != null && submit != null && txtValidation != null) {

            submit.setEnabled(false); // IMPORTANTE

            TextWatcher watcher = new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    boolean valid =
                            email.getText().toString().contains("@") &&
                                    pass.getText().toString().length() >= 6;

                    submit.setEnabled(valid);

                    txtValidation.setText(
                            valid ? "Formulario válido ✅" : "Complete el formulario ❌"
                    );
                }

                @Override public void beforeTextChanged(CharSequence s, int a, int b, int c) {}
                @Override public void onTextChanged(CharSequence s, int a, int b, int c) {}
            };

            email.addTextChangedListener(watcher);
            pass.addTextChangedListener(watcher);

            submit.setOnClickListener(v ->
                    Toast.makeText(this, "Formulario enviado", Toast.LENGTH_SHORT).show()
            );
        }
    }
    private void setupThemeRadioGroup() {
        RadioGroup themeGroup = findViewById(R.id.radioGroupTheme);

        if (themeGroup != null) {
            themeGroup.setOnCheckedChangeListener((group, checkedId) -> {
                String theme = "";

                if (checkedId == R.id.radioBtnLight) theme = "Tema Claro";
                else if (checkedId == R.id.radioBtnDark) theme = "Tema Oscuro";
                else if (checkedId == R.id.radioBtnAuto) theme = "Tema Automático";

                Toast.makeText(this, theme + " seleccionado", Toast.LENGTH_SHORT).show();
            });
        }
    }


    // IMAGE BUTTONS EXTRA
    private void setupExtraImageButtons() {
        ImageButton share = findViewById(R.id.imgBtnShare);
        ImageButton settings = findViewById(R.id.imgBtnSettings);

        if (share != null) {
            share.setOnClickListener(v ->
                    Toast.makeText(this, "Compartir presionado", Toast.LENGTH_SHORT).show()
            );
        }

        if (settings != null) {
            settings.setOnClickListener(v ->
                    Toast.makeText(this, "Configuración presionada", Toast.LENGTH_SHORT).show()
            );
        }
    }

    // SALIR
    private void setupExitButton() {
        Button btnSalir = findViewById(R.id.btnSalir);
        if (btnSalir != null) {
            btnSalir.setOnClickListener(v -> {
                startActivity(new Intent(this, Pantalla_principal.class));
                finishAffinity();
            });
        }
    }
}
