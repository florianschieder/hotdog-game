package engine;

import java.io.*;
import sun.audio.*;

public class Sound {
	
	public static void play(String bezeichner) {
		try {
			InputStream inputStream = Sound.class.getClass().getResourceAsStream("/assets/sounds/" + bezeichner + ".wav");
	    	AudioStream audioStream = new AudioStream(inputStream);
	    	AudioPlayer.player.start(audioStream);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
