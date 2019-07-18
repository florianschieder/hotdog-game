# Projekt HOTDOG 

Beschreibung:
=============

Bei diesem Projekt handelt es sich um ein Spiel, bei dem man einen Hund spielt. Dieser
muss in Hotdogbuden W�rstchen sammeln, um sich vor Gegnern zu sch�tzen, und der t�dlichen
Ketchupflasche entkommen.

Es gibt verschiedene Modi mit unterschiedlichen Zeitlimits, in denen man die Level schaffen
muss. Doch die Zeitlimits sind nicht die einzigen Gemeinheit, die die einzelnen Modi mit sich
bringen... :-)

Die Fenstergr��e ist zurzeit einheitlich 1152 x 864 Pixel.

Derzeit wird (noch) die Engine-Alpha verwendet.

Konventionen:
=============

1.) Dokumentation des Quellcodes:
---------------------------------

Der Quellcode wird ausf�hrlich dokumentiert. Das bedeutet, dass jede Klasse bzw. jede Methode einen
vorgegebenen Dokumentationskommentar der jeweiligen Art besitzt.

So dokumentieren wir eine Klasse / eine Enumeration / ein Interface:

`/**`  
` * Komponente:  [NAME] <br>`  
` * Typ:         [Klasse | Interface | Enumeration] <br>`    
` *`  
` * Funktion:    [KURZE BESCHREIBUNG] <br>`  
` *  [OPTIONALE AUSF�HRLICHE BESCHREIBUNG. <br>`  
` *  KANN �BER MEHRERE ZEILEN GEHEN.] <br>`  
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
Sofern die Methode nicht <void> zur�ckliefert, muss es eine Beschreibung f�r den R�ckgabewert
geben.

Ein Dokumentationskommentar steht jeweils direkt (!) vor den K�pfen (z.B. vor "public class ...",
"interface ..." oder dem Methodenkopf).

Dar�ber hinaus werden die wichtigsten, "kompliziertesten" Stellen mit "normalen" Kommentaren versehen.

2.) Assets
----------

Bilder werden derzeit in assets/images/ und Musik wird in assets/sounds/... gespeichert.
In einer Folgeversion ist eine Einbettung in die gesamte JAR-Datei geplant.