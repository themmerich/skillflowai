# Struktur von Modulen

Dies ist ein Beispiel-Modul, welches die Architektur enthält.
Alle Module sollen sich an dieses Schema halten.
Außerdem soll es ArchUnit-Tests geben, welche dafür sorgen, dass die Architektur nicht verletzt wird

## Package-Struktur

### presentation

Enthält alle Schnittstellen für den Zugriff von außen auf die Anwendung, z.B. per Rest-Controller oder Queue

- web: Enthält alle Rest-Controller
-

### domain

Enthält die Business-Logik.

Kommunikation mit anderen Modulen erfolgt über Events

### infrastructure

- config
    - Enthält insb. Spring-Config Klassen