# Projekt HOTDOG 

Beschreibung:
=============

Bei diesem Projekt handelt es sich um ein Spiel, bei dem man einen Hund spielt. Dieser
muss in Hotdogbuden Würstchen sammeln, um sich vor Gegnern zu schützen, und der tödlichen
Ketchupflasche entkommen.

Es gibt verschiedene Modi mit unterschiedlichen Zeitlimits, in denen man die Level schaffen
muss. Doch die Zeitlimits sind nicht die einzigen Gemeinheiten, die die einzelnen Modi mit
sich bringen... :-)

Die Fenstergröße ist zurzeit einheitlich 1152 x 864 Pixel.

Derzeit wird (noch) die Engine-Alpha verwendet.

Entwicklungsziel dieser Version:
================================

Diese Versionsspaltung auf "abstraction" hat zum Ziel, eine Abstraktion und somit als
noch fernes Ziel eine Umstellung auf eine andere 2D-Engine vorzunehmen. Damit werden
viele Optimierungen und Änderungen im jetzigen Stand der Spielelemente einhergehen.

Konventionen:
=============

1.) Dokumentation des Quellcodes:
---------------------------------

Der Quellcode wird ausführlich dokumentiert. Das bedeutet, dass jede Klasse bzw. jede Methode einen
vorgegebenen Dokumentationskommentar der jeweiligen Art besitzt.

So dokumentieren wir eine Klasse / eine Enumeration / ein Interface:

`/**`  
` * Kurze Beschreibung der Klasse.`  
` *`  
` * Eventuell über mehrere Zeilen mit <br>`  
` *`  
` * @author [AUTOR DER DATEI]`  
` */`  


So dokumentieren wir eine Methode:

`/**`  
` * [BESCHREIBUNG DER METHODE. ZWINGEND IN EINE ZEILE]`  
` *`   
` * @param [argument] [Beschreibung]`   
` * @return [Beschreibung]`   
` */`   


Pro Parameter einer Methode wird eine param-Zeile mit Argumentname und Beschreibung erzeugt,
solange Parameter vorliegen. Wenn nicht, gibt es hier keine param-Zeilen.
Sofern die Methode nicht <void> zurückliefert, muss es eine Beschreibung für den Rückgabewert
geben.

Ein Dokumentationskommentar steht jeweils direkt (!) vor den Köpfen (z.B. vor "public class ...",
"interface ..." oder dem Methodenkopf).

Darüber hinaus werden die wichtigsten, kompliziertesten Stellen mit "normalen" Kommentaren versehen.

2.) Assets
----------

Bilder werden derzeit in assets/images/ und Musik wird in assets/sounds/... gespeichert.
In einer Folgeversion ist eine Einbettung in die gesamte JAR-Datei geplant.