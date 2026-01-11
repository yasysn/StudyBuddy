# 📚 StudyBuddy

StudyBuddy is een Android-app ontwikkeld met **Jetpack Compose** die studenten helpt hun studietaken te beheren, gefocust te studeren en automatisch hun studievoortgang bij te houden.

Deze applicatie werd ontwikkeld in het kader van een schoolopdracht en focust op een **cleane architectuur**, **moderne Android-technologieën** en een duidelijke **USP**.

---

## 🎯 Doel van de app

Veel studenten hebben moeite met:
- uitstelgedrag
- tijdsbeheer
- het bijhouden van hun studie-inspanningen

**StudyBuddy** biedt een eenvoudige oplossing door:
- taken te organiseren
- studietijd te meten via een timer
- studiemomenten automatisch op te slaan
- voortgang overzichtelijk te tonen

---

## 👥 Doelgroep

- Hogeschool- en universiteitsstudenten
- Studenten die gestructureerder willen studeren
- Gebruikers die hun studietijd willen opvolgen zonder extra administratie

---

## ⭐ Belangrijkste functionaliteiten

### ✅ Task Planner
- Taken toevoegen met titel en prioriteit
- Overzicht van alle taken
- Start een timer rechtstreeks vanuit een taak

### ⏱️ Study Timer
- Start een studietimer (met of zonder gekoppelde taak)
- Timer kan gepauzeerd en gereset worden
- Bij afloop wordt de studiesessie **automatisch opgeslagen**

### 📊 Progress Tracking
- Overzicht van alle opgeslagen studiesessies
- Totale studietijd in minuten
- Historiek van sessies (duur + bijhorende taak)

### 💡 Motivational Quotes
- Dagelijkse motiverende quote op het startscherm
- Duidelijk zichtbaar en visueel geïntegreerd

---

## 🚀 Unique Selling Proposition (USP)

**Automatische studie-registratie**

De gebruiker hoeft **geen studietijd manueel in te geven**.  
Elke studiesessie wordt **automatisch opgeslagen** wanneer de timer eindigt, inclusief:
- duur van de sessie
- gekoppelde taak (indien van toepassing)

Dit verlaagt de drempel om voortgang bij te houden en verhoogt consistentie.

---

## 🧱 Architectuur & Technologieën

- **Kotlin**
- **Jetpack Compose** (UI)
- **Room Database** (lokale opslag)
- **MVVM-architectuur**
- **StateFlow & Coroutines**
- **Navigation Compose**
- **Material 3**

---

## 📁 Projectstructuur

studybuddy  
data  
local  
dao  
StudySessionDao.kt  
TaskDao.kt  

entity  
StudySessionEntity.kt  
SubjectEntity.kt  
TaskEntity.kt  

AppDatabase.kt  

repository  
StudyRepository.kt  
StudyRepositoryImpl.kt  

ui  
navigation  
StudyBuddyNav.kt  

screens  
progress  
ProgressModels.kt  
ProgressScreen.kt  
ProgressViewModel.kt  
ProgressViewModelFactory.kt  

tasks  
AddTaskScreen.kt  
AddTaskViewModel.kt  
AddTaskViewModelFactory.kt  
TasksScreen.kt  
TasksViewModel.kt  
TasksViewModelFactory.kt  

timer  
TimerScreen.kt  
TimerViewModel.kt  
TimerViewModelFactory.kt  

theme  

util  

AppContainer.kt  
MainActivity.kt  

---

## 📦 APK

De gecompileerde APK is beschikbaar in de repository:

apk/StudyBuddy-debug.apk

yaml
Copy code

Deze APK werd gegenereerd via Android Studio (**Build APK(s)**).

---

## 🧑‍💻 Auteur

- Naam: *Yassine Lakdimi*
- Opleiding: *EHB*
- Vak: *Android Development*
