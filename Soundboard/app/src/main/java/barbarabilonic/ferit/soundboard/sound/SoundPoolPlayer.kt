package barbarabilonic.ferit.soundboard.sound

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import barbarabilonic.ferit.soundboard.R

class SoundPoolPlayer(context:Context) : AudioPlayer {
    private val priority: Int = 1
    private val maxStreams: Int = 3
    private val srcQuality: Int = 1

    private val leftVolume = 1f
    private val rightVolume = 1f
    private val shouldLoop = 0
    private val playbackRate = 1f

    private val soundPool: SoundPool
    private val soundId : List<Int>

    init{
        if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.LOLLIPOP){
            val audioAttributes=AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
            soundPool=SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(maxStreams)
                .build()
        }
        else{
            soundPool= SoundPool(maxStreams,AudioManager.USE_DEFAULT_STREAM_TYPE,srcQuality)
        }

        soundId= listOf(
            soundPool.load(context, R.raw.hello_darkness_my_old_friend,priority),
            soundPool.load(context, R.raw.windows,priority),
            soundPool.load(context, R.raw.one_eternity_later_spongebob,priority)

        )
    }

    override fun playSound(soundNumber: Int) {
       soundPool.play(soundId[soundNumber-1],leftVolume,rightVolume,priority,shouldLoop,playbackRate)
    }


}