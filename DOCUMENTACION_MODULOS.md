# Documentacion de Modulos y Navegacion

## Resumen
Se implemento la navegacion faltante en la pantalla principal para los botones:

- `Google`
- `Legacy`
- `Acerca de`
- `Salir`

## Que hace ahora cada boton
- `Google`: abre `GoogleModuleActivity` con componentes de paleta Google: `MapView` y `AdView`.
- `Legacy`: abre `LegacyModuleActivity`, con accesos a Texto, Layouts y Widgets.
- `Acerca de`: abre `AboutActivity`, mostrando una descripcion del proyecto.
- `Salir`: cierra la sesion actual y vuelve a `Login` limpiando el stack de Activities.

## Archivos nuevos
- `app/src/main/java/com/example/tm1_4_todo_junto_funciona/GoogleModuleActivity.java`
- `app/src/main/java/com/example/tm1_4_todo_junto_funciona/LegacyModuleActivity.java`
- `app/src/main/java/com/example/tm1_4_todo_junto_funciona/AboutActivity.java`
- `app/src/main/res/layout/activity_google_module.xml`
- `app/src/main/res/layout/activity_legacy_module.xml`
- `app/src/main/res/layout/activity_about.xml`

## Archivos modificados
- `app/src/main/java/com/example/tm1_4_todo_junto_funciona/Pantalla_principal.java`
- `app/src/main/java/com/example/tm1_4_todo_junto_funciona/GoogleModuleActivity.java`
- `app/src/main/AndroidManifest.xml`
- `app/src/main/res/values/strings.xml`
- `app/src/main/res/layout/activity_google_module.xml`
- `app/build.gradle.kts`
- `gradle/libs.versions.toml`

## Configuracion pendiente en local
- Reemplazar `google_maps_key` en `app/src/main/res/values/strings.xml` con su API key real de Maps.
- El proyecto usa IDs de prueba de AdMob para evitar bloqueos durante desarrollo.

## Nota de compilacion
En este entorno no se pudo ejecutar `gradlew` por restricciones de red/sandbox para descargar Gradle.
Validen localmente con:

```bash
bash ./gradlew :app:assembleDebug
```
