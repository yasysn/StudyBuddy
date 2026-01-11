# 📚 StudyBuddy

StudyBuddy is een Android-applicatie ontwikkeld met **Jetpack Compose** die studenten helpt om hun studietaken te organiseren, gefocust te studeren met een timer en automatisch hun studievoortgang bij te houden.

De app legt de focus op **structuur, tijdsbeheer en inzicht in studiegedrag**, zonder onnodige complexiteit.

---

## 🎯 Doel van de applicatie

Veel studenten hebben moeite met:
- uitstelgedrag
- hun studietijd correct inschatten
- onthouden wat ze precies hebben gestudeerd

StudyBuddy biedt een eenvoudige oplossing door:
- studietaken aan te maken
- studietijd te meten met een timer
- studiesessies automatisch op te slaan
- duidelijk te tonen **waaraan** en **hoe lang** er is gestudeerd

---

## 👥 Doelgroep

- Studenten in het **secundair onderwijs**
- **Hogeschool- en universiteitsstudenten**
- Iedereen die gestructureerder wil studeren

---

## ✨ Functionaliteiten

### 📝 Takenbeheer
- Studietaken toevoegen
- Taken bekijken in een overzicht
- Taken hebben een prioriteit
- Elke taak kan gebruikt worden om een timer te starten

*(Het bewerken of verwijderen van taken is niet geïmplementeerd)*

---

### ⏱️ Studietimer (Pomodoro-stijl)
- Start, pauzeer en reset een timer
- De timer kan:
    - vrij gebruikt worden
    - of gekoppeld worden aan een specifieke taak
- Wanneer de timer eindigt:
    - wordt de studiesessie **automatisch opgeslagen**
    - krijgt de gebruiker visuele feedback via een melding

---

### 🔗 Automatische studie-tracking (USP)
- Elke afgeronde timer:
    - wordt automatisch opgeslagen in de lokale database
    - wordt gekoppeld aan de taak waarop werd gestudeerd (indien van toepassing)
- De gebruiker hoeft **niets handmatig op te slaan**

Dit is de **Unique Selling Proposition** van de app.

---

### 📊 Voortgangsoverzicht
- Overzicht van alle opgeslagen studiesessies
- Totale studietijd in minuten
- Per sessie wordt getoond:
    - de duur
    - de naam van de taak waarop werd gestudeerd  
      (geen technische ID’s)

---

### 💬 Motiverende boodschap
- Op het hoofdscherm wordt een **dagelijkse motiverende quote** getoond
- De quote verandert automatisch elke dag
- Dit verhoogt de betrokkenheid van de gebruiker

---

## 🧱 Technische implementatie

- **Kotlin**
- **Jetpack Compose** (UI)
- **Room** (lokale database)
- **Repository pattern**
- **ViewModel + StateFlow**
- **Navigation Compose**
- **Material 3**

---

## 🗂️ Projectstructuur

De applicatie is opgebouwd volgens een duidelijke en gestructureerde architectuur.

- **data**
    - **local**
        - **dao**: Room Data Access Objects
        - **entity**: Database-entiteiten
        - **AppDatabase.kt**: Room database configuratie
    - **repository**
        - **StudyRepository.kt**: Repository interface
        - **StudyRepositoryImpl.kt**: Implementatie van de repository

- **ui**
    - **navigation**
        - **StudyBuddyNav.kt**: Navigatiestructuur van de app
    - **screens**
        - **tasks**: Overzicht en toevoegen van taken
        - **timer**: Studietimer
        - **progress**: Voortgang en statistieken
    - **theme**
        - Material 3 thema

- **AppContainer.kt**
    - Eenvoudige dependency-container

- **MainActivity.kt**
    - Startpunt van de applicatie

---

## ▶️ De applicatie uitvoeren

1. Clone deze repository
2. Open het project in **Android Studio**
3. Sync Gradle
4. Start de app op een emulator of Android-toestel

---

## 📦 APK

Een gebouwde APK is toegevoegd aan de repository:

/apk/StudyBuddy-release.apk


Deze kan rechtstreeks geïnstalleerd worden op een Android-toestel.

---

## 🎤 Presentatie (demo)

Tijdens de presentatie kan getoond worden:
1. Een taak aanmaken
2. De timer starten vanuit een taak
3. De timer laten aflopen
4. Het voortgangsscherm openen en tonen:
    - totale studietijd
    - studiesessies met taaknamen

---

## 👤 Auteur

- **Naam**: Yassine Lakdimi
- **Opleiding**: Android Development
- **School**: Erasmushogeschool Brussel (EHB)
