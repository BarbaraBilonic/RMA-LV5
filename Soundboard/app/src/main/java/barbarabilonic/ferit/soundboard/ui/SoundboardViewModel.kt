package barbarabilonic.ferit.soundboard.ui

import androidx.lifecycle.ViewModel
import barbarabilonic.ferit.soundboard.sound.AudioPlayer

class SoundboardViewModel(private val audioPlayer: AudioPlayer) : ViewModel(){
    fun playSound(soundNumber:Int)=audioPlayer.playSound(soundNumber)
}