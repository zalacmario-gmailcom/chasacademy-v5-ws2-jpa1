## Om

Ett startprojekt för första uppgiften för workshop 2 vecka 5.

## Instruktioner

Klona ner det här repo:t och ha som bas för att lösa uppgiften på egen hand. Gör atomära kommits för att skapa en bra logg för hur ni arbetar med uppgiften.

## Teknisk info

Projektet är designat med Spring Boot 4.0 och fungerar med Java 17 eller nyare. Det är en medföljande gradle wrapper så för att bygga i en terminal/kommandotolk kör ```./gradlew bootRun```.

Kommandot ovan kommer bygga projektet och starta applikationen. Samma flöde går att åstakomma via IntelliJ och det kommer visas under workshoppen. I vissa fall kan du behöva ändra java version i ```build.gradle``` ändra i det här blocket till den version av Java du har installerat på din dator:

```
java {
     toolchain {
 	    languageVersion = JavaLanguageVersion.of(17)
     }
}

```
