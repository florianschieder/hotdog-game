/**
 * Haupteinsprungpunkt für das Spiel.<br>
 * 
 * Startet man dieses Programm bzw. führt es als eigenständiges Programm nach <br>
 * endgültiger Fertigstellung aus (z.B. als Endanwender), wird diese Methode <br>
 * automatisch von Java aufgerufen. <br>
 *  
 * @author Florian Schieder
 */

package game;
import javax.swing.JOptionPane;

public class HOTDOGLAUNCHER {
    
    /**
     * Einsprungpunkt, der beim Programmstart ausgeführt wird <br>
     * <br>
     * @param args Kommandozeilenargumente, die dem Programm zusätzlich übergeben werden können. <br>
     */
    
    public static void main(String[] args) {
        // Alle Optionen für die Auswahlmöglichkeit des Schwierigkeitsgrads zusammenpacken
        MODE[] modeSelectionValues = {
            MODE.Easy, MODE.Normal, MODE.Hard, MODE.Extreme
        };
        
        MODE modeSelection = (MODE) JOptionPane.showInputDialog(
            null,                                       // Es gibt kein übergeordnetes Fenster
            "Bitte wähle einen Schwierigkeitsgrad aus", // Anzeigetext
            "Schwierigkeitsgrad",                       // Titel
            JOptionPane.QUESTION_MESSAGE,               // "Frage"-Symbol
            null,                                       // Wir brauchen kein benutzerdefiniertes Symbol
            modeSelectionValues,                        // Die Auswahlmöglichkeiten. Auch wenn es sich bei der Aufzählung um rein numerische Werte handelt, wird hier automatisch ihr Bezeichner gezeigt.
            null                                        // Standardauswahl. In diesem Fall wird es der erste Eintrag dieser Liste sein, nicht irgendein anderer festgelegt.
        );
        
        if(modeSelection != null) new HOTDOGGAME(modeSelection);
    }
}